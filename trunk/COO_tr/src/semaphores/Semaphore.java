package semaphores;

import transports.Train;

/**
 * Classe Semaphore
 * @author Rémy GRASSART & Adrien MELOTTE
 */
public abstract class Semaphore {
    
    protected Etat etatSemaphore; // L'etat
    
    /**
     * Definir l'etat
     * @param etat L'etat
     */
    public void setEtat(Etat etat) {
        etatSemaphore = etat;
    }
    
    /**
     * Action sur le train
     * @param train Le train
     */
    public void actionOnTrain(Train train) {
        etatSemaphore.actionOnTrain(train);
    }
    
    /**
     * Affichage d'une semaphore
     * @return Description d'une semaphore
     */
    @Override
    public String toString() {
        return etatSemaphore.toString();
    }
    
}
