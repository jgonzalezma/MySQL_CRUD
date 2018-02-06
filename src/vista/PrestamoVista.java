package vista;

import java.util.Scanner;

import modelo.Libro;
import modelo.LibroModelo;
import modelo.Usuario;
import modelo.UsuarioModelo;

public class PrestamoVista {
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
			opcion = Integer.parseInt(scan.nextLine());
			
			switch (opcion) {
			case TOMAR_PRESTADO:
				realizarPrestamo(scan);
				break;
				
			case ENTREGAR:
				
				break;
				
			case SALIR:
				
				break;

			default:
				System.out.println("Opcion mal");
				break;
			}
		} while (opcion != SALIR);
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
		}else{//el libro no existe
			
		}
		
	}
}
