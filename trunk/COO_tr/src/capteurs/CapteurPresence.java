package capteurs;

import exceptions.CapteurException;
import exceptions.CapteurPresenceException;
import java.util.ArrayList;
import java.util.Observable;
import voies.Rail;
import regulation.CapteurObserver;
import simulreseauferroviaire.Direction;
import transports.Train;

/**
 * Classe CapteurPresence
 * @author Rémy GRASSART & Adrien MELOTTE
 */
public class CapteurPresence extends Capteur {

    /**
     * Constructeur
     */
    public CapteurPresence() {
        super();
    }
    
    /**
     * Constructeur
     * @param rail Le rail sur lequel le capteur sera situé 
     * @param pos La position sur le rail
     * @throws CapteurException Exception d'un capteur
     */
    public CapteurPresence(Rail rail, int pos) throws CapteurPresenceException, CapteurException {
        super(rail, pos);
    }
    
    /**
     * Notification des observateurs du capteur
     * @param presence Presence ou non d'un train
     */
    private void notifyObservers(boolean presence) {
        for(CapteurObserver capObserver : sesObservers) {
            capObserver.onPresenceChange(this, presence);
        }
    }
    
    /**
     * Mise à jour
     * @param o Observable
     * @param o1 Object
     */
    @Override
    public void update(Observable o, Object o1) {
        ArrayList<Train> lesTrains = sonRail.getTrains();
        
        for(Train train : lesTrains) {
            if(train.getSensDeplacement() == Direction.AVAL) {
                if( (positionSurRail <= train.getPositionSurRail()) && (positionSurRail > train.getPositionSurRail()-train.getTaille()) ) {
                    if(hasTrain == false) {
                        hasTrain = true;
                        notifyObservers(true);
                        System.out.println(this+" a détecté la présence d'un train sur le tronçon "+positionSurRail);
                    }
                    return;
                }
            }
            else if(train.getSensDeplacement() == Direction.AMONT) {
                if( (positionSurRail >= train.getPositionSurRail()) && (positionSurRail < train.getPositionSurRail()+train.getTaille()) ) {
                    if(hasTrain == false) {
                        hasTrain = true;
                        notifyObservers(true);
                        System.out.println(this+" a détecté la présence d'un train sur le tronçon "+positionSurRail);
                    }
                    return;
                }
            }
        }
        
        if(hasTrain == true) {
            hasTrain = false;
            notifyObservers(false);
        }
    }

    /**
     * Affichage du capteur de presence
     * @return Description du capteur de presence
     */
    @Override
    public String toString() {
        return "CapteurPresence("+sonRail+",PositionSurRail:"+positionSurRail+")";
    }
    
}
