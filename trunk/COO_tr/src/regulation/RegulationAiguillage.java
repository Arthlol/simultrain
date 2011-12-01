package regulation;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map.Entry;
import java.util.Set;

import capteur.Capteur;

import signalisation.Semaphore;
import voie.Aiguillage;
import voie.Rail;

public class RegulationAiguillage extends ElementRegulation{
 
	Aiguillage sonAiguillage;
	ArrayList<Capteur> avalCapteur,amontCapteur;
	ArrayList<Semaphore> avalSemaphore,amontSemaphore;
	ArrayList <Entry<Capteur,Rail>> correspondance;
	
	public RegulationAiguillage()
	{
		
	}
	
	public void run()
	{
		if(detectProblem())
		{
			/* REcherche d'une solution */
		}
	}
	
	boolean detectProblem()
	{
		Rail test=sonAiguillage.getAval();
		
		for(Entry<Capteur,Rail> e : correspondance)
		{
			if(test!=e.getValue() && e.getKey().getValeur()!=0)
			{
				return true;
			}
		}
		
		test=sonAiguillage.getAmont();
		
		for(Entry<Capteur,Rail> e : correspondance)
		{
			if(test!=e.getValue() && e.getKey().getValeur()!=0)
			{
				return true;
			}
		}
			
			return false; // RAS tout va bien
	}
	
	
}
