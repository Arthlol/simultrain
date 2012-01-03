package voies;

import exceptions.AiguillageException;
import java.util.ArrayList;

/**
 * Classe Aiguillage
 * @author Rémy GRASSART & Adrien MELOTTE
 */
public class Aiguillage extends Jonction {
    
    private static int idCompteur = 0; 
    private int idAiguillage; // ID de l'aiguillage
    private ArrayList<Rail> railsAmont; // Les rails amonts de l'aiguillage
    private ArrayList<Rail> railsAval; // Les rails avals de l'aiguillage
    private Rail sortieAmont; // La sortie amont de l'aiguillage
    private Rail sortieAval; // La sortie aval de l'aiguillage
    
    /**
     * Constructeur
     */
    public Aiguillage() {
        idCompteur++;
        idAiguillage = idCompteur;
        railsAmont = new ArrayList<Rail>();
        railsAval = new ArrayList<Rail>();
        sortieAmont = null;
        sortieAval = null;
    }
    
    /**
     * Constructeur
     * @param amont Les rails amonts
     * @param aval Les rails avals
     * @param sortieAmont La sortie amont
     * @param sortieAval La sortie aval
     */
    public Aiguillage(ArrayList<Rail> amont, ArrayList<Rail> aval, Rail sortieAmont, Rail sortieAval) {
        idCompteur++;
        idAiguillage = idCompteur;
        railsAmont = amont;
        railsAval = aval;
        this.sortieAmont = sortieAmont;
        this.sortieAval = sortieAval;
    }
    
    /**
     * Ajouter un rail amont
     * @param railAmont Le rail amont a ajouter
     * @throws AiguillageException Exception d'un aiguillage
     */
    public void addRailAmont(Rail railAmont) throws AiguillageException {
        if(railsAval.contains(railAmont)) {
            throw new AiguillageException("Impossible d'ajouter le rail à l'aiguillage en amont car l'aiguillage possède déjà le rail en aval");
        }
        else if(railsAmont.contains(railAmont)) {
            throw new AiguillageException("Impossible d'ajouter le rail à l'aiguillage en amont car l'aiguillage possède déjà le rail");
        }
        else {
            railsAmont.add(railAmont);
        }
    }
    
    /**
     * Ajouter un rail aval
     * @param railAval Le rail aval a ajouter
     * @throws AiguillageException Exception d'un aiguillage
     */
    public void addRailAval(Rail railAval) throws AiguillageException {
        if(railsAmont.contains(railAval)) {
            throw new AiguillageException("Impossible d'ajouter le rail à l'aiguillage en aval car l'aiguillage possède déjà le rail en amont");
        }
        else if(railsAval.contains(railAval)) {
            throw new AiguillageException("Impossible d'ajouter le rail à l'aiguillage en aval car l'aiguillage possède déjà le rail");
        }
        else {
            railsAval.add(railAval);
        }
    }
    
    /**
     * Supprimer un rail amont
     * @param railAmont Le rail amont a supprimer
     * @throws AiguillageException Exception d'un aiguillage
     */
    public void removeRailAmont(Rail railAmont) throws AiguillageException {
        if(!railsAmont.contains(railAmont)) {
            throw new AiguillageException("Impossible de supprimer le rail en amont car l'aiguillage ne possède pas ce rail");
        }
        else {
            railsAmont.remove(railAmont);
        }
    }
    
    /**
     * Supprimer un rail aval
     * @param railAval Le rail aval a supprimer
     * @throws AiguillageException Exception d'un aiguillage
     */
    public void removeRailAval(Rail railAval) throws AiguillageException {
        if(!railsAval.contains(railAval)) {
            throw new AiguillageException("Impossible de supprimer le rail en aval car l'aiguillage ne possède pas ce rail");
        }
        else {
            railsAval.remove(railAval);
        }
    }
        
    /**
     * Definir la sortie amont de l'aiguillage
     * @param rail Le rail
     * @throws AiguillageException Exception d'un aiguillage
     */
    public void setSortieAmont(Rail rail) throws AiguillageException {
        if(!railsAmont.contains(rail)) {
            throw new AiguillageException("Impossible de définir la sortie de l'aiguillage en amont car l'aiguillage ne possède pas ce rail en amont");
        }
        else {
            sortieAmont = rail;
        }
    }
    
    /**
     * Definir la sortie aval de l'aiguillage
     * @param rail Le rail
     * @throws AiguillageException Exception d'un aiguillage
     */
    public void setSortieAval(Rail rail) throws AiguillageException {
        if(!railsAval.contains(rail)) {
            throw new AiguillageException("Impossible de définir la sortie de l'aiguillage en aval car l'aiguillage ne possède pas ce rail en aval");
        }
        else {
            sortieAval = rail;
        }  
    }
    
    /**
     * Definir les rails aval de l'aiguillage
     * @param aval Les rails aval
     */
    public void setRailsAval(ArrayList<Rail> aval) {
        railsAval = aval;
        sortieAval = null;
    }
    
    /**
     * Definir les rails amont de l'aiguillage
     * @param amont Les rails amont
     */
    public void setRailsAmont(ArrayList<Rail> amont) {
        railsAmont = amont;
        sortieAmont = null;
    }
    
    /**
     * Ajout d'un rail amont
     * @param rail Le rail a ajouter
     */
    @Override
    protected void setRailAmont(Rail rail) {
        try {
            this.addRailAmont(rail);
        } catch (AiguillageException ex) {
        }
    }

    /**
     * Ajout d'un rail aval
     * @param rail Le rail
     */
    @Override
    protected void setRailAval(Rail rail) {
        try {
            this.addRailAval(rail);
        } catch (AiguillageException ex) {
        }
    }
    
    /**
     * Obtenir la sortie amont
     * @return La sortie amont
     */
    public Rail getSortieAmont() {
        return sortieAmont;
    }
   
    /**
     * Obtenir la sortie aval
     * @return La sortie aval
     */
    public Rail getSortieAval() {
        return sortieAval;
    }
    
    /**
     * Obtenir les rails amont
     * @return Les rails amont
     */
    public ArrayList<Rail> getRailsAmont() {
        return railsAmont;
    }
    
    /**
     * Obtenir les rails aval
     * @return Les rails aval
     */
    public ArrayList<Rail> getRailsAval() {
        return railsAval;
    }
    
    /**
     * Obtenir le rail suivant
     * @param rail Le rail d'origine
     * @return Le rail suivant
     * @throws AiguillageException Exception d'un aiguillage
     */
    @Override
    public Rail getRailSuivant(Rail rail) throws AiguillageException {
        if(sortieAmont != null && sortieAmont.equals(rail)) {
            return sortieAval;
        }
        else if(sortieAval != null && sortieAval.equals(rail)) {
            return sortieAmont;
        }
        else {
            throw new AiguillageException("Attention : le train va dérailler car l'aiguillage est mal configuré");
        }
    }
    
    /**
     * Affichage d'un aiguillage
     * @return Description d'un aiguillage
     */
    @Override
    public String toString() {
        return "Aiguillage(N°"+idAiguillage+")";
    }

}
