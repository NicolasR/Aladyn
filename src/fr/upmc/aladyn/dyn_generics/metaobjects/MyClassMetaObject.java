package fr.upmc.aladyn.dyn_generics.metaobjects;

import fr.upmc.aladyn.reflection.ClassMetaobject;

/**
 * Hérite de ClassMetaobject afin d'effectuer de la refléxion
 * 
 * @author Charles DUFOUR
 * @author Nicolas RIGNAULT
 *
 */
public class MyClassMetaObject extends ClassMetaobject {

	/**
	 * Id généré
	 */
	private static final long serialVersionUID = -3727521159911031690L;

	/**
	 * @param params params[0] est le nom de la classe des objects refléxifs.
	 */
	public MyClassMetaObject(String[] params) {
		super(params);
	}

}
