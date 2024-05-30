package Codex_26;
import java.util.ArrayList;
import java.util.Random;

public class Segnalino {
	
	private int pos;
	private Colore colore;
	private Colore coloreSecondario;
	private Random random=new Random();
	public Segnalino(Colore colore, Colore coloreSecondario, int pos) {
		this.pos=pos;
		this.colore=colore;
		this.coloreSecondario=coloreSecondario;
	}
	
	public Colore randomizzaColore(ArrayList<Colore> coloriDisp) {
        if (coloriDisp.isEmpty()) {
            System.out.println("colori disponibili finiti");
        }
        coloriDisp.remove(Colore.NERO);
        if (!coloriDisp.isEmpty()) {
            int n = random.nextInt(coloriDisp.size());
            Colore randomColore = coloriDisp.remove(n);
            return randomColore;
        } else {
            throw new IllegalStateException("Non ci sono colori disponibili.");
        }
	}
	public int getPos() {
		return pos;
	}
	public void setPos(int incremento) {
		this.pos += incremento;
	}
	public Colore getColore() {
		return colore;
	}
	public void setColore(Colore colore) {
		this.colore = colore;
	}
	public Colore getColoreSecondario() {
		return coloreSecondario;
	}
	public void setColoreSecondario(Colore coloreSecondario) {
		this.coloreSecondario = coloreSecondario;
	}
	
}
