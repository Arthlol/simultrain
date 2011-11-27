package capteur;

import train.Train;

public class CapteurVitesse extends Capteur{
	public CapteurVitesse() {
	}
	public void setValeur(Train t) {
		System.out.println("Vittesse :: "+t.getVitesse());
		mesure=t.getVitesse();
	}
}
