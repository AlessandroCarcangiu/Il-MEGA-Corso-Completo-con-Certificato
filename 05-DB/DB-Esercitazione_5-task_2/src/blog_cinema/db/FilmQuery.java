package blog_cinema.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import blog_cinema.dominio.Film;
import blog_cinema.dominio.Genere;

public class FilmQuery extends ConnectDB {
	
	// prendi tutti i film presenti nel db
	public static ArrayList<Film> get_film(){
		// inizializza lista film
		ArrayList<Film> film= new ArrayList<Film>();
		
		try {
			// crea query
			String query = "select * from film";
			
			// crea connessione
			Container container = crea_connessione();
			
			// esegui query
			ResultSet res = container.getSt().executeQuery(query);
			
			// cicla sul risultato della query
			while(res.next()) {
				film.add(get_data_from_res(res));
			}
			
			// chiudiamo la connessione
			chiudi_connessione(container);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return film;
	}
	
	// filtro per id
	public static Film get_film(int id){
		// inizializza film
		Film film= null;
		
		try {
			// crea query
			String query = String.join("", "select * from film where id=",Integer.toString(id));
			
			// crea connessione
			Container container = crea_connessione();
			
			// esegui query
			ResultSet res = container.getSt().executeQuery(query);
			
			// estrapola dati dal risultato query
			if(res.next()) {
				film = get_data_from_res(res);
			}
			
			// chiudiamo la connessione
			chiudi_connessione(container);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return film;
	}
	
	// filtro per nome
	public static Film get_film(String nome){
		// inizializza film
		Film film= null;
		
		try {
			// crea query
			String query = String.join("", "select * from film where nome='",nome,"'");
			
			// crea connessione
			Container container = crea_connessione();
			
			// esegui query
			ResultSet res = container.getSt().executeQuery(query);
			
			// estrapola dati dal risultato query
			if(res.next()) {
				film = get_data_from_res(res);
			}
			
			// chiudiamo la connessione
			chiudi_connessione(container);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return film;
	}
	
	// filtro per genere
	public static ArrayList<Film> get_film(Genere genere){
		// inizializza lista film
		ArrayList<Film> film= new ArrayList<Film>();
		
		try {
			// crea query
			String query = String.join("", "Select * from film where genere=",Integer.toString(genere.getId()));
			
			// crea connessione
			Container container = crea_connessione();
			
			// esegui query
			ResultSet res = container.getSt().executeQuery(query);
			
			// cicla sul risultato della query
			while(res.next()) {
				film.add(get_data_from_res(res));
			}
			
			// chiudiamo la connessione
			chiudi_connessione(container);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return film;
	}
		
	public static Film get_data_from_res(ResultSet res) throws SQLException {
		// crea film dai dati provenienti dal db
		Film film = new Film();
		film.setId(res.getInt("id"));
		film.setNome(res.getString("nome"));
		film.setTrama(res.getString("trama"));
		film.setImg(res.getString("img"));
		// prendi genere
		Genere genere = GenereQuery.get_genere(res.getInt("genere"));
		film.setGenere(genere);
		
		return film;
	}
}
