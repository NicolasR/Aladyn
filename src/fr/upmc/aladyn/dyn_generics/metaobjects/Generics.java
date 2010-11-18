package fr.upmc.aladyn.dyn_generics.metaobjects;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import fr.upmc.aladyn.dyn_generics.annotations.DynamicGenericType;
import fr.upmc.aladyn.dyn_generics.annotations.DynamicGenericTypeParameters;
import fr.upmc.aladyn.dyn_generics.exceptions.LatentTypeCheckException;


/**
 * Classe qui vérifie les paramètres, les retours et les accès aux champs
 * 
 * @author Charles DUFOUR
 * @author Nicolas RIGNAULT
 *
 */
public class Generics {
	
	/**
	 * Vérifie le type des paramètres d'une méthode
	 * 
	 * @param classinfo la classe dont on souhaite vérifier les paramètres
	 * @param types le tableau de type contenant les paramètres attendus
	 * @param methodName le nom de la méthode concernée
	 * @param args les paramètres de la fonctions
	 * @throws LatentTypeCheckException exception qui indique qu'il y a un problème de type
	 */
	public static void checkTypesParams(Class<?> classinfo, Class<?>[] types, String methodName, Object[] args) throws LatentTypeCheckException
	{
		/** Obsolete :)
		 * String methodName = Thread.currentThread().getStackTrace()[4].getMethodName();
		 */
		
		Method methlist[] = classinfo.getMethods();
		int num = 0;
		while (!methodName.equals(methlist[num].getName())){
			num++;
		}

		String[] typeParams = classinfo.getAnnotation(DynamicGenericTypeParameters.class).typeParams();
			
		Annotation[][] listannot = methlist[num].getParameterAnnotations();
		
		if(listannot.length > 0)
		{
			for (int j=0; j < listannot.length; j++)
			{
				for (int i = 0; i < typeParams.length; i++) 
				{
					if ( ((DynamicGenericType)listannot[j][0]).value().equals(typeParams[i]) )
					{
						
						if (!args[i].getClass().equals(types[i]))
						{
							try
							{
								@SuppressWarnings("unused")
								Object o = args[i].getClass().asSubclass(types[i]);
								
							}
							catch(Exception e)
							{
								throw new LatentTypeCheckException("["+methodName+"(parameter "+(i+1)+")]bad type "+args[i].getClass().getSimpleName()+", waiting "+types[i].getSimpleName());
							}
							
						}
					}
				}
			}
		}
	}
	
	
	/**
	 * Vérifie le type de retour d'une méthode
	 * 
	 * @param classinfo la classe dont on souhaite vérifier les paramètres
	 * @param types le tableau de type contenant les paramètres attendus
	 * @param methodName le nom de la méthode concernée
	 * @param typereturn la classe correspondant au type de retour de la fonction
	 * @throws LatentTypeCheckException exception qui indique qu'il y a un problème de type
	 */
	public static void checkTypeReturn(Class<?> classinfo, Class<?>[] types, String methodName, Class<?> typereturn) throws LatentTypeCheckException
	{
		/** Obsolete :) **/
		/*String methodName = Thread.currentThread().getStackTrace()[4].getMethodName();*/
		Method methlist[] = classinfo.getMethods();
		int num = 0;
		while (!methodName.equals(methlist[num].getName())){
			num++;
		}
	
		String type;
		String[] typeParams = classinfo.getAnnotation(DynamicGenericTypeParameters.class).typeParams();
		if (!methlist[num].getGenericReturnType().toString().equals("void"))
		{
			type = methlist[num].getAnnotation(DynamicGenericType.class).value();
			for (int i = 0; i < typeParams.length; i++)
			{
				if ( type.equals(typeParams[i]) )
				{
					if (!(typereturn.equals(types[i])))
					{
						try
						{
							@SuppressWarnings("unused")
							Object o = typereturn.asSubclass(types[i]);
							
						}
						catch(Exception e)
						{
							throw new LatentTypeCheckException("["+methodName+"]bad returntype "+typereturn.getSimpleName()+", waiting "+types[i].getSimpleName());
					
						}
					}
				}
			}
		}
	}
	
	/**
	 * Vérifie le type d'un champ
	 * 
	 * @param classinfo la classe dont on souhaite vérifier les paramètres
	 * @param name le nom du champ
	 * @param types le tableau de type contenant les paramètres attendus
	 * @param typeField la classe qui correspond au type du champ
	 */
	public static void checkTypeField(Class<?> classinfo, String name, Class<?>[] types, Class<?> typeField) throws LatentTypeCheckException
	{
		String[] typeParams = classinfo.getAnnotation(DynamicGenericTypeParameters.class).typeParams();
		Field[] fields = classinfo.getDeclaredFields();

		boolean found = false;
		int num = 0;
		for(num=0;num<fields.length;num++)
		{
			
			if (fields[num].getName().equals(name))
			{
				found = true;
				break;
			}
		}
		
		if (!found)
			return;
		
		if (fields[num].getAnnotations().length > 0)
		{
			String annotation = fields[num].getAnnotation(DynamicGenericType.class).value();
			for (int i = 0; i < typeParams.length; i++) 
			{
				if ( annotation.equals(typeParams[i]) )
				{	
					if (!(typeField.equals(types[i])))
					{
						try
						{
							@SuppressWarnings("unused")
							Object o = typeField.asSubclass(types[i]);
							
						}
						catch(Exception e)
						{
							throw new LatentTypeCheckException("bad type for field "+fields[num].getName()+
								" ("+typeField.getSimpleName()+"), waiting "+types[i].getSimpleName());
						}
					}
				}
			}
		}
	}
}
