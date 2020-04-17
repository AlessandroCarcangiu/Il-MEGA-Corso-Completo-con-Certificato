package blog_cinema.dominio;

public class Utente {
	
	public enum TipoUtente{
		ADMIN,
		LETTORE
	}
	
	// attributi
	private int id;
	private String nome;
	private String cognome;
	private String email;
	private String username;
	private String password;
	private TipoUtente tipo;
	
	// costruttore
	public Utente() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public TipoUtente getTipo() {
		return tipo;
	}

	public void setTipo(TipoUtente tipo) {
		this.tipo = tipo;
	}
	
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj instanceof Utente) {
			Utente temp = (Utente)obj;
			if(this.getId() == temp.getId()) {
				return true;
			}
		}
		return false;
	}
}
	