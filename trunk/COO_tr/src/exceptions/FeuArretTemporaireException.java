package exceptions;

/**
 * Classe FeuArretTemporaireException
 * @author Rémy GRASSART & Adrien MELOTTE
 */
public class FeuArretTemporaireException extends SemaphoreException {
   
    /**
     * Constructeur
     */
    public FeuArretTemporaireException() {
        System.out.println("Impossible d'instancier une classe FeuArretTemporaire");
    }
    
    /**
     * Constructeur
     * @param msg Message a afficher
     */
    public FeuArretTemporaireException(String msg) {
        super(msg);
    }
    
}
