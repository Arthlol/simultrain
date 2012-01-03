package transports;

import simulreseauferroviaire.Direction;
import voies.Rail;

/**
 * Classe EtatCourant
 * @author Rémy GRASSART & Adrien MELOTTE
 */
class EtatCourant {
    
    protected int positionSurRail; // La position sur le rail du train
    protected Direction sensDeplacement; // Le sens de deplacement du train
    protected int vitesseCourante; // La vitesse courante du train
    protected Rail sonRail; // Le rail sur lequel se situe le train

    /**
     * Constructeur
     * @param sonTrain Le train de l'etat courant
     * @param sonRail Le rail sur lequel se situe le train
     * @param sens Le sens de deplacement du train
     */
    public EtatCourant(Train sonTrain, Rail sonRail, Direction sens) {
        sensDeplacement = sens;
        vitesseCourante = 0;
        
        this.sonRail = sonRail;
        
        if(sens == Direction.AVAL) {
              positionSurRail = sonTrain.getTaille();
                                
              while(this.sonRail.getLongueur() < positionSurRail) {
                try {
                    if(this.sonRail.getJonctionAval().getRailSuivant(this.sonRail) != null) {
                           positionSurRail -= this.sonRail.getLongueur();
                           this.sonRail = this.sonRail.getJonctionAval().getRailSuivant(this.sonRail);
                    }
                    else {
                           this.sonRail = null;
                           positionSurRail = -1;
                           System.err.println("Impossible de placer le train à cet endroit");
                           break;
                    }
                } catch (Exception ex) {
                    System.err.println(ex);
                }
             }    
        }
        else if(sens == Direction.AMONT) {
             positionSurRail = sonRail.getLongueur() - sonTrain.getTaille();
                                
             while(positionSurRail <= 0) {
                try {
                    if(this.sonRail.getJonctionAmont().getRailSuivant(this.sonRail) != null) {
                       this.sonRail = this.sonRail.getJonctionAmont().getRailSuivant(this.sonRail);
                       positionSurRail += this.sonRail.getLongueur();
                    }
                    else {
                       this.sonRail = null;
                       positionSurRail = -1;
                       System.err.println("Impossible de placer le train à cet endroit");
                       break; 
                    }
                } catch (Exception ex) {
                    System.err.println(ex);
                }
             }            
        }
        else {
            this.sonRail = null;
            positionSurRail = -1;
        }
        
    }
       
    /**
     * Définit le rail du train
     * @param rail Le rail
     */
    protected void setSonRail(Rail rail) {
        this.sonRail = rail;
    }
    
    /**
     * Incremente la position sur le rail
     * @param valeur La valeur a ajoutee
     */
    protected void incPositionSurRail(int valeur) {
         positionSurRail += valeur;
    }
       
    /**
     * Decremente la position sur le rail
     * @param valeur La valeur a deduire
     */
    protected void decPositionSurRail(int valeur) {
         positionSurRail -= valeur;
    }
}