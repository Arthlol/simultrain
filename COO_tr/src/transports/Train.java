package transports;

import exceptions.TrainException;
import java.util.Observable;
import java.util.Observer;
import voies.Rail;
import simulreseauferroviaire.Direction;

/**
 * Classe Train
 * @author Rémy GRASSART & Adrien MELOTTE
 */
public class Train extends MoyenTransport implements Observer {
    
    private static int nbreDeTrain = 0; // Nombre total de train
    
    /**
     * Constructeur
     * @param id Identifiant du train
     * @param taille Taille du train
     * @param vitesseMax Vitesse max du train
     * @throws TrainException Exception d'un train
     */
    public Train(String id, int taille, int vitesseMax) throws TrainException {
        if(taille <= 0 && vitesseMax <= 0) {
            throw new TrainException();
        }
        else if(taille <=0) {
            throw new TrainException("Vous essayez d'instancier une classe Train avec une taille négative ou nulle");
        }
        else if(vitesseMax <= 0) {
            throw new TrainException("Vous essayez d'instancier une classe Train avec une vitesse max négative ou nulle");
        }
        else {
            identifiant = id;
            this.taille = taille;
            this.vitesseMax = vitesseMax;
            sonEtat = null;
            nbreDeTrain++;
        }
    }
    
    /**
     * Constructeur
     * @param id Identifiant du train
     * @param taille Taille du train
     * @param vitesseMax Vitesse max du train
     * @param sonRail Le rail sur lequel se situe le train
     * @param sens Le sens de deplacement du train
     * @throws TrainException Exception d'un train
     */
    public Train(String id, int taille, int vitesseMax, Rail sonRail, Direction sens) throws TrainException {
        if(taille <= 0 && vitesseMax <= 0) {
            throw new TrainException();
        }
        else if(taille <=0) {
            throw new TrainException("Vous essayez d'instancier une classe Train avec une taille négative ou nulle");
        }
        else if(vitesseMax <= 0) {
            throw new TrainException("Vous essayez d'instancier une classe Train avec une vitesse max négative ou nulle");
        }
        else if(sens != Direction.AMONT && sens != Direction.AVAL) {
            throw new TrainException("Vous essayez d'instancier une classe Train avec un sens de déplacement incorrect"); 
        }
        else {
            identifiant = id;
            this.taille = taille;
            this.vitesseMax = vitesseMax;
            sonEtat = new EtatCourant(this, sonRail, sens);
            nbreDeTrain++;
        }
    }
       
    /**
     * Obtenir le nombre de trains total
     * @return Le nombre de trains total
     */
    public static int getNbreDeTrain() {
        return nbreDeTrain;
    }
         
    /**
     * Définir la vitesse courante d'un train
     * @param vitesse La vitesse courante
     * @throws TrainException Exception d'un train
     */
    @Override
    public void setVitesseCourante(int vitesse) throws TrainException {
        if(vitesse > vitesseMax) {        
            throw new TrainException("Interdit : la vitesse courante ne peut pas être supérieure à la vitesse max");
        }
        else if(vitesse < 0) {
            throw new TrainException("Interdit : la vitesse courante ne peut pas être négative");
        }
        else {
            sonEtat.vitesseCourante = vitesse;
        }
    }
          
    /**
     * Avancer un train
     * @throws TrainException Exception d'un train 
     */
    public void avance() throws TrainException {  
        if(getSensDeplacement() == Direction.AVAL) {
            sonEtat.incPositionSurRail(sonEtat.vitesseCourante);
        }
        else if(getSensDeplacement() == Direction.AMONT) {
            sonEtat.decPositionSurRail(sonEtat.vitesseCourante);
        }
        
        if(getPositionSurRail() > getSonRail().getLongueur()) {
            if(getSonRail().getSemaphoreAval() != null) {
                getSonRail().getSemaphoreAval().actionOnTrain(this);
            }
            
            if(estArrete()) {
                sonEtat.positionSurRail = getSonRail().getLongueur();
            }
            else {
                try {
                    if(getSonRail().getJonctionAval().getRailSuivant(getSonRail()) == null) {
                        stop();
                        sonEtat.positionSurRail = getSonRail().getLongueur();
                    }
                    else {
                        sonEtat.positionSurRail -= getSonRail().getLongueur();
                        getSonRail().removeTrain(this);
                        setSonRail(getSonRail().getJonctionAval().getRailSuivant(getSonRail()));
                        getSonRail().addTrain(this);
                    }
                } catch (Exception ex) {
                    //System.err.println(ex);
                    stop();
                    sonEtat.positionSurRail = getSonRail().getLongueur();
                }
            }
        }
        else if(getPositionSurRail() <= 0) { 
            if(getSonRail().getSemaphoreAmont() != null) {
                getSonRail().getSemaphoreAmont().actionOnTrain(this);
            }
     
            if(estArrete()) {
                sonEtat.positionSurRail = 1;
            }
            else {
                      try {
                          if(getSonRail().getJonctionAmont().getRailSuivant(getSonRail()) == null) {
                              stop();
                              sonEtat.positionSurRail = 1;
                          }
                          else {
                              getSonRail().removeTrain(this);
                              setSonRail(getSonRail().getJonctionAmont().getRailSuivant(getSonRail()));
                              getSonRail().addTrain(this);
                              sonEtat.positionSurRail = getSonRail().getLongueur() - getVitesseCourante() - getPositionSurRail();
                          }
                      } catch (Exception ex) {
                          //System.err.println(ex);
                          sonEtat.positionSurRail = 1;
                     }
            }
        }
        
        if(getSonRail().getTrains().size() > 1) {
            for(int i=0 ; i<getSonRail().getTrains().size() ; i++) {
                if(!getSonRail().getTrains().get(i).equals(this)) {
                    if(this.getSensDeplacement() == Direction.AVAL && getSonRail().getTrains().get(i).getSensDeplacement() == Direction.AMONT) {
                        if(this.getPositionSurRail() >= getSonRail().getTrains().get(i).getPositionSurRail()) {
                            System.out.println("Attention : le train "+"Train(ID:"+this.getIdentifiant()+") est rentré en collision avec le train Train(ID:"+getSonRail().getTrains().get(i).getIdentifiant()+")");
                        }
                        else {
                            System.out.println("Attention : le train "+"Train(ID:"+this.getIdentifiant()+") va rentré en collision avec le train Train(ID:"+getSonRail().getTrains().get(i).getIdentifiant()+")");
                        }
                    }
                    else if(this.getSensDeplacement() == Direction.AMONT && getSonRail().getTrains().get(i).getSensDeplacement() == Direction.AVAL) {
                        if(this.getPositionSurRail() <= getSonRail().getTrains().get(i).getPositionSurRail()) {
                            System.out.println("Attention : le train "+"Train(ID:"+this.getIdentifiant()+") est rentré en collision avec le train Train(ID:"+getSonRail().getTrains().get(i).getIdentifiant()+")");
                        }
                        else {
                            System.out.println("Attention : le train "+"Train(ID:"+this.getIdentifiant()+") va rentré en collision avec le train Train(ID:"+getSonRail().getTrains().get(i).getIdentifiant()+")");
                        }
                    }
                    else if(this.getSensDeplacement() == Direction.AVAL && getSonRail().getTrains().get(i).getSensDeplacement() == Direction.AVAL) {
                        if((this.getPositionSurRail() > getSonRail().getTrains().get(i).getPositionSurRail()-getSonRail().getTrains().get(i).getTaille()) &&
                                this.getPositionSurRail() < getSonRail().getTrains().get(i).getPositionSurRail()) {
                            System.out.println("Attention : le train "+"Train(ID:"+this.getIdentifiant()+") est rentré en collision avec le train Train(ID:"+getSonRail().getTrains().get(i).getIdentifiant()+")");
                        } 
                    }
                    else if(this.getSensDeplacement() == Direction.AMONT && getSonRail().getTrains().get(i).getSensDeplacement() == Direction.AMONT) {
                        if((this.getPositionSurRail() < getSonRail().getTrains().get(i).getPositionSurRail()+getSonRail().getTrains().get(i).getTaille()) &&
                                this.getPositionSurRail() > getSonRail().getTrains().get(i).getPositionSurRail()) {
                            System.out.println("Attention : le train "+"Train(ID:"+this.getIdentifiant()+") est rentré en collision avec le train Train(ID:"+getSonRail().getTrains().get(i).getIdentifiant()+")");
                        } 
                    }
                }
            }
        }   
    }
    
    /**
     * Demarrer un train
     * @throws TrainException Exception d'un train
     */
    public void start() throws TrainException {
        try {
            this.setVitesseCourante(vitesseMax);
        } catch (TrainException ex) {
            this.setVitesseCourante(1);
        }
    }
    
    /**
     * Stopper un train
     * @throws TrainException Exception d'un train
     */
    public void stop() throws TrainException {
        this.setVitesseCourante(0);
    }
    
    /**
     * Mise a jour
     * @param o observable
     * @param o1 Object
     */
    @Override
    public void update(Observable o, Object o1) {
        try {
            avance();
        } catch (Exception ex) {
        }
    } 
    
    /**
     * Affichage d'un train
     * @return Description du train
     */
    @Override
    public String toString() {
        return "Train(ID:"+identifiant+",Taille:"+taille+",VitesseMax:"+vitesseMax+",VitesseCourante:"+sonEtat.vitesseCourante+",SensDeplacement:"+sonEtat.sensDeplacement+",Position:"+sonEtat.sonRail+" sur le tronçon "+sonEtat.positionSurRail+")";
    }
       
}