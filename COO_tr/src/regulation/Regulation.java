package regulation;

import capteurs.Capteur;

/**
 * Classe Regulation
 * @author Rémy GRASSART & Adrien MELOTTE
 */
public abstract class Regulation implements CapteurObserver {
    
    abstract protected void actionRegulation(Capteur capteur, boolean presence, int vitesse);
    
}
