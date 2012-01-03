package exceptions;

/**
 * Classe SemaphoreException
 * @author Rémy GRASSART & Adrien MELOTTE
 */
public class SemaphoreException extends Exception {
    
    /**
     * Constructeur
     */
    public SemaphoreException() {
        System.out.println("Impossible d'instancier une classe Semaphore");
    }
    
    /**
     * Constructeur
     * @param msg Message a afficher
     */
    public SemaphoreException(String msg) {
        super(msg);
    }
    
}
