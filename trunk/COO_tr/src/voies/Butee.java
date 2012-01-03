package voies;

/**
 * Classe Butee
 * @author Rémy GRASSART & Adrien MELOTTE
 */
public class Butee extends Jonction {
    
    private static int idCompteur = 0;
    private int idButee; // ID Butee
    private Rail rail; // Le rail sur lequel est situe la butee
    
    /**
     * Constructeur
     */
    public Butee() {
        idCompteur++;
        idButee = idCompteur;
        rail = null;
    }
    
    /**
     * Constructeur
     * @param rail Le rail sur lequel est situe la butee
     */
    public Butee(Rail rail) {
        idCompteur++;
        idButee = idCompteur;
        this.rail = rail;
    }
    
    /**
     * Definir le rail de la butee
     * @param rail Le rail
     */
    public void setRail(Rail rail) {
        this.rail = rail;
    }
    
    /**
     * Definir le rail amont de la butee
     * @param rail Le rail amont
     */
    @Override
    protected void setRailAmont(Rail rail) {
        this.rail = rail;
    }

    /**
     * Definir le rail aval de la butee
     * @param rail Le rail aval
     */
    @Override
    protected void setRailAval(Rail rail) {
        this.rail = rail;
    }
    
    /**
     * Obtenir le rail de la butee
     * @return Le rail
     */
    public Rail getRail() {
        return rail;
    }
    
    /**
     * Obtenir le rail suivant de la butee
     * @param rail Le rail precedent
     * @return null
     */
    @Override
    public Rail getRailSuivant(Rail rail) {
        return null;
    }
    
    /**
     * Affichage de la butee
     * @return Description de la butee
     */
    @Override
    public String toString() {
        return "Butee(N°"+idButee+")";
    }
    
}
