package Carta;

import java.util.Collection;

public class MazzoRisorsa extends Mazzo{
	private ArrayList<Risorsa> mazzo;
	
	
	
	public Iniziali pesca() {
		Collection.shuffle(mazzo);
	    Iniziale nuovaCarta= mazzo.get(0);
	    mazzo.remove(0);
	}
}
