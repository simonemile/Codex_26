package Carta;

public class Angolo {
		
	private Icona icona;
	private boolean nascosto;
	
	public Angolo(Icona icona) {
		this.icona=icona;
		this.nascosto=false;
	}
	
	public void setIcona(Icona icona) {
		this.icona=icona;
	}
	public Icona getIcona() {
		return icona;
	}	
	
	public boolean getNascosto() {
		return nascosto;
	}
	public void setNascosto(){
		this.nascosto=true;
	}
		
}
