package blog_cinema.db;

import java.sql.ResultSet;
import java.util.ArrayList;

import blog_cinema.dominio.Film;
import blog_cinema.dominio.Genere;
import blog_cinema.dominio.Recensione;
import blog_cinema.dominio.Utente;

public class RecensioneQuery extends ConnectDB {
	
	// prendi tutte le recensioni presenti sul db
	public static ArrayList<Recensione> get_recensioni(){
		// inizializza lista recensioni
		ArrayList<Recensione> recensioni = new ArrayList<Recensione>();
		
		try {
			// crea query
			String query = "select * from recensione";
			
			// crea connessione
			Container container = crea_connessione();
			
			// esegui query
			ResultSet res = container.getSt().executeQuery(query);
			
			// cicla sul risultato della query
			while(res.next()) {
				recensioni.add(get_data_from_res(res));
			}
			
			// chiudiamo la connessione
			chiudi_connessione(container);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return recensioni;
	}
	
	// filter per id
	public static Recensione get_recensione(int id){
		// inizializza recensione
		Recensione recensione = null;
		
		try {
			// crea query
			String query = String.join("", "select * from recensione where id=",Integer.toString(id));
			
			// crea connessione
			Container container = crea_connessione();
			
			// esegui query
			ResultSet res = container.getSt().executeQuery(query);
			
			// estrapoliamo recensione dal risultato della query
			if(res.next()) {
				recensione = get_data_from_res(res);
			}
			
			// chiudiamo la connessione
			chiudi_connessione(container);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return recensione;
	}	
	
	// filtra per film
	public static ArrayList<Recensione> get_recensioni(Film film){
		// inizializza lista recensioni
		ArrayList<Recensione> recensioni = new ArrayList<Recensione>();
		
		try {
			// crea query
			String query = String.join("", "select * from recensione where film=",Integer.toString(film.getId()));
			
			// crea connessione
			Container container = crea_connessione();
			
			// esegui query
			ResultSet res = container.getSt().executeQuery(query);
			
			// cicla sul risultato della query
			while(res.next()) {
				recensioni.add(get_data_from_res(res));
			}
			
			// chiudiamo la connessione
			chiudi_connessione(container);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return recensioni;
	}

	// filtra per genere
	public static ArrayList<Recensione> get_recensioni(Genere genere){
		// inizializza lista recensioni
		ArrayList<Recensione> recensioni = new ArrayList<Recensione>();
		
		try {
			// crea query
			String query = String.join("", "select * from recensione left join film ",
					"on recensione.film=film.id where genere=", Integer.toString(genere.getId()));
			
			// crea connessione
			Container container = crea_connessione();
			
			// esegui query
			ResultSet res = container.getSt().executeQuery(query);
			
			// cicla sul risultato della query
			while(res.next()) {
				recensioni.add(get_data_from_res(res));
			}
			
			// chiudiamo la connessione
			chiudi_connessione(container);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return recensioni;
	}

	// filtra per autore
	public static ArrayList<Recensione> get_recensioni(Utente autore){
		// inizializza lista recensioni
		ArrayList<Recensione> recensioni = new ArrayList<Recensione>();
		
		try {
			// crea query
			String query = String.join("", "select * from recensione where autore=", Integer.toString(autore.getId()));
			
			// crea connessione
			Container container = crea_connessione();
			
			// esegui query
			ResultSet res = container.getSt().executeQuery(query);
			
			// cicla sul risultato della query
			while(res.next()) {
				recensioni.add(get_data_from_res(res));
			}
			
			// chiudiamo la connessione
			chiudi_connessione(container);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return recensioni;
	}
	
	// inserisci recensione
	public static boolean inserisci_recensione(Recensione recensione) {
		try {
			// crea query
			String query = String.join("", "insert into recensione(contenuto_recensione,voto,film,autore) VALUES ('",
					recensione.getContenuto_recensione(),"', ",
					Integer.toString(recensione.getVoto()), ",",
					Integer.toString(recensione.getFilm().getId()), ",",
					Integer.toString(recensione.getAutore().getId()), ")"
			);
			
			// crea connessione
			Container container = crea_connessione();
			
			// esegui query
			container.getSt().executeUpdate(query);
			
			// chiudi connessione
			chiudi_connessione(container);
			
			return true;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return false;
	}
	
	// rimuovi recensione
	public static boolean rimuovi_recensione(Recensione recensione) {
		try {
			// crea query
			String query = String.join("", "delete from recensione where id=", Integer.toString(recensione.getId()) );
			
			// crea connessione
			Container container = crea_connessione();
			
			// esegui query
			container.getSt().executeUpdate(query);
			
			// chiudi connessione
			chiudi_connessione(container);
			
			return true;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return false;
	}
	
	public static Recensione get_data_from_res(ResultSet res) throws Exception {
		// crea una nuova recensione usando i dati provenienti dal db
		Recensione recensione = new Recensione();
		recensione.setId(res.getInt("id"));
		recensione.setContenuto_recensione(res.getString("contenuto_recensione"));
		recensione.setVoto(res.getInt("voto"));
		// prendi film
		Film film = FilmQuery.get_film(res.getInt("film"));
		recensione.setFilm(film);
		// prendi autore
		Utente autore = UtenteQuery.get_utente(res.getInt("autore"));
		recensione.setAutore(autore);
		
		return recensione;
	}

}
