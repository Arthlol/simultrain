package semaphores;

import exceptions.TrainException;
import transports.Train;

/**
 * Classe Jaune
 * @author Rémy GRASSART & Adrien MELOTTE
 */
public class Jaune implements Etat {
    
    private static final Jaune monInstance = new Jaune(); // L'unique instance
    private static final int dureeArret = 10; // La duree d'arret
    
    /**
     * Constructeur
     */
    private Jaune() {
    }
    
    /**
     * Obtenir l'unique instance
     * @return 
     */
    public static Jaune getInstance() {
        return monInstance;
    }
    
    /**
     * Obtenir la duree d'arret
     * @return La duree d'arret
     */
    public static int getDureeArret() {
        return dureeArret;
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
     * Affichage d'un etat jaune
     * @return Description de l'etat jaune
     */
    @Override
    public String toString() {
        return "Feu Jaune";
    }

}
