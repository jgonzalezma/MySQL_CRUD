package modelo;

import java.util.Date;

public class Prestamo {
	private int id;
	private Libro libro;
	private Usuario usuario;
	private Date fechaPrestamo;
	private Date fechaLimite;
	private boolean entregado;
	
	public Prestamo(int id, Libro libro, Usuario usuario, Date fechaPrestamo, Date fechaLimite, boolean entregado){
		this.id=id;
		this.libro=libro;
		this.usuario=usuario;
		this.fechaPrestamo=fechaPrestamo;
		this.fechaLimite=fechaLimite;
		this.entregado=entregado;
	}
	
	public Prestamo() {
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Libro getLibro() {
		return libro;
	}
	public void setLibro(Libro libro) {
		this.libro = libro;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Date getFechaPrestamo() {
		return fechaPrestamo;
	}
	public void setFechaPrestamo(Date fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}
	public Date getFechaLimite() {
		return fechaLimite;
	}
	public void setFechaLimite(Date fechaLimite) {
		this.fechaLimite = fechaLimite;
	}
	public boolean isEntregado() {
		return entregado;
	}
	public void setEntregado(boolean entregado) {
		this.entregado = entregado;
	}
	public void mostrarPrestamos(){
		System.out.println("\nID: " + getId() + "\nId Libro: " + getLibro() + "\nID Usuario: " + getUsuario() + "\nFecha prestamo: " + getFechaPrestamo() + "\nFecha Limite: " + getFechaLimite() + "\n Entregado: " + isEntregado() );
	}
}
