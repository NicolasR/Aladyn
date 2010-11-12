package fr.upmc.aladyn.dyn_generics.transform;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.NotFoundException;
import fr.upmc.aladyn.dyn_generics.annotations.DynamicGenericTypeParameters;
import fr.upmc.aladyn.reflection.Reflection;

/**
 * Effectue les injections si nécéssaires
 * @author Charles DUFOUR
 * @author Nicolas RIGNAULT
 *
 */
public class MyReflectionInjection extends Reflection {
	/**
	 * Injecte du code si la classe contient une annotation de type
	 * @param pool Le conteneur de la classe
	 * @param classname le nom de la classe
	 * @see fr.upmc.aladyn.reflection.Reflection#onLoad(javassist.ClassPool, java.lang.String)
	 */
	@Override
	public void onLoad(ClassPool pool, String classname)
			throws NotFoundException, CannotCompileException {
		
		CtClass ctClass = pool.get(classname);
		
		try {
			for (Object annot : ctClass.getAnnotations())
			{
				if (  annot instanceof DynamicGenericTypeParameters )
				{
					MyInjection.inject(ctClass);
					break;
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.onLoad(pool, classname);
	}
}
