package Codex_26;

import java.util.ArrayList;
import java.util.Collections;
import Carta.*;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		 boolean fine =false;
	        Scanner scanner = new Scanner(System.in);
	        int numeroGiocatori=0;
	        String nome=new String();
	        String nuovoGiocatore=new String();
	        ArrayList<Giocatore> giocatori = new ArrayList<Giocatore>();
	        Tavolo[]tavolo = null;
	        Segnalino[]segnalino = null;
	        MazzoIniziali mIniz=new MazzoIniziali();
	        mIniz.aggiungiCarta();
	        MazzoObiettivo mObb=new MazzoObiettivo();
	        mObb.aggiungiCarta();
	        MazzoRisorsa mRis=new MazzoRisorsa();
        	mRis.aggiungiCarta();
        	MazzoOro mOro=new MazzoOro();
        	mOro.aggiungiCarta();
	        int maxPunteggio=0;
	        
	        ArrayList<Colore> listaColori=new ArrayList<>();
	        Collections.addAll(listaColori, Colore.values());
	        listaColori.remove(Colore.NERO);
	        do {
	        	
	        	do {
	        		do {
	        			System.out.println("Inserire almeno due giocatori\npremere s se si vuole aggiungere un altro giocatore\n premere n se non si vuole inserirne altri");
	        			nuovoGiocatore=scanner.nextLine();
	        		}while(!nuovoGiocatore.matches("s")&& !nuovoGiocatore.matches("n"));
	        		scanner.reset();
	        		System.out.println("Inserire nome nuovo giocatore:");
	        		nome=scanner.nextLine();
	        		numeroGiocatori++;
	        		tavolo[numeroGiocatori]=new Tavolo();
	        		segnalino[numeroGiocatori]=new Segnalino();
	        		CartaObiettivo obbPersonale1=mObb.pescaCarta();
	        		CartaObiettivo obbPersonale2=mObb.pescaCarta();
	        		System.out.println("Scegliere con 1 o 2 quale carta scegliere");
	        		CartaObiettivo obbPersonale;
	        		int numObb;
	        		//ciclo per decidere quale carta obiettivo ricevere
	        		do {
	        			numObb=scanner.nextInt();
	        			if(numObb==1) {
	        				obbPersonale=obbPersonale1;
	        			}else if(numObb==2) {
	        				obbPersonale=obbPersonale2;
	        			}else {
	        				System.out.println("Gli obiettivi sono 2");
	        			}
	        			scanner.reset();
	        		}while(numObb!=1 || numObb!=2);
	        		giocatori.add(new Giocatore(nome,numeroGiocatori,tavolo[numeroGiocatori],segnalino[numeroGiocatori], obbPersonale));
	        		//impostazione colori dei segnalini associati ai giocatori
	        		if(numeroGiocatori==1) {
	        			segnalino[numeroGiocatori].setColore(Colore.NERO);
	        			segnalino[numeroGiocatori].setColoreSecondario(listaColori.get(0));
	        			listaColori.remove(listaColori.get(0));
	        		}else {
	        			Colore coloreSecondario = listaColori.get(0);
	        			segnalino[numeroGiocatori].setColoreSecondario(coloreSecondario);
	        			listaColori.remove(listaColori.get(0));
	        			segnalino[numeroGiocatori].setColore(coloreSecondario);
	        		}
	        	}while(nuovoGiocatore.matches("s")&&(numeroGiocatori<2||numeroGiocatori<=4));
	        	
	        	//carte presenti sul tavolo nel mometno iniziale
	        	Carta t1=mRis.pescaCarta();
	        	Carta t2=mRis.pescaCarta();
	        	Carta t3=mOro.pescaCarta();
	        	Carta t4=mOro.pescaCarta();
	        	Carta obbComune1=mObb.pescaCarta();
	        	Carta obbComune2=mObb.pescaCarta();
	        	
	        	//svolgimento del turno
	        	int turno=1;
	        	System.out.println("Regolamento: \nPer decidere se posizionare una carta fronte o retro premere rispettivamente u, d \n Per decidere posizione della carta indicare numero delle coordinate desiderate\n");
	        	System.out.println("Nella selezione di azioni del turno 1-2: prendono carte risorse scoperte, 3-4: prendono carte oro scoperte, 5:pesca dal mazzo risorsa, 6: pesca dal mazzo oro");
	        	do {
	        		System.out.println("Turno numero: "+turno);
	        		for(Giocatore giocatore: giocatori) {
	        			if(mRis.isEmpty() && mOro.isEmpty()) {
	        				break;
	        			}
	        			Segnalino personaleSegnalino=giocatore.getSegnalino();
	        			Tavolo personaleTavolo=giocatore.getTavolo();
	        			ArrayList<Carta> personaleMano=giocatore.getCarteInMano();
	        			System.out.println("Turno di: "+giocatore.getNome());
	        			//azioni compiute nel primo turno
	        			if(turno==1) {
	        				personaleMano.add(mOro.pescaCarta());
	        				personaleMano.add(mRis.pescaCarta());
	        				personaleMano.add(mRis.pescaCarta());
	        				Iniziale primaCarta= mIniz.pescaCarta();
	        				System.out.println("Decidere se posizionare la carta di fronte o retro: ");
	        				primaCarta.decisioneLato();
	        				personaleTavolo.aggiungiCarte(0,0,primaCarta,personaleTavolo);
	        			}
	        			
	        			
	        			
	        			
	  
	        		}
	        		turno++;
	        	}while(maxPunteggio<20); //il controllo punteggio avviene alla fine del turno dell'ultimo giocatore
	        
	        	
	        
	        	System.out.println("si desidera iniziare una nuova partita? S=si,");
	        }while(fine!=true);
	}

}
