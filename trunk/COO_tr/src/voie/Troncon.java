package voie;

import java.util.ArrayList;
import capteur.Capteur;

public class Troncon {
	ArrayList<Capteur> sesCapteurs;
	
	Troncon(ArrayList<Capteur> capteurs) {
		if(capteurs!=null) {
			sesCapteurs=(ArrayList<Capteur>) capteurs.clone();
		}else{
			sesCapteurs=null;
		}
	}
}
