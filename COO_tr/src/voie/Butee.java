package voie;

public class Butee extends Jonction{

	Rail monRail;
	
	Butee(Rail r, int longueur)
	{
		super(longueur);
		monRail=r;
	}
	
	public Rail getSuivant(Rail p) {
		System.out.println(" Est en Butee");
		return null;
	}

}
