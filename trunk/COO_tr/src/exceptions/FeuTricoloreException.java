package exceptions;

/**
 * Classe FeuTricoloreException
 * @author Rémy GRASSART & Adrien MELOTTE
 */
public class FeuTricoloreException extends SemaphoreException {
    
    /**
     * Constructeur
     */
    public FeuTricoloreException() {
        System.out.println("Impossible d'instancier une classe FeuTricolore");
    }
    
    /**
     * Constructeur
     * @param msg Message a afficher
     */
    public FeuTricoloreException(String msg) {
        super(msg);
    }
    
}
