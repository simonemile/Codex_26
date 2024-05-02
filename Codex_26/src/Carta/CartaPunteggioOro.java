package Carta;

import java.util.List;

class CartaPunteggioOro extends Carta {
    int valorePV; // Valore dei Punti Vittoria associato alla carta
    
    public CartaPunteggioOro(String tipo, String colore, List<Icona> icone, int valorePV) {
        super(tipo, colore, icone);
        this.valorePV = valorePV;
    }
    
    @Override
    public int getValorePV() {
        return this.valorePV;
    }

	@Override
	boolean ControlloGirata() {
		// TODO Auto-generated method stub
		return false;
	}
}
