package Carta;

import java.util.List;

class CartaObiettivo extends Carta {
    int puntiVittoria; // Punti Vittoria associati all'obiettivo
    private boolean personale;
    
    public CartaObiettivo(String tipo, String colore, List<Icona> icone, int puntiVittoria) {
        super(tipo, colore, icone);
        this.puntiVittoria = puntiVittoria;
        this.personale = false;
    }
    
    @Override
    public int getValorePV() {
        return this.puntiVittoria;
    }

	@Override
	boolean ControlloGirata() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isPersonale() {
		return personale;
	}

	public void setPersonale(boolean personale) {
		this.personale = personale;
	}
}
