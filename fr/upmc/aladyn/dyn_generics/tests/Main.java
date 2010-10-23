package fr.upmc.aladyn.dyn_generics.tests;

import javassist.ClassPool;
import javassist.Loader;
import fr.upmc.aladyn.dyn_generics.metaobjects.MyReflection;
public class Main {

	public static void main(String[] args) throws Throwable {
		
		MyReflection r = new MyReflection();
		ClassPool pool = ClassPool.getDefault();
		Loader cl = new Loader(pool);
		cl.addTranslator(pool, r);
		
		cl.run("fr.upmc.aladyn.dyn_generics.tests.MainUser", args);
	}
}
