package Carta;

import java.util.ArrayList;
import java.util.Collections;

public class MazzoRisorsa extends Mazzo{
	private ArrayList<Risorsa> mazzo;
	private Risorsa c1, c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15;
	private Risorsa	c16,c17,c18,c19,c20,c21,c22,c23,c24,c25,c26,c27,c28;
	
	//regno, a1,a2,a3,a4
	//VEGETALE, ANIMALE, FUNGHI, INSETTI, PIUMA, INCHIOSTRO, PERGAMENA, VUOTO, ASSENTE;
	@Override
	public void aggiungiCarta() {
		
		mazzo=new ArrayList<Risorsa>(28);
		
		mazzo.add(c1=new Risorsa(Icona.FUNGHI,Icona.FUNGHI,Icona.FUNGHI,Icona.VUOTO,Icona.ASSENTE));
		mazzo.add(c2=new Risorsa(Icona.FUNGHI,Icona.FUNGHI,Icona.FUNGHI,Icona.ASSENTE,Icona.VUOTO));
		mazzo.add(c3=new Risorsa(Icona.FUNGHI,Icona.VUOTO,Icona.ASSENTE,Icona.FUNGHI,Icona.FUNGHI));
		mazzo.add(c4=new Risorsa(Icona.FUNGHI,Icona.ASSENTE,Icona.FUNGHI,Icona.VUOTO,Icona.FUNGHI));
		mazzo.add(c5=new Risorsa(Icona.FUNGHI,Icona.ASSENTE,Icona.PIUMA,Icona.VEGETALE,Icona.FUNGHI));
		mazzo.add(c6=new Risorsa(Icona.FUNGHI,Icona.INCHIOSTRO,Icona.FUNGHI,Icona.VUOTO,Icona.ANIMALE));
		mazzo.add(c7=new Risorsa(Icona.FUNGHI,Icona.FUNGHI,Icona.INSETTI,Icona.PERGAMENA,Icona.VUOTO));
		
		mazzo.add(c8=new Risorsa(Icona.VEGETALE,Icona.VEGETALE,Icona.VUOTO,Icona.VEGETALE,Icona.ASSENTE));
		mazzo.add(c9=new Risorsa(Icona.VEGETALE,Icona.VEGETALE,Icona.VEGETALE,Icona.ASSENTE,Icona.VUOTO));
		mazzo.add(c10=new Risorsa(Icona.VEGETALE,Icona.VUOTO,Icona.ASSENTE,Icona.VEGETALE,Icona.VEGETALE));
		mazzo.add(c11=new Risorsa(Icona.VEGETALE,Icona.ASSENTE,Icona.VEGETALE,Icona.VUOTO,Icona.VEGETALE));
		mazzo.add(c12=new Risorsa(Icona.VEGETALE,Icona.ASSENTE,Icona.INSETTI,Icona.PIUMA,Icona.VEGETALE));
		mazzo.add(c13=new Risorsa(Icona.VEGETALE,Icona.FUNGHI,Icona.VEGETALE,Icona.ASSENTE,Icona.INCHIOSTRO));
		mazzo.add(c14=new Risorsa(Icona.VEGETALE,Icona.PERGAMENA,Icona.ASSENTE,Icona.VEGETALE,Icona.ANIMALE));
		
		mazzo.add(c15=new Risorsa(Icona.ANIMALE,Icona.ANIMALE,Icona.ANIMALE,Icona.VUOTO,Icona.ASSENTE));
		mazzo.add(c16=new Risorsa(Icona.ANIMALE,Icona.ASSENTE,Icona.VUOTO,Icona.ANIMALE,Icona.ANIMALE));
		mazzo.add(c17=new Risorsa(Icona.ANIMALE,Icona.ANIMALE,Icona.ASSENTE,Icona.ANIMALE,Icona.VUOTO));
		mazzo.add(c18=new Risorsa(Icona.ANIMALE,Icona.VUOTO,Icona.ANIMALE,Icona.ASSENTE,Icona.ANIMALE));
		mazzo.add(c19=new Risorsa(Icona.ANIMALE,Icona.ASSENTE,Icona.INSETTI,Icona.INCHIOSTRO,Icona.ANIMALE));
		mazzo.add(c20=new Risorsa(Icona.ANIMALE,Icona.VEGETALE,Icona.ANIMALE,Icona.ASSENTE,Icona.PERGAMENA));
		mazzo.add(c21=new Risorsa(Icona.ANIMALE,Icona.PIUMA,Icona.ASSENTE,Icona.ANIMALE,Icona.FUNGHI));
		
		mazzo.add(c22=new Risorsa(Icona.INSETTI,Icona.INSETTI,Icona.INSETTI,Icona.VUOTO,Icona.ASSENTE));
		mazzo.add(c23=new Risorsa(Icona.INSETTI,Icona.ASSENTE,Icona.VUOTO,Icona.INSETTI,Icona.INSETTI));
		mazzo.add(c24=new Risorsa(Icona.INSETTI,Icona.INSETTI,Icona.ASSENTE,Icona.INSETTI,Icona.VUOTO));
		mazzo.add(c25=new Risorsa(Icona.INSETTI,Icona.VUOTO,Icona.INSETTI,Icona.ASSENTE,Icona.INSETTI));
		mazzo.add(c26=new Risorsa(Icona.INSETTI,Icona.ASSENTE,Icona.PIUMA,Icona.ANIMALI,Icona.INSETTI));
		mazzo.add(c27=new Risorsa(Icona.INSETTI,Icona.PERGAMENA,Icona.INSETTI,Icona.ASSENTE,Icona.FUNGHI));
		mazzo.add(c28=new Risorsa(Icona.INSETTI,Icona.INSETTI,Icona.VEGETALE,Icona.INCHIOSTRO,Icona.ASSENTE));
		
		Collections.shuffle(mazzo);
	}
	
	@Override
	public Risorsa pescaCarta() {
		Risorsa nuovaCarta= mazzo.get(0);
	    mazzo.remove(0);
	    nuovaCarta.girare();
	    return nuovaCarta;
	}
}
