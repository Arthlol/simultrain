package exceptions;

/**
 * Classe EltVoieException
 * @author Rémy GRASSART & Adrien MELOTTE
 */
public class EltVoieException extends Exception {
   
    /**
     * Constructeur
     */
    public EltVoieException() {
        System.out.println("Impossible d'instancier une classe EltVoie");
    }
    
    /**
     * Constructeur
     * @param msg Message a afficher
     */
    public EltVoieException(String msg) {
        super(msg);
    }
    
}
