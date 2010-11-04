package fr.upmc.aladyn.dyn_generics.transform;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.NotFoundException;
import fr.upmc.aladyn.dyn_generics.annotations.DynamicGenericTypeParameters;
import fr.upmc.aladyn.reflection.Reflection;

public class MyReflectionInjection extends Reflection {
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
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.onLoad(pool, classname);
	}
}
