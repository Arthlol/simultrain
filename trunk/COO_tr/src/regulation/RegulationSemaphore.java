package regulation;

import java.util.ArrayList;

import signalisation.Semaphore;

public class RegulationSemaphore extends ElementRegulation{

	ArrayList<Semaphore> mesSemaphore;
	
	public RegulationSemaphore(ArrayList<Semaphore> semaphore)
	{
		mesSemaphore=(ArrayList<Semaphore>) semaphore.clone();
	}
	
	void reset(int i)
	{
		mesSemaphore.get(i).reset();
	}
	
	void add(Semaphore s)
	{
		mesSemaphore.add(s);
	}
}
