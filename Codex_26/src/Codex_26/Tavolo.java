package Codex_26;

import Carta.*;

public class Tavolo {
	
    private Carta[][] tabellone = new Carta[0][0];
    private ArrayList<Icone> risorseDisponibili;
    
    

	public Carta[][] getTabellone() {
		return tabellone;
	}

	public void setTabellone(Carta[][] tabellone) {
		this.tabellone = tabellone;
	}
}
