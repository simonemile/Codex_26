package Codex_26;

public class Segnalino {
		
		private int pos;
		final private String colore;
		final private String coloreSecondario;
		
		public int getPos() {
			return pos;
		}
		public void setPos(int incremento) {
			this.pos += incremento;
		}
		public String getColore() {
			return colore;
		}
		public void setColore(String colore) {
			this.colore = colore;
		}
		public String getsecondarioColore() {
			return coloreSecondario;
		}
		public void setColore(String coloreSecondario) {
			this.coloreSecondario = coloreSecondario;
		}
}
