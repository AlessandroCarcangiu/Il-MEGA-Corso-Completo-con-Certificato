package blog_cinema.dominio;

import blog_cinema.dominio.Utente.TipoUtente;

public class Recensione {
	
	// attributi
	private int id;
	private String contenuto_recensione;
	private int voto;
	private Film film;
	private Utente autore;
	
	// costruttore
	public Recensione() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContenuto_recensione() {
		return contenuto_recensione;
	}

	public void setContenuto_recensione(String contenuto_recensione) {
		this.contenuto_recensione = contenuto_recensione;
	}

	public int getVoto() {
		return voto;
	}

	public void setVoto(int voto) {
		this.voto = voto;
	}

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public Utente getAutore() {
		return autore;
	}

	public void setAutore(Utente autore) throws Exception {
		if (!autore.getTipo().equals(TipoUtente.ADMIN)) {
			throw new Exception("Solo gli admin possono inserire una recensione");
		}
		this.autore = autore;
	}
	
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj instanceof Recensione) {
			Recensione temp = (Recensione)obj;
			if(this.getId() == temp.getId()) {
				return true;
			}
		}
		return false;
	}
}
