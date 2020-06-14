package blog_cinema.db;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Container {
	   
    private Connection connection;
    private PreparedStatement stmt;
   
    public Container(Connection connection, PreparedStatement pst) {
    	this.connection = connection;
    	this.stmt = pst;
    }
    
    public Connection getConnection() {
		return connection;
	}

	public PreparedStatement getStmt() {
		return stmt;
	}

}
