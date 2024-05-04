package Carta;
import java.util.Collections;

public class MazzoObiettivo extends Mazzo{
	private ArrayList<CartaObiettivo> mazzo;
	
	
	@Override
	public void pescaCarta() {
		Collections.shuffle(mazzo);
	    Iniziale nuovaCarta= mazzo.get(0);
	    mazzo.remove(0);
	}
}
