package Carta;

import java.util.List;

public class Risorsa extends Carta {

	public Risorsa(String tipo, String colore, List<Icona> icone) {
		super(tipo, colore, icone);
		// TODO Auto-generated constructor stub
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