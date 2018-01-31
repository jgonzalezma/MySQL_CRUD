package vista;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import modelo.Usuario;
import modelo.UsuarioModelo;

import modelo.UsuarioModelo;

public class UsuarioVista extends Usuario {
	
	public void menuDeUsuario(){
		Scanner scan = new Scanner(System.in);
		final int INSERTAR = 1;
		final int ELIMINAR = 2;
		final int LISTAR = 3;
		final int SALIR = 0;
		int opcion;
		
		do {
			System.out.println("---MENU---");
			System.out.println(INSERTAR + " Insertar usuarios");
			System.out.println(ELIMINAR + " Eliminar usuarios");
			System.out.println(LISTAR + " Listar usuarios");
			System.out.println(SALIR);
			
			opcion = Integer.parseInt(scan.nextLine());
			
			switch (opcion) {
			case INSERTAR:
				UsuarioModelo usuarioModelo = new UsuarioModelo();
				
				break;
			case ELIMINAR:
				break;
			case LISTAR:
				UsuarioModelo usuarioModelo = new UsuarioModelo();
				ArrayList<Usuario> usuarios = usuarioModelo.selectAll();
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

	private void mostrarUsuarios(ArrayList<Usuario> usuarios) {
		Usuario u = new Usuario();
		Iterator<Usuario> i = usuarios.iterator();
		while(i.hasNext()){
			Usuario usuario = i.next();
			u.mostrarUsuario(usuario);
		}
		
	}

	
}
