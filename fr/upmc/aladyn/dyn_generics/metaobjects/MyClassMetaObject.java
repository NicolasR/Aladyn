package fr.upmc.aladyn.dyn_generics.metaobjects;

import fr.upmc.aladyn.reflection.ClassMetaobject;

/**
 * Hérite de ClassMetaobject afin d'effectuer de la réflection
 * 
 * @author Charles DUFOUR
 * @author Nicolas RIGNAULT
 *
 */
public class MyClassMetaObject extends ClassMetaobject {

	/**
	 * @param params
	 */
	public MyClassMetaObject(String[] params) {
		super(params);
	}

}
