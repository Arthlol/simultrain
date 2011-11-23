package voie;

public abstract class Jonction extends ElementVoie{

	Jonction(int longueur)
	{
		super(longueur);
	}
	
	public abstract Rail getSuivant(Rail r);
	
}
