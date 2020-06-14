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
			Container container = crea_connessione(query);
			
			// esegui query
			ResultSet res = container.getStmt().executeQuery();
			
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
			String query = "select * from recensione where id=?";
			
			// crea connessione
			Container container = crea_connessione(query);
			
			// esegui query
			container.getStmt().setInt(1, id);
			ResultSet res = container.getStmt().executeQuery();
			
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
			String query = "select * from recensione where film=?";
			
			// crea connessione
			Container container = crea_connessione(query);
			
			// esegui query
			container.getStmt().setInt(1, film.getId());
			ResultSet res = container.getStmt().executeQuery();
			
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
			String query = "select * from recensione left join film on recensione.film=film.id where genere=?";
			
			// crea connessione
			Container container = crea_connessione(query);
			
			// esegui query
			container.getStmt().setInt(1, genere.getId());
			ResultSet res = container.getStmt().executeQuery();
			
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
			String query = "select * from recensione where autore=?";
			
			// crea connessione
			Container container = crea_connessione(query);
			
			// esegui query
			container.getStmt().setInt(1, autore.getId());
			ResultSet res = container.getStmt().executeQuery();
			
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
			String query = "insert into recensione(contenuto_recensione,voto,film,autore) VALUES (?,?,?,?)";

			// crea connessione
			Container container = crea_connessione(query);
			
			// esegui query
			container.getStmt().setString(1, recensione.getContenuto_recensione());
			container.getStmt().setInt(2, recensione.getVoto());
			container.getStmt().setInt(3, recensione.getFilm().getId());
			container.getStmt().setInt(4, recensione.getAutore().getId());
			container.getStmt().executeUpdate();
			
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
			String query = "delete from recensione where id=?";
			
			// crea connessione
			Container container = crea_connessione(query);
			
			// esegui query
			container.getStmt().setInt(1, recensione.getId());
			container.getStmt().executeUpdate();
			
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
	
	// prendi la recensione successiva
	public static Recensione recensione_successiva(int id) {
		// inizializza recensione
		Recensione recensione = null;
		
		try {
			// crea query
			String query = "select * from recensione where id>? order by id ASC limit 1";
			
			// crea connessione
			Container container = crea_connessione(query);
			
			// esegui query
			container.getStmt().setInt(1, id);
			ResultSet res = container.getStmt().executeQuery();

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
	
	// prendi la recensione precedente
	public static Recensione recensione_precedente(int id) {
		// inizializza recensione
		Recensione recensione = null;
		
		try {
			// crea query
			String query = "select * from recensione where id<? order by id DESC limit 1";
			
			// crea connessione
			Container container = crea_connessione(query);
			
			// esegui query
			container.getStmt().setInt(1, id);
			ResultSet res = container.getStmt().executeQuery();
			
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
	
	// filtra le recensioni in base al nome del film che recensiscono
	public static ArrayList<Recensione> get_recensioni(String input_utente){
		// inizializza lista recensioni
		ArrayList<Recensione> recensioni = new ArrayList<Recensione>();
		
		try {
			// crea query
			String query = "select * from recensione left join film on recensione.film=film.id where nome like ?";
			
			// crea connessione
			Container container = crea_connessione(query);
			
			// esegui query
			container.getStmt().setString(1, String.join("", "%",input_utente,"%"));
			ResultSet res = container.getStmt().executeQuery();
			
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
