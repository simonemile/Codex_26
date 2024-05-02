package Codex_26;

import Carta.Mazzo;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
			
		// Creazione del mazzo di carte
        Mazzo mazzo = new Mazzo();
        // Aggiunta delle carte al mazzo
        boolean fine =false;
        Scanner scanner = new Scanner(System.in);
        int numeroGiocatori;
        String nome=new String();
        String nuovoGiocatore=new String();
        ArrayList<Giocatore> giocatori = new ArrayList<Giocatori>();
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
        		giocatori.add(new Giocatore(nome,numeroGiocatori));
        		if(numeroGiocatori==1) {
        			giocatori.get(0).impostaColoreSegnalino("Nero");
        		}
        	}while(nuovoGiocatore.matches("s")&&(numeroGiocatori<2||numeroGiocatori<=4));
        	//Tavolo[size] tavolo=new Tavolo[size]();
        
        
        
        }while(fine!=true);
	}

}
