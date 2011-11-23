package train;

import voie.Jonction;
import voie.Rail;
import voie.Troncon;

public class EtatTrain {
        Rail monRail;
	int sensDeplacement,vitesseCourante;
	Troncon position;
        
	public EtatTrain(Rail r,Troncon laPosition, int leSensDepalcement, int laVitesseCourante)
	{
		monRail=r;
		position=laPosition;
		sensDeplacement=leSensDepalcement;
		vitesseCourante=laVitesseCourante;
	}
        
        public void avancer(Train t)
        {
            monRail=monRail.avance(vitesseCourante,position,sensDeplacement,t);
        }
        
     public String toString()
     {
    	 return "ETAT TRAINT : \n Troncon : "+(position!=null)+ "\n Rail : "+(monRail!=null)+ "\n sens : "+sensDeplacement+" \n Vitesse :"+vitesseCourante;
     }
        
}
