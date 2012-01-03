package semaphores;

import exceptions.TrainException;
import transports.Train;

/**
 * Classe Vert
 * @author Rémy GRASSART & Adrien MELOTTE
 */
public class Vert implements Etat {
    
    private static final Vert monInstance = new Vert(); // L'unique instance
    
    /**
     * Constructeur
     */
    private Vert() {
    }
    
    /**
     * Obtenir l'unique instance
     * @return L'unique instance
     */
    public static Vert getInstance() {
        return monInstance;
    }
     
    /**
     * Action sur le train
     * @param train Le train
     */
    @Override
    public void actionOnTrain(Train train) {
        if(train.estArrete()) {
            try {
                train.start();
            } catch (TrainException ex) {
                System.err.println("Impossible de démarrer le train");
            }
        }
    }
    
    /**
     * Affichage de l'etat vert
     * @return Description de l'etat vert
     */
    @Override
    public String toString() {
        return "Feu Vert";
    }
    
}
