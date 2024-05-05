package Carta;

import java.util.Collections;

public abstract class Mazzo {
	public abstract void aggiungiCarta();
	public Carta pescaCarta() {
		Collections.shuffle(mazzo);
		Iniziale nuovaCarta= mazzo.get(0);
	    mazzo.remove(0);
	    return nuovaCarta;
	}
	
}
