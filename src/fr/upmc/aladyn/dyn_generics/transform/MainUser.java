package fr.upmc.aladyn.dyn_generics.transform;

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
		Pair p = new Pair(new Class<?>[]{Number.class, Number.class}, 10, 20);
		System.out.println("[Injection]Récupère le premier élément (p.getFirst())");
		p.getFirst();
		System.out.println("[Injection]Met à jour la paire (1.1,2))");
		p.update(1.1, 2);
	}
}
