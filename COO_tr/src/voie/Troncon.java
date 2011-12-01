package voie;

import java.util.ArrayList;
import signalisation.Semaphore;

import capteur.Capteur;
import train.Train;

public class Troncon {
	ArrayList<Capteur> sesCapteurs;
	ArrayList<Semaphore> sesSemaphoresS1,sesSemaphoresS2;
	public Troncon(ArrayList<Capteur> capteurs,ArrayList<Semaphore> mesSemaphore1,ArrayList<Semaphore> mesSemaphore2) {
		if(capteurs!=null) {
			sesCapteurs=(ArrayList<Capteur>) capteurs.clone();
		}else{
			sesCapteurs=null;
		}
		if(mesSemaphore1!=null) {
			sesSemaphoresS1=(ArrayList<Semaphore>) mesSemaphore1.clone();
		}else{
			sesSemaphoresS1=null;
		}
		if(mesSemaphore2!=null) {
			sesSemaphoresS2=(ArrayList<Semaphore>) mesSemaphore2.clone();
		}else{
			sesSemaphoresS2=null;
		}
		
	}
        
        public void active(Train t,int sens)
        {
        	if(sesCapteurs!=null)
        	{
        		 for(Capteur e : sesCapteurs)
                 {
                     e.setValeur(t);
                 }
        	}
        	
        	if(sesSemaphoresS1!=null ||sesSemaphoresS2!=null )
        	{
        		if(sens==1)
        		{
        			if(sesSemaphoresS1!=null)
        			{
		        		for(Semaphore e : sesSemaphoresS1)
		                {
		                    e.modifTrain(t);
		                }
        			}
        		}else{
        			if(sesSemaphoresS2!=null)
        			{
	        			for(Semaphore e : sesSemaphoresS2)
		                {
		                    e.modifTrain(t);
		                }
        			}
        		}
        	}
           
        }
}
