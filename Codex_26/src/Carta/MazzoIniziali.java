package Carta; 

public class MazzoIniziali extends Mazzo{
	private ArrayList<Iniziale> mazzo;
	
	
	@Override
	public Iniziali pesca() {
		Random rand = new Random();
	    Iniziale nuovaCarta= mazzo.get(0);
	    mazzo.remove(0);
	}
}
