package voie;

public class JonctionSimple extends Jonction{

	
	
	public JonctionSimple()
	{
		super(0);
	}
	
	
	public JonctionSimple(Rail rail1,Rail rail2) {
		super(0);
		r1=rail1;
		r2=rail2;
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
