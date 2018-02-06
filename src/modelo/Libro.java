package modelo;

public class Libro {
	//atributos
	private int id;
	private String titulo;
	private String autor;
	
	//getters y setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public void mostrarLibros(){
		System.out.println("\nID: " + getId() + "\nTitulo: " + getTitulo() + "\nAutor: " + getAutor());
	}
}
