package signalisation;

import train.Train;

public class Attente extends Semaphore{
	int duree;
	final int  dureeMAx;
	int vitesse=0;
	public Attente (int d) { 
		dureeMAx=d;
		duree=d;
		super.etat=1;
	}
	
	boolean action()
	{
		if(duree<=0)
		{
			duree=dureeMAx;
			etat=0; // le feu s'eteind
			System.out.println("--- LE TRAIN REPART ---");
			return true; // le train repart
		}
		else
		{
			duree--;
			etat=1;
			System.out.println("--- LE TRAIN ATTEND ---");
			
			return false; // le train attend
		}
		
	}
	
	public void modifTrain(Train t) {
		
		if(etat==1)
		{
			if( action())
			{
				t.setVitesse(vitesse);
				t.avancer();
				vitesse=0;
				etat=1;
			}else{
				// on arrete le train
				vitesse=t.getVitesse();
				t.setVitesse(0);
				
			}
			
			
		}
		
	}
}
