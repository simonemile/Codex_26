package Carta;

import java.util.List;

public abstract class Carta {
    String tipo; // Tipo della carta (es. "Risorsa", "Oro", "Obiettivo")
    String colore; // Colore della carta (es. "Verde", "Blu", "Viola", "Arancione")
    List<Icona> icone; // Lista delle icone presenti sulla carta
    private boolean girata;
    
    public Carta(String tipo, String colore, List<Icona> icone) {
        this.tipo = tipo;
        this.colore = colore;
        this.icone = icone;
        this.girata = false;
    }
    
    // Metodo astratto per ottenere il valore dei Punti Vittoria associato alla carta
    abstract int getValorePV();

	public boolean isGirata() {
		return girata;
	}

	public void setGirata(boolean girata) {
		this.girata = girata;
	}
	
	abstract boolean ControlloGirata();
	
	
}
