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
		         segnalino[numeroGiocatori]=new Segnalino(null, null, 0);
		         CartaObiettivo obbPersonale1=mObb.pescaCarta();
		         CartaObiettivo obbPersonale2=mObb.pescaCarta();
		         System.out.println("Scegliere con 1 o 2 quale carta scegliere");
		         CartaObiettivo obbPersonale = null;
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
	        				}catch(Exception e) {
	        					System.out.println("Scegliere un numero tra 1-3!");
	        					scanner.reset();
	        				}
	        			}
	        			scanner.reset();
	        			
	        		   //selezione lato e coordinate
	        		   int x;
	        		   int y;
	        	       while(true) {
	        	    	   System.out.println("Scegliere lato con cui posizionare carta (usare 'u' e 'd')");
	        	    	   cSelezionata.decisioneLato();
	        	    	   System.out.println("Inserire riga e colonna in cui si desidera posizionare la carta \nRighe e colonne 0 sono valide e considerate antecedenti ai limiti");
	        	    	   while (true) {
	        	    		   try {
	        	    			   x=scanner.nextInt();
	        	    			   y=scanner.nextInt();
	        	    			   scanner.reset(); 
	                            	successo=true;
	                            	break;
	        	    		   } catch (Exception e) {
	        	    			   System.out.println("Input non valido. Riprovare!");
	                        		scanner.reset(); 
	        	    		   }
	        	    	   }
	        	    	   personaleTavolo.aggiungiCarte(x,y,cSelezionata,personaleTavolo,successo);
	        	    	   if(successo) {
	        	    		   break;
	        	    	   }else {
	        	    		   System.out.println("Impossibile utilizzare quella posizione!");
	        	    	   }
	        	       }
	        		   scanner.reset();
	     
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
	        				   break;
	        			   } 
	        		   }
	        		  break;
	        	  }
	        	  //assegnazione punti per turno degli obiettivi comuni
	        	  int p2=obbComune1.assegnaPunteggio(obbComune1, personaleTavolo);
	        	  int p3=obbComune2.assegnaPunteggio(obbComune2, personaleTavolo);
	        	  personaleSegnalino.setPos(-tmp1-tmp2+p3+p2);
	        			
	        	  while (!successo) {
	                  System.out.println("Seleziona carta da pescare");
	                  int azione = -1;
	                  while (true) {
	                      try {
	                          azione = scanner.nextInt();
	                          scanner.reset(); 
	                          if (azione<1 || azione>6) {
	                              System.out.println("Scegliere un numero tra 1 e 6!");
	                          } else {
	                              break;
	                          }
	                      } catch (Exception e) {
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
	                          break;
	                  }
	                  }
	                  }
	          
	        	  if(personaleSegnalino.getPos()>maxPunteggio) {
	        		  maxPunteggio=personaleSegnalino.getPos();
	        	  }
	            }		
	  
	        	
	        	turno++;
	        }while(maxPunteggio<20); //il controllo punteggio avviene alla fine del turno dell'ultimo giocatore
	         
	         //punti ricevuti alla fine per obiettivo personale
	         for(Giocatori giocatore: giocatori) {
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
	         System.out.println("Il vincitore è "+vincitore.getNome()+" con punteggio: "vincitore.getSegnalino().getPos());
	        	
	        
	       	System.out.println("si desidera iniziare una nuova partita? S=si,");
	    }while(fine!=true);
	}

}