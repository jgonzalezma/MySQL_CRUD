package modelo;

import java.util.Date;

public class Usuario {
	//atributos
	private int id;
	private String nombre;
	private String apellido;
	private int edad;
	private String dni;
	private Date fechaNacimiento;
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	//getters y setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public void mostrarUsuario(Usuario usuario) {
		System.out.println("\nID: " + usuario.getId() + "\nNombre-Apellido: " + usuario.getNombre() + " " + usuario.getApellido() + "\nEdad: " + usuario.getEdad() + "\nDNI: " + usuario.getDni() + "\nFecha nacimiento: " + usuario.getFechaNacimiento());
	}
}
