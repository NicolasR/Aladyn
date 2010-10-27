package fr.upmc.aladyn.dyn_generics.transform;

import javassist.ClassPool;
import javassist.Loader;
import fr.upmc.aladyn.dyn_generics.metaobjects.MyReflectionInjection;
public class Main {

	public static void main(String[] args) throws Throwable {
		
		MyReflectionInjection r = new MyReflectionInjection();
		ClassPool pool = ClassPool.getDefault();
		Loader cl = new Loader(pool);
		cl.addTranslator(pool, r);
		
		cl.run("fr.upmc.aladyn.dyn_generics.transform.MainUser", args);
	}
}
