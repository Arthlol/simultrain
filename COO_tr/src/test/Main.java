package test;

import java.util.ArrayList;

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
		
		mesJonctions[0]=new JonctionSimple(null,null);
		
		for(int i=1;i<50;i++)
		{
			mesJonctions[(1+i)%50]=new JonctionSimple(mesRails[i-1],null);
			ArrayList<Troncon> lesTroncons=new ArrayList<Troncon>();
			for(int j=0;j<5+(5+i*8)%40;j++)
			{
				lesTroncons.add(new Troncon(null));
			}
			mesRails[i]=new Rail((i*7)%16,mesJonctions[i%50],mesJonctions[(1+i)%50],(ArrayList<Troncon>)lesTroncons.clone() );
			mesJonctions[(1+i)%50].setR2(mesRails[i]);

		}
		
		System.out.println("SUCCESS - Creation Rail et Jonction ");
		
		t1=new Train(0, 5, 15, new EtatTrain(mesRails[30],mesRails[30].getTroncon(0),1,15));
		t2=new Train(1, 15, 10, new EtatTrain(mesRails[10],mesRails[10].getTroncon(0),1,10));
		t3=new Train(2, 3, 20, new EtatTrain(mesRails[20],mesRails[20].getTroncon(0),1,20));
		
		System.out.println("SUCCESS - Creation ");
	
		while(true)
		{
			
			t1.avancer();
			t2.avancer();
			t3.avancer();
			
			System.out.println(t1);
			System.out.println(t2);
			System.out.println(t3);
		}
		
	}

}
