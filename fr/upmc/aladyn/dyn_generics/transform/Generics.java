package fr.upmc.aladyn.dyn_generics.transform;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import fr.upmc.aladyn.dyn_generics.annotations.DynamicGenericType;
import fr.upmc.aladyn.dyn_generics.annotations.DynamicGenericTypeParameters;
import fr.upmc.aladyn.dyn_generics.exceptions.LatentTypeCheckStaticException;

/**
 * Classe qui vérifie les paramètres et les retours
 * 
 * @author Charles DUFOUR
 * @author Nicolas RIGNAULT
 *
 */
public class Generics {
	
	/**
	 * Vérifie le type des paramètre d'une méthode
	 * 
	 * @param classinfo la classe dont on souhaite vérifier les paramètres
	 * @param types le tableau de type contenant les paramètres attendus
	 * @param args les paramètres de la fonctions
	 * @throws LatentTypeCheckStaticException exception qui indique qu'il y a un problème de type
	 */
	public static void checkTypesParams(Class<?> classinfo, Class<?>[] types, Object[] args) throws LatentTypeCheckStaticException
	{
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
							throw new LatentTypeCheckStaticException("["+methodName+"(parameter "+(i+1)+")]bad type "+args[i].getClass().getSimpleName()+", waiting "+types[i].getSimpleName());
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
	 * @param typereturn la classe correspondant au type de retour de la fonction
	 * @throws LatentTypeCheckStaticException exception qui indique qu'il y a un problème de type
	 */
	public static void checkTypeReturn(Class<?> classinfo, Class<?>[] types, Object typereturn) throws LatentTypeCheckStaticException
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
						throw new LatentTypeCheckStaticException("["+methodName+"]bad returntype "+typereturn.getClass()+", waiting "+types[i].getSimpleName());
					}
				}
			}
		}
	}
}
