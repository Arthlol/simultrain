package capteur;

import train.Train;

public class CapteurPresence extends Capteur{
	public CapteurPresence() {
	}
	public void setValeur(Train t) {
		//System.out.println(" Un train est d�tect� ");
		mesure=t.getIdentifiant();
	}

}
