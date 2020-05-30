package blog_cinema.dominio;

public class Film {
	
	// attributi
	private int id;
	private String nome;
	private String trama;
	private String img;
	private Genere genere;
	
	// costruttore
	public Film() {
		
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

	public String getTrama() {
		return trama;
	}

	public void setTrama(String trama) {
		this.trama = trama;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Genere getGenere() {
		return genere;
	}

	public void setGenere(Genere genere) {
		this.genere = genere;
	}
	
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj instanceof Film) {
			Film temp = (Film)obj;
			if(this.getId() == temp.getId()) {
				return true;
			}
		}
		return false;
	}
}
