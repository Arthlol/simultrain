package voie;

import java.util.ArrayList;

public class Aiguillage extends Jonction{

	ArrayList<Rail> amont,aval;
	
	
	
	Aiguillage(int longueur,ArrayList<Rail>monAmont,ArrayList<Rail>monAval) {
		super(longueur);
		amont=(ArrayList<Rail>) monAmont.clone();
		aval=(ArrayList<Rail>) monAval.clone();
		
	}

	
	public Rail getSuivant(Rail r) {
		if(r!=null && !amont.isEmpty() && !aval.isEmpty())
		{
			if(amont.contains(r))
			{
				return r1;
			}else if(aval.contains(r))
			{
				return r2;
			}else{
				System.out.println(" Aiguillage - Erreur suivant "); // cas d'erreur 
				return null; 
			}
		}
		System.out.println(" Aiguillage - Erreur suivant "); // cas d'erreur 
		return null; 
	}
	
	void changeAval(int index)
	{
		if(index<aval.size()&&index>-1){
			r1=aval.get(index);
		}
		else{
			// cas d'erreur
			System.out.println(" Erreur dans le choix d'index ");
		}
	}
	
	void changeAmont(int index)
	{
		if(index<amont.size()&&index>-1){
			r2=amont.get(index);
		}
		else{
			// cas d'erreur
			System.out.println(" Erreur dans le choix d'index ");
		}
	}

	public Rail getAval()
	{
		return r1;
	}
	
	public Rail getAmont()
	{
		return r2;
	}
}