package semaphores;

import exceptions.TrainException;
import transports.Train;

/**
 * Classe Orange
 * @author Rémy GRASSART & Adrien MELOTTE
 */
public class Orange implements Etat {
    
    private static final Orange monInstance = new Orange(); // L'unique instance
    
    /**
     * Constructeur
     */
    private Orange() {
    }
    
    /**
     * Obtenir l'unique instance
     * @return L'unique instance
     */
    public static Orange getInstance() {
        return monInstance;
    }
     
    /**
     * Action sur le train
     * @param train Le train
     */
    @Override
    public void actionOnTrain(Train train) {
        if(!train.estArrete()) {
            try {
                train.setVitesseCourante(train.getVitesseCourante()/2);
            } catch (TrainException ex) {
                System.err.println("Impossible de réduire la vitesse du train");
            }
        }
    }
    
    /**
     * Affichage d'un etat orange
     * @return Description d'un etat orange
     */
    @Override
    public String toString() {
        return "Feu Orange";
    }
    
}
