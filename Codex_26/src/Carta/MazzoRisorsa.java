package Carta;

import java.util.Collections;

public class MazzoRisorsa extends Mazzo{
	private ArrayList<Risorsa> mazzo;
	
	
	
	@Override
	public void pescaCarta() {
		Collections.shuffle(mazzo);
	    Iniziale nuovaCarta= mazzo.get(0);
	    mazzo.remove(0);
	}
}
