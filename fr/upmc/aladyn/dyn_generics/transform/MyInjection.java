package fr.upmc.aladyn.dyn_generics.transform;

import javassist.CannotCompileException;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;
import javassist.expr.ExprEditor;
import javassist.expr.MethodCall;
import fr.upmc.aladyn.dyn_generics.annotations.DynamicGenericType;

public class MyInjection {
	
	public static void inject(CtClass ctClass) throws CannotCompileException, ClassNotFoundException, NotFoundException
	{
		for (CtMethod m : ctClass.getMethods()) 
		{
			for (int i = 0; i < m.getAnnotations().length; i++) 
			{	
				if ( m.getAnnotations()[i] instanceof DynamicGenericType )
				{System.out.println("coucou");
					m.instrument(
						    new ExprEditor() {
						        public void edit(MethodCall method)
						                      throws CannotCompileException
						        {
						            if (method.getClassName().equals("Pair")
						                          && method.getMethodName().equals("getFirst"))
						            	method.replace("{ Object value = ($r)$proceed(); = 0; $_ = value; }");
						        }
						    });

					
					//m.insertBefore("fr.upmc.aladyn.dyn_generics.transform.Generics.checkTypeReturn(this.getClass(), $_,this.types);");
				}
			}
				for (int i = 0; i < m.getParameterAnnotations().length; i++) 
				{
					Object[] tmp = m.getParameterAnnotations()[i];
					for (int j = 0; j < tmp.length; j++) 
					{
						if (tmp[0] instanceof DynamicGenericType )
						{
							//TODO refaire la methode checktypesaparams pour l'injection, car le tableau de parametres est obsolete.
							m.insertBefore("System.out.println(\"Injection !!!!\");");
							//m.insertBefore("fr.upmc.aladyn.dyn_generics.transform.Generics.checkTypeParams(this.getClass(), this.types);");
							break;
						}
					}
					
				}
		}
	}
}
