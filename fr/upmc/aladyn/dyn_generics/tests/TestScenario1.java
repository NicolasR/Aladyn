package fr.upmc.aladyn.dyn_generics.tests;

import static junit.framework.Assert.*;

import org.junit.Test;


public class TestScenario1 {
	@Test
	public static void main(String[] args)
	{
		Pair p = new Pair(new Class<?>[]{Integer.class, Integer.class}, 10, 20);

		try
		{
			p.update(4, 3);
			assertTrue(true);
		}
		catch (Exception e) 
		{
			assertTrue(false);
		}
		
		try
		{
			p.update("test", 3);
			assertTrue(false);
		}
		catch (Exception e) 
		{
			assertTrue(true);
		}
		
		try
		{
			p.update(1, 2);
			assertTrue(true);
		}
		catch (Exception e) 
		{
			assertTrue(false);
		}
		
		try
		{
			p.update(42, "test");
			assertTrue(false);
		}
		catch (Exception e) 
		{
			assertTrue(true);
		}

		try
		{
			//On vérifie que les appels manqués n'ont pas modifié les valeurs
			assertEquals(1, ((Integer)p.getFirst()).intValue());
			assertEquals(2, ((Integer)p.getSecond()).intValue());
			assertTrue(true);
		}
		catch (Exception e) 
		{
			assertTrue(false);
		}
	}
}
