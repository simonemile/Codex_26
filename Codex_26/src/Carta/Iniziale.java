package Carta;

import java.util.List;

import prova.Icona;

public class Iniziale extends Carta {
	
	private final Angolo[] angoliFronte=new Angolo[4];
	private final Angolo[] angoliRetro=new Angolo[6];
	private boolean girata; 
	public Iniziale(Icona a1, Icona a2, Icona a3, Icona a4, Icona aC1, Icona aC2,Icona aR1,Icona aR2,Icona aR3,Icona aR4) {
		this.angoliRetro[0]=new Angolo(aR1);
		this.angoliRetro[1]=new Angolo(aR2);
		this.angoliRetro[2]=new Angolo(aR3);
		this.angoliRetro[3]=new Angolo(aR4);
		this.angoliRetro[4]=new Angolo(aC1);
		this.angoliRetro[5]=new Angolo(aC2);
		this.girata=true;
		if(angoliRetro[4].getIcona()==Icona.ASSENTE && angoliRetro[5].getIcona()==Icona.ASSENTE) {
			this.girata=false;
			this.angoliFronte[0]=new Angolo(a1);
			this.angoliFronte[1]=new Angolo(a2);
			this.angoliFronte[2]=new Angolo(a3);
			this.angoliFronte[3]=new Angolo(a4);
			this.angoliFronte[4]=new Angolo(aC1);
			this.angoliFronte[5]=new Angolo(aC2);
		}
	}
	
	@Override
	public int getValorePV() {
		return 0;
	}
	@Override
	public boolean riceviPunti() {
		return false;
	}
		

}
