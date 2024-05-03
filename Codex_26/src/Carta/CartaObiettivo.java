package Carta;

import java.util.List;

class CartaObiettivo extends Carta {
    int puntiVittoria; // Punti Vittoria associati all'obiettivo
    private boolean personale;
    private Angolo[] angolo;
    
    public CartaObiettivo(int ID, String tipo, String colore, List<Icona> icone, int puntiVittoria,Angolo[] angolo) {
        super(ID, tipo, colore, icone);
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
