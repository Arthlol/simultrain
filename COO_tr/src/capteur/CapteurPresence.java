package capteur;

import train.Train;

public class CapteurPresence extends Capteur{
	CapteurPresence() {
	}
	public void setValeur(Train t) {
		mesure=t.getIdentifiant();
	}

}
