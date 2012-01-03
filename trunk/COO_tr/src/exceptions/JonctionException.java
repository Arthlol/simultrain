package exceptions;

/**
 * Classe JonctionException
 * @author Rémy GRASSART & Adrien MELOTTE
 */
public class JonctionException extends EltVoieException {
   
    /**
     * Constructeur
     */
    public JonctionException() {
        System.out.println("Impossible d'instancier une classe Jonction");
    }
    
    /**
     * Constructeur
     * @param msg Message a afficher
     */
    public JonctionException(String msg) {
        super(msg);
    }
    
}
