package fr.upmc.aladyn.dyn_generics.tests;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import org.junit.Test;

import fr.upmc.aladyn.dyn_generics.pair.Pair;

/**
 * Scénario de test d'accès sur la vérification de types en présence de types hérités
 * 
 * @author Charles Dufour
 * @author Nicolas Rignault
 */
public class TestScenario2 {
	/**
	 * Scénario de test
	 * @param args les arguments passés à la fonction
	 */
	@SuppressWarnings("unchecked")
	@Test
	public static void main(String[] args)
	{
		Pair p = new Pair(new Class<?>[]{Number.class, Iterable.class}, 10, new LinkedList<String>());
		
		try
		{
			ArrayList<String> tmp = new ArrayList<String>();
			tmp.add("test");
			p.update((Double)13.37, tmp);
			assertTrue(true);
		}
		catch (Exception e) {
			assertTrue(false);
		}
		
		try
		{
			p.update(10, new HashMap<String, Object>());
			assertTrue(false);
		}
		catch (Exception e) {
			assertTrue(true);
		}
		
		try
		{
			assertEquals(13.37, (Double)p.getFirst(), 0.1);
			assertEquals("test", ((ArrayList<String>)p.getSecond()).get(0));
			assertTrue(true);
		}
		catch (Exception e)
		{
			assertTrue(false);
		}
	}
}
