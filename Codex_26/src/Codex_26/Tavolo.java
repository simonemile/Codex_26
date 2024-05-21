package Codex_26;

import java.util.ArrayList;
import Carta.*;

public class Tavolo {
	
    private Carta[][] tabellone;
    private int righe;
    private int colonne;
    private ArrayList<Icona> risorseDisponibili;
    private ArrayList<Icona> regniDisponibili;
    
    public Tavolo() {
    	righe=1;
    	colonne=1;
    	tabellone=new Carta[righe][colonne];
    	risorseDisponibili = new ArrayList<>();
        regniDisponibili = new ArrayList<>();
    }
    
    //questo metodo permette di espandere la matrice nel momento in cui si voglia inserire 
    //una carta al di fuori delle righe e colonne già creati dal costruttore
    private void espandiTavolo(int rigaC, int colonnaC){
    	boolean espandi=false;
    	if((rigaC==0||rigaC==righe-1) || (colonnaC==0 || colonnaC==colonne-1)) {
    		espandi=true;
    	}
    	if(espandi) {
    		int righe2=righe+1;
    		int colonne2=colonne+1;
    		Carta[][] nuovoTabellone=new Carta[righe2][colonne2];
    		for(int i=0; i<righe2; i++) {
    			for(int j=0; j<colonne2; j++) {
    				nuovoTabellone[i][j]=null;
    			}
    		}
    		//riga e colonna Inizio permettono di capire se la nuova tabella parta da una riga o colonna prima rispetto a quella definita in precedenza.
    		int rigaInizio;
    		int colonnaInizio;
    		if(rigaC==0) {
    			rigaInizio=1;
    		}else {
    			rigaInizio=0;
    		}
    		if(colonnaC==0) {
    			colonnaInizio=1;
    		}else {
    			colonnaInizio=0;
    		}
    		for(int i=0; i<righe; i++) {
    			for(int j=0; j<colonne; j++) {
    				nuovoTabellone[i+rigaInizio][j+colonnaInizio]=tabellone[i][j];
    			}	
    		}
    		tabellone=nuovoTabellone;
    		righe=righe2;
    		colonne=colonne2;
    	}
    }
    
    
    public boolean controllaPosCarta(int rigaC, int colonnaC,Tavolo t) {
    	Carta[][] cartePresenti=t.getTabellone();
    	//controllo se ci sono già carte in cella richiesta
    	if(cartePresenti[rigaC][colonnaC]!=null) {
    		return false;
    	}
    	//controllo validità del tipo di carta scelta
    	if(cartePresenti[rigaC][colonnaC].getTipoCarta()==TipoCarta.OBIETTIVO||cartePresenti[rigaC][colonnaC].getTipoCarta()==TipoCarta.INIZIALE) {
    		return false;
    	}
    	//controllo Icone agli angoli delle carte poste diagonalmente
    	//prendo le 4 carte direttamente in diagonale a quella che voglio piazzare
    	//di tali carte considero gli angoli d'interesse per la carta da piazzare
    	Carta gsx=null,gdx=null,sdx=null,ssx=null;
    	if(rigaC > 0 && colonnaC > 0) {
    	    gsx = cartePresenti[rigaC-1][colonnaC-1];//carta basso sinistra
    	    //considera angolo alto destra
    	    if(gsx != null && gsx.getAngolo()[1].getIcona() == Icona.ASSENTE) {
    	    	return false;
    	    }
    	}
    	if(rigaC < cartePresenti.length-1 && colonnaC>0) {
    	     gdx = cartePresenti[rigaC+1][colonnaC-1];//carta basso destra
    	  //considero angolo alto sinistra
    	    if(gdx != null && gdx.getAngolo()[0].getIcona() == Icona.ASSENTE) {
    	    	return false;
    	    }
    	}
    	if (rigaC < cartePresenti.length-1 && colonnaC < cartePresenti[0].length-1) {
    	     sdx = cartePresenti[rigaC+1][colonnaC+1];//carta alto destra
    	    //considero angolo basso sinistra
    	    if(sdx != null && sdx.getAngolo()[2].getIcona() == Icona.ASSENTE) {
    	    	return false;
    	    }
    	}
    	if (rigaC>0 && colonnaC <cartePresenti[0].length-1) {
    	     ssx = cartePresenti[rigaC-1][colonnaC+1];//carta alto sinistra
    	    //considero angolo basso destra
    	    if(ssx != null && ssx.getAngolo()[3].getIcona() == Icona.ASSENTE) {
    	    	return false;
    	    }
    	}
    	//controllo se non esiste alcuna carta in diagonale rispetto a quella da posizionare
    	//permette anche di non posizionare carte immediatamente ai lati delle carte già preseni sul tavolo
    	if(gsx == null && gdx == null && sdx == null && ssx == null) {
    		return false;
    	}
    	return true;
 
    }
    
    public void aggiungiCarte(int riga, int colonna, Carta carta, Tavolo tavolo) {
    	
    	espandiTavolo(riga,colonna);
    	Carta[][] t=tavolo.getTabellone();
    	
    	if(controllaPosCarta(riga,colonna,tavolo)) {
    		t[riga][colonna]=carta;
    		aggiornaAngoli(riga,colonna,tavolo);
    		regniDisponibili.add(carta.getRegno());
    		for (Angolo angolo : carta.getAngolo()) {
                Icona icona = angolo.getIcona();
                risorseDisponibili.add(icona);
            }
    	}else {
    		System.out.println("Posizione non possibile per la carta scelta!");
    	}
    	
    }
    
    private void aggiornaAngoli(int riga, int colonna, Tavolo tavolo) {
    	
    	Carta[][] t = tavolo.getTabellone();
    	//considera gli angoli che vengono coperti dalla nuova carta, li rimuove dall'arraylist delle risorse disponibili e li setta a Icona.ASSENTE
    	if (riga > 0 && colonna > 0 && t[riga-1][colonna-1] != null) {
            risorseDisponibili.remove(t[riga-1][colonna-1].getAngolo()[3].getIcona());
            t[riga-1][colonna-1].getAngolo()[3].setNascosto();
        }
        if (riga< t.length-1 && colonna< t[0].length - 1 && t[riga+1][colonna+1] != null) {
        	risorseDisponibili.remove(t[riga+1][colonna+1].getAngolo()[1].getIcona());
        	t[riga + 1][colonna + 1].getAngolo()[1].setNascosto();
        }
        if (riga> 0 && colonna< t[0].length-1 && t[riga-1][colonna+1] != null) {
        	risorseDisponibili.remove(t[riga-1][colonna+1].getAngolo()[2].getIcona());
            t[riga-1][colonna+1].getAngolo()[2].setNascosto();
        }
        if (riga< t.length-1 && colonna>0 && t[riga+1][colonna-1] != null) {
        	 risorseDisponibili.remove(t[riga+1][colonna-1].getAngolo()[0].getIcona());
            t[riga+1][colonna-1].getAngolo()[0].setNascosto();
        }
        
    }
    
    public void stampa() {
    	
    }
    
	public Carta[][] getTabellone() {
		return tabellone;
	}
	public ArrayList<Icona> getRisorseDisponibili(){
		return risorseDisponibili;
	}
	public ArrayList<Icona> getregniDisponibili(){
		return regniDisponibili;
	}
	public Carta getCarta(int riga, int colonna) {
		return tabellone[riga][colonna];
	}

}