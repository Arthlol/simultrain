package voies;

import exceptions.JonctionException;

/**
 * Classe Jonction
 * @author Rémy GRASSART & Adrien MELOTTE
 */
public abstract class Jonction extends EltVoie {
    
    abstract public Rail getRailSuivant(Rail rail) throws JonctionException;
    abstract protected void setRailAmont(Rail rail) throws JonctionException;
    abstract protected void setRailAval(Rail rail) throws JonctionException;
    
}
