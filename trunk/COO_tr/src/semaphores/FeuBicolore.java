package semaphores;

import exceptions.FeuBicoloreException;

/**
 * Classe FeuBicolore
 * @author Rémy GRASSART & Adrien MELOTTE
 */
public class FeuBicolore extends Semaphore {
 
    private static Etat couleurs[] = {Vert.getInstance(), Rouge.getInstance()}; // Les etats
    private CouleurFeu etatActuel; // L'etat actuel
    
    /**
     * Constructeur
     */
    public FeuBicolore() {
        etatSemaphore = couleurs[0];
        etatActuel = CouleurFeu.VERT; 
    }
    
    /**
     * Constructeur
     * @param etat L'etat
     * @throws FeuBicoloreException Exception d'un feu bicolore
     */
    public FeuBicolore(CouleurFeu etat) throws FeuBicoloreException {
        if(etat != CouleurFeu.VERT && etat != CouleurFeu.ROUGE) {
            throw new FeuBicoloreException("Impossible d'instancier une classe FeuBicolore avec cet état");
        }
        else if(etat == CouleurFeu.VERT) {
            etatSemaphore = couleurs[0];
            etatActuel = etat;
        }
        else {
            etatSemaphore = couleurs[1];
            etatActuel = etat;
        }
    }
    
    /**
     * Changer l'etat d'un feu bicolore
     */
    public void changeEtat() {
        if(etatActuel == CouleurFeu.VERT) {
            etatActuel = CouleurFeu.ROUGE;
            etatSemaphore = couleurs[1];
        }
        else if(etatActuel == CouleurFeu.ROUGE) {
            etatActuel = CouleurFeu.VERT;
            etatSemaphore = couleurs[0];
        }
    }
    
}
