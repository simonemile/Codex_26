package Codex_26;

import Carta.*;

import java.util.ArrayList;

public class Giocatore {
	private String nome;
	private Segnalino segnalino;
	private Tavolo tavolo;
	private CartaObiettivo obiettivoPersonale;
	private int posizioneGiocatore;
	private ArrayList<Carta> carteInMano;
	
	public Giocatore(String nome, int posizioneGiocatore, Tavolo tavolo, Segnalino segnalino, CartaObiettivo obiettivoPersonale,ArrayList<Carta> carteInMano) {
		this.nome = nome;
		this.posizioneGiocatore=posizioneGiocatore;
		this.tavolo=tavolo;
		this.segnalino=segnalino;
		this.obiettivoPersonale=obiettivoPersonale;
		this.carteInMano=carteInMano;
	}
	
	public ArrayList<Carta> getCarteInMano() {
	    return carteInMano;
	}
	public CartaObiettivo getObiettivoPersonale() {
		return obiettivoPersonale;
	}
	public Segnalino getSegnalino() {
		return segnalino;
	}
	public Tavolo getTavolo() {
		return tavolo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getposizioneGiocatore() {
		return posizioneGiocatore;
	}
	public void posizioneGiocatore(int posizioneGiocatore) {
		this.posizioneGiocatore = posizioneGiocatore;
	}
	
	
}
