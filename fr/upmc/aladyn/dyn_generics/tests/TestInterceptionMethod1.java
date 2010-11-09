package fr.upmc.aladyn.dyn_generics.tests;

import static junit.framework.Assert.assertTrue;

import org.junit.Test;


public class TestInterceptionMethod1 {
	
	@Test
	public static void main(String[] args)
	{
		Pair p = new Pair(new Class<?>[]{Integer.class, Integer.class}, 10, 20);
		
		try {
			p.update(10, 40);
			assertTrue(true);
		} catch (RuntimeException e) 
		{
			assertTrue(false);
		}
		
		try {
			p.update("test", 40);
			assertTrue(false);
			
		}
		catch (RuntimeException e) 
		{
			System.out.println("AHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH");
			assertTrue(true);
		}
	}
}
