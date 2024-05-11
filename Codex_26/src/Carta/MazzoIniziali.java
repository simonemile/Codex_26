package Carta; 

import java.util.Collections;
import java.util.ArrayList;

public class MazzoIniziali extends Mazzo{
	private ArrayList<Iniziale> mazzo;
	private Iniziale c1,c2,c3,c4,c5,c6;
	
	//VEGETALE, ANIMALE, FUNGHI, INSETTI, PIUMA, INCHIOSTRO, PERGAMENA, VUOTO, ASSENTE;
	//Icona a1, Icona a2, Icona a3, Icona a4, Icona aRC1, Icona aC2,Icona aC3, Icona aR1,Icona aR2,Icona aR3,Icona aR4
	@Override
	public void aggiungiCarta() {
		
		mazzo=new ArrayList<Iniziale>(6);
		
		mazzo.add(c1=new Iniziale(Icona.VUOTO,Icona.VEGETALE,Icona.INSETTI,Icona.VUOTO,Icona.ASSENTE,Icona.INSETTI,Icona.ASSENTE,Icona.FUNGHI,Icona.VEGETALE,Icona.INSETTI,Icona.ANIMALE));
		mazzo.add(c2=new Iniziale(Icona.ANIMALE,Icona.VUOTO,Icona.VUOTO,Icona.FUNGHI,Icona.ASSENTE,Icona.FUNGHI,Icona.ASSENTE,Icona.VEGETALE,Icona.ANIMALE,Icona.FUNGHI,Icona.INSETTI));
		mazzo.add(c3=new Iniziale(Icona.VUOTO,Icona.VUOTO,Icona.VUOTO,Icona.VUOTO,Icona.VEGETALE,Icona.FUNGHI,Icona.ASSENTE,Icona.INSETTI,Icona.ANIMALE,Icona.FUNGHI,Icona.VEGETALE));
		mazzo.add(c4=new Iniziale(Icona.VUOTO,Icona.VUOTO,Icona.VUOTO,Icona.VUOTO,Icona.ANIMALE,Icona.INSETTI,Icona.ASSENTE,Icona.VEGETALE,Icona.INSETTI,Icona.ANIMALE,Icona.FUNGHI));
		mazzo.add(c5=new Iniziale(Icona.VUOTO,Icona.VUOTO,Icona.ASSENTE,Icona.ASSENTE,Icona.ANIMALE,Icona.INSETTI,Icona.VEGETALE,Icona.INSETTI,Icona.FUNGHI,Icona.VEGETALE,Icona.ANIMALE));
		mazzo.add(c6=new Iniziale(Icona.VUOTO,Icona.VUOTO,Icona.ASSENTE,Icona.ASSENTE,Icona.VEGETALE,Icona.ANIMALE,Icona.FUNGHI,Icona.FUNGHI,Icona.ANIMALE,Icona.VEGETALE,Icona.INSETTI));
		
		Collections.shuffle(mazzo);
	}
	
	@Override
	public Iniziale pescaCarta() {
		Iniziale nuovaCarta= mazzo.get(0);
	    mazzo.remove(0);
	    nuovaCarta.girare();
	    return nuovaCarta;
	}
		
}
