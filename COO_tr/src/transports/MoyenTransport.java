package transports;

import exceptions.MoyenTransportException;
import voies.Rail;
import simulreseauferroviaire.Direction;

/**
 * Classe MoyenTransport
 * @author Rémy GRASSART & Adrien MELOTTE
 */
public abstract class MoyenTransport {
    
    protected String identifiant; // L'identifiant du moyen de transport
    protected int taille; // La taille du moyen de transport
    protected int vitesseMax; // La vitesse max du moyen de transport
    protected EtatCourant sonEtat; // L'etat courant du moyen de transport
    
    /**
     * Obtenir la taille du moyen de transport
     * @return La taille
     */
    public int getTaille() {
        return taille;
    }
    
    /**
     * Obtenir la vitesse max du moyen de transport
     * @return La vitesse max
     */
    public int getVitesseMax() {
        return vitesseMax;
    }
    
    /**
     * Obtenir l'identifiant du moyen de transport
     * @return L'identifiant
     */
    public String getIdentifiant() {
        return identifiant;
    }
    
    /**
     * Obtenir la vitesse courante du moyen de transport
     * @return La vitesse courante
     */
    public int getVitesseCourante() {
        return sonEtat.vitesseCourante;
    }
    
    /**
     * Obtenir la position sur le rail du moyen de transport
     * @return La position sur le rail
     */
    public int getPositionSurRail() {
        return sonEtat.positionSurRail;
    }
    
    /**
     * Obtenir le sens de deplacement du moyen de transport
     * @return Le sens de deplacement
     */
    public Direction getSensDeplacement() {
        return sonEtat.sensDeplacement;
    }
    
    /**
     * Obtenir le rail du moyen de transport
     * @return Le rail
     */
    public Rail getSonRail() {
        return sonEtat.sonRail;
    }
    
    /**
     * Definir le rail du moyen de transport
     * @param rail Le rail
     */
    public void setSonRail(Rail rail) {
        sonEtat.setSonRail(rail);
    } 
        
    /**
     * Le train est arrete oui ou non
     * @return true si le train est arrete, false sinon
     */
    public boolean estArrete() {
        return (sonEtat.vitesseCourante == 0) ? true : false;
    }
    
    abstract public void setVitesseCourante(int vitesse) throws MoyenTransportException;
    @Override
    abstract public String toString();
    
}
