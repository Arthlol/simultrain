package exceptions;

/**
 * Classe FeuBicoloreException
 * @author Rémy GRASSART & Adrien MELOTTE
 */
public class FeuBicoloreException extends SemaphoreException {
    
    /**
     * Constructeur
     */
    public FeuBicoloreException() {
        System.out.println("Impossible d'instancier une classe FeuBicolore");
    }
    
    /**
     * Constructeur
     * @param msg Message a afficher
     */
    public FeuBicoloreException(String msg) {
        super(msg);
    }
    
}
