package capteur;

import train.Train;

public abstract class Capteur {
	int mesure;
	public int getValeur() { return mesure; }
	public abstract void setValeur(Train t);
	public void raz() { mesure=0; }
}
