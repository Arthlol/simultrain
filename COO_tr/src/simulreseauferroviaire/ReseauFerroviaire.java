package simulreseauferroviaire;

import capteurs.*;
import exceptions.*;
import transports.*;
import java.util.ArrayList;
import java.util.Observable;
import voies.*;
import regulation.*;
import semaphores.*;

/**
 * Classe ReseauFerroviaire
 * @author Rémy GRASSART & Adrien MELOTTE
 */
public class ReseauFerroviaire extends Observable {
    
    private ArrayList<Rail> sesRails; // Tous les rails
    private ArrayList<Train> sesTrains; // Tous les trains
    private ArrayList<Regulation> sesRegulateurs; // Tous les regulateurs
    private ArrayList<Semaphore> sesSemaphores; // Tous les semaphores
    private ArrayList<Capteur> sesCapteurs; // Tous les capteurs
    private ArrayList<Jonction> sesJonctions; // Toutes les jonctions
    private boolean continu;

    /**
     * Constructeur
     */
    public ReseauFerroviaire() {
        sesRails = new ArrayList<Rail>();
        sesTrains = new ArrayList<Train>();
        sesRegulateurs = new ArrayList<Regulation>();
        sesSemaphores = new ArrayList<Semaphore>();
        sesCapteurs = new ArrayList<Capteur>();
        sesJonctions = new ArrayList<Jonction>();
        continu = true;
    }
    
    /**
     * Ajout d'un rail
     * @param rail Le rail
     */
    public void addRail(Rail rail) {
        sesRails.add(rail);
    }
    
    /**
     * Ajout d'un train
     * @param train Le train
     */
    public void addTrain(Train train) {
        sesTrains.add(train);
        this.addObserver(train);
    }
    
    /**
     * Ajout d'un regulateur
     * @param regulateur Le regulateur
     */
    public void addRegulateur(Regulation regulateur) {
        sesRegulateurs.add(regulateur);
    }
    
    /**
     * Ajout d'une semaphore
     * @param semaphore La semaphore
     */
    public void addSemaphore(Semaphore semaphore) {
        sesSemaphores.add(semaphore);
    }
    
    /**
     * Ajout d'un capteur
     * @param capteur Le capteur
     */
    public void addCapteur(Capteur capteur) {
        sesCapteurs.add(capteur);
    }
    
    /**
     * Ajout d'une jonction
     * @param jonction La jonction
     */
    public void addJonction(Jonction jonction) {
        sesJonctions.add(jonction);
    }
   
    /**
     * Obtenir le train pour un indice donne
     * @param index Indice
     * @return Le train
     */
    public Train getTrain(int index) {
        return sesTrains.get(index);
    }
    
    /**
     * Obtenir le rail pour un indice donne
     * @param index Indice
     * @return Le rail
     */
    public Rail getRail(int index) {
        return sesRails.get(index);
    }
    
    /**
     * Obtenir le regulateur pour un indice donne
     * @param index Indice
     * @return Le regulateur
     */
    public Regulation getRegulation(int index) {
        return sesRegulateurs.get(index);
    }
    
    /**
     * Obtenir la semaphore pour un indice donne
     * @param index Indice
     * @return La semaphore
     */
    public Semaphore getSemaphore(int index) {
        return sesSemaphores.get(index);
    }
    
    /**
     * Obtenir le capteur pour un indice donne
     * @param index Indice
     * @return Le capteur
     */
    public Capteur getCapteur(int index) {
        return sesCapteurs.get(index);
    }
    
    /**
     * Obtenir la jonction pour un indice donne
     * @param index Indice
     * @return La jonction
     */
    public Jonction getJonction(int index) {
        return sesJonctions.get(index);
    }
    
    /**
     * Demarrer le cycle d'horloge
     */
    public void startHorloge() {
        continu = true;
        
        for(Train train : sesTrains) {
            try {
                train.start();
            } catch (TrainException ex) {
                System.err.println(ex);
            }
        }
        
        while(continu) {
            setChanged();
            notifyObservers();
            
            for(int i=0 ; i<sesTrains.size() ; i++) {
                System.out.println("Train (ID:"+sesTrains.get(i).getIdentifiant()+") sur le rail "+sesTrains.get(i).getSonRail()+" au tronçon "+sesTrains.get(i).getPositionSurRail());
            }
            
            try {
                Thread.sleep(1000);
            } catch(java.lang.InterruptedException exp) {
                System.err.println("Problème avec le cycle d'horloge");
            }
        }
    }
    
    /**
     * Stopper le cycle d'horloge
     */
    public void stopHorloge() {
        continu = false;
    }
    
    /**
     * Methode principale
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {          
             ReseauFerroviaire reseau = new ReseauFerroviaire();
                     
             
           /* 
             // Une simple ligne ferroviaire avec un sémaphore rouge
             Butee butee1 = new Butee();
             Butee butee2 = new Butee();
             JonctionSimple jonctionSimple1 = new JonctionSimple();
             JonctionSimple jonctionSimple2 = new JonctionSimple();
             FeuBicolore feuBicolore1 = new FeuBicolore();
             feuBicolore1.setEtat(Rouge.getInstance());
               
             Rail rail1 = new Rail(15, butee1, jonctionSimple1);
             butee1.setRail(rail1);
             jonctionSimple1.setRailAmont(rail1);        
             reseau.addRail(rail1);
                    
             Rail rail2 = new Rail(42, jonctionSimple1, jonctionSimple2);
             jonctionSimple1.setRailAval(rail2);
             jonctionSimple2.setRailAmont(rail2);
             rail2.setSemaphoreAval(feuBicolore1);
             reseau.addRail(rail2);
                    
             Rail rail3 = new Rail(4, jonctionSimple2, butee2);
             butee2.setRail(rail3);
             jonctionSimple2.setRailAval(rail3);
             reseau.addRail(rail3);
                    
             Train train1 = new Train("Toto", 5, 3, reseau.getRail(0), Direction.AVAL);
             reseau.addTrain(train1);
             reseau.getRail(0).addTrain(train1);
          */  
             
             Butee butee1 = new Butee();
             Butee butee2 = new Butee();
             Butee butee3 = new Butee();
             JonctionSimple jonctionSimple1 = new JonctionSimple();
             Aiguillage aiguillage1 = new Aiguillage();
             FeuBicolore feuBicolore1 = new FeuBicolore();
             FeuBicolore feuBicolore2 = new FeuBicolore();
             FeuBicolore feuBicolore3 = new FeuBicolore();
             Regulation regulation1 = new RegulateurAiguillage();
               
             Rail rail1 = new Rail(9, butee1, jonctionSimple1);
             butee1.setRail(rail1);
             jonctionSimple1.setRailAmont(rail1);
             reseau.addRail(rail1);
             reseau.addJonction(butee1);
               
             Rail rail2 = new Rail(21, jonctionSimple1, aiguillage1);
             jonctionSimple1.setRailAval(rail2);
             aiguillage1.addRailAmont(rail2);
             aiguillage1.setSortieAmont(rail2);
             reseau.addRail(rail2);
             reseau.addJonction(jonctionSimple1);
                
             Rail rail3 = new Rail(8, aiguillage1, butee2);
             aiguillage1.addRailAval(rail3);
             butee2.setRail(rail3);
             reseau.addRail(rail3);
             reseau.addJonction(butee2);
               
             Rail rail4 = new Rail(15, aiguillage1, butee3);
             aiguillage1.addRailAval(rail4);
             aiguillage1.setSortieAval(rail3);
             butee3.setRail(rail4);
             reseau.addRail(rail4);
             reseau.addJonction(butee3);
             reseau.addJonction(aiguillage1);
                                
             CapteurPresence capteurPresence1 = new CapteurPresence(reseau.getRail(1), 15);
             CapteurPresence capteurPresence2 = new CapteurPresence(reseau.getRail(2), 2);
             CapteurPresence capteurPresence3 = new CapteurPresence(reseau.getRail(3), 1);
             reseau.addCapteur(capteurPresence1);
             reseau.addCapteur(capteurPresence2);
             reseau.addCapteur(capteurPresence3);
             reseau.addObserver(capteurPresence1);
             reseau.addObserver(capteurPresence2);
             reseau.addObserver(capteurPresence3);
                
             reseau.addSemaphore(feuBicolore1);
             reseau.addSemaphore(feuBicolore2);
             reseau.addSemaphore(feuBicolore3);
             reseau.getRail(1).setSemaphoreAval(feuBicolore1);
             reseau.getRail(2).setSemaphoreAmont(feuBicolore2);
             reseau.getRail(3).setSemaphoreAmont(feuBicolore3);
                
             reseau.addRegulateur(regulation1);
             ArrayList<CapteurPresence> capteurs = new ArrayList<CapteurPresence>();
             capteurs.add(capteurPresence1);
             capteurs.add(capteurPresence2);
             capteurs.add(capteurPresence3);
             ArrayList<FeuBicolore> feux = new ArrayList<FeuBicolore>();
             feux.add(feuBicolore1);
             feux.add(feuBicolore2);
             feux.add(feuBicolore3);
             ((RegulateurAiguillage)(reseau.getRegulation(0))).setCapteursPresence(capteurs);
             ((RegulateurAiguillage)(reseau.getRegulation(0))).setFeuxBicolore(feux);
             ((RegulateurAiguillage)(reseau.getRegulation(0))).setAiguillage(aiguillage1);
                
             reseau.getCapteur(0).addObserver(reseau.getRegulation(0));
             reseau.getCapteur(1).addObserver(reseau.getRegulation(0));
             reseau.getCapteur(2).addObserver(reseau.getRegulation(0));
                
             Train train1 = new Train("Toto", 5, 3, reseau.getRail(0), Direction.AVAL);
             Train train2 = new Train("Titi", 6, 3, reseau.getRail(3), Direction.AMONT);
             reseau.addTrain(train1);
             reseau.addTrain(train2);
             reseau.getRail(0).addTrain(reseau.getTrain(0));
             reseau.getRail(3).addTrain(reseau.getTrain(1));
             
             
             
             reseau.startHorloge();
                    
        } catch (AiguillageException ex) {
            System.err.println(ex);
        } catch (CapteurException ex) {
            System.err.println(ex);
        } catch (TrainException ex) {
            System.err.println(ex);
        } catch (RailException ex) {
            System.err.println(ex);
        } catch (JonctionSimpleException ex) {
            System.err.println(ex);
        }                         
    }
    
}