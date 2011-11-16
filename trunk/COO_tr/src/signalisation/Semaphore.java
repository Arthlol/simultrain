package signalisation;

import train.Train;

public abstract class Semaphore {
	int etat;
	
	Semaphore(){
		etat=0;
	}
	
	Semaphore(int n){
		etat=n;
	}
	
	abstract void modifTrain(Train t);
	

}
