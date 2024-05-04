package Codex_26;
import Carta.CartaObiettivo;

public class Giocatore {
		
		final private String nome;
		private Segnalino segnalino;
		private Tavolo tavolo;
		private CartaObiettivo obiettivoPersonale;
		private int posizioneGiocatore;
		private ArrayList<Carta> carteInMano;
		
		public Giocatore(String nome, int posizioneGiocatore, Tavolo tavolo, Segnalino segnalino) {
			this.nome = nome;
			this.posizioneGiocatore=posizioneGiocatore;
			this.tavolo=tavolo;
			this.segnalino=segnalino;
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
