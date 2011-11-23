package voie;

import java.util.ArrayList;
import train.Train;

public class Rail extends ElementVoie{

	Jonction saJonction1,saJonction2;
	ArrayList<Troncon> sesTroncons;
	
	
	public Rail(int longueur,Jonction j1,Jonction j2, ArrayList<Troncon> troncons)
	{
		super(longueur);
		sesTroncons = (ArrayList<Troncon>) troncons.clone();
		saJonction1=j1;
		saJonction2=j2;
		System.out.println(sesTroncons.size());
	}   
        
        public Rail avance(int nbTroncon,Troncon currentTroncon,int sens,Train t)
        {
            int currentPosition;
            if(currentTroncon==null)
            {
                if(sens==1){
                    currentPosition=0;
                }else{
                    currentPosition=sesTroncons.size()-1;
                }
            }else{
                currentPosition=sesTroncons.indexOf(currentTroncon);
            }
            
            System.out.println(currentPosition);
            
            
            switch(sens){
                case 1:
                    for(int i=currentPosition;i<sesTroncons.size();i++)
                    {
                        sesTroncons.get(i).active(t);
                    }
                    if(nbTroncon+currentPosition>sesTroncons.size()-1){
                        return getSuivant(saJonction2).avance(nbTroncon-(sesTroncons.size()-currentPosition),null, sens, t);
                    }
                    return this;
                    
                case -1:
                    for(int i=currentPosition;i>=0;i--)
                    {
                        sesTroncons.get(i).active(t);
                    }
                    if(-nbTroncon+currentPosition<0){
                        return getSuivant(saJonction2).avance(nbTroncon-(currentPosition),null, sens,t);
                    }
                    return this;
                   
                    
            }
            
            
            return null;
        
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

	public Troncon getTroncon(int i) {
		
		return sesTroncons.get(i);
	}
	
	public void setJ1(Jonction j)
	{
		saJonction1=j;
	}
	
	public void setJ2(Jonction j)
	{
		saJonction2=j;
	}
	
}
