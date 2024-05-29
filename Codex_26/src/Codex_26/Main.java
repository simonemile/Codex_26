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
	     MazzoIniziali mIniz;
	     mIniz.aggiungiCarta();
	     MazzoObiettivo mObb;
	     mObb.aggiungiCarta();
	     MazzoRisorsa mRis;
         mRis.aggiungiCarta();
         MazzoOro mOro;
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
	        	segnalino[numeroGiocatori]=new Segnalino(null, null, 0);
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
	       	CartaObiettivo obbComune1=mObb.pescaCarta();
	        CartaObiettivo obbComune2=mObb.pescaCarta();
	        	
	        //svolgimento del turno
	        int turno=1;
	        System.out.println("Regolamento: \nPer decidere se posizionare una carta fronte o retro premere rispettivamente u, d \nPer decidere posizione della carta indicare numero delle coordinate desiderate\n");
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
	        			Iniziale primaCarta= mIniz.pescaCarta();
	        			System.out.println("Decidere se posizionare la carta di fronte o retro: ");
	        			primaCarta.decisioneLato();
	        			personaleTavolo.aggiungiCarte(0,0,primaCarta,personaleTavolo, false);
	        			
	        			personaleMano.add(mOro.pescaCarta());
	        			personaleMano.add(mRis.pescaCarta());
	        			personaleMano.add(mRis.pescaCarta());
	        		}
	        		System.out.println("Inserire il numero della carta che si desidera posizionare");
	        		int numCarta;
	        		boolean successo;
	        		Carta cSelezionata;
	        		//trovo punteggio assegnato dagli obiettivi comuni prima dell'inserimento della carta
	        		int tmp1=obbComune1.assegnaPunteggio(obbComune1, personaleTavolo);
	        		int tmp2=obbComune2.assegnaPunteggio(obbComune2, personaleTavolo);
	        		do {
	        			numCarta=scanner.nextInt();
	        			switch(numCarta) {
	        			//controllo validità del type della carta 
	        				case 1:
	        					cSelezionata=personaleMano.get(0);
	        					cSelezionata.castCarta(successo,cSelezionata);
	        					break;
	        				case 2:
	        					cSelezionata=personaleMano.get(1);
	        					cSelezionata.castCarta(successo,cSelezionata);
	        					break;
	        				case 3:
	        					cSelezionata=personaleMano.get(2);
	        					cSelezionata.castCarta(successo,cSelezionata);
	        					break;
	        				default:
	        					System.out.println("Scegliere un numero tra 1-3!");
	        					scanner.reset();
	        					break;
	        			}
	        			scanner.reset();
	        			do {
	        				System.out.println("Scegliere lato con cui posizionare carta (usare 'u' e 'd')");
	        				cSelezionata.decisioneLato();
	        				int x;
	        				int y;
	        				System.out.println("Inserire riga e colonna in cui si desidera posizionare la carta \nRighe e colonne 0 sono valide e considerate antecedenti ai limiti");
	        				x=scanner.nextInt();
	        				scanner.reset();
	        				y=scanner.nextInt();
	        				scanner.reset();
	        				personaleTavolo.aggiungiCarte(x,y,cSelezionata,personaleTavolo,successo);
	        				if(successo!=true) {
	        					break;
	        				}
	        				//azioni specifiche in caso di carta oro posizionata
	        				if(cSelezionata.getTipoCarta()==TipoCarta.ORO) {
	        					CartaPunteggioOro cOro=(CartaPunteggioOro) cSelezionata;
	        					Icona[] risNec=cOro.getRisorseMinime();
	        					successo=cOro.verificaRisorse(risNec, personaleTavolo);
	        					if(successo!=true) {
	        						break;
	        					}
	        					int p=cOro.assegnaPunti(cOro, personaleTavolo, personaleSegnalino, x-1, y-1);
	        					personaleSegnalino.setPos(p);
	        				}
	        			}while(successo!=true);
	        			//assegnazione punti per turno degli obiettivi comuni
	        			int p2=obbComune1.assegnaPunteggio(obbComune1, personaleTavolo);
	        			int p3=obbComune2.assegnaPunteggio(obbComune2, personaleTavolo);
	        			personaleSegnalino.setPos(-tmp1-tmp2+p3+p2);
	        			
	        			
	        		}while(successo==false);
	        			
	        			
	        			
	        			
	        			
	        			
	  
	        	}
	        	
	        	turno++;
	        }while(maxPunteggio<20); //il controllo punteggio avviene alla fine del turno dell'ultimo giocatore
	        
	        	
	        
	       	System.out.println("si desidera iniziare una nuova partita? S=si,");
	    }while(fine!=true);
	}

}