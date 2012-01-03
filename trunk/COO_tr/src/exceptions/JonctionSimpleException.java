package exceptions;

/**
 * Classe JonctionSimpleException
 * @author Rémy GRASSART & Adrien MELOTTE
 */
public class JonctionSimpleException extends JonctionException {
   
    /**
     * Constructeur
     */
    public JonctionSimpleException() {
        System.out.println("Impossible d'instancier une classe JonctionSimple");
    }
    
    /**
     * Constructeur
     * @param msg Message a afficher
     */
    public JonctionSimpleException(String msg) {
        super(msg);
    }
    
}
