package Carta;

import java.util.ArrayList;
import java.util.Collections;

public class MazzoOro extends Mazzo{
	private ArrayList<CartaPunteggioOro> mazzo;
	
	@Override
	public void aggiungiCarta() {
		mazzo=new ArrayList<Risorsa>(40);
		mazzo.add(c1=new c1())
	}
	
	@Override
	public void pescaCarta() {
		Collections.shuffle(mazzo);
		Iniziale nuovaCarta= mazzo.get(0);
	    mazzo.remove(0);
	    nuovaCarta.girare();
	    return nuovaCarta;
	}
	
}
