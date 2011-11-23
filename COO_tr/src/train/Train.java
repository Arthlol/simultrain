package train;

public class Train {
	private int identifiant;
	int taille;
	int vitesseMax;
	EtatTrain monEtat;
	
	
	public Train(int id, int size, int vitesse,EtatTrain etat)
	{
		identifiant=id;
		taille=size;
		vitesseMax=vitesse;
		monEtat=etat;
		
	}


	public int getIdentifiant() {
		return identifiant;
	}
	public int getVitesse() {
		return monEtat.vitesseCourante;
	}
	public void setVitesse(int v) {
		monEtat.vitesseCourante=v;
	}

        public void avancer()
        {
            monEtat.avancer(this);
        }
	
        
        public String toString()
        {
        	return monEtat.toString();
        }
}
