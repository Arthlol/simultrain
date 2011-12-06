package voie;

public abstract class Jonction extends ElementVoie{

	Rail r1,r2;
	
	public Jonction(int longueur,Rail rail1,Rail rail2)
	{
		super(longueur);
		r1=rail1;
		r2=rail2;
	}
	
	public Rail getSuivant(Rail r) {
		
		if(r!=null)
		{
			if(r==r2)
			{
				//System.out.println(" R2 -> R1 ");
				return r1;
			}else 
			{
				//System.out.println(" R1 -> R2 ");
				return r2;
			}
		}
		System.out.println(" Jonction vide - Erreur suivant "); // cas d'erreur 
		return null; 
	}
	
}
