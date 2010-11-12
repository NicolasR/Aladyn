package fr.upmc.aladyn.dyn_generics.transform;

import javassist.ClassPool;
import javassist.Loader;
/**
 * Réflection par Injection
 * Exécute le MainUser
 * 
 * @author Charles DUFOUR
 * @author Nicolas RIGNAULT
 *
 */
public class Main {
	
	/**
	 * Exécute l'injection
	 * 
	 * @param args arguments passés en paramètre
	 * @throws Throwable une exception
	 */
	public static void main(String[] args) throws Throwable {
		
		MyReflectionInjection r = new MyReflectionInjection();
		ClassPool pool = ClassPool.getDefault();
		Loader cl = new Loader(pool);
		cl.addTranslator(pool, r);
		
		cl.run("fr.upmc.aladyn.dyn_generics.transform.MainUser", args);
	}
}
