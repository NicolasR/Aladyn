package fr.upmc.aladyn.dyn_generics.transform;

import fr.upmc.aladyn.dyn_generics.tests.Pair;

public class MainUser {
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Pair p = new Pair(new Class<?>[]{Integer.class, Integer.class}, 10, 20);		
		p.getFirst();
		p.update(1, 1);
	}
}
