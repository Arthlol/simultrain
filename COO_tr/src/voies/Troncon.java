package voies;

/**
 * Classe Troncon
 * @author Rémy GRASSART & Adrien MELOTTE
 */
public class Troncon extends EltVoie {
    
    private Rail sonRail; // Le rail sur lequel est situe le troncon
    
    /**
     * Constructeur
     * @param sonRail Le rail du troncon 
     */
    public Troncon(Rail sonRail) {
        this.sonRail = sonRail;
    }

    /**
     * Affichage du troncon
     * @return Description du troncon
     */
    @Override
    public String toString() {
        return "Tronçon";
    }
    
}
