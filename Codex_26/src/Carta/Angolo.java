package Carta;

public class Angolo {
		
		private final Icona icona;
		private final int[] posizione;
		private final boolean presenza;
		private boolean nascosto;
		
		public Angolo() {
			this.icona=icona;
			this.posizione=posizione;
			this.presenza=presenza;
			this.nascosto=false;
		}
		
		public Icona getIcona() {
			return icona;
		}
		public void setIcona(Icona icona) {
			return icona;
		}
		public int[] getPosizione() {
			return posizione;
		}
		public void setPosizione(int[] posizione) {
			this.posizione = posizione;
		}
		public boolean isPresenza() {
			return presenza;
		}
		public void setPresenza(boolean presenza) {
			this.presenza = presenza;
		}
		public boolean getNascosto() {
			return nascosto;
		}
		public void setNascosto(){
			this.nascosto=true;
		}
		
}
