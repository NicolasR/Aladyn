package fr.upmc.aladyn.dyn_generics.exceptions;

/**
 * Hérite de Exception: lancée si le type trouvé ne correspond pas au type attendu
 * Peut être rattrapée
 * @author Charles DUFOUR
 * @author Nicolas RIGNAULT
 *
 */
public class LatentTypeCheckStaticException extends Exception 
{
	private static final long serialVersionUID = 1L;
	
	/**
	 * Appel le constructeur de Exception, affiche un message
	 * 
	 * @param string le message à afficher
	 */
	public LatentTypeCheckStaticException(String string) 
	{
		super(string);
	}
}
