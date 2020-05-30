package blog_cinema.db;

import java.sql.Connection;
import java.sql.Statement;

public class Container {
	private Connection connection;
	private Statement st;
	
	public Container(Connection connection, Statement st)
	{
		this.connection = connection;
		this.st = st;
	}

	public Connection getConnection() {
		return connection;
	}

	public Statement getSt() {
		return st;
	}
	
}
