package fr.upmc.aladyn.dyn_generics.metaobjects;

import fr.upmc.aladyn.dyn_generics.tests.Generics2;
import fr.upmc.aladyn.reflection.Metaobject;

public class MyMetaObject extends Metaobject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 967068947015262702L;
	private Class<?>[] types;

	public MyMetaObject(Object self, Object[] args) {
		super(self, args);
		this.types = (Class<?>[]) args[0];
	}

	@Override
	public Object trapFieldRead(String name){
		Object fieldtype = super.trapFieldRead(name);
		System.out.println("[trapFieldRead]FieldName: "+name);
		Generics2.checkTypeField(getObject().getClass(), name, types, fieldtype.getClass());
		return fieldtype;
	}
	
	@Override
	public void trapFieldWrite(String name, Object value){
		System.out.println("[trapFieldWrite]FieldName: "+name);
		Generics2.checkTypeField(getObject().getClass(), name, types, value.getClass());
		super.trapFieldWrite(name, value);
	}
	
	@Override
	public Object trapMethodcall(int identifier, Object[] args) throws Throwable{
		System.out.println(this.getReturnType(identifier).getName());
		System.out.println("[trapMethodcall]FieldName: "+Thread.currentThread().getStackTrace()[3].getMethodName());
		//Generics2.checkTypesParams(getObject().getClass(), types, args);
		//Generics2.checkTypeReturn(getObject().getClass(), types);
		//Generics2.checkTypeReturn(this.getClass(), this.first.getClass(), types);
		Object o = super.trapMethodcall(identifier, args);
		System.out.println("L'objet de nos reves : " + o.getClass());
		return o;
	}
}
