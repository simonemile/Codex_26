package Carta;

import java.util.ArrayList;
import java.util.Collections;

public class MazzoRisorsa extends Mazzo{
	private ArrayList<Risorsa> mazzo;
	private Risorsa c1, c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15;
	private Risorsa	c16,c17,c18,c19,c20,c21,c22,c23,c24,c25,c26,c27,c28;
	private Risorsa c29,c30,c31,c32,c33,c34,c35,c36,c37,c38,c39,c40;
	
	 public boolean isEmpty() {
	        return mazzo.isEmpty();
	 }
	 
	//punti, regno, a1,a2,a3,a4
	//VEGETALE, ANIMALE, FUNGHI, INSETTI, PIUMA, INCHIOSTRO, PERGAMENA, VUOTO, ASSENTE;
	@Override
	public void aggiungiCarta() {
		
		mazzo=new ArrayList<Risorsa>(40);
		
		mazzo.add(c1=new Risorsa(0,Icona.FUNGHI,Icona.FUNGHI,Icona.FUNGHI,Icona.VUOTO,Icona.ASSENTE));
		mazzo.add(c2=new Risorsa(0,Icona.FUNGHI,Icona.FUNGHI,Icona.FUNGHI,Icona.ASSENTE,Icona.VUOTO));
		mazzo.add(c3=new Risorsa(0,Icona.FUNGHI,Icona.VUOTO,Icona.ASSENTE,Icona.FUNGHI,Icona.FUNGHI));
		mazzo.add(c4=new Risorsa(0,Icona.FUNGHI,Icona.ASSENTE,Icona.FUNGHI,Icona.VUOTO,Icona.FUNGHI));
		mazzo.add(c5=new Risorsa(0,Icona.FUNGHI,Icona.ASSENTE,Icona.PIUMA,Icona.VEGETALE,Icona.FUNGHI));
		mazzo.add(c6=new Risorsa(0,Icona.FUNGHI,Icona.INCHIOSTRO,Icona.FUNGHI,Icona.VUOTO,Icona.ANIMALE));
		mazzo.add(c7=new Risorsa(0,Icona.FUNGHI,Icona.FUNGHI,Icona.INSETTI,Icona.PERGAMENA,Icona.VUOTO));
		mazzo.add(c8=new Risorsa(1,Icona.FUNGHI,Icona.VUOTO,Icona.FUNGHI,Icona.VUOTO,Icona.ASSENTE));
		mazzo.add(c9=new Risorsa(1,Icona.FUNGHI,Icona.FUNGHI,Icona.ASSENTE,Icona.VUOTO,Icona.VUOTO));
		mazzo.add(c10=new Risorsa(1,Icona.FUNGHI,Icona.ASSENTE,Icona.VUOTO,Icona.FUNGHI,Icona.VUOTO));
		
		mazzo.add(c11=new Risorsa(0,Icona.VEGETALE,Icona.VEGETALE,Icona.VUOTO,Icona.VEGETALE,Icona.ASSENTE));
		mazzo.add(c12=new Risorsa(0,Icona.VEGETALE,Icona.VEGETALE,Icona.VEGETALE,Icona.ASSENTE,Icona.VUOTO));
		mazzo.add(c13=new Risorsa(0,Icona.VEGETALE,Icona.VUOTO,Icona.ASSENTE,Icona.VEGETALE,Icona.VEGETALE));
		mazzo.add(c14=new Risorsa(0,Icona.VEGETALE,Icona.ASSENTE,Icona.VEGETALE,Icona.VUOTO,Icona.VEGETALE));
		mazzo.add(c15=new Risorsa(0,Icona.VEGETALE,Icona.ASSENTE,Icona.INSETTI,Icona.PIUMA,Icona.VEGETALE));
		mazzo.add(c16=new Risorsa(0,Icona.VEGETALE,Icona.FUNGHI,Icona.VEGETALE,Icona.ASSENTE,Icona.INCHIOSTRO));
		mazzo.add(c17=new Risorsa(0,Icona.VEGETALE,Icona.PERGAMENA,Icona.ASSENTE,Icona.VEGETALE,Icona.ANIMALE));
		mazzo.add(c18=new Risorsa(1,Icona.VEGETALE,Icona.VUOTO,Icona.VUOTO,Icona.VEGETALE,Icona.ASSENTE));
		mazzo.add(c19=new Risorsa(1,Icona.VEGETALE,Icona.VUOTO,Icona.VUOTO,Icona.ASSENTE,Icona.VEGETALE));
		mazzo.add(c20=new Risorsa(1,Icona.VEGETALE,Icona.ASSENTE,Icona.VEGETALE,Icona.VUOTO,Icona.VUOTO));
		
		mazzo.add(c21=new Risorsa(0,Icona.ANIMALE,Icona.ANIMALE,Icona.ANIMALE,Icona.VUOTO,Icona.ASSENTE));
		mazzo.add(c22=new Risorsa(0,Icona.ANIMALE,Icona.ASSENTE,Icona.VUOTO,Icona.ANIMALE,Icona.ANIMALE));
		mazzo.add(c23=new Risorsa(0,Icona.ANIMALE,Icona.ANIMALE,Icona.ASSENTE,Icona.ANIMALE,Icona.VUOTO));
		mazzo.add(c24=new Risorsa(0,Icona.ANIMALE,Icona.VUOTO,Icona.ANIMALE,Icona.ASSENTE,Icona.ANIMALE));
		mazzo.add(c25=new Risorsa(0,Icona.ANIMALE,Icona.ASSENTE,Icona.INSETTI,Icona.INCHIOSTRO,Icona.ANIMALE));
		mazzo.add(c26=new Risorsa(0,Icona.ANIMALE,Icona.VEGETALE,Icona.ANIMALE,Icona.ASSENTE,Icona.PERGAMENA));
		mazzo.add(c27=new Risorsa(0,Icona.ANIMALE,Icona.PIUMA,Icona.ASSENTE,Icona.ANIMALE,Icona.FUNGHI));
		mazzo.add(c28=new Risorsa(1,Icona.ANIMALE,Icona.ASSENTE,Icona.VUOTO,Icona.ANIMALE,Icona.VUOTO));
		mazzo.add(c29=new Risorsa(1,Icona.ANIMALE,Icona.VUOTO,Icona.ASSENTE,Icona.VUOTO,Icona.ANIMALE));
		mazzo.add(c30=new Risorsa(1,Icona.ANIMALE,Icona.VUOTO,Icona.ANIMALE,Icona.VUOTO,Icona.ASSENTE));
		
		mazzo.add(c31=new Risorsa(0,Icona.INSETTI,Icona.INSETTI,Icona.INSETTI,Icona.VUOTO,Icona.ASSENTE));
		mazzo.add(c32=new Risorsa(0,Icona.INSETTI,Icona.ASSENTE,Icona.VUOTO,Icona.INSETTI,Icona.INSETTI));
		mazzo.add(c33=new Risorsa(0,Icona.INSETTI,Icona.INSETTI,Icona.ASSENTE,Icona.INSETTI,Icona.VUOTO));
		mazzo.add(c34=new Risorsa(0,Icona.INSETTI,Icona.VUOTO,Icona.INSETTI,Icona.ASSENTE,Icona.INSETTI));
		mazzo.add(c35=new Risorsa(0,Icona.INSETTI,Icona.ASSENTE,Icona.PIUMA,Icona.ANIMALE,Icona.INSETTI));
		mazzo.add(c36=new Risorsa(0,Icona.INSETTI,Icona.PERGAMENA,Icona.INSETTI,Icona.ASSENTE,Icona.FUNGHI));
		mazzo.add(c37=new Risorsa(0,Icona.INSETTI,Icona.INSETTI,Icona.VEGETALE,Icona.INCHIOSTRO,Icona.ASSENTE));
		mazzo.add(c38=new Risorsa(1,Icona.INSETTI,Icona.INSETTI,Icona.ASSENTE,Icona.VUOTO,Icona.VUOTO));
		mazzo.add(c39=new Risorsa(1,Icona.INSETTI,Icona.VUOTO,Icona.VUOTO,Icona.ASSENTE,Icona.INSETTI));
		mazzo.add(c40=new Risorsa(1,Icona.INSETTI,Icona.ASSENTE,Icona.INSETTI,Icona.VUOTO,Icona.VUOTO));
		
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
