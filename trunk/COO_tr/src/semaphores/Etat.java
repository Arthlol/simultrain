package semaphores;

import transports.Train;

/**
 * Interface Etat
 * @author Rémy GRASSART & Adrien MELOTTE
 */
public interface Etat {
    
    public void actionOnTrain(Train train);
    @Override
    public String toString();
    
}
