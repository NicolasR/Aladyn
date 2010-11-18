package fr.upmc.aladyn.dyn_generics.metaobjects;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.NotFoundException;
import fr.upmc.aladyn.dyn_generics.annotations.DynamicGenericTypeParameters;
import fr.upmc.aladyn.reflection.Reflection;

/**
 * Hérite de reflection et reimplémente la réflexion pour une classe donnée en paramètre
 * @author Charles DUFOUR
 * @author Nicolas RIGNAULT
 *
 */
public class MyReflection extends Reflection {
	
	/** 
	 * Rend une classe réflexive au au chargement
	 * @param pool Conteneur de la classe
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
					makeReflective(classname, "fr.upmc.aladyn.dyn_generics.metaobjects.MyMetaObject", "fr.upmc.aladyn.dyn_generics.metaobjects.MyClassMetaObject");
					break;
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		super.onLoad(pool, classname);
	}
}
