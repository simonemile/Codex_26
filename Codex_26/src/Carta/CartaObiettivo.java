package Carta;

import java.util.ArrayList;
import java.util.List;
import Codex_26
import prova.Angolo;
import prova.Icona;
import prova.Obiettivo;

class CartaObiettivo extends Carta {
	
	private final int punteggio;
    private boolean girata;
    private Icona[] risorsaNecessaria=new Icona[4];
    private Icona[][] risorsaNecessaria2=new Icona[3][3];
    private Icona[][] risorsaNecessaria3=new Icona[4][2];
    private final int type;
    
    //costruttore per carte obiettivo con risorse minime necessarie sul tavolo per ottenimento punti
    //type 0 indica carte obiettivo con richiesta risorse minime
    public CartaObiettivo(int punteggio, Icona r1, Icona r2, Icona r3) {
    	this.type=0;
    	this.girata=true;
    	this.punteggio=punteggio;
    	this.risorsaNecessaria[0]=r1;
    	this.risorsaNecessaria[1]=r2;
    	this.risorsaNecessaria[2]=r3;
    }
    
    //costruttore per carte obiettivo che richiedono un determinato schema di carte per ottenimento punti
    //tipo indica grandezza matrice necessaria
    //tipo 1 indica costruttore per matrice 3x3, tipo 2 matrice 4x2
    public CartaObiettivo(int punteggio,int type, Icona reg11, Icona reg12, Icona reg13,Icona reg21, Icona reg22, Icona reg23,Icona reg31, Icona reg32, Icona reg33) {
    	this.girata=true;
    	this.type=1;
    	this.punteggio=punteggio;
    	this.risorsaNecessaria2[0][0]=reg11;
    	this.risorsaNecessaria2[0][1]=reg12;
    	this.risorsaNecessaria2[0][2]=reg13;
    	this.risorsaNecessaria2[1][0]=reg21;
    	this.risorsaNecessaria2[1][1]=reg22;
    	this.risorsaNecessaria2[1][2]=reg23;
    	this.risorsaNecessaria2[2][0]=reg31;
    	this.risorsaNecessaria2[2][1]=reg32;
    	this.risorsaNecessaria2[2][2]=reg33;
    }
    
    public CartaObiettivo(Icona reg11,int type, Icona reg12, Icona reg21, Icona reg22, Icona reg31, Icona reg32, Icona reg41, Icona reg42) {
    	this.girata=true;
    	this.type=2;
    	this.punteggio=punteggio;
    	this.risorsaNecessaria3[0][0]=reg11;
    	this.risorsaNecessaria3[0][1]=reg12;
    	this.risorsaNecessaria3[1][0]=reg21;
    	this.risorsaNecessaria3[1][1]=reg22;
    	this.risorsaNecessaria3[2][0]=reg31;
    	this.risorsaNecessaria3[2][1]=reg32;
    	this.risorsaNecessaria3[3][1]=reg41;
    	this.risorsaNecessaria3[3][2]=reg42;
    }
    	
  //metodo per assegnare il punteggio per le carte obiettivo che richiedono un minimo di risorse sul tavolo
    public int assegnaPunteggio1(Tavolo tavolo, CartaObiettivo c) {
        int num = 0;
        int puntiCarta = c.getPunteggio();
        Icona[] risorsaNecessaria=c.getRisorsaNecessaria();;
        ArrayList<Icona> risorseDisponibili = tavolo.getRisorseDisponibili();
        for (int i = 0; i <= risorseDisponibili.size()-risorsaNecessaria.length; i++) {
            boolean trovato = true;
            ArrayList<Icona> risorseUsate= new ArrayList<>(risorseDisponibili); 
            //rimuovo icone disponibili ogni qual volta trovo una corrispondenza in modo da evitare duplicazioni del conteggio delle risorse in caso di ripetizione delle risorse necessarie
            for (Icona icona : risorsaNecessaria) {
                if (!risorseUsate.remove(icona)) { 
                    trovato = false;
                    break;
                }
            }
            if (trovato) {
                num++;
            }
        }
        int punteggio=num * puntiCarta;
        return punteggio;
    }
    
    //metodo per assegnare il punteggio per le carte obiettivo che presentano un pattern
    public int assegnaPunteggio2(Tavolo tavolo, CartaObietttivo c) {
    	int num=0;
    	int puntiCarta=c.getPunteggio();
    	Icona[][] risorsaNecessaria2=new Icona[][];
    	risorsaNecessaria2=c.getRisorsaNecessaria2(c);
    	Carta[][] carteTavolo=tavolo.getTabellone();
    	Icona[][] regniTavolo=new Icona[carteTavolo.length][carteTavolo[0].length];
    	int tavoloRighe=carteTavolo.length;
    	int tavoloColonne=carteTavolo[0].length;
    	int patternRighe=risorsaNecessaria2.length;
    	int patternColonne=risorsaNecessaria2[0].length;
    	//converte la matrice di carte in matrice di regni(tipo icona)
    	for(int i=0;i<tavoloRighe; i++) {
    		for (int j = 0; j < tavoloColonne; j++) {
    			if (carteTavolo[i][j] != null) {
    				regniTavolo[i][j] = carteTavolo[i][j].getRegno();
    			}else {
    				regniTavolo[i][j] = null;
                }
            }
    	}
    	//confronta matrice di carta obiettivo con matrice del tavolo. per ogni ripetizione del pattern incrementa num per poterlo moltiplicare alla fine con il punteggio della carta
    	//cicli per evitare di andare oltre limite della matrice
    	for (int i=0; i <= tavoloRighe-patternRighe; i++) {
            for (int j=0; j <= tavoloColonne-patternColonne; j++) {
                boolean trovato= true;
                //ciclo per confrontare le icone del pattern e del tavolo
                for (int k=0; k <patternRighe; k++) {
                    for (int l=0; l < patternColonne; l++) {
                        if (risorsaNecessaria2[k][l] != null) {
                            if (risorsaNecessaria2[k][l] != Icona.ASSENTE && regniTavolo[i+k][j+l] != null) {
                                if (!risorsaNecessaria2[k][l].equals(regniTavolo[i+k][j+l])) {
                                	trovato = false;
                                    break;
                                }
                            } else if (risorsaNecessaria2[k][l] == Icona.ASSENTE && regniTavolo[i+k][j+l]!= null) {
                            	trovato=false;
                                break;
                            }
                        } else if (regniTavolo[i+k][j+l] != null) {
                        	trovato=false;
                            break;
                        }
                    }
                    if(!trovato) {
                    	break;
                    }
                }
                if(trovato) {
                    num++;
                }
            }
        }
    	int punteggio=num * puntiCarta;
        return punteggio;
    }
    
    
    public int getPunteggio() {
		return  punteggio;
	}
    public Icona[] getRisorsaNecessaria() {
		return risorsaNecessaria;
	}
    //restituisce matrici di dimensioni diverse al seconda del type della carta obiettivo
    public Icona[][] getRisorsaNecessaria2(CartaObiettivo c) {
    	int type=c.getType();
    	if(type==1) {
    		return risorsaNecessaria2;
    	}else{
    		return risorsaNecessaria3;
    	}
	}
    public int getType() {
		return type;
	}
    
    @Override
	public Angolo[] getAngolo() {
		return null;
	}
    
    @Override
	public Icona getRegno() {
		return Icona.ASSENTE;
	}
    
}
