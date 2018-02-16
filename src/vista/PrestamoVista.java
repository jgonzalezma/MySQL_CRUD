package vista;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import modelo.Libro;
import modelo.LibroModelo;
import modelo.Prestamo;
import modelo.PrestamoModelo;
import modelo.Usuario;
import modelo.UsuarioModelo;

public class PrestamoVista extends Usuario {
	static final int TOMAR_PRESTADO = 1;
	static final int ENTREGAR = 2;
	static final int SALIR = 0;

	
	public void menuPrestamo(){
		int opcion;
		Scanner scan = new Scanner(System.in);
		do {
			System.out.println("--Prestamos--");
			System.out.println(TOMAR_PRESTADO + "- Tomar prestado un libro");
			System.out.println(ENTREGAR + "- Entregar un libro");
			System.out.println(SALIR + "- Salir");
			opcion = Integer.parseInt(scan.nextLine());
			
			switch (opcion) {
			case TOMAR_PRESTADO:
				realizarPrestamo(scan);
				break;
			case ENTREGAR:
				realizarEntrega(scan);
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

	private void realizarEntrega(Scanner scan) {
		//pedir dni, titulo
		System.out.println("Introduce el DNI del usuario");
		String dni = scan.nextLine();
		//conseguir usuario
		UsuarioModelo usuarioModelo = new UsuarioModelo();
		Usuario usuario = usuarioModelo.selectPorDNI(dni);
		//pedir el titulo
		System.out.println("Introduce el titulo del libro");
		String titulo = scan.nextLine();
		//conseguir libro
		LibroModelo libroModelo = new LibroModelo();
		Libro libro = libroModelo.selectPorTitulo(titulo);
		//conseguir el prestamo de la BBDD
		PrestamoModelo prestamoModelo = new PrestamoModelo();
		Prestamo prestamo = prestamoModelo.prestamoNoFinalizado(libro, usuario);
		//cambiar el objeto prestamo a entregado
		prestamo.setEntregado(true);
		//hacer update de la BBDD
		prestamoModelo.update(prestamo);
		
		System.out.println("El libro " + libro.getTitulo() + " ha sido entregado");
	}

	private void realizarPrestamo(Scanner scan) {
		System.out.println("Introduce un titulo");
		String titulo = scan.nextLine();
		LibroModelo lm = new LibroModelo();
		Libro libro = lm.selectPorTitulo(titulo);
		
		if(libro != null){//el libro existe
			System.out.println("Introduce el DNI");
			String dni = scan.nextLine();
			UsuarioModelo um = new UsuarioModelo();
			Usuario usuario = um.selectPorDNI(dni);
			
			//crear el objeto prestamo
			Prestamo prestamo = new Prestamo();
			prestamo.setIdLibro(libro.getId());
			prestamo.setIdUsuario(usuario.getId());
			
			Date fechaPrestamo = new Date();
			
			Calendar calendario = Calendar.getInstance();
			calendario.setTime(fechaPrestamo);
			calendario.add(Calendar.DATE, 21);
			fechaPrestamo = calendario.getTime();
			
			prestamo.setEntregado(false);
			//crear el objeto modeloprestamo
			PrestamoModelo pModelo = new PrestamoModelo();
			//insertar prestamo utilizando modeloprestamo
			pModelo.insertar(prestamo);
			System.out.println("Prestamo realizado");

		}else{//el libro no existe
			System.out.println("El libro introducido no existe");
		}
		
	}
}
