package Carta;

import java.util.List;

public class Risorsa extends Carta {
	
	Angolo angolo

	public Risorsa(String tipo, String colore, List<Icona> icone,Angolo[] angolo) {
		super(tipo, colore, icone);
		this.angolo=angolo;
	}
	
	
	 public Angolo[] getAngolo() {
			return angolo;
		}
	public void setAngolo(Angolo[] angolo) {
		this.angolo = angolo;
	}

	@Override
	int getValorePV() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	boolean ControlloGirata() {
		// TODO Auto-generated method stub
		return false;
	}

}
