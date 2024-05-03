package Carta; 
import java.util.Collection;

public class MazzoIniziali extends Mazzo{
	private ArrayList<Iniziale> mazzo;
	
	@Override
	public MazzoIniziali() {
		mazzo=new ArrayList<Iniziale>(6);
		mazz.add()//da aggiungere tutte le carte iniziali
		
	}

	@Override
	public Iniziali pesca() {
		Collection.shuffle(mazzo);
	    Iniziale nuovaCarta= mazzo.get(0);
	    mazzo.remove(0);
	}
}
