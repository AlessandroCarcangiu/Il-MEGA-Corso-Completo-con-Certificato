package blog_cinema.factories;

import java.util.ArrayList;

import blog_cinema.dominio.Film;
import blog_cinema.dominio.Genere;

public class FilmFactory {
	
	// singleton
	private static FilmFactory singleton = null;
	
	// lista film
	ArrayList<Film> lista_film = new ArrayList<Film>(); 
	
	// costruttore
	private FilmFactory() {
		// Film 1
		Film primo_film = new Film();
		primo_film.setId(1);
		primo_film.setNome("Star Wars Episodio IV");
		primo_film.setTrama("trama Star Wars Episodio IV");
		primo_film.setImg("img/film/star_wars_iv.png");
		primo_film.setGenere(GenereFactory.get_instance().get_genere(1));
		getLista_film().add(primo_film);
		
		// Film 2
		Film secondo_film = new Film();
		secondo_film.setId(2);
		secondo_film.setNome("Schindler's List");
		secondo_film.setTrama("trama Schindler's List");
		secondo_film.setImg("img/film/schindler_list.png");
		secondo_film.setGenere(GenereFactory.get_instance().get_genere(2));
		getLista_film().add(secondo_film);
	}
	
	// restituisci singleton
	public static FilmFactory get_instance() {
		if(singleton==null) {
			singleton=new FilmFactory();
		}
		return singleton;
	}

	public ArrayList<Film> getLista_film() {
		return lista_film;
	}
	
	// filtro per id
	public Film get_film(int id) {
		for(Film film:getLista_film()) {
			if(film.getId()==id) {
				return film;
			}
		}
		return null;
	}
	
	// filtro per nome
	public Film get_film(String name) {
		for(Film film:getLista_film()) {
			if (film.getNome().equals(name)) {
				return film;
			}
		}
		return null;
	}
	
	// filtro per genere
	public ArrayList<Film> get_film(Genere genere) {
		ArrayList<Film> list_films = new ArrayList<Film>();
		for(Film film:getLista_film()) {
			if (film.getGenere().equals(genere) ) {
				list_films.add(film);
			}
		}
		return list_films;
	}
}
