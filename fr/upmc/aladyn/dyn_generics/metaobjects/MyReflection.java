package fr.upmc.aladyn.dyn_generics.metaobjects;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.NotFoundException;
import fr.upmc.aladyn.dyn_generics.annotations.DynamicGenericTypeParameters;
import fr.upmc.aladyn.reflection.Reflection;

public class MyReflection extends Reflection {
	
	@Override
	public void onLoad(ClassPool pool, String classname)
			throws NotFoundException, CannotCompileException {
		
		CtClass ctClass = pool.get(classname);
		//System.out.println(classname);
	    /*for (CtMethod ctMethod:ctClass.getDeclaredMethods()) {
	       // On évite de chercher à modifier des méthodes natives ;-)
	       if (!Modifier.isNative(ctMethod.getModifiers())) {
	       }
	    }*/
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.onLoad(pool, classname);
	}
}
