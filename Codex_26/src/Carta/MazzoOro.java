package Carta;

import java.util.Collections;

public class MazzoOro extends Mazzo{
	private ArrayList<CartaPunteggioOro> mazzo;
	
	
	@Override
	public void pescaCarta() {
		Collections.shuffle(mazzo);
		CartaPunteggioOro nuovaCarta= mazzo.get(0);
	    mazzo.remove(0);
	}
}
