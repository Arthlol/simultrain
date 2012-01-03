package exceptions;

/**
 * Classe AiguillageException
 * @author Rémy GRASSART & Adrien MELOTTE
 */
public class AiguillageException extends JonctionException {
    
    /**
     * Constructeur
     */
    public AiguillageException() {
        System.out.println("Impossible d'instancier une classe Aiguillage");
    }
    
    /**
     * Constructeur
     * @param msg Message a afficher
     */
    public AiguillageException(String msg) {
        super(msg);
    }
    
}
