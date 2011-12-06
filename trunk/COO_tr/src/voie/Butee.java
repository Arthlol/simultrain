package voie;

public class Butee extends Jonction{

	
	
	Butee(Rail r, int longueur)
	{
		super(longueur,r,null);
		
	}
	
	public Rail getSuivant(Rail p) {
		System.out.println(" Est en Butee");
		return null;
	}

}
