package Carta;

import Codex_26.*;
import java.util.ArrayList;

class CartaPunteggioOro extends Carta {
	private Angolo[] angoliFronte=new Angolo[4];
	private Angolo[] angoliRetro=new Angolo[5];
	private final Icona[] risorseMinime=new Icona[5];
	private final Icona regno;
	private final int punteggio;
	private final int type;
	private final Icona dipIcona;
	private final TipoCarta n;
	
	/*costruttore cartaPunteggioOro, riceve come parametri punti assegnati, le risorse per poterla usare e le proprietà degli angoli retro/fronte
	**la carta avrà icone diversi agli angoli a seconda se questa sia girata o meno
	**il type indica se il punteggio dipende dagli angoli coperti della carta 2,dalle risorse sul campo 1, o sono fissi 0
	**dipIcona indica l'icona da cui dipendono i punteggi di alcune carte
	*/
	public CartaPunteggioOro(int punteggio, int type, Icona dipIcona, Icona regno, Icona r1,Icona r2, Icona r3, Icona r4, Icona r5,Icona a1, Icona a2, Icona a3, Icona a4) {
		this.n=TipoCarta.ORO;
		this.regno=regno;
		this.type=type;
		if(isGirata()) {	
			this.dipIcona=Icona.ASSENTE;	
			this.punteggio=0;
			this.angoliRetro[0]=new Angolo(Icona.VUOTO);
			this.angoliRetro[1]=new Angolo(Icona.VUOTO);
			this.angoliRetro[2]=new Angolo(Icona.VUOTO);
			this.angoliRetro[3]=new Angolo(Icona.VUOTO);
			this.angoliRetro[4]=new Angolo(regno);
		}else {
			this.dipIcona=dipIcona;
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
		for(int i=0; i<6; i++) {
			if(!risorseDisponibili.contains(risorseMinime[i]) && (risorseMinime[i]!=Icona.ASSENTE || risorseMinime[i]!=Icona.VUOTO)) {
				return false;
			}
		}
		return true;
	}
	
	//permette di contare quanti angoli una carta copre per i punteggi assegnati dipendente dal numero di angoli coperti
	private int contaAngoliCoperti(Tavolo tavolo, int riga, int colonna) {
		int coperti=0;
		Carta[][] carteTavolo=tavolo.getTabellone();
		//se l'angolo viene coperto getnascosto->true e incrementa il numero di angoli coperti
		//controllo alto sx
		 if(riga>0 && colonna>0) {
	            if(carteTavolo[riga-1][colonna-1]!= null) {
	                if(carteTavolo[riga-1][colonna-1].getAngolo()[2].getNascosto()){
	                	coperti++;
	                }
	            }
	        }
		 //controllo alto dx
	        if(riga>0 && colonna<carteTavolo[0].length-1){
	            if(carteTavolo[riga-1][colonna+1]!= null){
	                if(carteTavolo[riga-1][colonna+1].getAngolo()[3].getNascosto()){
	                    coperti++;
	                }
	            }
	        }
	        // controllo basso sx
	        if(riga<carteTavolo.length-1 && colonna>0){
	            if (carteTavolo[riga+1][colonna-1]!= null){
	                if (carteTavolo[riga+1][colonna-1].getAngolo()[1].getNascosto()) {
	                    coperti++;
	                }
	            }
	        }
	        //controllo basso dx
	        if (riga<carteTavolo.length-1 && colonna<carteTavolo[0].length-1){
	            if (carteTavolo[riga+1][colonna+1]!= null){
	                if (carteTavolo[riga+1][colonna+1].getAngolo()[0].getNascosto()){
	                    coperti++;
	                }
	            }
	        }
		
		return coperti;
	}
	
	//metodo per contare ripetizione di risorse nel caso il punteggio sia assegnato in base alle risorse disponibili sul tavolo
	private int contaDipIcona(CartaPunteggioOro c, Tavolo t) {
		int ripetizione=0;
		Icona iconaCercata=c.getDipIcona();
	   	ArrayList<Icona> risorseDisponibili=t.getRisorseDisponibili();
	   	for(Icona elemento:risorseDisponibili) {
	   		if(elemento.equals(iconaCercata)) {
	   			ripetizione++;
	   		}
	   	}
	  		return ripetizione;
	}
	
	public void assegnaPunti(CartaPunteggioOro c, Tavolo t, Segnalino s, int x, int y) {
		int tipoCarta=c.getType();
		int punteggioCarta=c.getPunteggio();
		if(isGirata()==false) {
			if(tipoCarta==0) {
				s.setPos(punteggioCarta);
			}else if(tipoCarta==1) {
				int numRisorse=c.contaDipIcona(c, t);
				s.setPos(numRisorse*punteggioCarta);
			}else if(tipoCarta==2) {
				int numAngoli=c.contaAngoliCoperti(t, x, y);
				s.setPos(numAngoli*punteggioCarta);
			}
		}
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
	public Icona getDipIcona() {
		return dipIcona;
	}
	public int getType() {
		return type;
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
	@Override
	public TipoCarta getTipoCarta() {
		return n;
	}

}
