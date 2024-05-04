package Carta;

import java.util.List;

class CartaPunteggioOro extends Carta {
    int valorePV; // Valore dei Punti Vittoria associato alla carta
    
    public CartaPunteggioOro(String tipo, String colore, List<Icona> icone, int valorePV,Angolo[] angolo) {
        super(tipo, colore, icone);
        this.valorePV = valorePV;
        this.angolo=angolo;
    }
    
    public Angolo[] getAngolo() {
		return angolo;
	}
	public void setAngolo(Angolo[] angolo) {
		this.angolo = angolo;
	}
    
    @Override
    public int getValorePV() {
        return this.valorePV;
    }


}
