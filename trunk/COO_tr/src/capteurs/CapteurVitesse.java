package capteurs;

import exceptions.CapteurException;
import exceptions.CapteurVitesseException;
import java.util.ArrayList;
import java.util.Observable;
import voies.Rail;
import regulation.CapteurObserver;
import simulreseauferroviaire.Direction;
import transports.Train;

/**
 * Classe CapteurVitesse
 * @author Rémy GRASSART & Adrien MELOTTE
 */
public class CapteurVitesse extends Capteur {

    private int vitesseDetecte; // La vitesse detectee
    
    /**
     * Constructeur
     */
    public CapteurVitesse() {
        super();
        vitesseDetecte = 0;
    }
    
    /**
     * Constructeur
     * @param rail Le rail sur lequel sera situe le capteur
     * @param pos La position sur le rail
     * @throws CapteurException Exception d'un capteur
     */
    public CapteurVitesse(Rail rail, int pos) throws CapteurVitesseException, CapteurException {
        super(rail, pos);
        vitesseDetecte = 0;
    }
    
    /**
     * Notification des observateurs du capteur
     * @param presence Vitesse du train
     */
    private void notifyObservers(int vitesse) {
        for(CapteurObserver capObserver : sesObservers) {
            capObserver.onVitesseChange(this, vitesse);
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
                        vitesseDetecte = train.getVitesseCourante();
                        notifyObservers(train.getVitesseCourante());
                        System.out.println(this+" a détecté un train dont la vitesse est de "+vitesseDetecte+"km/h");
                    }
                    else if(vitesseDetecte != train.getVitesseCourante()) {
                        vitesseDetecte = train.getVitesseCourante();
                        notifyObservers(train.getVitesseCourante());
                        System.out.println(this+" a détecté un train dont la vitesse est de "+vitesseDetecte+"km/h");
                    }
                    return;
                }
            }
            else if(train.getSensDeplacement() == Direction.AMONT) {
                 if( (positionSurRail >= train.getPositionSurRail()) && (positionSurRail < train.getPositionSurRail()+train.getTaille()) ) {
                    if(hasTrain == false) {
                        hasTrain = true;
                        vitesseDetecte = train.getVitesseCourante();
                        notifyObservers(train.getVitesseCourante());
                        System.out.println(this+" a détecté un train dont la vitesse est de "+vitesseDetecte+"km/h");
                    }
                    else if(vitesseDetecte != train.getVitesseCourante()) {
                        vitesseDetecte = train.getVitesseCourante();
                        notifyObservers(train.getVitesseCourante());
                        System.out.println(this+" a détecté un train dont la vitesse est de "+vitesseDetecte+"km/h");
                    }
                    return;
                }
            }
        }
        
        hasTrain = false;
        notifyObservers(-1);
    }
    
    /**
     * Affichage du capteur de vitesse
     * @return Description du capteur de vitesse
     */
    @Override
    public String toString() {
        return "CapteurVitesse("+sonRail+",PositionSurRail:"+positionSurRail+")";
    }
    
}
