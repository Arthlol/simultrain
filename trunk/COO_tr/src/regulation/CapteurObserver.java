package regulation;

import capteurs.Capteur;

/**
 * Interface CapteurObserver
 * @author Rémy GRASSART & Adrien MELOTTE
 */
public interface CapteurObserver {
    
    void onPresenceChange(Capteur capteur, boolean presence);
    void onVitesseChange(Capteur capteur, int vitesse);
    
}