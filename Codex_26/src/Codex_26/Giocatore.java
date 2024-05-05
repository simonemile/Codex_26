package Codex_26;

import Carta.*;
import java.util.ArrayList;

public class Giocatore {
		
		final private String nome;
		private Segnalino segnalino;
		private Tavolo tavolo;
		private CartaObiettivo obiettivoPersonale;
		private int posizioneGiocatore;
		private ArrayList<Carta> carteInMano;
		
		public Giocatore(String nome, int posizioneGiocatore, Tavolo tavolo, Segnalino segnalino, CartaPunteggioOro obiettivoPersonale) {
			this.nome = nome;
			this.posizioneGiocatore=posizioneGiocatore;
			this.tavolo=tavolo;
			this.segnalino=segnalino;
			this.obiettivoPersonale=obiettivoPersonale;
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
		public void impostaColoreSegnalino() {
			return segnalino.getColore();
		}
		
		
		
}
