package Carta;

import java.util.Collection;

public class MazzoOro extends Mazzo{
	private ArrayList<CartaPunteggioOro> mazzo;
	
	
	public Iniziali pesca() {
		Collection.shuffle(mazzo);
	    Iniziale nuovaCarta= mazzo.get(0);
	    mazzo.remove(0);
	}
}
