package regulation;

import capteurs.Capteur;
import capteurs.CapteurPresence;
import exceptions.AiguillageException;
import java.util.ArrayList;
import voies.Aiguillage;
import voies.Rail;
import semaphores.FeuBicolore;
import semaphores.Rouge;
import semaphores.Vert;

/**
 * Classe RegulateurAiguillage
 * @author Rémy GRASSART & Adrien MELOTTE
 */
public class RegulateurAiguillage extends Regulation {

    private Aiguillage aiguillage; // L'aiguillage
    private ArrayList<CapteurPresence> capteursPresence; // Les capteurs de presence
    private ArrayList<FeuBicolore> feuxBicolore; // Les feux bicolore
    
    /**
     * Constructeur
     */
    public RegulateurAiguillage() {
        aiguillage = null;
        capteursPresence = new ArrayList<CapteurPresence>();
        feuxBicolore = new ArrayList<FeuBicolore>();
    }
       
    /**
     * Définit l'aiguillage
     * @param aiguillage L'aiguillage
     */
    public void setAiguillage(Aiguillage aiguillage) {
        this.aiguillage = aiguillage;
    }
    
    /**
     * Définit les capteurs de presence
     * @param capteurs Les capteurs de presence
     */
    public void setCapteursPresence(ArrayList<CapteurPresence> capteurs) {
        capteursPresence = capteurs;
    }
    
    /**
     * Définit les feux bicolore
     * @param feux Les feux bicolore
     */
    public void setFeuxBicolore(ArrayList<FeuBicolore> feux) {
        feuxBicolore = feux;
    }
    
    /**
     * onPresenceChange
     * @param capteur Le capteur
     * @param presence Presence ou non d'un train
     */
    @Override
    public void onPresenceChange(Capteur capteur, boolean presence) {
        actionRegulation(capteur, presence, -1);
    }

    /**
     * onVitesseChange
     * @param capteur Le capteur
     * @param vitesse La vitesse du train
     */
    @Override
    public void onVitesseChange(Capteur capteur, int vitesse) {
    }

    /**
     * L'action du regulateur
     * @param capteur Le capteur
     * @param presence Presence ou non d'un train
     * @param vitesse La vitesse du train
     */
    @Override
    protected void actionRegulation(Capteur capteur, boolean presence, int vitesse) {
        int numCapteur = 0;
        
        for(int i=0 ; i<capteursPresence.size() ; i++) {
            if(capteur.equals(capteursPresence.get(i))) {
                numCapteur = i;
                break;
            }
        }
        
        if(presence) {
            Rail rail = capteursPresence.get(numCapteur).getSonRail();
            
            if(rail.equals(aiguillage.getSortieAmont())) {
                feuxBicolore.get(numCapteur).setEtat(Vert.getInstance());
                
                for(int i=0 ; i<feuxBicolore.size() ; i++) {
                    if(i != numCapteur) {
                        feuxBicolore.get(i).setEtat(Rouge.getInstance());
                    }
                }

                System.out.println("Changement des feux");
            }
            else if(aiguillage.getRailsAmont().contains(rail)) {
                feuxBicolore.get(numCapteur).setEtat(Rouge.getInstance());
                
                try {
                    aiguillage.setSortieAmont(rail);
                    feuxBicolore.get(numCapteur).setEtat(Vert.getInstance());
                } catch (AiguillageException ex) {
                    System.err.println(ex);
                }
                
                for(int i=0 ; i<feuxBicolore.size() ; i++) {
                    if(i != numCapteur) {
                        feuxBicolore.get(i).setEtat(Rouge.getInstance());
                    }
                }

                System.out.println("Changement des feux et de l'aiguillage");
            }
            else if(rail.equals(aiguillage.getSortieAval())) {
                feuxBicolore.get(numCapteur).setEtat(Vert.getInstance());
                
                for(int i=0 ; i<feuxBicolore.size() ; i++) {
                    if(i != numCapteur) {
                        feuxBicolore.get(i).setEtat(Rouge.getInstance());
                    }
                }

                System.out.println("Changement des feux");
            }
            else if(aiguillage.getRailsAval().contains(rail)) {
                feuxBicolore.get(numCapteur).setEtat(Rouge.getInstance());
                
                try {
                    aiguillage.setSortieAval(rail);
                    feuxBicolore.get(numCapteur).setEtat(Vert.getInstance());
                } catch (AiguillageException ex) {
                    System.err.println(ex);
                }
                
                for(int i=0 ; i<feuxBicolore.size() ; i++) {
                    if(i != numCapteur) {
                        feuxBicolore.get(i).setEtat(Rouge.getInstance());
                    }
                }

                System.out.println("Changement des feux et de l'aiguillage");
            }
        }
    }
      
}
