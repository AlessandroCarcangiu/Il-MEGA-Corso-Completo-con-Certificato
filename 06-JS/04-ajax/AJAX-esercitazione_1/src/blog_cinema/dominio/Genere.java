package blog_cinema.dominio;

public class Genere {
	
	// attributi
	private int id;
	private String nome;
	private String descrizione;
	private String img;
	
	// costruttore
	public Genere() {
		
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

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
	
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj instanceof Genere) {
			Genere temp = (Genere)obj;
			if(this.getId() == temp.getId()) {
				return true;
			}
		}
		return false;
	}
	
}
