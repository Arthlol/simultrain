package exceptions;

/**
 * Classe MoyenTransportException
 * @author Rémy GRASSART & Adrien MELOTTE
 */
public class MoyenTransportException extends Exception {
    
    /**
     * Constructeur
     */
    public MoyenTransportException() {
        System.out.println("Impossible d'instancier une classe MoyenTransport");
    }
    
    /**
     * Constructeur
     * @param msg Message a afficher
     */
    public MoyenTransportException(String msg) {
        super(msg);
    }
    
}
