package capteurs;

import exceptions.CapteurException;
import java.util.ArrayList;
import java.util.Observer;
import voies.Rail;
import regulation.CapteurObserver;

/**
 * Classe Capteur
 * @author Rémy GRASSART & Adrien MELOTTE
 */
public abstract class Capteur implements Observer {
    
    protected Rail sonRail; // Le rail sur lequel est situé le capteur
    protected int positionSurRail; // La position sur le rail du capteur
    protected boolean hasTrain; // Détection d'un train ou non
    protected ArrayList<CapteurObserver> sesObservers; // Les observateurs
    
    /**
     * Constructeur
     */
    public Capteur() {
        sonRail = null;
        positionSurRail = 1;
        hasTrain = false;
        sesObservers = new ArrayList<CapteurObserver>();
    }
    
    /**
     * Constructeur
     * @param rail Le rail sur lequel est situé le capteur
     * @param positionSurRail La position sur le rail du capteur
     * @throws CapteurException Exception d'un capteur
     */
    public Capteur(Rail rail, int positionSurRail) throws CapteurException {
        // Si la position du capteur n'est pas valable
        if(positionSurRail <= 0 || positionSurRail > rail.getLongueur()) {
            throw new CapteurException("Impossible d'instancier une classe Capteur car la position du capteur sur le rail n'est pas valable");
        }
        else {
            sonRail = rail;
            this.positionSurRail = positionSurRail;
            hasTrain = false;
            sesObservers = new ArrayList<CapteurObserver>();
        }
    } 
    
    /**
     * Ajout d'un observateur au capteur
     * @param obs L'observateur à ajouter au capteur
     * @throws CapteurException Exception d'un capteur
     */
    public void addObserver(CapteurObserver obs) throws CapteurException {
        if(obs == null) {
            throw new CapteurException("Impossible d'ajouter le capteur observer car l'objet est vide");
        }
        else {
            sesObservers.add(obs);
        }
    }
    
    /**
     * Suppression d'un observateur au capteur
     * @param obs L'observateur à supprimer au capteur
     * @throws CapteurException Exception d'un capteur
     */
    public void removeObserver(CapteurObserver obs) throws CapteurException {
        // Si le capteur ne possède pas l'observateur
        if(!sesObservers.contains(obs)) {
            throw new CapteurException("Impossible de supprimer le capteur observer car le capteur ne possède pas cet observer");
        }
        else {
            sesObservers.remove(obs);
        }
    }
        
    /**
     * Définit le rail du capteur
     * @param rail Le rail sur lequel le capteur sera situé
     */
    public void setSonRail(Rail rail) {
        sonRail = rail;
        
        // Si la position sur le rail n'est plus valable
        if(rail.getLongueur() < positionSurRail) {
            positionSurRail = 1;
        }
    }
    
    /**
     * Définit la position sur le rail
     * @param pos La position sur le rail
     * @throws CapteurException Exception d'un capteur
     */
    public void setPositionSurRail(int pos) throws CapteurException {
        // Si la position sur le rail n'est pas valable
        if(pos <= 0 || pos > sonRail.getLongueur()) {
            throw new CapteurException("Impossible de définir la position du capteur sur le rail car celle ci n'est pas valable");
        }
        else {
            positionSurRail = pos;
        }
    }
        
    /**
     * Définit la position du capteur
     * @param rail Le rail sur lequel le capteur sera situé
     * @param pos La position sur le rail
     * @throws CapteurException Exception d'un capteur
     */
    public void setSaPosition(Rail rail, int pos) throws CapteurException {
        // Si la position sur le rail n'est pas valable
        if(pos <= 0 || pos > rail.getLongueur()) {
            throw new CapteurException("Impossible de définir la position du capteur sur le rail car celle ci n'est pas valable");
        }
        else {
            sonRail = rail;
            this.positionSurRail = pos;
        }
    }
    
    /**
     * Obtenir la position sur le rail
     * @return La position sur le rail
     */
    public int getPositionSurRail() {
        return positionSurRail;
    }
       
    /**
     * Obtenir le rail du capteur
     * @return Le rail
     */
    public Rail getSonRail() {
        return sonRail;
    }
      
    /**
     * Affichage du capteur
     * @return Description du capteur
     */
    @Override
    abstract public String toString();
    
}
