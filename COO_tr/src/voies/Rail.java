package voies;

import exceptions.RailException;
import java.util.ArrayList;
import semaphores.Semaphore;
import simulreseauferroviaire.Direction;
import transports.Train;

/**
 * Classe Rail
 * @author Rémy GRASSART & Adrien MELOTTE
 */
public class Rail extends EltVoie {
    
    private static int idCompteur = 0;
    private int idRail; // ID Rail
    private ArrayList<Troncon> sesTroncons; // Les troncons du rail
    private Jonction jonctionAmont; // La jonction amont du rail
    private Jonction jonctionAval; // La jonction aval du rail
    private ArrayList<Train> sesTrains; // Les trains qui sont sur le rail
    private Semaphore semaphoreAmont; // La semaphore amont du rail
    private Semaphore semaphoreAval; // La semaphore aval du rail
        
    /**
     * Constructeur
     * @param longueur Longueur du rail
     * @throws RailException Exception d'un rail
     */
    public Rail(int longueur) throws RailException {
        if(longueur <= 0) {
            throw new RailException("Impossible d'instancier une classe Rail : la longueur d'un train ne peut pas être négative ou nulle");
        }
        else {
            idCompteur++;
            idRail = idCompteur;
            super.longueur = longueur;
            sesTroncons = new ArrayList<Troncon>();

            for(int i=0 ; i<longueur ; i++) {
                sesTroncons.add(new Troncon(this));
            }
            jonctionAmont = null;
            jonctionAval = null;
            semaphoreAmont = null;
            semaphoreAval = null;
            sesTrains = new ArrayList<Train>();
        }
    }
   
    /**
     * Constructeur
     * @param longueur Longueur du rail
     * @param jonctionAmont La jonction amont
     * @param jonctionAval La jonction aval
     * @throws RailException Exception d'un rail
     */
    public Rail(int longueur, Jonction jonctionAmont, Jonction jonctionAval) throws RailException {
        if(longueur <= 0) {
            throw new RailException("Impossible d'instancier une classe Rail : la longueur d'un train ne peut pas être négative ou nulle");
        }
        else if(jonctionAmont != null && jonctionAmont.equals(jonctionAval)) {
            throw new RailException("Impossible d'instancier une classe Rail : la jonction amont et la jonction aval sont identiques");
        }
        else {
            idCompteur++;
            idRail = idCompteur;
            super.longueur = longueur;
            sesTroncons = new ArrayList<Troncon>();

            for(int i=0 ; i<longueur ; i++) {
                sesTroncons.add(new Troncon(this));
            }

            this.jonctionAmont = jonctionAmont;
            this.jonctionAval = jonctionAval;
            semaphoreAmont = null;
            semaphoreAval = null;
            sesTrains = new ArrayList<Train>();
        }
    }
    
    /**
     * Constructeur
     * @param longueur Longueur du rail
     * @param jonctionAmont La jonction amont
     * @param jonctionAval La jonction aval
     * @param semaphoreAmont La semaphore amont
     * @param semaphoreAval La semaphore aval
     * @throws RailException Exception d'un rail
     */
    public Rail(int longueur, Jonction jonctionAmont, Jonction jonctionAval, Semaphore semaphoreAmont, Semaphore semaphoreAval) throws RailException {
        if(longueur <= 0) {
            throw new RailException("Impossible d'instancier une classe Rail : la longueur d'un train ne peut pas être négative ou nulle");
        }
        else if(jonctionAmont != null && jonctionAmont.equals(jonctionAval)) {
            throw new RailException("Impossible d'instancier une classe Rail : la jonction amont et la jonction aval sont identiques");
        }
        else if(semaphoreAmont != null && semaphoreAmont.equals(semaphoreAval)) {
            throw new RailException("Impossible d'instancier une classe Rail : la sémaphore amont et la sémaphore aval sont identiques");
        }
        else {
            idCompteur++;
            idRail = idCompteur;
            super.longueur = longueur;
            sesTroncons = new ArrayList<Troncon>();

            for(int i=0 ; i<longueur ; i++) {
                sesTroncons.add(new Troncon(this));
            }

            this.jonctionAmont = jonctionAmont;
            this.jonctionAval = jonctionAval;
            this.semaphoreAmont = semaphoreAmont;
            this.semaphoreAval = semaphoreAval;
            sesTrains = new ArrayList<Train>();
        }
    }
    
    /**
     * Ajout d'un troncon
     */
    public void addTroncon() {
        sesTroncons.add(new Troncon(this));
        longueur++;      
    } 
    
    /**
     * Suppresion d'un troncon
     * @throws RailException Exception d'un rail
     */
    public void removeTroncon() throws RailException {
        if(longueur <= 1) {
            throw new RailException("Impossible de supprimer des tronçons supplémentaires");
        }
        else {
            sesTroncons.remove(longueur-1);
            longueur--;
        }
    }
      
    /**
     * Ajout d'un train sur le rail
     * @param train Le train
     * @throws RailException Exception d'un rail 
     */
    public void addTrain(Train train) throws RailException {
        if(train == null) {
            throw new RailException("Impossible d'ajouter le train sur le rail car l'objet est vide");
        }
        else {
            sesTrains.add(train);
        }
    }
    
    /**
     * Suppresion d'un train sur le rail
     * @param train Le train
     * @throws RailException Exception d'un rail 
     */
    public void removeTrain(Train train) throws RailException {
        if(!sesTrains.contains(train)) {
            throw new RailException("Impossible de supprimer le train du rail car le train n'est pas présent sur le rail");
        }
        else {
            sesTrains.remove(train);
        }
    }
    
    /**
     * Obtenir la longueur du rail
     * @return La longueur
     */
    public int getLongueur() {
        return longueur;
    }
    
    /**
     * Obtenir la jonction amont
     * @return La jonction amont
     */
    public Jonction getJonctionAmont() {
        return jonctionAmont;
    }
    
    /**
     * Obtenir la jonction aval
     * @return La jonction aval
     */
    public Jonction getJonctionAval() {
        return jonctionAval;
    }
    
    /**
     * Obtenir la jonction selon la direction
     * @param dir La direction
     * @return La jonction
     * @throws RailException Exception d'un rail 
     */
    public Jonction getJonction(Direction dir) throws RailException {
        if(dir != Direction.AMONT && dir != Direction.AVAL) {
            throw new RailException("Impossible d'obtenir la jonction dans cette direction");
        }
        else if(dir == Direction.AMONT) {
            return jonctionAmont;
        }
        else {
            return jonctionAval;
        }
    }
    
    /**
     * Obtenir la semaphore amont
     * @return La semaphore amont
     */
    public Semaphore getSemaphoreAmont() {
        return semaphoreAmont;
    }
    
    /**
     * Obtenir la semaphore aval
     * @return La semaphore aval
     */
    public Semaphore getSemaphoreAval() {
        return semaphoreAval;
    }
    
    /**
     * Obtenir la semaphore selon la direction
     * @param dir La direction
     * @return La semaphore
     * @throws RailException Exception d'un rail 
     */
    public Semaphore getSemaphore(Direction dir) throws RailException {
        if(dir != Direction.AMONT && dir != Direction.AVAL) {
            throw new RailException("Impossible d'obtenir la sémaphore dans cette direction");
        }
        else if(dir == Direction.AMONT) {
            return semaphoreAmont;
        }
        else {
            return semaphoreAval;
        }
    }
    
    /**
     * Obtenir les trains sur le rail
     * @return Les trains
     */
    public ArrayList<Train> getTrains() {
        return sesTrains;
    }
    
    /**
     * Definir la jonction amont du rail
     * @param jonctionAmont La jonction amont
     * @throws RailException Exception d'un rail
     */
    public void setJonctionAmont(Jonction jonctionAmont) throws RailException {
        if(jonctionAval != null && jonctionAval.equals(jonctionAmont)) {
            throw new RailException("Impossible de définir la jonction amont du rail car le rail possède déjà cette jonction en aval");
        }
        else {
            this.jonctionAmont = jonctionAmont;
        }
    }
    
    /**
     * Definir la jonction aval du rail
     * @param jonctionAval La jonction aval
     * @throws RailException Exception d'un rail
     */
    public void setJonctionAval(Jonction jonctionAval) throws RailException {
        if(jonctionAmont != null && jonctionAmont.equals(jonctionAval)) {
            throw new RailException("Impossible de définir la jonction aval du rail car le rail possède déjà cette jonction en amont");
        }
        else {
            this.jonctionAval = jonctionAval;
        }
    }
    
    /**
     * Definir la semaphore amont du rail
     * @param semaphoreAmont La semaphore amont
     * @throws RailException Exception d'un rail
     */
    public void setSemaphoreAmont(Semaphore semaphoreAmont) throws RailException {
        if(semaphoreAval != null && semaphoreAval.equals(semaphoreAmont)) {
            throw new RailException("Impossible de définir la sémaphore amont du rail car le rail possède déjà cette sémaphore en aval");
        }
        else {
            this.semaphoreAmont = semaphoreAmont;
        }
    }
    
    /**
     * Definir la semaphore aval du rail
     * @param semaphoreAval La semaphore aval
     * @throws RailException Exception d'un rail
     */
    public void setSemaphoreAval(Semaphore semaphoreAval) throws RailException {
        if(semaphoreAmont != null && semaphoreAmont != null && semaphoreAmont.equals(semaphoreAval)) {
            throw new RailException("Impossible de définir la sémaphore aval du rail car le rail possède déjà cette sémaphore en amont");
        }
        else {
            this.semaphoreAval = semaphoreAval;
        }
    }
    
    /**
     * Definir les trains sur le rail
     * @param trains Les trains
     */
    public void setTrains(ArrayList<Train> trains) {
        sesTrains = trains;
    }
     
    /**
     * Affichage d'un rail
     * @return Description du rail
     */
    @Override
    public String toString() {
        return "Rail(N°"+idRail+",Longueur:"+longueur+")";
    }
    
}
