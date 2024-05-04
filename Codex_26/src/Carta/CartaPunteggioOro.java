package Carta;
import java.util.ArrayList;

class CartaPunteggioOro extends Carta {
	private final Angolo[] angoliFronte=new Angolo[4];
	private final Angolo[] angoliRetro=new Angolo[5];
	private final Icona[] risorseMinime=new Icona[5];
	private final Icona regno;
	private int punteggio;
	
	public CartaPunteggioOro(int punteggio,Icona regno, Icona r1,Icona r2, Icona r3, Icona r4, Icona r5,Icona aCR,Icona a1R,Icona a2R,Icona a3R,Icona a4R, Icona a1, Icona a2, Icona a3, Icona a4) {
		this.regno=regno;
		if(isGirata()==false) {	
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
		}else {
			this.angoliRetro[0]=new Angolo(a1R);
			this.angoliRetro[1]=new Angolo(a2R);
			this.angoliRetro[2]=new Angolo(a3R);
			this.angoliRetro[3]=new Angolo(a4R);
			this.angoliRetro[4]=new Angolo(aCR);
		}
		
	}
	
	public boolean verificaRisorse(Icona[] risorseMinime, ArrayList<Icone> risorseTavolo) {
		for(int i=0; i<5; i++) {
			if(!risorseTavolo.contains(risorseMinime[i])) {
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
	public Icona getRegno() {
		return regno;
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
