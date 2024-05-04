package Carta;


public class Risorsa extends Carta {
	
	private final Angolo[] angoliFronte=new Angolo[4];
	private final Angolo[] angoliRetro=new Angolo[5];
	private String regno;
	
	public Risorsa(String regno, Icona a1, Icona a2, Icona a3, Icona a4, Icona aC, Icona aR1,Icona aR2,Icona aR3,Icona aR4) {
		this.regno=regno;
		if(isGirata()==true) {
			this.angoliRetro[0]=new Angolo(aR1);
			this.angoliRetro[1]=new Angolo(aR2);
			this.angoliRetro[2]=new Angolo(aR3);
			this.angoliRetro[3]=new Angolo(aR4);
			this.angoliRetro[4]=new Angolo(aC);
		}else {
			this.angoliFronte[0]=new Angolo(a1);
			this.angoliFronte[1]=new Angolo(a2);
			this.angoliFronte[2]=new Angolo(a3);
			this.angoliFronte[3]=new Angolo(a4);
		}
		
	}

	@Override
	public int getValorePV() {
		return 0;
	}
	@Override
	public boolean riceviPunti() {
		return false;
	}

}
