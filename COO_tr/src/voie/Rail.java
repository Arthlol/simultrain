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
	
		System.out.print(""+(saJonction1==null ? "JONCTION 1 EST NULL \t" : "")+""+(saJonction2==null?"JONCTION 2 EST NULL \t ": ""));
	}   
        
        public Rail avance(int nbTroncon,Troncon currentTroncon,int sens,Train t)
        {
        	//System.out.print("\n Rail \t nbt \t"+nbTroncon+" \t "+(currentTroncon!=null ? "Pexsite" : "Pvide")+" \t s"+sens);
            int currentPosition;
            if(currentTroncon==null)
            {
            	
                if(sens==1){
                	
                    currentPosition=0;
                }else{
                    currentPosition=sesTroncons.size()-1;
                }
            }else{
            	//System.out.print("\t ICI  ::"+(sesTroncons.contains(currentTroncon)? "Inclu" :"NonInclu"));
                currentPosition=sesTroncons.indexOf(currentTroncon);
                
                
            }
            
            //System.out.print("\t Pactuel \t"+currentPosition+" \n");
            
            
            switch(sens){
                case 1:
                    for(int i=currentPosition;i<sesTroncons.size();i++)
                    {
                        sesTroncons.get(i).active(t);
                    }
                    if(nbTroncon+currentPosition>sesTroncons.size()-1){
                    	if(getSuivant(saJonction1)== null){
                    		System.out.print("\n QUELQUE CHOSE DE NULL");
                    	}
                        return getSuivant(saJonction1).avance(nbTroncon-(sesTroncons.size()-currentPosition),null, 1, t);
                    }
                    currentTroncon=sesTroncons.get(currentPosition+nbTroncon);
                    t.setPosition(currentTroncon);
                    
                    return this;
                    
                case -1:
                    for(int i=currentPosition;i>=0;i--)
                    {
                        sesTroncons.get(i).active(t);
                    }
                    if(-nbTroncon+currentPosition<0){
                    	if(getSuivant(saJonction2)== null){
                    		System.out.print("\n QUELQUE CHOSE DE NULL");
                    	}
                    	
                        return getSuivant(saJonction2).avance(nbTroncon-(currentPosition),null, -1,t);
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
				//System.out.print(" ENTREE R1 \t");
				return saJonction2.getSuivant(this);
			}
			else
			{
				//System.out.print(" ENTREE R2 \t");
				return saJonction1.getSuivant(this);
			}
			
		}
		//System.out.println("ERROR - Jonction NULL");
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
