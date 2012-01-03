package semaphores;

import exceptions.TrainException;
import transports.Train;

/**
 * Classe Rouge
 * @author Rémy GRASSART & Adrien MELOTTE
 */
public class Rouge implements Etat {

    private static final Rouge monInstance = new Rouge(); // L'unique instance
    
    /**
     * Constructeur
     */
    private Rouge() {
    }
    
    /**
     * Obtenir l'unique instance
     * @return L'unique instance
     */
    public static Rouge getInstance() {
        return monInstance;
    }
    
    /**
     * Action sur le train
     * @param train Le train
     */
    @Override
    public void actionOnTrain(Train train) {
        try {
            train.stop();
        } catch (TrainException ex) {
            System.err.println("Impossible de stopper le train");
        }
    }
    
    /**
     * Affichage de l'etat rouge
     * @return Description de l'etat rouge
     */
    @Override
    public String toString() {
        return "Feu Rouge";
    }
    
}
