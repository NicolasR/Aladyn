package fr.upmc.aladyn.dyn_generics.tests;

import javassist.ClassPool;
import javassist.Loader;
import fr.upmc.aladyn.reflection.Reflection;
public class Main2 {

	public static void main(String[] args) throws Throwable {
		//Pair p = new Pair(new Class<?>[]{Integer.class, Integer.class}, 10, 20);
		
		// Bon types : ca passe
		//p.getFirst();
		
		// mauvais type : ca passe plus !
		//p.update(2, 3);
		//MyMetaObject metaobj = new MyMetaObject();
		
		Reflection r = new Reflection();
		ClassPool pool = ClassPool.getDefault();
		Loader cl = new Loader(pool);
		cl.addTranslator(pool, r);
		
		
		r.makeReflective("fr.upmc.aladyn.dyn_generics.tests.Pair",
				"fr.upmc.aladyn.dyn_generics.metaobjects.MyMetaObject", 
				"fr.upmc.aladyn.dyn_generics.metaobjects.MyClassMetaObject");
		r.onLoad(pool, "fr.upmc.aladyn.dyn_generics.tests.Pair");
		cl.run("fr.upmc.aladyn.dyn_generics.tests.Pair", args);
	}
}
