package Carta;

import java.util.List;

public abstract class Carta {
    private boolean girata;
	abstract boolean rceviPunti();
    abstract int getValorePV();
    public void girare() {
    	if(girata==true) {
    		girata=false;
    	}else {
    		girata=true;
    	}
    }
	public boolean isGirata() {
		return girata;
	}
	public void setGirata(boolean girata) {
		this.girata = girata;
	}
	
}
