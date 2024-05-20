package Codex_26;

import java.util.ArrayList;
import Carta.*;
import prova.Icona;

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
    
    
    public boolean controllaPosCarta(int rigaC, int colonnaC,Tavolo t, Carta c) {
    	Carta[][] cartePresenti=t.getTabellone();
    	//controllo se ci sono già carte in cella richiesta
    	if(cartePresenti[rigaC][colonnaC]!=null) {
    		return false;
    	}
    	//controllo necessità espansione tavolo
    	if(rigaC<0||rigaC>righe||colonnaC<0||colonnaC>colonne) {
    		t.espandiTavolo(rigaC, colonnaC);
    	}
    	//controllo se la carta non venga posizionata adiacentemente a una esistente
    	//utilizzo solo celle adiacenti alla posizione della nuova carta
    	for(int riga=rigaC-1; riga<=rigaC+1; riga++) {
    		for(int colonna=colonnaC-1; colonna<=colonnaC+1; colonna++) {
    			if((riga==rigaC||colonna==colonnaC)&& !(riga==rigaC && colonna==colonnaC)) {//esclude pos carta stessa e considera solo stessi valori riga/colonna per tenere true pos diagonali
    				if(cartePresenti[riga][colonna]!=null && riga>=0 && riga<righe && colonna>=0 && colonna<colonne) {
    					return false;
    				}
    			}
    		}
    	}
    	//controllo uguaglianze Icone agli angoli delle carte poste diagonalmente
    	//prendo le 4 carte direttamente in diagonale a quella che voglio piazzare
    	//di tali carte considero gli angoli d'interesse per la carta da piazzare
    	Carta gsx,gdx,sdx,ssx;
    	if(rigaC > 0 && colonnaC > 0) {
    	    gsx = cartePresenti[rigaC-1][colonnaC-1];//carta basso sinistra
    	    Icona asd = gsx.getAngolo()[1].getIcona();//angolo alto destra
    	    Icona angoloCarta= c.getAngolo()[2].getIcona();
    	    if() {
    	    	return false;
    	    }
    	}else {
    		gsx=null;
    	}
    	if(rigaC < cartePresenti.length-1 && colonnaC>0) {
    	    Carta gdx = cartePresenti[rigaC+1][colonnaC-1];//carta basso destra
    	    Icona ass = gdx.getAngolo()[0].getIcona();//angolo alto sinistra
    	    Icona angoloCarta= c.getAngolo()[3].getIcona();
    	    if() {
    	    	return false;
    	    }
    	}else {
    		gdx=null;
    	}
    	if (rigaC < cartePresenti.length-1 && colonnaC < cartePresenti[0].length-1) {
    	    Carta sdx = cartePresenti[rigaC+1][colonnaC+1];//carta alto destra
    	    Icona ags = sdx.getAngolo()[2].getIcona();//angolo basso sinistra
    	    Icona angoloCarta= c.getAngolo()[1].getIcona();
    	    if() {
    	    	return false;
    	    }
    	}else {
    		sdx=null;
    	}
    	if (rigaC>0 && colonnaC <cartePresenti[0].length-1) {
    	    Carta ssx = cartePresenti[rigaC-1][colonnaC+1];//carta alto sinistra
    	    Icona agd = ssx.getAngolo()[3].getIcona();//angolo basso destra
    	    Icona angoloCarta= c.getAngolo()[0].getIcona();
    	    if() {
    	    	return false;
    	    }
    	}else {
    		ssx=null;
    	}
    	//controllo se non esiste alcuna carta in diagonale rispetto a quella da posizionare
    	if(gsx == null && gdx == null && sdx == null && ssx == null) {
    		return false;
    	}
    	return true;
    	
    }
    
    public void aggiungiCarte(int colonna, int riga, Carta carta) {
    	
    }
    
    
    public void stampa() {
    	
    }
    
	public Carta[][] getTabellone() {
		return tabellone;
	}
	public void setTabellone(Carta[][] tabellone) {
		this.tabellone = tabellone;
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
