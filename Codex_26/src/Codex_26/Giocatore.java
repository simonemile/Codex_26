package Codex_26;

public class Giocatore {
		
		private int id;
		private String nome;
		private int punti;
		Tavolo tavolo;
		
		
		public Giocatore() {
			this.punti = 0;
			this.nome = "";
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
		public int getPunti() {
			return punti;
		}
		public void setPunti(int punti) {
			this.punti = punti;
		}
		
		
		
}
