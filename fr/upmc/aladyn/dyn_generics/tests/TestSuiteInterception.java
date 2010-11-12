package fr.upmc.aladyn.dyn_generics.tests;

import javassist.ClassPool;
import javassist.Loader;

import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Suite.SuiteClasses;

import fr.upmc.aladyn.dyn_generics.metaobjects.MyReflection;

@SuiteClasses(value={TestGetter1.class, TestMethod1.class, TestScenario1.class, TestScenario2.class})
public class TestSuiteInterception {
	
	MyReflection r;
	ClassPool pool;
	Loader cl;
	
	@Before
	public void setUp() throws Exception
	{
		r = new MyReflection();
		pool = ClassPool.getDefault();
		cl = new Loader(pool);
		cl.addTranslator(pool, r);
	}
	
	@Test
	public void testLoad() throws Throwable
	{	
		Class<?>[] annotation = TestSuiteInterception.class.getAnnotation(SuiteClasses.class).value();
		
		for (int i = 0; i < annotation.length; i++) {
			cl.run(annotation[i].getName(), null);
		}
	}
}
