package Carta;

import java.util.ArrayList;
import java.util.Collections;

public abstract class Mazzo {
	ArrayList<Carta> mazzo;
	public abstract void aggiungiCarta();
	public Carta pescaCarta() {
		Collections.shuffle(mazzo);
		Carta nuovaCarta= mazzo.get(0);
	    mazzo.remove(0);
	    nuovaCarta.girare();
	    return nuovaCarta;
	}
	
}
