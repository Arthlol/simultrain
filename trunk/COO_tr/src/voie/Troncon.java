package voie;

import java.util.ArrayList;
import capteur.Capteur;
import train.Train;

public class Troncon {
	ArrayList<Capteur> sesCapteurs;
	
	public Troncon(ArrayList<Capteur> capteurs) {
		if(capteurs!=null) {
			sesCapteurs=(ArrayList<Capteur>) capteurs.clone();
		}else{
			sesCapteurs=null;
		}
	}
        
        public void active(Train t)
        {
        	if(sesCapteurs!=null)
        	{
        		 for(Capteur e : sesCapteurs)
                 {
                     e.setValeur(t);
                 }
        	}
           
        }
}
