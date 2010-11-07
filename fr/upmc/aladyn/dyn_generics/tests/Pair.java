package fr.upmc.aladyn.dyn_generics.tests;

import fr.upmc.aladyn.dyn_generics.annotations.DynamicGenericType;
import fr.upmc.aladyn.dyn_generics.annotations.DynamicGenericTypeParameters;

/**
 * Crée une pair d'élements
 * 
 * @author Charles DUFOUR
 * @author Nicolas RIGNAULT
 *
 */
@DynamicGenericTypeParameters(typeParams={"firstType", "secondType"})
public class Pair 
{	
	@DynamicGenericType("firstType") private Object first;
	@DynamicGenericType("secondType") private Object second;
	
	/**
	 * Tableau correspondant aux types attendus
	 */
	@SuppressWarnings("unused")
	private Class<?>[] types;
	
	/**
	 * Crée la pair d'éléments
	 * 
	 * @param types les types des éléments
	 * @param first le premier élément
	 * @param second le second élément
	 */
	public Pair(Class<?>[] types, @DynamicGenericType("firstType") Object first, @DynamicGenericType("secondType") Object second)
	{
		this.types = types;
		this.first = first;
		this.second = second;
	}

	/**
	 * Renvoie le premier élément
	 * 
	 * @return le premier élément
	 */
	@DynamicGenericType("firstType")
	public Object getFirst()
	{		
		/*String methodName = (new Exception()).getStackTrace()[0].getMethodName();
		try {
			String type = this.getClass().getMethod(methodName).getAnnotation(DynamicGenericType.class).value();
			
			String[] typeParams = this.getClass().getAnnotation(DynamicGenericTypeParameters.class).typeParams();
			for (int i = 0; i < typeParams.length; i++) {
				if ( type.equals(typeParams[i]) )
				{
					if (this.first.getClass().equals(this.types[i]))
					{
						return first;
					}
				}
			}
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		throw new LatentTypeCheckException(methodName);*/

		//Generics2.checkTypesParams(this.getClass(), this.first.getClass(), types);
		//Generics2.checkTypeReturn(this.getClass(), this.first.getClass(), types);
		//Generics.checkTypesParam(types, this.getClass());
		//Generics.checkTypesReturn(types, this.getClass());
		//System.out.println("gg");
		return first;
	}

	/**
	 * Recupère le second élément
	 * 
	 * @return le second élément
	 */
	@DynamicGenericType("secondType")
	public Object getSecond()
	{
		/*String methodName = (new Exception()).getStackTrace()[0].getMethodName();
		try {
			String type = this.getClass().getMethod(methodName).getAnnotation(DynamicGenericType.class).value();
			
			String[] typeParams = this.getClass().getAnnotation(DynamicGenericTypeParameters.class).typeParams();
			for (int i = 0; i < typeParams.length; i++) {
				if ( type.equals(typeParams[i]) )
				{
					if (this.second.getClass().equals(this.types[i]))
					{
						return second;
					}
				}
			}
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		throw new LatentTypeCheckException(methodName);*/
		//Generics.checkTypesParam(types);
		//Generics2.checkTypesParams(this.getClass(), this.first.getClass(), types);
		//Generics2.checkTypeReturn(this.getClass(), this.first.getClass(), types);
		return second;	
	}

	public void update(@DynamicGenericType("firstType") Object first, @DynamicGenericType("secondType") Object second) 
	{
		/*String methodName = (new Exception()).getStackTrace()[0].getMethodName();
		try {
			Annotation paramType1 = this.getClass().getMethod(methodName, Object.class, Object.class).getParameterAnnotations()[0][0];
			Annotation paramType2 = this.getClass().getMethod(methodName, Object.class, Object.class).getParameterAnnotations()[1][0];
			
			String[] typeParams = this.getClass().getAnnotation(DynamicGenericTypeParameters.class).typeParams();
			for (int i = 0; i < typeParams.length; i++) {
				if ( ((DynamicGenericType)paramType1).value().equals(typeParams[i]) )
				{
					if (first.getClass().equals(this.types[i]))
					{
						this.first = first;
					}
					else
					{
						throw new LatentTypeCheckException(methodName);
					}
				}
			}
			for (int i = 0; i < typeParams.length; i++) {
				if ( ((DynamicGenericType)paramType2).value().equals(typeParams[i]) )
				{
					if (second.getClass().equals(this.types[i]))
					{
						this.second = second;
					}
					else
					{
						throw new LatentTypeCheckException(methodName);
					}
				}
			}
			
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		//Generics.checkTypesParam(types);
		//Generics2.checkTypesParams(this.getClass(), this.first.getClass(), types);
		//Generics2.checkTypeReturn(this.getClass(), this.first.getClass(), types);
		this.first = first;
		this.second = second;
	}
	
}
