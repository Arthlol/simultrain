package voies;

import exceptions.JonctionSimpleException;

/**
 * Classe JonctionSimple
 * @author Rémy GRASSART & Adrien MELOTTE
 */
public class JonctionSimple extends Jonction {
    
    private static int idCompteur = 0;
    private int idJonctionSimple; // ID de la jonction simple
    private Rail railAmont; // Le rail amont de la jonction simple
    private Rail railAval; // Le rail aval de la jonction simple
    
    /**
     * Constructeur
     */
    public JonctionSimple() {
        idCompteur++;
        idJonctionSimple = idCompteur;
        railAmont = null;
        railAval = null;
    }
    
    /**
     * Constructeur
     * @param amont Le rail amont
     * @param aval Le rail aval
     */
    public JonctionSimple(Rail amont, Rail aval) {
        idCompteur++;
        idJonctionSimple = idCompteur;
        railAmont = amont;
        railAval = aval;
    }
    
    /**
     * Definir le rail amont de la jonction simple
     * @param amont Le rail amont
     * @throws JonctionSimpleException Exception d'une jonction simple
     */
    @Override
    public void setRailAmont(Rail amont) throws JonctionSimpleException {
        if(railAval != null && railAval.equals(amont)) {
            throw new JonctionSimpleException("Impossible de définir le rail amont de la jonction simple car la jonction possède déjà le rail en aval");
        }
        else {
            railAmont = amont;
        }
    }
    
    /**
     * Definir le rail aval de la jonction simple
     * @param aval Le rail aval
     * @throws JonctionSimpleException Exception d'une jonction simple
     */
    @Override
    public void setRailAval(Rail aval) throws JonctionSimpleException {
        if(railAmont != null && railAmont.equals(aval)) {
            throw new JonctionSimpleException("Impossible de définir le rail aval de la jonction simple car la jonction possède déjà le rail en amont");
        }
        else {
            railAval = aval;
        }
    }
    
    /**
     * Obtenir le rail aval
     * @return Le rail aval
     */
    public Rail getRailAval() {
        return railAval;
    }
    
    /**
     * Obtenir le rail amont
     * @return Le rail amont
     */
    public Rail getRailAmont() {
        return railAmont;
    }
    
    /**
     * Obtenir le rail suivant de la jonction simple
     * @param rail Le rail precedent
     * @return Le rail suivant
     * @throws JonctionSimpleException Exception d'une jonction simple
     */
    @Override
    public Rail getRailSuivant(Rail rail) throws JonctionSimpleException {
        if(railAmont != null && railAmont.equals(rail)) {
            return railAval;
        }
        else if(railAval != null && railAval.equals(rail)) {
            return railAmont;
        }
        else {
            throw new JonctionSimpleException("Attention : le train va dérailler car la jonction simple est mal configurée");
        }
    }
    
    /**
     * Affichage de la jonction simple
     * @return Description de la jonction simple
     */
    @Override
    public String toString() {
        return "Jonction Simple(N°"+idJonctionSimple+")";
    }
    
}
