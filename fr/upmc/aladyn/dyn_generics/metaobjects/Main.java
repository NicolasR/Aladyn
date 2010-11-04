package fr.upmc.aladyn.dyn_generics.metaobjects;

import javassist.ClassPool;
import javassist.Loader;
public class Main {

	public static void main(String[] args) throws Throwable {
		
		MyReflection r = new MyReflection();
		ClassPool pool = ClassPool.getDefault();
		Loader cl = new Loader(pool);
		cl.addTranslator(pool, r);
		
		cl.run("fr.upmc.aladyn.dyn_generics.metaobjects.MainUser", args);
	}
}
