package fr.upmc.aladyn.dyn_generics.transform;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import fr.upmc.aladyn.dyn_generics.annotations.DynamicGenericType;
import fr.upmc.aladyn.dyn_generics.annotations.DynamicGenericTypeParameters;
import fr.upmc.aladyn.dyn_generics.exceptions.LatentTypeCheckException;

public class Generics {
	public static void checkTypesParams(Class<?> classinfo, Class<?>[] types, Object[] args) throws LatentTypeCheckException
	{
		try {
				String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
				Method methlist[] = classinfo.getMethods();
				int num = 0;
				while (!methlist[num].getName().contains(methodName) || !methodName.equals(methlist[num].getName())){
					num++;
				}
				
				String[] typeParams = classinfo.getAnnotation(DynamicGenericTypeParameters.class).typeParams();
					
				Annotation[][] listannot = methlist[num].getParameterAnnotations();
				
				if(listannot.length > 0)
				{
					for (int j=0; j < listannot.length; j++)
					{
						for (int i = 0; i < typeParams.length; i++) {
							if ( ((DynamicGenericType)listannot[j][0]).value().equals(typeParams[i]) )
							{
								if (!args[i].getClass().equals(types[i]))
								{
									throw new LatentTypeCheckException("["+methodName+"(parameter "+(i+1)+")]bad type "+args[i].getClass().getSimpleName()+", waiting "+types[i].getSimpleName());
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
	
	
	public static void checkTypeReturn(Class<?> classinfo, Class<?>[] types, Object typereturn) throws LatentTypeCheckException
	{
		String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		Method methlist[] = classinfo.getMethods();
		int num = 0;
		while (!methlist[num].getName().contains(methodName) || !methodName.equals(methlist[num].getName())){
			num++;
		}
		
		String type;
		String[] typeParams = classinfo.getAnnotation(DynamicGenericTypeParameters.class).typeParams();
		if (!methlist[num].getGenericReturnType().toString().equals("void"))
		{
			type = methlist[num].getAnnotation(DynamicGenericType.class).value();
			for (int i = 0; i < typeParams.length; i++) {
				if ( type.equals(typeParams[i]) )
				{
					if (!(typereturn.getClass().equals(types[i])))
					{
						throw new LatentTypeCheckException("["+methodName+"]bad returntype "+typereturn.getClass()+", waiting "+types[i].getSimpleName());
					}
				}
			}
		}
	}
}
