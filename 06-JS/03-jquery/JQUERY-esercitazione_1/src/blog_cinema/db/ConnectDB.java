package blog_cinema.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectDB {
	// DB variabili per la connessione
	static final String databaseName = "blog_cinema";
	static final String username = "ale";
	static final String password = "ale1";
	static final String url = String.join("", "jdbc:mysql://localhost:3306/", databaseName,
			"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
			
	protected static Container crea_connessione(String query) throws ClassNotFoundException, SQLException, IllegalAccessException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		// crea la connessione e il prepared statement con cui eseguire la query
		Connection connection = DriverManager.getConnection(url, username, password);
		PreparedStatement stmt = connection.prepareStatement(query);
		// ritorna valori creati
		return new Container(connection, stmt);
	}
	
	protected static void chiudi_connessione(Container container) throws SQLException {
		// chiudi stmt
		if (container.getStmt() != null) {
			container.getStmt().close();
    	}
		// chiudi connection
		if(container.getConnection() != null) {
			container.getConnection().close();
		}
	}
	
}
