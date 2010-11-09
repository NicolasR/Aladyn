package fr.upmc.aladyn.dyn_generics.tests;

import javassist.ClassPool;
import javassist.Loader;

import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Suite.SuiteClasses;

import fr.upmc.aladyn.dyn_generics.metaobjects.MyReflection;

//@RunWith(Suite.class)
@SuiteClasses(value={TestInterceptionGetter1.class, TestInterceptionMethod1.class})
public class TestSuite {
	
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
		Class<?>[] annotation = TestSuite.class.getAnnotation(SuiteClasses.class).value();
		
		for (int i = 0; i < annotation.length; i++) {
			cl.run(annotation[i].getName(), null);
		}
	}
}
