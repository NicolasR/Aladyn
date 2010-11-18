package fr.upmc.aladyn.dyn_generics.metaobjects;

import fr.upmc.aladyn.dyn_generics.pair.Pair;

/**
 * Instancie la classe Pair
 * 
 * @author Charles DUFOUR
 * @author Nicolas RIGNAULT
 */
public class MainUser {

	/**
	 * Main qui instancie la classe pair
	 * @param args arguments passés en paramètre
	 */
	public static void main(String[] args)
	{
		System.out.println("[Injection]Crée la paire de nombres (10,20)");
		System.out.println("[Injection]Met à jour la paire (\"test\", 1) -> doit bloquer");
		Pair p = new Pair(new Class<?>[]{Number.class, Number.class}, 10, 20);
		p.update("test", 1);
	}

}
