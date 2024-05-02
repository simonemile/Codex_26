package Codex_26;
import Carta.CartaObiettivo;

public class Giocatore {
		
		final private int id;
		final private String nome;
		private Segnalino segnalino;
		private Tavolo tavolo;
		private CartaObiettivo obiettivoPersonale;
		private int posizioneGiocatore;
		
		
		public Giocatore(String nome, int posizioneGiocatore) {
			this.nome = nome;
			this.posizioneGiocatore=posizioneGiocatore;
		}
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
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
		void impostaColoreSegnalino() {
			return segnalino.getColore();
		}
		
		
		
}
