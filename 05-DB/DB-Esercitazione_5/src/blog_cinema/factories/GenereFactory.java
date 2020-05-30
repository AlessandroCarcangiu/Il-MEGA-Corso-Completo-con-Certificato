package blog_cinema.factories;

import java.util.ArrayList;

import blog_cinema.dominio.Genere;

public class GenereFactory {
	
	// singleton
	private static GenereFactory singleton = null;
	
	// lista generi
	ArrayList<Genere> generi = new ArrayList<Genere>();
	
	// costruttore
	private GenereFactory() {
		// Genere 1
		Genere primo_genere = new Genere();
		primo_genere.setId(1);
		primo_genere.setNome("Fantascienza");
		primo_genere.setDescrizione("descrizione Fantascienza");
		primo_genere.setImg("img/generi/fantascienza.png");
		getGeneri().add(primo_genere);
		
		// Genere 2
		Genere secondo_genere = new Genere();
		secondo_genere.setId(2);
		secondo_genere.setNome("Dramma");
		secondo_genere.setDescrizione("descrizione Dramma");
		secondo_genere.setImg("img/generi/dramma.png");
		getGeneri().add(secondo_genere);
	}
	
	// restituisci singleton
	public static GenereFactory get_instance() {
		if(singleton == null) {
			singleton = new GenereFactory();
		}
		return singleton;
	}

	public ArrayList<Genere> getGeneri() {
		return generi;
	}
	
	// filtro per id
	public Genere get_genere(int id) {
		for(Genere genere:getGeneri()) {
			if(genere.getId()==id) {
				return genere;
			}
		}
		return null;
	}
	
	// filtro per genere
	public Genere get_genere(String name) {
		for(Genere genere:getGeneri()) {
			if (genere.getNome().equals(name) ) {
				return genere;
			}
		}
		return null;
	}
	
}
