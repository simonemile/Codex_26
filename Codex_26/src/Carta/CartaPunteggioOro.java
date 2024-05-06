package Carta;

import Codex_26.Tavolo;
import prova.Icona;

import java.util.ArrayList;

class CartaPunteggioOro extends Carta {
	private final Angolo[] angoliFronte=new Angolo[4];
	private final Angolo[] angoliRetro=new Angolo[5];
	private final Icona[] risorseMinime=new Icona[5];
	private final Icona regno;
	private int punteggio;
	
	//costruttore cartaPunteggioOro, riceve come parametri punti assegnati, le risorse per poterla usare e le proprietà degli angoli retro/fronte
	//la carta avrà icone diversi agli angoli a seconda se questa sia girata o meno
	public CartaPunteggioOro(int punteggio,Icona regno, Icona r1,Icona r2, Icona r3, Icona r4, Icona r5,Icona aCR,Icona a1R,Icona a2R,Icona a3R,Icona a4R, Icona a1, Icona a2, Icona a3, Icona a4) {
		this.regno=regno;
		if(isGirata()) {	
			this.angoliRetro[0]=new Angolo(a1R);
			this.angoliRetro[1]=new Angolo(a2R);
			this.angoliRetro[2]=new Angolo(a3R);
			this.angoliRetro[3]=new Angolo(a4R);
			this.angoliRetro[4]=new Angolo(aCR);
		}else {
			this.punteggio=punteggio;
			this.risorseMinime[0]=r1;
			this.risorseMinime[1]=r2;
			this.risorseMinime[2]=r3;
			this.risorseMinime[3]=r4;
			this.risorseMinime[4]=r5;
			this.angoliFronte[0]=new Angolo(a1);
			this.angoliFronte[1]=new Angolo(a2);
			this.angoliFronte[2]=new Angolo(a3);
			this.angoliFronte[3]=new Angolo(a4);
		}
		
	}
	
	//metodo per verificare che le condizioni per poter piazzare la carta siano incontrate
	public boolean verificaRisorse(Icona[] risorseMinime,Tavolo tavolo) {
		ArrayList<Icona> risorseDisponibili=tavolo.getRisorseDisponibili();
		for(int i=0; i<5; i++) {
			if(!risorseDisponibili.contains(risorseMinime[i])) {
				return false;
			}
		}
		return true;
	}
	
	
	public int getPunteggio() {
		return punteggio;
	}
	public Angolo[] getAngoliFronte() {
		return angoliFronte;
	}
	public Angolo[] getAngoliRetro() {
		return angoliRetro;
	}
	public Icona[] getRisorseMinime() {
		return risorseMinime;
	}
	@Override
	public Icona getRegno() {
		return regno;
	}

}
