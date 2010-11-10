package fr.upmc.aladyn.dyn_generics.transform;

import javassist.CannotCompileException;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;
import fr.upmc.aladyn.dyn_generics.annotations.DynamicGenericType;

/**
 * @author Charles DUFOUR
 * @author Nicolas RIGNAULT
 * Effectue les injections nécessaires pour effectuer les vérifications
 */
public class MyInjection {
	
	/**
	 * Effectue l'injection de code dans la classe donnée
	 * @param ctClass la classe où l'on souhaite ajouter du code
	 * @throws CannotCompileException Exception qui indique une erreur de compilation
	 * @throws ClassNotFoundException Exception qui indique que la classe n'a pas été trouvée
	 * @throws NotFoundException Exception qui indique que l'élément n'a pas été trouvé
	 */
	public static void inject(CtClass ctClass) throws CannotCompileException, ClassNotFoundException, NotFoundException
	{
		for (CtMethod m : ctClass.getMethods()) 
		{
			for (int i = 0; i < m.getAnnotations().length; i++) 
			{	
				if ( m.getAnnotations()[i] instanceof DynamicGenericType )

				{
					m.insertAfter("fr.upmc.aladyn.dyn_generics.transform.Generics.checkTypeReturn(this.getClass(), this.types, $_);");
				}
			}
				for (int i = 0; i < m.getParameterAnnotations().length; i++) 
				{
					Object[] tmp = m.getParameterAnnotations()[i];
					for (int j = 0; j < tmp.length; j++) 
					{
						if (tmp[j] instanceof DynamicGenericType )
						{
							m.insertBefore("fr.upmc.aladyn.dyn_generics.transform.Generics.checkTypesParams(this.getClass(), this.types, $args);");
							break;
						}
					}
					
				}
		}
	}
}
