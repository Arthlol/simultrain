package semaphores;

import exceptions.FeuTricoloreException;

/**
 * Classe FeuTricolore
 * @author Rémy GRASSART & Adrien MELOTTE
 */
public class FeuTricolore extends Semaphore {
 
    private static Etat couleurs[] = {Vert.getInstance(), Orange.getInstance(), Rouge.getInstance()}; // Les etats
    private CouleurFeu etatActuel; // L'etat actuel
    
    /**
     * Constructeur
     */
    public FeuTricolore() {
        etatSemaphore = couleurs[0];
        etatActuel = CouleurFeu.VERT; 
    }
    
    /**
     * Constructeur
     * @param etat L'etat
     * @throws FeuTricoloreException Exception d'un feu tricolore
     */
    public FeuTricolore(CouleurFeu etat) throws FeuTricoloreException {
        if(etat != CouleurFeu.VERT && etat != CouleurFeu.ORANGE && etat != CouleurFeu.ROUGE) {
            throw new FeuTricoloreException("Impossible d'instancier une classe FeuTricolore avec cet état");
        }
        else if(etat == CouleurFeu.VERT) {
            etatSemaphore = couleurs[0];
        }
        else if(etat == CouleurFeu.ORANGE) {
            etatSemaphore = couleurs[1];
        }
        else if(etat == CouleurFeu.ROUGE) {
            etatSemaphore = couleurs[2];
        }
        etatActuel = etat;
    }
    
    /**
     * Changer l'etat d'un feu tricolore
     */
    public void changeEtat() {
        if(etatActuel == CouleurFeu.VERT) {
            etatActuel = CouleurFeu.ORANGE;
            etatSemaphore = couleurs[1];
        }
        else if(etatActuel == CouleurFeu.ORANGE) {
            etatActuel = CouleurFeu.ROUGE;
            etatSemaphore = couleurs[2];
        }
        else if(etatActuel == CouleurFeu.ROUGE) {
            etatActuel = CouleurFeu.VERT;
            etatSemaphore = couleurs[0];
        }
    }
    
}
