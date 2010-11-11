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
		return second;	
	}

	public void update(@DynamicGenericType("firstType") Object first, @DynamicGenericType("secondType") Object second) 
	{
		this.first = first;
		this.second = second;
	}
	
}
