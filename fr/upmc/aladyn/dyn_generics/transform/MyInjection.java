package fr.upmc.aladyn.dyn_generics.transform;

import javassist.CannotCompileException;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;
import fr.upmc.aladyn.dyn_generics.annotations.DynamicGenericType;

public class MyInjection {
	
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
						if (tmp[0] instanceof DynamicGenericType )
						{
							m.insertBefore("fr.upmc.aladyn.dyn_generics.transform.Generics.checkTypesParams(this.getClass(), this.types, $args);");
							break;
						}
					}
					
				}
		}
	}
}
