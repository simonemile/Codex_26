package Carta;

import java.util.List;

public abstract class Carta {
	
    private boolean girata;
    
    public abstract Icona getRegno();
    
    //metodo per girare le carte
    public void girare() {
    	setGirata(girata=!girata);
    }
    
    public boolean isGirata() {
		return girata;
	}
	public void setGirata(boolean girata) {
		this.girata = true;
	}
	
}