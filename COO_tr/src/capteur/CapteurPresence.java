package capteur;

import train.Train;

public class CapteurPresence extends Capteur{
	CapteurPresence() {
	}
	void setValeur(Train t) {
		mesure=t.getIdentifiant();
	}

}
