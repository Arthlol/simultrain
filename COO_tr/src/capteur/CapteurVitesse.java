package capteur;

import train.Train;

public class CapteurVitesse extends Capteur{
	CapteurVitesse() {
	}
	public void setValeur(Train t) {
		mesure=t.getVitesse();
	}
}
