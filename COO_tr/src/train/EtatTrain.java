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
    	 return "\n ETAT TRAINT : \t Troncon : "+(position!=null)+ "\t Rail : "+(monRail!=null)+ "\t sens : "+sensDeplacement+" \t Vitesse :"+vitesseCourante;
     }
        
     public Rail getRail()
     {
    	 return monRail;
     }
}
