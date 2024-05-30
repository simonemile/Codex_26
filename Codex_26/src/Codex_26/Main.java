package Codex_26;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		 boolean fine =false;
	     Scanner scanner = new Scanner(System.in);
	     int numeroGiocatori=0;
	     int totgiocatori=0;
	     String nome=new String();
	     String nuovoGiocatore=new String();
	     ArrayList<Giocatore> giocatori = new ArrayList<Giocatore>();
	     ArrayList<Carta>[] carteInMano=new ArrayList[5];
	     Tavolo[]tavolo =new Tavolo[5];
	     Segnalino[]segnalino =new Segnalino[5];
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
	     
	     do {
	    	 System.out.println("Inserire almeno 2 giocatori:");
	    	 do {
	    		 System.out.println("\npremere s se si vuole aggiungere un altro giocatore\npremere n se non si vuole inserirne altri");
	    		 nuovoGiocatore=scanner.nextLine();
	    		 if(nuovoGiocatore.matches("s")) {
	    			 totgiocatori++;
	    			 if(totgiocatori <=4) {
	    				 scanner.reset();
	    				 System.out.println("Inserire nome nuovo giocatore:");
	    				 nome=scanner.nextLine();
	    				 tavolo[numeroGiocatori]=new Tavolo();
	    				 carteInMano[numeroGiocatori]=new ArrayList<Carta>();
	    				 segnalino[numeroGiocatori]=new Segnalino(null, null, 0);
	  		         	CartaObiettivo obbPersonale1=mObb.pescaCarta();
	  		         	CartaObiettivo obbPersonale2=mObb.pescaCarta();
	  		         	System.out.println("Scegliere con 1 o 2 quale carta scegliere");
	  		         	CartaObiettivo obbPersonale = null;
	  		         	int numObb=0;
	  		         	//ciclo per decidere quale carta obiettivo ricevere
	  		         	do {
	  		         		try {
	  		         			numObb=scanner.nextInt();
	  		         		}catch(InputMismatchException e) {
	  		         			System.out.println("Inserire un numero!");
	  		         			scanner.next();
	  		         			continue;
	  		         		}
	  		         		if(numObb==1) {
	  		         			obbPersonale=obbPersonale1;
	  		         		}else if(numObb==2) {
	  		         			obbPersonale=obbPersonale2;
	  		         		}else {
	  		         			System.out.println("Gli obiettivi sono 2");
	    	       			 	continue;
	  		         		}
	  		         		scanner.reset();
	  		         		break;
	  		         	}while(numObb!=1 &&numObb!=2);
	  		         	giocatori.add(new Giocatore(nome,numeroGiocatori,tavolo[numeroGiocatori],segnalino[numeroGiocatori], obbPersonale,carteInMano[numeroGiocatori]));
	  		         	//impostazione colori dei segnalini associati ai giocatori
	  		         	if (numeroGiocatori == 0) {
	  		         		segnalino[numeroGiocatori].setColore(Colore.NERO);
	  		         		if (!listaColori.isEmpty()) {
	  		         			segnalino[numeroGiocatori].setColoreSecondario(segnalino[numeroGiocatori].randomizzaColore(listaColori));
	  		         		} else {
	  		         			System.out.println("Non ci sono più colori disponibili per i segnalini secondari!");
	  		         		}
	  		         	} else {
	  		         		if (!listaColori.isEmpty()) {
	                    	 segnalino[numeroGiocatori].setColoreSecondario(segnalino[numeroGiocatori].randomizzaColore(listaColori));
	                    	 Colore c2=segnalino[numeroGiocatori].getColoreSecondario();
	                    	 segnalino[numeroGiocatori].setColore(c2);
	  		         		} else {
	  		         			System.out.println("Non ci sono più colori disponibili per i segnalini!");
	  		         		}
	  		         	}
	  		         	numeroGiocatori++;
	    			 }else {
	    				 break;
	    			 }
	    		 }else if (nuovoGiocatore.matches("n")) {
	    			 if (totgiocatori < 2) {
	    				 System.out.println("Devi inserire almeno due giocatori. Premi 's' per aggiungere un altro giocatore.");
	    			 } else {
	    				 break;
	    			 }
	    		 }
	    	 }while(true);

	        	
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
	        		   	 System.out.println("Decidere se posizionare la carta iniziale di fronte o retro: ");
	        		     primaCarta.decisioneLato();
	        		     personaleTavolo.setTabellone(0,0,primaCarta);

	        			 personaleMano.add(mOro.pescaCarta());
	        			 personaleMano.add(mRis.pescaCarta());
	        			 personaleMano.add(mRis.pescaCarta());
	        		 }
	        		 System.out.println("Inserire il numero della carta che si desidera posizionare");
	        		 int numCarta;
	        		 boolean successo=false;
	        		 Carta cSelezionata=null;
	        		 //trovo punteggio assegnato dagli obiettivi comuni prima dell'inserimento della carta
	        		 int tmp1=obbComune1.assegnaPunteggio(obbComune1, personaleTavolo);
	        		 int tmp2=obbComune2.assegnaPunteggio(obbComune2, personaleTavolo);
	        		
	        		 //azioni base durante il turno, la boolean successo consente di ripetere l'azione qualora si sia compiuto un errore
	        		 //selezione carta da piazzare
	        		 while(!successo) {
	        			 while(true) {
	        				try {
	        					numCarta = scanner.nextInt();
	        					if(numCarta>=1 && numCarta<=3) {
	        						 cSelezionata=personaleMano.get(numCarta - 1);
	        						 successo=true;
	        						 break;
	        					}else {
	        						System.out.println("Scegliere un numero tra 1-3!");
	        					}
	        				}catch(InputMismatchException e) {
	        					System.out.println("Scegliere un numero tra 1-3!");
	        					scanner.next();
	        				}
	        			 }
	        			 scanner.reset();
	        			
	        			 //selezione lato e coordinate
	        			 int x;
	        			 int y;
	        	         System.out.println("Scegliere lato con cui posizionare carta (usare 'u' e 'd')");
	        	    	 cSelezionata.decisioneLato();
	        	         System.out.println("Inserire riga e colonna in cui si desidera posizionare la carta \nRighe e colonne 0 sono valide e considerate antecedenti ai limiti");
	        	         while (true) {
	        	        	 try {
	        	        		 x=scanner.nextInt();
	        	        		 scanner.nextLine();
	        	    		     y=scanner.nextInt(); 
	                       	 	 successo=personaleTavolo.controllaPosCarta(x,y,personaleTavolo);
	                       	 	 if(successo) {
	                       	 		 personaleTavolo.aggiungiCarte(x,y,cSelezionata,personaleTavolo);
	    	            	    	 break;
	                       	 	 }
	        	   		     } catch (InputMismatchException  e) {
	        	   		    	 System.out.println("Input non valido. Riprovare!");
	                       		 scanner.next(); 
	       	    		     }
	        	    	 }

	        	         scanner.reset();
	        		     
	        		     //azioni specifiche in caso di carta risorsa posizionata
	        		     if(cSelezionata.getTipoCarta()==TipoCarta.RISORSA) {
		        			   Risorsa cRis=(Risorsa) cSelezionata;
		        			   personaleSegnalino.setPos(cRis.getPunteggio());
	        		     }
	        		    //azioni specifiche in caso di carta oro posizionata
	        		    if(cSelezionata.getTipoCarta()==TipoCarta.ORO) {
	        		    	CartaPunteggioOro cOro=(CartaPunteggioOro) cSelezionata;
	        			     Icona[] risNec=cOro.getRisorseMinime();
	        			     successo=cOro.verificaRisorse(risNec, personaleTavolo);
	        			     if(successo) {
	        			    	 int p=cOro.assegnaPunti(cOro, personaleTavolo, personaleSegnalino, x-1, y-1);
	        				     personaleSegnalino.setPos(p);
	        			     }else {
	        			    	 System.out.println("Risorse insufficienti, scegliere un'altra carta.");
	        			     } 
	        		    }
	        		 }
	        		 //assegnazione punti per turno degli obiettivi comuni
	        		 int p2=obbComune1.assegnaPunteggio(obbComune1, personaleTavolo);
	        	     int p3=obbComune2.assegnaPunteggio(obbComune2, personaleTavolo);
	        	     personaleSegnalino.setPos(-tmp1-tmp2+p3+p2);
	        		
	        	     //dopo aver piazzato la carta c'è la possibilità di pescare
	        	     while (!successo) {
	        	    	 System.out.println("Seleziona carta da pescare");
	                     int azione = -1;
	                     while (successo) {
	                    	 try {
	                    		 azione = scanner.nextInt();
	                             scanner.reset(); 
	                             if (azione<1 || azione>6) {
	                            	 System.out.println("Scegliere un numero tra 1 e 6!");
	                             } else {
	                            	 break;
	                             }
	                    	 } catch (InputMismatchException  e) {
	                    		 System.out.println("Input non valido. Riprovare!");
	                    		 scanner.reset();
	                    	 }

	                    	 switch (azione) {
	                    	 case 1:
	                    		 personaleMano.add(t1);
	                    		 t1=mRis.pescaCarta();
	                    		 successo = true;
	                    		 break;
	                         case 2:
	                        	 personaleMano.add(t2);
	                        	 t2=mRis.pescaCarta();
	                             successo = true;
	                             break;
	                         case 3:
	                    	     personaleMano.add(t3);
	                    	     t3=mOro.pescaCarta();
	                             successo = true;
	                             break;
	                         case 4:
	                    	     personaleMano.add(t4);
	                    	     t4=mOro.pescaCarta();
	                             successo = true;
	                             break;
	                         case 5:
	                    	     personaleMano.add(mRis.pescaCarta());
	                             successo = true;
	                             break;
	                         case 6:
	                    	     personaleMano.add(mOro.pescaCarta());
	                             successo = true;
	                             break;
	                         default:
	                             System.out.println("Scegliere un numero tra 1 e 6!");
	                             successo=false;
	                    	 }
	                     }
	        	     }
	          
	        	     if(personaleSegnalino.getPos()>maxPunteggio) {
	        		     maxPunteggio=personaleSegnalino.getPos();
	        	     }
	        	     System.out.println(personaleSegnalino.getPos());
	        	 }		
	  
	        	 turno++;
	         }while(maxPunteggio<20); //il controllo punteggio avviene alla fine del turno dell'ultimo giocatore
	         
	         //punti ricevuti alla fine per obiettivo personale
	         for(Giocatore giocatore: giocatori) {
	        	CartaObiettivo c=giocatore.getObiettivoPersonale();
	        	Tavolo t=giocatore.getTavolo();
	        	Segnalino s=giocatore.getSegnalino();
	        	s.setPos(c.assegnaPunteggio(c,t));
	         }
	         Giocatore vincitore=giocatori.get(0);
	         for (Giocatore giocatore: giocatori) {
	        	 if (giocatore.getSegnalino().getPos() > vincitore.getSegnalino().getPos()) {
	        		 vincitore = giocatore;
	        	 } 
	         }
	         System.out.println("Il vincitore è "+vincitore.getNome()+" con punteggio: "+vincitore.getSegnalino().getPos());
	        	
	        
	       	System.out.println("si desidera iniziare una nuova partita? S=si,");
	    }while(fine!=true);
	}

}