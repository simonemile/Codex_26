package Carta;

public class Iniziale extends Carta {
	
	private final Angolo[] angoliFronte=new Angolo[7];
	private final Angolo[] angoliRetro=new Angolo[4];
	private Icona regno;
	
	//costruttore delle carte iniziali in cui vengono chiamati i simboli presenti sul fronte e sul retro della carta
	//la carta avrà icone diversi agli angoli a seconda se questa sia girata o meno
	public Iniziale(Icona a1, Icona a2, Icona a3, Icona a4, Icona aC1, Icona aC2,Icona aC3, Icona aR1,Icona aR2,Icona aR3,Icona aR4) {
		if(isGirata()) {
			this.angoliRetro[0]=new Angolo(aR1);
			this.angoliRetro[1]=new Angolo(aR2);
			this.angoliRetro[2]=new Angolo(aR3);
			this.angoliRetro[3]=new Angolo(aR4);
		}else {
			this.angoliFronte[0]=new Angolo(a1);
			this.angoliFronte[1]=new Angolo(a2);
			this.angoliFronte[2]=new Angolo(a3);
			this.angoliFronte[3]=new Angolo(a4);
			this.angoliRetro[4]=new Angolo(aC1);
			this.angoliRetro[5]=new Angolo(aC2);
			this.angoliRetro[6]=new Angolo(aC3);
		}
	}
	
	public Angolo[] getAngolo() {
		if(isGirata()) {
			return angoliRetro;
		}else {
			return angoliFronte;
		}
	}
	
	@Override
	public Angolo[] getAngolo() {
		if(isGirata()) {
			return angoliRetro;
		}else {
			return angoliFronte;
		}
	}
	@Override
	public Icona getRegno() {
		return Icona.VUOTO;
	}
	
}
