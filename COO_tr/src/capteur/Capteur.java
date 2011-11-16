package capteur;

import train.Train;

public abstract class Capteur {
	int mesure;
	int getValeur() { return mesure; }
	abstract void setValeur(Train t);
	void raz() { mesure=0; }
}
