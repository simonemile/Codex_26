package Codex_26;

import java.util.ArrayList;
import Carta.*;

public class Tavolo {
	
    private Carta[][] tabellone = new Carta[0][0];
    private ArrayList<Icona> risorseDisponibili;
    
	public Carta[][] getTabellone() {
		return tabellone;
	}

	public void setTabellone(Carta[][] tabellone) {
		this.tabellone = tabellone;
	}
	public ArrayList<Icona> getRisorseDisponibili(){
		return risorseDisponibili;
	}
}
