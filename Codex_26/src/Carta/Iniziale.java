package Carta;

import java.util.List;

public class Iniziale extends Carta {

	public Iniziale(String tipo, String colore, List<Icona> icone, boolean girata) {
		super(tipo, colore, icone, girata);
	}
	
	public Angolo[] getAngolo() {
		return angolo;
	}
	public void setAngolo(Angolo[] angolo) {
		this.angolo = angolo;
	}

	@Override
	int getValorePV() {
		return 0;
	}

	@Override
	void ControlloGirata() {
		
	}
	
	
		

}
