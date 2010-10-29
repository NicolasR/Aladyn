package fr.upmc.aladyn.dyn_generics.tests;

public class MainUser {

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Pair p = new Pair(new Class<?>[]{Integer.class, Integer.class}, 10, 10);
		//System.out.println(p.first);
		//p.getFirst();
		p.update((Integer)1, (Integer)1);
	}

}
