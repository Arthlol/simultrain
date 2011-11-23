package voie;

public class JonctionSimple extends Jonction{

	Rail r1,r2;
	
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
	public void setR1(Rail r)
	{
		r1=r;
	}
	
	public void setR2(Rail r){
		r2=r;
	}

}
