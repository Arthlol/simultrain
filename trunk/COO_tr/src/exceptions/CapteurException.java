package exceptions;

/**
 * Classe CapteurException
 * @author Rémy GRASSART & Adrien MELOTTE
 */
public class CapteurException extends Exception {
    
    /**
     * Constructeur
     */
    public CapteurException() {
        System.out.println("Impossible d'instancier une classe Capteur");
    }
    
    /**
     * Constructeur
     * @param msg Message a afficher
     */
    public CapteurException(String msg) {
        super(msg);
    }
    
}
