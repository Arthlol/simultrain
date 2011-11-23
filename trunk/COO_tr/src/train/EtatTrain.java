package train;

import voie.Jonction;
import voie.Rail;

public class EtatTrain {
        Rail monRail;
	int position,sensDeplacement,vitesseCourante;
	
        
	EtatTrain(int laPosition, int leSensDepalcement, int laVitesseCourante)
	{
		position=laPosition;
		sensDeplacement=leSensDepalcement;
		vitesseCourante=laVitesseCourante;
	}
        
        public void avancer(int nbTroncons)
        {
            monRail=monRail.avance(vitesseCourante,position,sensDeplacement);
        }

}
