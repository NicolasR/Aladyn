package fr.upmc.aladyn.dyn_generics.transform;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

public class Profiler {
	// Insertion � chaud de code Java dans la methode ctMethode d'une classe
	// ctClass. Notez que le code est un bloc entre { .. }
	public static void addInstrumentation(CtClass ctClass, CtMethod ctMethod)
			throws CannotCompileException {
		ctMethod.insertBefore("{ System.out.println(\"Salut par ici\"); }");
	}

	public static void main(String[] args) throws Exception { // Cr�ation d'un
																// pool de
																// classes par
																// javassist. Le
																// pool peut
																// �tre vu comme
																// un cache.
		ClassPool pool = ClassPool.getDefault();
		// extraction de notre classe Test.
		CtClass ctClass = pool
				.get("fr.upmc.aladyn.dyn_generics.transform.Test");
		// Recherche de la m�thode � modifier
		CtMethod ctMethod = ctClass.getDeclaredMethod("ma_methode");
		// Ajout du code � chaud
		addInstrumentation(ctClass, ctMethod);
		// On transforme le CtClass Javassist en Class Java classique et on
		// fabrique une nouvelle instance
		Class c = ctClass.toClass();
		Test test = (Test) c.newInstance(); // Appel de ma_methode
		test.ma_methode();
	}
}
