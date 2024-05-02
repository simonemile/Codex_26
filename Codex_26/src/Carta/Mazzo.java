package Carta;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Mazzo {

	 List<Carta> carte; // Lista delle carte presenti nel mazzo
	    
	    public Mazzo() {
	        this.carte = new ArrayList<>();
	    }
	    
	    public void aggiungiCarta(Carta carta) {
	        this.carte.add(carta);
	    }
	    
	    public Carta pescaCarta() {
	        // Implementazione della pesca casuale di una carta dal mazzo
	        Random rand = new Random();
	        int index = rand.nextInt(this.carte.size());
	        return this.carte.remove(index);
	    }
}
