package exceptions;

/**
 * Classe Capteur
 * @author Rémy GRASSART & Adrien MELOTTE
 */
public class TrainException extends MoyenTransportException {
    
    /**
     * Constructeur
     */
    public TrainException() {
        System.out.println("Impossible d'instancier une classe Train");
    }
    
    /**
     * Constructeur
     * @param msg Message a afficher
     */
    public TrainException(String msg) {
        super(msg);
    }
    
}
