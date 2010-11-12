package fr.upmc.aladyn.dyn_generics.metaobjects;

import fr.upmc.aladyn.reflection.Metaobject;

/**
 * Hérite de Metaobject et intercepte les différents appels que l'on souhaite modifier
 * 
 * @author Charles DUFOUR
 * @author Nicolas RIGNAULT
 */
public class MyMetaObject extends Metaobject {

	/**
	 * Numéro de version associé à la classe
	 */
	private static final long serialVersionUID = 967068947015262702L;
	
	/**
	 * Tableau de types correspondant aux types attendus
	 */
	private Class<?>[] types;

	/**
	 * Constructeur du MetaObject
	 * @param self la classe reflective
	 * @param args les arguments passés au constructeur de la classe self
	 */
	public MyMetaObject(Object self, Object[] args) {
		super(self, args);
		this.types = (Class<?>[]) args[0];
	}

	/**
	 * Redéfinition de la méthode qui intercepte les lectures d'attribut
	 * @param name le nom de l'attribut
	 * @see fr.upmc.aladyn.reflection.Metaobject#trapFieldRead(java.lang.String)
	 * @return l'attribut
	 */
	@Override
	public Object trapFieldRead(String name){
		Object fieldtype = super.trapFieldRead(name);
		Generics.checkTypeField(getObject().getClass(), name, types, fieldtype.getClass());
		return fieldtype;
	}
	
	/**
	 * Redéfinition de la méthode qui intercepte les écritures d'attribut
	 * @param name le nom de l'attribut
	 * @param value la valeur que l'on souhaite donner à l'attribut
	 * @see fr.upmc.aladyn.reflection.Metaobject#trapFieldWrite(java.lang.String, java.lang.Object)
	 */
	@Override
	public void trapFieldWrite(String name, Object value){
		Generics.checkTypeField(getObject().getClass(), name, types, value.getClass());
		super.trapFieldWrite(name, value);
	}
	
	/**
	 * Redéfinition de la méthode qui intercepte les appels de méthode
	 * @param identifier le numéro identifiant la méthode
	 * @param args les arguments passés à la méthode
	 * @return le résultat
	 * @see fr.upmc.aladyn.reflection.Metaobject#trapMethodcall(int, java.lang.Object[])
	 */
	@Override
	public Object trapMethodcall(int identifier, Object[] args) throws Throwable{
		String methodName = "_m_"+identifier+"_"+getMethodName(identifier);
		Generics.checkTypesParams(getObject().getClass(), types, methodName, args);
		Object o = super.trapMethodcall(identifier, args);
		if (o != null)
		{
			Generics.checkTypeReturn(getObject().getClass(), types, methodName, o.getClass());
		}

		return o;
	}
}
