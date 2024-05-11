package Carta;

import prova.Angolo;
import prova.Icona;

public class Risorsa extends Carta {
	
	private final Angolo[] angoliFronte=new Angolo[4];
	private final Angolo[] angoliRetro=new Angolo[5];
	private final Icona regno;
	private final int punteggio;
	
	//costruttore carte Risorsa, ricevono il regno di appartenenza e simboli di ciascun angolo della carta per fronte/retro
	//la carta avrà icone diversi agli angoli a seconda se questa sia girata o meno
	public Risorsa(int punteggio,Icona regno, Icona a1, Icona a2, Icona a3, Icona a4) {
		this.regno=regno;
		if(isGirata()) {
			this.punteggio=0;
			this.angoliRetro[0]=new Angolo(Icona.VUOTO);
			this.angoliRetro[1]=new Angolo(Icona.VUOTO);
			this.angoliRetro[2]=new Angolo(Icona.VUOTO);
			this.angoliRetro[3]=new Angolo(Icona.VUOTO);
			this.angoliRetro[4]=new Angolo(regno);
		}else {
			this.punteggio=punteggio;
			this.angoliFronte[0]=new Angolo(a1);
			this.angoliFronte[1]=new Angolo(a2);
			this.angoliFronte[2]=new Angolo(a3);
			this.angoliFronte[3]=new Angolo(a4);
		}
	}
	
	@Override
	public Angolo[] getAngolo() {
		if(isGirata()) {
			return angoliRetro;
		}else {
			return angoliFronte;
		}
	}
	
	@Override
	public Icona getRegno() {
		return regno;
	}
	
}
