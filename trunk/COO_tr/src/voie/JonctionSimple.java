package voie;

public class JonctionSimple extends Jonction{

	Rail r1,r2;
	
	JonctionSimple(int longueur,Rail rail1,Rail rail2) {
		super(longueur);
		r1=rail1;
		r2=rail2;
	}

	
	Rail getSuivant(Rail r) {
		if(r!=null)
		{
			if(r==r1)
			{
				return r2;
			}
			else if(r==r2)
			{
				return r1;
			}
			else
			{
				return null;
			}
		}
		
		
		return null;
	}

}
