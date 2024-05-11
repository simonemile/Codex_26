package Carta;

import java.util.ArrayList;
import java.util.Collections;

public class MazzoOro extends Mazzo{
	private ArrayList<CartaPunteggioOro> mazzo;
	private CartaPunteggioOro c1, c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15;
	private CartaPunteggioOro	c16,c17,c18,c19,c20,c21,c22,c23,c24,c25,c26,c27,c28;
	private CartaPunteggioOro c29,c30,c31,c32,c33,c34,c35,c36,c37,c38,c39,c40;
	
	
	//int punteggio, int type, Icona dipIcona, Icona regno, Icona r1,Icona r2, Icona r3, Icona r4, Icona r5,Icona a1, Icona a2, Icona a3, Icona a4
	@Override
	public void aggiungiCarta() {
		
		mazzo=new ArrayList<CartaPunteggioOro>(40);
		
		mazzo.add(c1=new CartaPunteggioOro(1,1,Icona.PIUMA, Icona.FUNGHI,Icona.FUNGHI,Icona.FUNGHI,Icona.ANIMALE,Icona.ASSENTE,Icona.ASSENTE,Icona.ASSENTE,Icona.VUOTO,Icona.VUOTO,Icona.PIUMA));
		mazzo.add(c2=new CartaPunteggioOro(1,1,Icona.INCHIOSTRO, Icona.FUNGHI,Icona.FUNGHI,Icona.FUNGHI,Icona.VEGETALE,Icona.ASSENTE,Icona.ASSENTE,Icona.VUOTO,Icona.INCHIOSTRO,Icona.ASSENTE,Icona.VUOTO));
		mazzo.add(c3=new CartaPunteggioOro(1,1,Icona.PERGAMENA, Icona.FUNGHI,Icona.FUNGHI,Icona.FUNGHI,Icona.INSETTI,Icona.ASSENTE,Icona.ASSENTE,Icona.PERGAMENA,Icona.VUOTO,Icona.VUOTO,Icona.ASSENTE));
		
		mazzo.add(c4=new CartaPunteggioOro(2,2,Icona.ASSENTE, Icona.FUNGHI,Icona.FUNGHI,Icona.FUNGHI,Icona.FUNGHI,Icona.ANIMALE,Icona.ASSENTE,Icona.VUOTO,Icona.VUOTO,Icona.ASSENTE,Icona.VUOTO));
		mazzo.add(c5=new CartaPunteggioOro(2,2,Icona.ASSENTE, Icona.FUNGHI,Icona.FUNGHI,Icona.FUNGHI,Icona.FUNGHI,Icona.VEGETALE,Icona.ASSENTE,Icona.VUOTO,Icona.VUOTO,Icona.VUOTO,Icona.ASSENTE));
		mazzo.add(c6=new CartaPunteggioOro(2,2,Icona.ASSENTE, Icona.FUNGHI,Icona.FUNGHI,Icona.FUNGHI,Icona.FUNGHI,Icona.INSETTI,Icona.ASSENTE,Icona.VUOTO,Icona.ASSENTE,Icona.VUOTO,Icona.VUOTO));
		
		mazzo.add(c7=new CartaPunteggioOro(3,0,Icona.ASSENTE, Icona.FUNGHI,Icona.FUNGHI,Icona.FUNGHI,Icona.FUNGHI,Icona.ASSENTE,Icona.ASSENTE,Icona.VUOTO,Icona.ASSENTE,Icona.INCHIOSTRO,Icona.ASSENTE));
		mazzo.add(c8=new CartaPunteggioOro(3,0,Icona.ASSENTE, Icona.FUNGHI,Icona.FUNGHI,Icona.FUNGHI,Icona.FUNGHI,Icona.ASSENTE,Icona.ASSENTE,Icona.PIUMA,Icona.VUOTO,Icona.ASSENTE,Icona.ASSENTE));
		mazzo.add(c9=new CartaPunteggioOro(3,0,Icona.ASSENTE, Icona.FUNGHI,Icona.FUNGHI,Icona.FUNGHI,Icona.FUNGHI,Icona.ASSENTE,Icona.ASSENTE,Icona.ASSENTE,Icona.PERGAMENA,Icona.ASSENTE,Icona.VUOTO));
		mazzo.add(c10=new CartaPunteggioOro(5,0,Icona.ASSENTE, Icona.FUNGHI,Icona.FUNGHI,Icona.FUNGHI,Icona.FUNGHI,Icona.FUNGHI,Icona.FUNGHI,Icona.VUOTO,Icona.ASSENTE,Icona.VUOTO,Icona.ASSENTE));

		mazzo.add(c11=new CartaPunteggioOro(1,1,Icona.PIUMA, Icona.VEGETALE,Icona.VEGETALE,Icona.VEGETALE,Icona.INSETTI,Icona.ASSENTE,Icona.ASSENTE,Icona.PIUMA,Icona.VUOTO,Icona.VUOTO,Icona.ASSENTE));
		mazzo.add(c12=new CartaPunteggioOro(1,1,Icona.PERGAMENA, Icona.VEGETALE,Icona.VEGETALE,Icona.VEGETALE,Icona.FUNGHI,Icona.ASSENTE,Icona.ASSENTE,Icona.VUOTO,Icona.PERGAMENA,Icona.ASSENTE,Icona.VUOTO));
		mazzo.add(c13=new CartaPunteggioOro(1,1,Icona.INCHIOSTRO, Icona.VEGETALE,Icona.VEGETALE,Icona.VEGETALE,Icona.ANIAMLE,Icona.ASSENTE,Icona.ASSENTE,Icona.VUOTO,Icona.ASSENTE,Icona.INCHIOSTRO,Icona.VUOTO));
		
		mazzo.add(c14=new CartaPunteggioOro(2,2,Icona.ASSENTE, Icona.VEGETALE,Icona.VEGETALE,Icona.VEGETALE,Icona.VEGETALE,Icona.INSETTI,Icona.ASSENTE,Icona.ASSENTE,Icona.VUOTO,Icona.VUOTO,Icona.VUOTO));
		mazzo.add(c15=new CartaPunteggioOro(2,2,Icona.ASSENTE, Icona.VEGETALE,Icona.VEGETALE,Icona.VEGETALE,Icona.VEGETALE,Icona.ANIMALE,Icona.ASSENTE,Icona.VUOTO,Icona.VUOTO,Icona.VUOTO,Icona.ASSENTE));
		mazzo.add(c16=new CartaPunteggioOro(2,2,Icona.ASSENTE, Icona.VEGETALE,Icona.VEGETALE,Icona.VEGETALE,Icona.VEGETALE,Icona.FUNGHI,Icona.ASSENTE,Icona.VUOTO,Icona.ASSENTE,Icona.VUOTO,Icona.VUOTO));
		
		mazzo.add(c17=new CartaPunteggioOro(3,0,Icona.ASSENTE, Icona.VEGETALE,Icona.VEGETALE,Icona.VEGETALE,Icona.VEGETALE,Icona.ASSENTE,Icona.ASSENTE,Icona.VUOTO,Icona.ASSENTE,Icona.PIUMA,Icona.ASSENTE));
		mazzo.add(c18=new CartaPunteggioOro(3,0,Icona.ASSENTE, Icona.VEGETALE,Icona.VEGETALE,Icona.VEGETALE,Icona.VEGETALE,Icona.ASSENTE,Icona.ASSENTE,Icona.PERGAMENA,Icona.VUOTO,Icona.ASSENTE,Icona.ASSENTE));
		mazzo.add(c19=new CartaPunteggioOro(3,0,Icona.ASSENTE, Icona.VEGETALE,Icona.VEGETALE,Icona.VEGETALE,Icona.VEGETALE,Icona.ASSENTE,Icona.ASSENTE,Icona.ASSENTE,Icona.INCHIOSTRO,Icona.ASSENTE,Icona.VUOTO));
		mazzo.add(c20=new CartaPunteggioOro(5,0,Icona.ASSENTE, Icona.VEGETALE,Icona.VEGETALE,Icona.VEGETALE,Icona.VEGETALE,Icona.VEGETALE,Icona.VEGETALE,Icona.VUOTO,Icona.ASSENTE,Icona.VUOTO,Icona.ASSENTE));

		mazzo.add(c21=new CartaPunteggioOro(1,1,Icona.INCHIOSTRO, Icona.ANIMALE,Icona.ANIMALE,Icona.ANIMALE,Icona.INSETTI,Icona.ASSENTE,Icona.ASSENTE,Icona.INCHIOSTRO,Icona.VUOTO,Icona.VUOTO,Icona.ASSENTE));
		mazzo.add(c22=new CartaPunteggioOro(1,1,Icona.PERGAMENA, Icona.ANIMALE,Icona.ANIMALE,Icona.ANIMALE,Icona.VEGETALE,Icona.ASSENTE,Icona.ASSENTE,Icona.ASSENTE,Icona.VUOTO,Icona.VUOTO,Icona.PERGAMENA));
		mazzo.add(c23=new CartaPunteggioOro(1,1,Icona.PIUMA, Icona.ANIMALE,Icona.ANIMALE,Icona.ANIMALE,Icona.FUNGHI,Icona.ASSENTE,Icona.ASSENTE,Icona.VUOTO,Icona.ASSENTE,Icona.PIUMA,Icona.VUOTO));
		
		mazzo.add(c24=new CartaPunteggioOro(2,2,Icona.ASSENTE, Icona.ANIMALE,Icona.ANIMALE,Icona.ANIMALE,Icona.ANIMALE,Icona.INSETTI,Icona.ASSENTE,Icona.VUOTO,Icona.VUOTO,Icona.ASSENTE,Icona.VUOTO));
		mazzo.add(c25=new CartaPunteggioOro(2,2,Icona.ASSENTE, Icona.ANIMALE,Icona.ANIMALE,Icona.ANIMALE,Icona.ANIMALE,Icona.FUNGHI,Icona.ASSENTE,Icona.VUOTO,Icona.ASSENTE,Icona.VUOTO,Icona.VUOTO));
		mazzo.add(c26=new CartaPunteggioOro(2,2,Icona.ASSENTE, Icona.ANIMALE,Icona.ANIMALE,Icona.ANIMALE,Icona.ANIMALE,Icona.VEGETALE,Icona.ASSENTE,Icona.ASSENTE,Icona.VUOTO,Icona.VUOTO,Icona.VUOTO));
		
		mazzo.add(c27=new CartaPunteggioOro(3,0,Icona.ASSENTE, Icona.ANIMALE,Icona.ANIMALE,Icona.ANIMALE,Icona.ANIMALE,Icona.ASSENTE,Icona.ASSENTE,Icona.VUOTO,Icona.ASSENTE,Icona.PERGAMENA,Icona.ASSENTE));
		mazzo.add(c28=new CartaPunteggioOro(3,0,Icona.ASSENTE, Icona.ANIMALE,Icona.ANIMALE,Icona.ANIMALE,Icona.ANIMALE,Icona.ASSENTE,Icona.ASSENTE,Icona.VUOTO,Icona.INCHIOSTRO,Icona.ASSENTE,Icona.ASSENTE));
		mazzo.add(c29=new CartaPunteggioOro(3,0,Icona.ASSENTE, Icona.ANIMALE,Icona.ANIMALE,Icona.ANIMALE,Icona.ANIMALE,Icona.ASSENTE,Icona.ASSENTE,Icona.ASSENTE,Icona.VUOTO,Icona.ASSENTE,Icona.PIUMA));
		mazzo.add(c30=new CartaPunteggioOro(5,0,Icona.ASSENTE, Icona.ANIMALE,Icona.ANIMALE,Icona.ANIMALE,Icona.ANIMALE,Icona.ANIMALE,Icona.ANIMALE,Icona.ASSENTE,Icona.VUOTO,Icona.ASSENTE,Icona.VUOTO));

		mazzo.add(c31=new CartaPunteggioOro(1,1,Icona.PIUMA, Icona.INSETTI,Icona.INSETTI,Icona.INSETTI,Icona.VEGETALE,Icona.ASSENTE,Icona.ASSENTE,Icona.VUOTO,Icona.PIUMA,Icona.ASSENTE,Icona.VUOTO));
		mazzo.add(c32=new CartaPunteggioOro(1,1,Icona.PERGAMENA, Icona.INSETTI,Icona.INSETTI,Icona.INSETTI,Icona.ANIMALE,Icona.ASSENTE,Icona.ASSENTE,Icona.VUOTO,Icona.ASSENTE,Icona.PERGAMENA,Icona.VUOTO));
		mazzo.add(c33=new CartaPunteggioOro(1,1,Icona.INCHIOSTRO, Icona.INSETTI,Icona.INSETTI,Icona.INSETTI,Icona.FUNGHI,Icona.ASSENTE,Icona.ASSENTE,Icona.ASSENTE,Icona.VUOTO,Icona.VUOTO,Icona.INCHIOSTRO));
		
		mazzo.add(c34=new CartaPunteggioOro(2,2,Icona.ASSENTE, Icona.INSETTI,Icona.INSETTI,Icona.INSETTI,Icona.INSETTI,Icona.ANIMALE,Icona.ASSENTE,Icona.VUOTO,Icona.VUOTO,Icona.ASSENTE,Icona.VUOTO));
		mazzo.add(c35=new CartaPunteggioOro(2,2,Icona.ASSENTE, Icona.INSETTI,Icona.INSETTI,Icona.INSETTI,Icona.INSETTI,Icona.VEGETALE,Icona.ASSENTE,Icona.VUOTO,Icona.VUOTO,Icona.VUOTO,Icona.ASSENTE));
		mazzo.add(c36=new CartaPunteggioOro(2,2,Icona.ASSENTE, Icona.INSETTI,Icona.INSETTI,Icona.INSETTI,Icona.INSETTI,Icona.FUNGHI,Icona.ASSENTE,Icona.VUOTO,Icona.ASSENTE,Icona.VUOTO,Icona.VUOTO));
		
		mazzo.add(c37=new CartaPunteggioOro(3,0,Icona.ASSENTE, Icona.INSETTI,Icona.INSETTI,Icona.INSETTI,Icona.INSETTI,Icona.ASSENTE,Icona.ASSENTE,Icona.INCHIOSTRO,Icona.ASSENTE,Icona.VUOTO,Icona.ASSENTE));
		mazzo.add(c38=new CartaPunteggioOro(3,0,Icona.ASSENTE, Icona.INSETTI,Icona.INSETTI,Icona.INSETTI,Icona.INSETTI,Icona.ASSENTE,Icona.ASSENTE,Icona.VUOTO,Icona.PERGAMENA,Icona.ASSENTE,Icona.ASSENTE));
		mazzo.add(c39=new CartaPunteggioOro(3,0,Icona.ASSENTE, Icona.INSETTI,Icona.INSETTI,Icona.INSETTI,Icona.INSETTI,Icona.ASSENTE,Icona.ASSENTE,Icona.ASSENTE,Icona.ASSENTE,Icona.PIUMA,Icona.VUOTO));
		mazzo.add(c40=new CartaPunteggioOro(5,0,Icona.ASSENTE, Icona.INSETTI,Icona.INSETTI,Icona.INSETTI,Icona.INSETTI,Icona.INSETTI,Icona.INSETTI,Icona.VUOTO,Icona.VUOTO,Icona.ASSENTE,Icona.ASSENTE));

		
		Collections.shuffle(mazzo);
	}
	
	@Override
	public CartaPunteggioOro pescaCarta() {
		Iniziale nuovaCarta= mazzo.get(0);
	    mazzo.remove(0);
	    nuovaCarta.girare();
	    return nuovaCarta;
	}
	
}
