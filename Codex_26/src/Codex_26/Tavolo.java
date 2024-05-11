package Codex_26;

import java.util.ArrayList;
import Carta.*;

public class Tavolo {
	
    private Carta[][] tabellone = new Carta[][];
    private ArrayList<Icona> risorseDisponibili;
    private ArrayList<Icona> regniDisponibili;
    
	public Carta[][] getTabellone() {
		return tabellone;
	}
	public void setTabellone(Carta[][] tabellone) {
		this.tabellone = tabellone;
	}
	public ArrayList<Icona> getRisorseDisponibili(){
		return risorseDisponibili;
	}
	public ArrayList<Icona> getregniDisponibili(){
		return regniDisponibili;
	}
	public Carta getCarta(int riga, int colonna) {
		return tabellone[riga][colonna];
	}

}
