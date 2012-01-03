package exceptions;

/**
 * Classe CapteurVitesseException
 * @author Rémy GRASSART & Adrien MELOTTE
 */
public class CapteurVitesseException extends CapteurException {
    
    /**
     * Constructeur
     */
    public CapteurVitesseException() {
        System.out.println("Impossible d'instancier une classe CapteurVitesse");
    }
    
    /**
     * Constructeur
     * @param msg Message a afficher
     */
    public CapteurVitesseException(String msg) {
        super(msg);
    }
    
}
