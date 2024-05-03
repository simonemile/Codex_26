package Carta;

import java.util.List;

public abstract class Carta {
    List<Icona> icone; // Lista delle icone presenti sulla carta
    private boolean girata;
    private final int ID;
    
    public Carta(int ID, List<Icona> icone) {
        this.colore = colore;
        this.icone = icone;
        this.girata = false;
        this.ID=ID;
    }
    
    // Metodo astratto per ottenere il valore dei Punti Vittoria associato alla carta
    abstract int getValorePV();

	public boolean isGirata() {
		return girata;
	}
	public void setGirata(boolean girata) {
		this.girata = girata;
	}
	
	public boolean getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID=ID;
	}
	
	abstract void ControlloGirata();
	
	
}
