package test;

import java.util.ArrayList;

import train.EtatTrain;
import train.Train;
import voie.Aiguillage;
import voie.Rail;

public class Test2 extends Main{

	public static void main(String[] args) {
		Rail[] mesRails_1=creerRail(20);
		Rail[] mesRails_2=creerRail(20);
		Rail[] mesRails_3=creerRail(20);
		ArrayList<Rail> l_a1,l_a2,l_b1,l_b2;
		l_a1=new ArrayList<Rail>();
		l_a1.add(mesRails_1[0]);
		l_a1.add(mesRails_2[0]);
		l_a2=new ArrayList<Rail>();
		l_a2.add(mesRails_3[19]);
		l_b1=new ArrayList<Rail>();
		l_b1.add(mesRails_1[19]);
		l_b1.add(mesRails_2[19]);
		l_b2=new ArrayList<Rail>();
		l_b2.add(mesRails_3[0]);
		
		
		Aiguillage a =new Aiguillage(0,l_a2,l_a1  );
		Aiguillage b =new Aiguillage(0, l_b2,l_b1);
		
		mesRails_1[19].setJ2(b);
		
		mesRails_1[0].setJ1(a);
		mesRails_2[0].setJ1(a);
		mesRails_3[19].setJ2(a);
		
		mesRails_1[19].setJ2(b);
		mesRails_2[19].setJ2(b);
		mesRails_3[0].setJ1(b);
		
		
		
		Train t1=new Train(0, 5, 15, new EtatTrain(mesRails_1[8],mesRails_1[8].getTroncon(1),-1,5));
		int avalA=0;
		int avalB=0;
		int i=0;
		while(true)
		{
			if(getNumeroRail(t1,mesRails_1)>0)
			{
				avalA++;
				avalA=avalA%2;
				b.changeAmont(1);
			}
			
			else if(getNumeroRail(t1,mesRails_2)>0)
			{
				avalA++;
				avalA=avalA%2;
				b.changeAmont(0);
			}
			
			
			i++;
			t1.avancer();
			//System.out.println(t1);
			System.out.println(section(t1,mesRails_1,mesRails_2,mesRails_3));
			
			
		}
	}
	
	
	public static String section(Train t,Rail[] a,Rail[] b,Rail[] c)
	{
		Rail monRail=t.monEtat().getRail();
		for(int i=0;i<a.length;i++)
		{
			if(monRail==a[i])
			{
				return "SUR A \t "+getNumeroRail(t,a);
			}
		}
		for(int i=0;i<b.length;i++)
		{
			if(monRail==b[i])
			{
				return "SUR B \t "+getNumeroRail(t,b);
			}
		}
		for(int i=0;i<c.length;i++)
		{
			if(monRail==c[i])
			{
				return "SUR C \t"+getNumeroRail(t,c);
			}
		}
		return "NON trouvé ";
	}
}
