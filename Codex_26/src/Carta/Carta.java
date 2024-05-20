package Carta;

import java.util.List;

import prova.Angolo;
import prova.TipoCarta;

public abstract class Carta {
	
    private boolean girata;
    
    public abstract Icona getRegno();
    public abstract Angolo[] getAngolo();
    public abstract TipoCarta getTipoCarta();
    
    //metodo per girare le carte
    public void girare() {
    	setGirata(girata=!girata);
    }
    
    public boolean isGirata() {
		return girata;
	}
	public void setGirata(boolean girata) {
		this.girata = girata;
	}
	
}