package fr.upmc.aladyn.dyn_generics.tests;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import fr.upmc.aladyn.dyn_generics.annotations.DynamicGenericType;
import fr.upmc.aladyn.dyn_generics.annotations.DynamicGenericTypeParameters;
import fr.upmc.aladyn.dyn_generics.exceptions.LatentTypeCheckException;

public class Generics {
	
	// TODO : S�parer en 2 m�thodes, une pour la verif du retour, une pour les param�tres
	public static void checkTypesParam(Class<?>[] types, Class<?> classinfo) throws LatentTypeCheckException
	{
		try {
				String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
				//Class<?> classinfo = Thread.currentThread().getStackTrace()[2].getClass();
				System.out.println(methodName);
				Method methlist[] = classinfo.getMethods();
				int num = 0;
				while (!methodName.equals(methlist[num].getName())){
					num++;
					System.out.println(methlist[num].getName());
				}

				String[] typeParams = classinfo.getAnnotation(DynamicGenericTypeParameters.class).typeParams();
				
				/*if (!methlist[num].getGenericReturnType().toString().equals("void"))
				{
					type = methlist[num].getAnnotation(DynamicGenericType.class).value();
					for (int i = 0; i < typeParams.length; i++) {
						if ( type.equals(typeParams[i]) )
						{

							if (!(typefield.equals(types[i])))
							{
								throw new LatentTypeCheckException("bad type for "+field+", waiting "+types[i].toString());
							}
						}
					}
				}*/
				
				Annotation[][] listannot = methlist[num].getParameterAnnotations();
				Class<?>[] listParams = methlist[num].getParameterTypes();
				if(listannot.length > 0)
				{
					for (int j=0; j < listannot.length; j++)
					{
						for (int i = 0; i < typeParams.length; i++) {
							if ( ((DynamicGenericType)listannot[j][0]).value().equals(typeParams[i]) )
							{
								System.out.println(listParams[i]);
								System.out.println(types[i]);
								if (!listParams[i].equals(types[i]))
								{
									throw new LatentTypeCheckException("bad type for "+listParams[i]+", waiting "+types[i].toString());
								}
							}
						}
					}
				}
			} catch (LatentTypeCheckException e){
				e.printStackTrace();
				System.exit(0);
			}
	}
	
	public static void checkTypesReturn(Class<?>[] types, Class<?> classinfo) throws LatentTypeCheckException
	{
		
		String methodName = Thread.currentThread().getStackTrace()[3].getMethodName();
		//Class<?> classinfo = Thread.currentThread().getStackTrace()[3].getClass();
		
		Method methlist[] = classinfo.getMethods();
		int num = 0;
		while (!methodName.equals(methlist[num].getName())){
			num++;
		}
		
		String[] typeParams = classinfo.getAnnotation(DynamicGenericTypeParameters.class).typeParams();
		Class<?> returnType = methlist[num].getGenericReturnType().getClass();
		if (!methlist[num].getGenericReturnType().toString().equals("void"))
		{
			String type = methlist[num].getAnnotation(DynamicGenericType.class).value();
			for (int i = 0; i < typeParams.length; i++) {
				if ( type.equals(typeParams[i]) )
				{

					if (!(returnType.equals(types[i])))
					{
						throw new LatentTypeCheckException("bad returntype for "+methodName+", waiting "+types[i].toString());
					}
				}
			}
		}
	}
}














