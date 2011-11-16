package signalisation;

import train.Train;

public class Attente extends Semaphore{
	int duree;
	final int  dureeMAx;
	int vitesse=0;
	Attente (int d) { 
		dureeMAx=d;
		duree=d;
	}
	
	boolean action()
	{
		if(duree==0)
		{
			duree=dureeMAx;
			etat=0; // le feu s'eteind
			return true; // le train repart
		}
		if(duree!=0)
		{
			duree--;
			
		}
		return false; // le train attend
	}
	
	void modifTrain(Train t) {
		if(etat!=1)
		{
			if(vitesse !=0) // securite si Pb sur vitesse
			{
				t.setVitesse(vitesse);
			}
		}else{
			if( action())
			{
				t.setVitesse(vitesse);
				vitesse=0;
			}else{
				// on arrete le train
				vitesse=t.getVitesse();
				t.setVitesse(0);
				
			}
			
			
		}
		
	}
}
