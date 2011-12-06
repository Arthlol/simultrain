package voie;

import java.util.ArrayList;

public class Aiguillage extends Jonction{

	ArrayList<Rail> amont,aval;
	
	
	
	public Aiguillage(int longueur,ArrayList<Rail>monAval,ArrayList<Rail>monAmont) {
		super(longueur,monAval.get(0),monAmont.get(0));
		amont=monAmont;
		aval=monAval;
		
	}

	
	
	
	public void changeAval(int index)
	{
		if(index<aval.size() && index>-1){
			r1=aval.get(index);
		}
		else{
			// cas d'erreur
			System.out.println(" Erreur dans le choix d'index ");
		}
	}
	
	public void changeAmont(int index)
	{
		if(index<amont.size() && index>-1){
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
	
	public ArrayList<Rail> getAllAval()
	{
		return aval;
	}
	
	public ArrayList<Rail> getAllAmont()
	{
		return amont;
	}
}
