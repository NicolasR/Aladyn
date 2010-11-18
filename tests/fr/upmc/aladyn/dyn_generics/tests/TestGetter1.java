package fr.upmc.aladyn.dyn_generics.tests;

import static junit.framework.Assert.assertTrue;

import org.junit.Test;

import fr.upmc.aladyn.dyn_generics.pair.Pair;


/**
 * Tests basiques sur les accesseurs de Pair
 * @author Charles Dufour
 * @author Nicolas Rignault
 * 
 */
public class TestGetter1 {
	
	/**
	 * Effectue les tests
	 * @param args arguments de la fonction
	 */
	@Test
	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		Pair p1 = new Pair(new Class<?>[]{Integer.class, Integer.class}, 10, 20);
		Pair p2 = new Pair(new Class<?>[]{String.class, Integer.class}, "test", 20);
		Pair p3 = new Pair(new Class<?>[]{Integer.class, String.class}, 10, "test");
		
		try {
			Integer ret1 = (Integer)p1.getFirst();
			Integer ret2 = (Integer)p1.getSecond();
			
			assertTrue(true);
		} catch (ClassCastException e) 
		{
			//On test si le cast marche pour s'assurer que le type est bon
			assertTrue(false);
		}
		
		try {
			
			String ret1 = (String)p2.getFirst();
			Integer ret2 = (Integer)p2.getSecond();
			
			assertTrue(true);
		}
		catch (ClassCastException e) 
		{
			//On test si le cast marche pour s'assurer que le type est bon
			assertTrue(false);
		}
		
		try {
			Integer ret1 = (Integer)p3.getFirst();
			String ret2 = (String)p3.getSecond();
			
			assertTrue(true);
		}
		catch (ClassCastException e) 
		{
			//On test si le cast marche pour s'assurer que le type est bon
			assertTrue(false);
		}
	}
}
