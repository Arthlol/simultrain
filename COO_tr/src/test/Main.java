package test;

import java.util.ArrayList;

import capteur.Capteur;
import capteur.CapteurPresence;
import capteur.CapteurVitesse;

import train.EtatTrain;
import train.Train;
import voie.Jonction;
import voie.JonctionSimple;
import voie.Rail;
import voie.Troncon;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Train t1,t2,t3;
		Rail[] mesRails=new Rail[50];
		JonctionSimple[]mesJonctions =new JonctionSimple[50];
		
		
		
		for(int i=0;i<50;i++)
		{
			mesJonctions[i]=new JonctionSimple(null,null);
		}
		
		
		for(int i=0;i<50;i++)
		{
			
			ArrayList<Troncon> lesTroncons=new ArrayList<Troncon>();
			for(int j=0;j<5+(5+i*8)%40;j++)
			{
				if(Math.random()<0.01)
				{
					ArrayList<Capteur> mesCapteur=new ArrayList<Capteur>(); 
					mesCapteur.add(new CapteurPresence());
					mesCapteur.add(new CapteurVitesse());
					lesTroncons.add(new Troncon(mesCapteur));
				}else{
					lesTroncons.add(new Troncon(null));
				}
				
			}
			mesRails[i]=new Rail((i*7)%16,mesJonctions[(i)%50],mesJonctions[(1+i)%50],(ArrayList<Troncon>)lesTroncons.clone() );
			

		}
		for(int i=0;i<50;i++)
		{
			mesJonctions[i].setR1(mesRails[i%50]);
			mesJonctions[i].setR2(mesRails[(1+i)%50]);
		}
		
		
		
		Rail railTest=mesRails[0];
		
		for(int j=0;j<50;j++)
		{
			System.out.println("VALEUR DE J \t"+j+" \t "+(railTest!=null ? "N'est pas NULL" : "Est NULL "));
			railTest=railTest.getSuivant(mesJonctions[j%50]);
			
		}
		/* TEST 2 */
		System.out.println("\n -----------------------------");
		railTest=mesRails[49];
		for(int j=49;j>=0;j--)
		{
			System.out.println("VALEUR DE J \t"+j+" \t "+(railTest==mesRails[j] ? "Valide" : "Invalide  "));
			railTest=railTest.getSuivant(mesJonctions[(50+j-1)%50]);
			
		}
		
		
		System.out.println("SUCCESS - Creation Rail et Jonction ");
		
		t1=new Train(0, 5, 15, new EtatTrain(mesRails[30],mesRails[30].getTroncon(0),1,1));
		t2=new Train(1, 15, 10, new EtatTrain(mesRails[10],mesRails[10].getTroncon(0),-1,1));
		t3=new Train(2, 3, 20, new EtatTrain(mesRails[20],mesRails[20].getTroncon(0),1,1));
		
		System.out.println("SUCCESS - Creation ");
		int i=1;
		while(true)
		{
			System.out.println("\n ------------------"+i+"------------ ");
			System.out.println(t1+"  NUM RAIL"+(getNumeroRail(t1,mesRails)));
			t1.avancer();
			
			System.out.println(t2+"  NUM RAIL"+(getNumeroRail(t2,mesRails)));
			t2.avancer();
			
			System.out.println(t3+"  NUM RAIL"+(getNumeroRail(t3,mesRails)));
			t3.avancer();
			
			i++;
		}
		
	}

	
	public static int getNumeroRail(Train t,Rail [] mesRails)
	{
		Rail test=t.monEtat().getRail();
		for(int i = 0;i<=mesRails.length-1;i++)
		{
			if(mesRails[i]==test)
			{
				return i;
			}
			
		}
		return -1;
	}
	
}
