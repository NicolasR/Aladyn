package fr.upmc.aladyn.dyn_generics.tests;

import static junit.framework.Assert.assertTrue;

import org.junit.Test;


/*
 * Tests basiques sur les getters de Pair
 */
public class TestGetter1 {
	
	@Test
	public static void main(String[] args)
	{
		Pair p1 = new Pair(new Class<?>[]{Integer.class, Integer.class}, 10, 20);
		Pair p2 = new Pair(new Class<?>[]{String.class, Integer.class}, "test", 20);
		Pair p3 = new Pair(new Class<?>[]{Integer.class, String.class}, 10, "test");
		
		try {
			@SuppressWarnings("unused")
			Integer ret1 = (Integer)p1.getFirst();
			@SuppressWarnings("unused")
			Integer ret2 = (Integer)p1.getSecond();
			
			assertTrue(true);
		} catch (ClassCastException e) 
		{
			//On test si le cast marche pour s'assurer que le type est bon
			assertTrue(false);
		}
		
		try {
			@SuppressWarnings("unused")
			String ret1 = (String)p2.getFirst();
			@SuppressWarnings("unused")
			Integer ret2 = (Integer)p2.getSecond();
			
			assertTrue(true);
		}
		catch (ClassCastException e) 
		{
			//On test si le cast marche pour s'assurer que le type est bon
			assertTrue(false);
		}
		
		try {
			@SuppressWarnings("unused")
			Integer ret1 = (Integer)p3.getFirst();
			@SuppressWarnings("unused")
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
