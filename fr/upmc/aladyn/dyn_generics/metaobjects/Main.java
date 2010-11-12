package fr.upmc.aladyn.dyn_generics.metaobjects;

import javassist.ClassPool;
import javassist.Loader;

/**
 * Réflection par Interception
 * Exécute le MainUser et rend la classe associée refléxive
 * 
 * @author Charles DUFOUR
 * @author Nicolas RIGNAULT
 *
 */
public class Main {

	/**
	 * Exécute l'interception
	 * 
	 * @param args arguments passés en paramètre
	 * @throws Throwable une exception
	 */
	public static void main(String[] args) throws Throwable {
		
		MyReflection r = new MyReflection();
		ClassPool pool = ClassPool.getDefault();
		Loader cl = new Loader(pool);
		cl.addTranslator(pool, r);
		
		cl.run("fr.upmc.aladyn.dyn_generics.metaobjects.MainUser", args);
	}
}
