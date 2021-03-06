package modelo;

import java.util.ArrayList;

public class Libro {
	//atributos
	private int id;
	private String titulo;
	private String autor;
	private ArrayList<Prestamo> prestamos;
	
	public Libro(){
		
	}
	
	public Libro(int id, String titulo, String autor) {
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
	}
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
