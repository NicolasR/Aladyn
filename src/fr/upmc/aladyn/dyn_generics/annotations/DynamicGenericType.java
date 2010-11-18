package fr.upmc.aladyn.dyn_generics.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Déclare les annotations pour un type précis
 * @author Charles DUFOUR
 * @author Nicolas RIGNAULT
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
public @interface DynamicGenericType {
	/**
	 * Nom identifiant le type
	 * @return le nom du type
	 */
	String value();
}
