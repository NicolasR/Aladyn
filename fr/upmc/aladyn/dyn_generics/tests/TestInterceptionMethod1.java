package fr.upmc.aladyn.dyn_generics.tests;

import static junit.framework.Assert.assertTrue;

import org.junit.Test;


public class TestInterceptionMethod1 {
	
	@Test
	public static void main(String[] args)
	{
		Pair p = new Pair(new Class<?>[]{Integer.class, Integer.class}, 10, 20);
		
		try {
			p.update(30, 40);
			assertTrue(true);
		} catch (Throwable e) 
		{
			assertTrue(false);
		}
		
		try {
			p.update("test", 40);
			assertTrue(false);
			
		}
		catch (Throwable e) 
		{
			assertTrue(true);
		}
	}
}
