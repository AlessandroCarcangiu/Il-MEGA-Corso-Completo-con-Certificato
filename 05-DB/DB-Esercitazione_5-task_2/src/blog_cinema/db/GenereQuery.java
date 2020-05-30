package blog_cinema.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import blog_cinema.dominio.Genere;



public class GenereQuery extends ConnectDB {
	
	// prendi tutti i generi dal db
	public static ArrayList<Genere> get_generi(){
		// inizializza la lista
		ArrayList<Genere> generi = new ArrayList<Genere>();
		
		try {
			// crea query
			String query = "select * from genere";
			
			// crea connessione
			Container container = crea_connessione();
			
			// esegui query
			ResultSet res = container.getSt().executeQuery(query);
			
			// cicla sul risultato della query
			while(res.next()) {
				generi.add(get_data_from_res(res));
			}
			
			// chiudiamo la connessione
			chiudi_connessione(container);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return generi;
	}
	
	// filtro per id
	public static Genere get_genere(int id){
		// inizializza genere
		Genere genere = null;
		
		try {
			// crea query
			String query = String.join("", "select * from genere where id=",Integer.toString(id));
			
			// crea connessione
			Container container = crea_connessione();
			
			// esegui query
			ResultSet res = container.getSt().executeQuery(query);
			
			// estrapola genere dal risultato della query
			if(res.next()) {
				genere = get_data_from_res(res);
			}
			
			// chiudiamo la connessione
			chiudi_connessione(container);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return genere;
	}
	
	// filtro per id
	public static Genere get_genere(String nome){
		// inizializza genere
		Genere genere = null;
		
		try {
			// crea query
			String query = String.join("", "select * from genere where nome='",nome,"'");
			
			// crea connessione
			Container container = crea_connessione();
			
			// esegui query
			ResultSet res = container.getSt().executeQuery(query);
			
			// estrapola genere dal risultato della query
			if(res.next()) {
				genere = get_data_from_res(res);
			}
			
			// chiudiamo la connessione
			chiudi_connessione(container);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return genere;
	}
	
	public static Genere get_data_from_res(ResultSet res) throws SQLException {
		// crea un genere usando i dati provenienti dal db
		Genere genere = new Genere();
		genere.setId(res.getInt("id"));
		genere.setNome(res.getString("nome"));
		genere.setDescrizione(res.getString("descrizione"));
		genere.setImg(res.getString("img"));
		
		return genere;
	}
}
