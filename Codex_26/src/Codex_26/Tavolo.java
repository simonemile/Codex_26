package Codex_26;

import java.util.ArrayList;
import Carta.*;

public class Tavolo {
	
    private Carta[][] tabellone = new Carta[40][40];
    private ArrayList<Icona> risorseDisponibili;
    private ArrayList<Icona> regniDisponibili;
    
	public Carta[][] getTabellone() {
		return tabellone;
	}
	public Icona[][] getRegno(){
		
	}
	public void setTabellone(Carta[][] tabellone) {
		this.tabellone = tabellone;
	}
	public ArrayList<Icona> getRisorseDisponibili(){
		return risorseDisponibili;
	}

}
