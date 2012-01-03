package semaphores;

import exceptions.FeuArretTemporaireException;

/**
 * Classe FeuArretTemporaire
 * @author Rémy GRASSART & Adrien MELOTTE
 */
public class FeuArretTemporaire extends Semaphore {
    
    private static Etat couleurs[] = {Vert.getInstance(), Jaune.getInstance()}; // Les etats
    private CouleurFeu etatActuel; // L'etat actuel
    private int compteur = Jaune.getDureeArret(); // Le compteur
    
    /**
     * Constructeur
     */
    public FeuArretTemporaire() {
        etatSemaphore = couleurs[0];
        etatActuel = CouleurFeu.VERT; 
    }
    
    /**
     * Constructeur
     * @param etat L'etat
     * @throws FeuArretTemporaireException Exception d'un feu d'arret temporaire
     */
    public FeuArretTemporaire(CouleurFeu etat) throws FeuArretTemporaireException {
        if(etat != CouleurFeu.VERT && etat != CouleurFeu.JAUNE) {
            throw new FeuArretTemporaireException("Impossible d'instancier une classe FeuArretTemporaire avec cet état");
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
     * Changer l'etat du feu d'arret temporaire
     */
    public void changeEtat() {
        if(etatActuel == CouleurFeu.JAUNE) {
            etatActuel = CouleurFeu.VERT;
            etatSemaphore = couleurs[0];
        }
        else if(etatActuel == CouleurFeu.VERT) {
            compteur = Jaune.getDureeArret();
            etatActuel = CouleurFeu.JAUNE;
            etatSemaphore = couleurs[1];
        }
    }
    
}
