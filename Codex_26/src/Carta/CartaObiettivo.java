package Carta;

import java.util.ArrayList;
import java.util.List;
import Codex_26
import prova.Angolo;
import prova.Icona;
import prova.Obiettivo;

class CartaObiettivo extends Carta {
	
	private int punteggio;
    private boolean girata;
    private Icona[] risorsaNecessaria=new Icona[4];
    private Icona[][] risorsaNecessaria2=new Icona[3][3];
    private Icona[][] risorsaNecessaria3=new Icona[3][2];
    private int type;
    
    //costruttore per carte obiettivo con risorse minime necessarie sul tavolo per ottenimento punti
    public CartaObiettivo(int punteggio, Icona r1, Icona r2, Icona r3) {
    	this.girata=true;
    	this.punteggio=punteggio;
    	this.risorsaNecessaria[0]=r1;
    	this.risorsaNecessaria[1]=r2;
    	this.risorsaNecessaria[2]=r3;
    }
    
    //costruttore per carte obiettivo che richiedono un determinato schema di carte per ottenimento punti
    //tipo indica grandezza matrice necessaria
    //tipo 1 indica costruttore per matrice 3x3, tipo 2 matrice 3x2
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
    
    public CartaObiettivo(Icona reg11,int type, Icona reg12, Icona reg21, Icona reg22, Icona reg31, Icona reg32) {
    	this.girata=true;
    	this.type=2;
    	this.punteggio=punteggio;
    	this.risorsaNecessaria3[0][0]=reg11;
    	this.risorsaNecessaria3[0][1]=reg12;
    	this.risorsaNecessaria3[1][0]=reg21;
    	this.risorsaNecessaria3[1][1]=reg22;
    	this.risorsaNecessaria3[2][0]=reg31;
    	this.risorsaNecessaria3[2][1]=reg32;
    }
    	
    
    public int assegnaPunteggio1(Tavolo tavolo, CartaObiettivo c) {
        int num = 0;
        int puntiCarta = c.getPunteggio();
        Icona[] risorsaNecessaria=c.getRisorsaNecessaria();;
        ArrayList<Icona> regniDisponibili = tavolo.getRegniDisponibili();
        for (int i = 0; i <= regniDisponibili.size()-risorsaNecessaria.length; i++) {
            boolean trovato = true;
            ArrayList<Icona> regniUsati = new ArrayList<>(regniDisponibili); 
            for (Icona icona : risorsaNecessaria) {
                if (!regniUsati.remove(icona)) { 
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
    	for(int i=0;i<tavoloRighe; i++) {
    		for(int j=0; j<carteTavolo[i].length; j++) {
				regniTavolo[i][j]=carteTavolo[i][j].getRegno();
    		}
    	}
    	for(int i=0; i<=tavoloRighe-patternRighe; i++) {
    		for (int j = 0; j<= tavoloColonne -patternColonne; j++) {
    	            boolean ripete = true;
    	            for (int k = 0; k<patternRighe; k++) {
    	                for (int l = 0; l<patternColonne; l++) {
    	                    if (risorsaNecessaria2[k][l]!=Icona.ASSENTE && !risorsaNecessaria2[k][l].equals(regniTavolo[i+k][j+l])) {
    	                        ripete = false;
    	                        break;
    	                    } 
    	                }if (!ripete) {
    	                	break;
    	                }
    	            }if (ripete){
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
    public Icona[][] getRisorsaNecessaria2(Obiettivo c) {
    	int type=c.getType();
    	if(type==1) {
    		return risorsaNecessaria2;
    	}else {
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
