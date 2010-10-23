package fr.upmc.aladyn.dyn_generics.tests;

import static junit.framework.Assert.assertTrue;

import org.junit.Test;


public class TestInterception2 {
	
	@Test
	public static void main(String[] args)
	{
		try {
			Pair p = new Pair(new Class<?>[]{Integer.class, Integer.class}, 10, 20);
			p.getSecond();
			assertTrue(true);
		} catch (Throwable e) 
		{
			assertTrue(false);
		}
	}
}
