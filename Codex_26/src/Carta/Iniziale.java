package Carta;

import java.util.List;

public class Iniziale extends Carta {
	
	private final Angolo[] angoliFronte=new Angolo[4];
	private final Angolo[] angoliRetro=new Angolo[4];
	public Iniziale(int ID, String colore, List<Icona> icone, boolean girata) {
		super(ID, colore, icone, girata);
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
