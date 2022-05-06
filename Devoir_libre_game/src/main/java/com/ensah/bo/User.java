package com.ensah.bo;

public class User {
		private String nom ; 
		
		private String prenom ;
		
		private String login ; 
		
		private String password ;
		
		private int bestScore ;
		
		
		
		public User() {
			
		}
		

		public User(String nom, String prenom, String login, String password, int bestScore) {

			this.nom = nom;
			this.prenom = prenom;
			this.login = login;
			this.password = password;
			this.bestScore = bestScore;
		}



		public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}

		public String getPrenom() {
			return prenom;
		}

		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}

		public String getLogin() {
			return login;
		}

		public void setLogin(String login) {
			this.login = login;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public int getBestScore() {
			return bestScore;
		}

		public void setBestScore(int bestScore) {
			this.bestScore = bestScore;
		}
		




		@Override
		public String toString() {
			return "User [nom=" + nom + ", prenom=" + prenom + ", login=" + login + ", password=" + password
					+ ", bestScore=" + bestScore + "]";
		}
		
		
		
}