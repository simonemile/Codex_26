package Carta;

import prova.Icona;

public class Risorsa extends Carta {
	
	private final Angolo[] angoliFronte=new Angolo[4];
	private final Angolo[] angoliRetro=new Angolo[5];
	private final Icona regno;
	
	//costruttore carte Risorsa, ricevono il regno di appartenenza e simboli di ciascun angolo della carta per fronte/retro
	//la carta avrà icone diversi agli angoli a seconda se questa sia girata o meno
	public Risorsa(Icona regno, Icona a1, Icona a2, Icona a3, Icona a4) {
		this.regno=regno;
		if(isGirata()) {
			this.angoliRetro[0]=new Angolo(Icona.VUOTO);
			this.angoliRetro[1]=new Angolo(Icona.VUOTO);
			this.angoliRetro[2]=new Angolo(Icona.VUOTO);
			this.angoliRetro[3]=new Angolo(Icona.VUOTO);
			this.angoliRetro[4]=new Angolo(regno);
		}else {
			this.angoliFronte[0]=new Angolo(a1);
			this.angoliFronte[1]=new Angolo(a2);
			this.angoliFronte[2]=new Angolo(a3);
			this.angoliFronte[3]=new Angolo(a4);
		}
		
	}
	
	@Override
	public Icona getRegno() {
		return regno;
	}
	
}
