package blog_cinema.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectDB {
	// DB variabili per la connessione
	static final String databaseName = "blog_cinema";
	static final String username = "ale";
	static final String password = "ale1";
	static final String url = String.join("", "jdbc:mysql://localhost:3306/", databaseName,
			"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
			
	protected static Container crea_connessione() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		// crea la connessione e lo statement con cui eseguire le query
		Connection connection = DriverManager.getConnection(url,username,password);
		Statement st = connection.createStatement();
		// ritorna valori creati attraverso la classe Container
		return new Container(connection, st);
	}
	
	protected static void chiudi_connessione(Container container) throws SQLException {
		// chiudi st
		if(container.getSt() != null) {
			container.getSt().close();
		}
		// chiudi connection
		if(container.getConnection() != null) {
			container.getConnection().close();
		}
	}
	
}
