package regulation;

import java.util.ArrayList;

import capteur.Capteur;

public class RegulationCapteur extends ElementRegulation{

	ArrayList<Capteur> mesCapteurs;
	
	public RegulationCapteur(ArrayList<Capteur> capteurs)
	{
		mesCapteurs=(ArrayList<Capteur>) capteurs.clone();
	}
	
	public void add(Capteur c)
	{
		mesCapteurs.add(c);
	}
	
	public int[] getState()
	{
		int[] monTab;
		if(mesCapteurs==null || mesCapteurs.isEmpty())
		{
			monTab=new int[1];
			monTab[0]=-1;
		}else{
			monTab=new int[mesCapteurs.size()];
			for(int i=0;i<monTab.length;i++)
			{
				monTab[i]=mesCapteurs.get(i).getValeur();
				mesCapteurs.get(i).raz();
			}
			
		}
		return monTab;
	}
	
	
}
