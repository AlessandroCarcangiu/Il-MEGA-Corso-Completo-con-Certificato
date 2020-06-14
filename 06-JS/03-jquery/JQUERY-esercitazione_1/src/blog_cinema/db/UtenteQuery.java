package blog_cinema.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import blog_cinema.dominio.Utente;
import blog_cinema.dominio.Utente.TipoUtente;

public class UtenteQuery extends ConnectDB{
	
	// filtro per id
	public static Utente get_utente(int id) {
		// Inizializza utente
		Utente utente = null;
		
		try {
			// crea query
			String query = "select * from utente where id=?";

			// crea connessione
			Container container = crea_connessione(query);
			
			// esegui query
			container.getStmt().setInt(1, id);
			ResultSet res = container.getStmt().executeQuery();
			
			// cicla sui risultati ottenuti dalla query
			if(res.next()) {
				utente = get_data_from_res(res);
			}
			
			// chiudi connessione
			chiudi_connessione(container);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return utente;
	}
	
	// filtro per username e password
	public static Utente get_utente(String username, String password) {
		// Inizializza utente
		Utente utente = null;
		
		try {
			// crea query
			String query = "select * from utente where username=? and password=?";
			
			// crea connessione
			Container container = crea_connessione(query);
			
			// esegui query
			container.getStmt().setString(1, username);
			container.getStmt().setString(2, password);
			ResultSet res = container.getStmt().executeQuery();
			
			// cicla sui risultati ottenuti dalla query
			if(res.next()) {
				utente = get_data_from_res(res);
			}
			
			// chiudi connessione
			chiudi_connessione(container);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return utente;
	}
	
	// rimuovi utente
	public static boolean rimuovi_utente(Utente utente) {
		try {
			// crea query
			String query = "delete from utente where id=?";
			
			// crea connessione
			Container container = crea_connessione(query);
			
			// esegui query
			container.getStmt().setInt(1, utente.getId());
			container.getStmt().executeUpdate();
	        
	        // chiudi la connessione
        	chiudi_connessione(container);
        	
        	return true;
		}
        catch (Exception e) {
            e.printStackTrace();
        }
		
		return false;
	}
		
	public static Utente get_data_from_res(ResultSet res) throws SQLException {
		// crea un utente usando i dati provenienti dal db
		Utente utente = new Utente();
		utente.setId(res.getInt("id"));
		utente.setNome(res.getString("nome"));
		utente.setCognome(res.getString("cognome"));
		utente.setUsername(res.getString("username"));
		utente.setEmail(res.getString("email"));
		utente.setPassword(res.getString("password"));
		utente.setTipo(TipoUtente.values()[res.getInt("tipoutente")-1]);
		
		return utente;
	}

}
