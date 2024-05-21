package Codex_26;

public class Segnalino {
		
	private int pos;
	private Colore colore;
	private Colore coloreSecondario;
	
	public int getPos() {
		return pos;
	}
	public void setPos(int incremento) {
		this.pos += incremento;
	}
	public Colore getColore() {
		return colore;
	}
	public void setColore(Colore nero) {
		this.colore = nero;
	}
	public Colore getsecondarioColore() {
		return coloreSecondario;
	}
	public void setColoresecondario(Colore coloreSecondario) {
		this.coloreSecondario = coloreSecondario;
	}
}
