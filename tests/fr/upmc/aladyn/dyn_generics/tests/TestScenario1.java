package fr.upmc.aladyn.dyn_generics.tests;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

import org.junit.Test;

import fr.upmc.aladyn.dyn_generics.pair.Pair;

/**
 * Scénario de test d'accès sur les types
 * 
 * @author Charles Dufour
 * @author Nicolas Rignault
 */
public class TestScenario1 {
	/**
	 * Scénario de test
	 * @param args les arguments passés à la fonction
	 */
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
