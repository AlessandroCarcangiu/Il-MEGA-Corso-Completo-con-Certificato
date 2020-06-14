package blog_cinema.factories;

import java.util.ArrayList;

import blog_cinema.dominio.Utente;
import blog_cinema.dominio.Utente.TipoUtente;

public class UtenteFactory {
	
	// singleton
	private static UtenteFactory singleton = null;
	
	// lista utenti
	private ArrayList<Utente> utenti = new ArrayList<Utente>();
	
	// costruttore
	private UtenteFactory() {
		// Primo utente
		Utente primo_utente = new Utente();
		primo_utente.setId(1);
		primo_utente.setNome("admin");
		primo_utente.setCognome("admin");
		primo_utente.setEmail("admin@email.com");
		primo_utente.setUsername("admin");
		primo_utente.setPassword("psw1234");
		primo_utente.setTipo(TipoUtente.ADMIN);
		getUtenti().add(primo_utente);
		
		// Secondo utente
		Utente secondo_utente = new Utente();
		secondo_utente.setId(2);
		secondo_utente.setNome("lettore");
		secondo_utente.setCognome("lettore");
		secondo_utente.setEmail("lettore@email.com");
		secondo_utente.setUsername("lettore");
		secondo_utente.setPassword("psw1234");
		secondo_utente.setTipo(TipoUtente.LETTORE);
		getUtenti().add(secondo_utente);
	}
	
	// restituisci singleton
	public static UtenteFactory get_instance() {
		if(singleton == null) {
			singleton = new UtenteFactory();
		}
		return singleton;
	}

	public ArrayList<Utente> getUtenti() {
		return utenti;
	}
	
	// filtro per id
	public Utente get_utente(int id) {
		for(Utente user:getUtenti()) {
			if(user.getId()==id) {
				return user;
			}
		}
		return null;
	}
	
	// filtro per username e password
	public Utente get_utente(String username, String psw) {
		for(Utente user: getUtenti()) {
			if ( user.getUsername().equals(username) & user.getPassword().equals(psw) ) {
				return user;
			}
		}
		return null;
	}
}
