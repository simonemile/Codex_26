package Codex_26;
import java.util.Random;

public class Segnalino {
		
	private int pos;
	private Colore colore;
	private Colore coloreSecondario;
	
	public Segnalino(Colore col, Colore col2, int pos) {
		this.pos=pos;
		this.colore=colore;
		this.coloreSecondario=coloreSecondario;
	}
	
	public Colore randomizzaColore() {
		Colore[] c=Colore.values();
		Random random= new Random();
		int n=random.nextInt(c.length);
		Colore randomColore=c[n];
		return randomColore;
	}
	
	public int getPos() {
		return pos;
	}
	public void setPos(int incremento) {
		this.pos += incremento;
	}
	public void setColore(Colore colore) {
		this.colore = colore;
	}
	public void setColoreSecondario(Colore coloreSecondario) {
		this.coloreSecondario = coloreSecondario;
	}
	public Colore getColoreSegondario() {
		return coloreSecondario;
	}
	
}
