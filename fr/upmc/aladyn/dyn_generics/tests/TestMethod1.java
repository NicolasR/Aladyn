package fr.upmc.aladyn.dyn_generics.tests;

import static junit.framework.Assert.*;

import org.junit.Test;

/*
 * Tests basiques sur la méthode update
 */
public class TestMethod1 {
	
	@Test
	public static void main(String[] args)
	{
		Pair p = new Pair(new Class<?>[]{Integer.class, Integer.class}, 10, 20);
		Pair p2 = new Pair(new Class<?>[]{Number.class, Number.class}, 10, 20);
		
		try {
			p.update(10, 40);
			assertTrue(true);
		} catch (Exception e) 
		{
			assertTrue(false);
		}
		
		try {
			p.update("test", 40);
			assertTrue(false);
			
		}
		catch (Exception e) 
		{
			assertTrue(true);
		}
		
		try {
			p.update(20, "test");
			assertTrue(false);
			
		}
		catch (Exception e) 
		{
			assertTrue(true);
		}
		
		try {
			p.update("test", "test");
			assertTrue(false);
			
		}
		catch (Exception e) 
		{
			assertTrue(true);
		}
		
		try {
			p2.update(20.3, 10);
			assertTrue(true);
			
		}
		catch (Exception e) 
		{
			assertTrue(false);
		}
		
		try {
			p2.update((Double)20.3, (Double)10.3);
			assertTrue(true);
			
		}
		catch (Exception e) 
		{
			assertTrue(false);
		}
	}
}
