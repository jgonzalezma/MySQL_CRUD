package vista;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

import modelo.Usuario;
import modelo.UsuarioModelo;

import modelo.UsuarioModelo;

public class UsuarioVista extends Usuario {
	
	public void menuDeUsuario(){
		Scanner scan = new Scanner(System.in);
		UsuarioModelo um = new UsuarioModelo();
		final int INSERTAR = 1;
		final int LISTAR = 2;
		final int SALIR = 0;
		int opcion;
		
		do {
			System.out.println("---MENU---");
			System.out.println(INSERTAR + "- Insertar usuarios");
			System.out.println(LISTAR + "- Listar usuarios");
			System.out.println(SALIR + "- Salir del programa");
			
			opcion = Integer.parseInt(scan.nextLine());
			
			switch (opcion) {
			case INSERTAR:
				um.insert(crearUsuario());
				break;
			case LISTAR:
				UsuarioModelo usrModelo = new UsuarioModelo();
				ArrayList<Usuario> usuarios = usrModelo.selectAll();
				this.mostrarUsuarios(usuarios);
				break;
			case SALIR:
				System.out.println("Saliendo...");
				break;

			default:
				System.out.println("Opcion mal");
				break;
			}
			
			
			
		} while (opcion != SALIR);
			
		
	}

	public Usuario crearUsuario() {
		Usuario usuario = new Usuario();
		Scanner scan = new Scanner(System.in);
		System.out.println("Inserte su nombre");
		String nombre = scan.nextLine();
		usuario.setNombre(nombre);
		System.out.println("Inserte su apellido");
		String apellido = scan.nextLine();
		usuario.setApellido(apellido);
		System.out.println("Introduzca su edad");
		int edad = Integer.parseInt(scan.nextLine());
		usuario.setEdad(edad);
		System.out.println("Introduzca su dni");
		String dni = scan.nextLine();
		usuario.setDni(dni);
		
		Date fechaNacimiento;
		try {
			System.out.println("Introduzca su fecha de nacimiento en formato yyyy-MM-dd");
			String fecha = scan.nextLine();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			fechaNacimiento = df.parse(fecha);
			usuario.setFechaNacimiento(fechaNacimiento);
		} catch (ParseException e) {
		}
		
		return usuario;
	}

	public void mostrarUsuarios(ArrayList<Usuario> usuarios) {
		Usuario u = new Usuario();
		Iterator<Usuario> i = usuarios.iterator();
		while(i.hasNext()){
			Usuario usuario = i.next();
			u.mostrarUsuario(usuario);
		}
		
	}

	
}
