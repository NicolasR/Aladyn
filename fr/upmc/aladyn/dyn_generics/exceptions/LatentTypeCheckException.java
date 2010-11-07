package fr.upmc.aladyn.dyn_generics.exceptions;

/**
 * Hérite de RuntimeException: lancée si le type trouvé ne correspond pas au type attendu
 * Ne peut être rattrapée
 * @author Charles DUFOUR
 * @author Nicolas RIGNAULT
 *
 */
public class LatentTypeCheckException extends RuntimeException 
{
	private static final long serialVersionUID = 1L;

	/**
	 * Appel le constructeur de RuntimeException, affiche un message
	 * 
	 * @param string le message que l'on souhaite afficher
	 */
	public LatentTypeCheckException(String string) 
	{
		super(string);
	}

}
