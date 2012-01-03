package exceptions;

/**
 * Classe CapteurPresenceException
 * @author Rémy GRASSART & Adrien MELOTTE
 */
public class CapteurPresenceException extends CapteurException {
    
    /**
     * Constructeur
     */
    public CapteurPresenceException() {
        System.out.println("Impossible d'instancier une classe CapteurPresence");
    }
    
    /**
     * Constructeur
     * @param msg Message a afficher
     */
    public CapteurPresenceException(String msg) {
        super(msg);
    }
    
}
