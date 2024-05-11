package Carta;

import java.util.Collections;
import java.util.ArrayList;

public class MazzoObiettivo extends Mazzo{
	private ArrayList<CartaObiettivo> mazzo;
	private CartaObiettivo c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16;
	
	/*VEGETALE, ANIMALE, FUNGHI, INSETTI, PIUMA, INCHIOSTRO, PERGAMENA, VUOTO, ASSENTE;
	**int punteggio,type, Icona r1, Icona r2, Icona r3
	**int punteggio,type, Icona reg11, Icona reg12, Icona reg13,Icona reg21, Icona reg22, Icona reg23,Icona reg31, Icona reg32, Icona reg33
	**p, type,Icona reg11, Icona reg12, Icona reg21, Icona reg22, Icona reg31, Icona reg32
	**/
	@Override
	public void aggiungiCarta() {
		
		mazzo=new ArrayList<CartaObiettivo>(16);
		
		mazzo.add(c1=new CartaObiettivo(2,Icona.PIUMA,Icona.PIUMA,Icona.ASSENTE));
		mazzo.add(c2=new CartaObiettivo(2,Icona.INCHIOSTRO,Icona.INCHIOSTRO,Icona.ASSENTE));
		mazzo.add(c3=new CartaObiettivo(2,Icona.PERGAMENA,Icona.PERGAMENA,Icona.ASSENTE));
		mazzo.add(c4=new CartaObiettivo(3,Icona.PIUMA,Icona.INCHIOSTRO,Icona.PERGAMENA));
		mazzo.add(c5=new CartaObiettivo(2,Icona.INSETTI,Icona.INSETTI,Icona.INSETTI));
		mazzo.add(c6=new CartaObiettivo(2,Icona.ANIMALE,Icona.ANIMALE,Icona.ANIMALE));
		mazzo.add(c7=new CartaObiettivo(2,Icona.VEGETALE,Icona.VEGETALE,Icona.VEGETALE));
		mazzo.add(c8=new CartaObiettivo(2,Icona.FUNGHI,Icona.FUNGHI,Icona.FUNGHI));
		
		mazzo.add(c9=new CartaObiettivo(2,1,Icona.ASSENTE,Icona.ASSENTE,Icona.FUNGHI,Icona.ASSENTE,Icona.FUNGHI,Icona.ASSENTE,Icona.FUNGHI,Icona.ASSENTE,Icona.ASSENTE));
		mazzo.add(c10=new CartaObiettivo(2,1,Icona.ASSENTE,Icona.ASSENTE,Icona.VEGETALE,Icona.ASSENTE,Icona.VEGETALE,Icona.ASSENTE,Icona.VEGETALE,Icona.ASSENTE,Icona.ASSENTE));
		mazzo.add(c11=new CartaObiettivo(2,1,Icona.ASSENTE,Icona.ASSENTE,Icona.ANIMALE,Icona.ASSENTE,Icona.ANIMALE,Icona.ASSENTE,Icona.ANIMALE,Icona.ASSENTE,Icona.ASSENTE));
		mazzo.add(c12=new CartaObiettivo(2,1,Icona.ASSENTE,Icona.ASSENTE,Icona.INSETTI,Icona.ASSENTE,Icona.INSETTI,Icona.ASSENTE,Icona.INSETTI,Icona.ASSENTE,Icona.ASSENTE));
		
		mazzo.add(c13=new CartaObiettivo(3,2,Icona.FUNGHI,Icona.ASSENTE,Icona.FUNGHI,Icona.ASSENTE,Icona.ASSENTE,Icona.VEGETALE));
		mazzo.add(c14=new CartaObiettivo(3,2,Icona.ASSENTE,Icona.VEGETALE,Icona.ASSENTE,Icona.VEGETALE,Icona.INSETTI,Icona.ASSENTE));
		mazzo.add(c15=new CartaObiettivo(3,2,Icona.ASSENTE,Icona.FUNGHI,Icona.ANIMALE,Icona.ASSENTE,Icona.ANIMALE,Icona.ASSENTE));
		mazzo.add(c16=new CartaObiettivo(3,2,Icona.ANIMALE,Icona.ASSENTE,Icona.ASSENTE,Icona.INSETTI,Icona.ASSENTE,Icona.INSETTI));
		
		Collections.shuffle(mazzo);
	}
	
	
	@Override
	public CartaObiettivo pescaCarta() {
		CartaObiettivo nuovaCarta= mazzo.get(0);
	    mazzo.remove(0);
	    nuovaCarta.girare();
	    return nuovaCarta;
	}
	

}
