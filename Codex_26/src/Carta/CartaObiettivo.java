package Carta;

import java.util.List;

class CartaObiettivo extends Carta {
	
	private int punteggio;
	private Icona regno;
    private boolean personale=false;
    private boolean girata;
    private Icona[] risorsaNecessaria;
    
    //costruttore per carte obiettivo con risorse minime necessarie sul tavolo
    public CartaObiettivo(int punteggio, Icona r1, Icona r2, Icona r3, Icona r4) {
    	this.girata=false;
    	this.punteggio=punteggio;
    	this.risorsaNecessaria[0]=r1;
    	this.risorsaNecessaria[1]=r2;
    	this.risorsaNecessaria[2]=r3;
    	this.risorsaNecessaria[3]=r4;
    }
    
    //
    public CartaObiettivo() {
    	
    }
    
    public void rendiPersonale(CartaObiettivo cartaObiettivoPersonale) {
    	super.girare(cartaObiettivoPersonale);
    	
    }

}
