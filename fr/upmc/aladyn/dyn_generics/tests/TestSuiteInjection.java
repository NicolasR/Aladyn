package fr.upmc.aladyn.dyn_generics.tests;

import javassist.ClassPool;
import javassist.Loader;

import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Suite.SuiteClasses;

import fr.upmc.aladyn.dyn_generics.transform.MyReflectionInjection;

@SuiteClasses(value={TestMethod1.class, TestGetter1.class, TestScenario1.class, TestScenario2.class})
public class TestSuiteInjection {
	
	MyReflectionInjection r;
	ClassPool pool;
	Loader cl;
	
	@Before
	public void setUp() throws Exception
	{
		r = new MyReflectionInjection();
		pool = ClassPool.getDefault();
		cl = new Loader(pool);
		cl.addTranslator(pool, r);
	}
	
	@Test
	public void testLoad() throws Throwable
	{	
		Class<?>[] annotation = TestSuiteInjection.class.getAnnotation(SuiteClasses.class).value();
		
		for (int i = 0; i < annotation.length; i++) {
			cl.run(annotation[i].getName(), null);
		}
	}
}
