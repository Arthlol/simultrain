package voie;

import java.util.ArrayList;
import capteur.Capteur;
import train.Train;

public class Troncon {
	ArrayList<Capteur> sesCapteurs;
	
	Troncon(ArrayList<Capteur> capteurs) {
		if(capteurs!=null) {
			sesCapteurs=(ArrayList<Capteur>) capteurs.clone();
		}else{
			sesCapteurs=null;
		}
	}
        
        public void active(Train t)
        {
            for(Capteur e : sesCapteurs)
            {
                e.setValeur(t);
            }
        }
}
