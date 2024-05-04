package Carta; 
import java.util.Collections;

import prova.CartaPunteggioOro;

public class MazzoIniziali extends Mazzo{
	private ArrayList<Iniziale> mazzo;
	


	@Override
	public void aggiungiCarta() {
		mazzo=new ArrayList<Iniziale>(6);
		mazzo.add()=(cI1=new Iniziale());
		
	}

	@Override
	public void pescaCarta() {
		Collections.shuffle(mazzo);
		Iniziale nuovaCarta= mazzo.get(0);
	    mazzo.remove(0);
	}
		
	}
}
