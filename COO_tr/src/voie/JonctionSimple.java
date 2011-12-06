package voie;

public class JonctionSimple extends Jonction{

	
	
	
	
	
	public JonctionSimple(Rail rail1,Rail rail2) {
		super(0,rail1,rail2);
		
	}

	
	public Rail getSuivant(Rail r) {
		if(r!=null)
		{
			if(r==r1)
			{
				//System.out.print(" \t SORTIE R2 \n");
				return r2;
			}
			else
			{
				
				return r1;
			}
		}
		
		System.out.println(" Jonction cible est NULL");
		return null;
	}
	public void setR1(Rail r)
	{
		r1=r;
	}
	
	public void setR2(Rail r){
		r2=r;
	}

}
