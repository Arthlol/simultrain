package exceptions;

/**
 * Classe RailException
 * @author Rémy GRASSART & Adrien MELOTTE
 */
public class RailException extends EltVoieException {
    
    /**
     * Constructeur
     */
    public RailException() {
        System.out.println("Impossible d'instancier une classe Rail");
    }
    
    /**
     * Constructeur
     * @param msg Message a afficher
     */
    public RailException(String msg) {
        super(msg);
    }
    
}
