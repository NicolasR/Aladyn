package fr.upmc.aladyn.dyn_generics.transform;

import fr.upmc.aladyn.dyn_generics.tests.Pair;

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
		Pair p = new Pair(new Class<?>[]{Integer.class, Integer.class}, 10, 20);
		p.getFirst();
		p.update("test", 2);
	}
}
