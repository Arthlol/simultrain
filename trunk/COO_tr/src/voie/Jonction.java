package voie;

public abstract class Jonction extends ElementVoie{

	Rail r1,r2;
	
	public Jonction(int longueur)
	{
		super(longueur);
	}
	
	public abstract Rail getSuivant(Rail r);
	
}
