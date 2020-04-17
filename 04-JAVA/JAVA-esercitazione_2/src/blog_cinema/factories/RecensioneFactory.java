package blog_cinema.factories;

import java.util.ArrayList;

import blog_cinema.dominio.*;

public class RecensioneFactory {

	// singleton
	private static RecensioneFactory instance = null;
	// attributi vari
	private ArrayList<Recensione> recensioni = new ArrayList<Recensione>();
	
	// costruttore
	private RecensioneFactory() throws Exception {
		// Recensione 1
		Recensione prima_recensione = new Recensione();
		prima_recensione.setId(1);
		prima_recensione.setContenuto_recensione("Recensione Star Wars Episodio IV");
		prima_recensione.setVoto(9);
		prima_recensione.setFilm(FilmFactory.get_instance().get_film(1));
		prima_recensione.setAutore(UtenteFactory.get_instance().get_utente(1));
		getRecensioni().add(prima_recensione);
		
		// Recensione 2
		Recensione seconda_recensione = new Recensione();
		seconda_recensione.setId(2);
		seconda_recensione.setContenuto_recensione("Recensione Schindler's List");
		seconda_recensione.setVoto(10);
		seconda_recensione.setFilm(FilmFactory.get_instance().get_film(2));
		seconda_recensione.setAutore(UtenteFactory.get_instance().get_utente(1));
		getRecensioni().add(seconda_recensione);
	}
	
	public static RecensioneFactory get_instance() throws Exception {
		if (instance == null) {
			instance = new RecensioneFactory();
		}
		return instance;
	}
	
	public ArrayList<Recensione> getRecensioni() {
		return recensioni;
	}
	
	// filtro per id
	public Recensione get_recensione(int id) {
		for(Recensione recensione: getRecensioni()) {
			if (recensione.getId() == id) {
				return recensione;
			}
		}
		return null;
	}
	
	// filtro per film
	public ArrayList<Recensione> get_recensione(Film film) {
		ArrayList<Recensione> list_recensioni = new ArrayList<Recensione>();
		for(Recensione recensione: getRecensioni()) {
			if ( recensione.getFilm().equals(film) ) {
				list_recensioni.add(recensione);
			}
		}
		return list_recensioni;
	}
	
	// filtro per genere
	public ArrayList<Recensione> get_recensione(Genere genere) {
		ArrayList<Recensione> list_recensioni = new ArrayList<Recensione>();
		for(Recensione recensione: getRecensioni()) {
			if ( recensione.getFilm().getGenere().equals(genere) ) {
				list_recensioni.add(recensione);
			}
		}
		return list_recensioni;
	}
	
	// filtro per utente
	public ArrayList<Recensione> get_recensione(Utente utente) {
		ArrayList<Recensione> list_recensioni = new ArrayList<Recensione>();
		for(Recensione recensione: getRecensioni()) {
			if ( recensione.getAutore().equals(utente) ) {
				list_recensioni.add(recensione);
			}
		}
		return list_recensioni;
	}
	
}
