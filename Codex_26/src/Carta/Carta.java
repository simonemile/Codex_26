package Carta;

import java.util.ArrayList;
import java.util.Scanner;


public abstract class Carta {
	
    private boolean girata;
    
    public abstract Icona getRegno();
    public abstract Angolo[] getAngolo();
    public abstract TipoCarta getTipoCarta();
    
    //metodo per girare le carte
    public void girare() {
    	setGirata(girata=!girata);
    }
    
    public boolean isGirata() {
		return girata;
	}
	public void setGirata(boolean girata) {
		this.girata = girata;
	}
	
	public void decisioneLato() {
		boolean decisione=false;
		Scanner scanner=new Scanner(System.in);
		while(!decisione) {
			char a = scanner.next().charAt(0);
			if(a=='u') {
				setGirata(false);
				decisione=true;
			}else if(a=='d') {
				setGirata(true);
				decisione=true;
			}else {
				System.out.println("Lettera non valida, riprova!");
			}
		}
	}
	
	public void castCarta(boolean t,Carta c) {
		TipoCarta tipo=c.getTipoCarta();
		if(tipo==TipoCarta.RISORSA) {
			Risorsa risSelezionata=(Risorsa) c;
			t=true;
		}else if(tipo==TipoCarta.ORO) {
			CartaPunteggioOro oroSelezionata=(CartaPunteggioOro) c;
			t=true;
		}else {
			t=false;
		}
	}
	
}