package Carta;
import java.util.Collection;

public class MazzoObiettivo extends Mazzo{
	private ArrayList<CartaObiettivo> mazzo;
	
	
	public Iniziali pesca() {
		Collection.shuffle(mazzo);
	    Iniziale nuovaCarta= mazzo.get(0);
	    mazzo.remove(0);
	}
}
