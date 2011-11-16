package voie;

import java.util.ArrayList;

public class Rail extends ElementVoie{

	Jonction saJonction1,saJonction2;
	ArrayList<Troncon> sesTroncons;
	
	
	Rail(int longueur,Jonction j1,Jonction j2, ArrayList<Troncon> troncons)
	{
		super(longueur);
		sesTroncons = (ArrayList<Troncon>) troncons.clone();
		saJonction1=j1;
		saJonction2=j2;
	}
	
	public Rail getSuivant(Jonction j)
	{
		if(j!=null)
		{
			if(saJonction1==j)
			{
				return saJonction1.getSuivant(this);
			}
			else if(saJonction2==j)
			{
				return saJonction2.getSuivant(this);
			}
			else{
				return null; //Cas d'erreur
			}
		}
		return null; //Cas d'erreur
	}
	
}
