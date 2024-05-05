package Carta;

import java.util.List;

public abstract class Carta {
	
    private boolean girata;
    
    //metodo per girare le carte
    public void girare(Carta carta) {
    	girata=!girata;
    }
    
    public boolean isGirata() {
		return girata;
	}
	public void setGirata(boolean girata) {
		this.girata = true;
	}
	
}