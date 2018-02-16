package vista;

import java.util.Scanner;
public class BibliotecaVista {
	static final int GESTIONAR_USUARIOS = 1;
	static final int GESTIONAR_LIBROS = 2;
	static final int GESTIONAR_PRESTAMOS = 3;
	static final int SALIR = 0;
	
	public void menuBiblioteca(){
		LibroVista libroVista = new LibroVista();
		UsuarioVista usuarioVista = new UsuarioVista();
		PrestamoVista prestamoVista = new PrestamoVista();
		
		Scanner scan = new Scanner(System.in);
		int opcion;
		
		do {
			System.out.println(GESTIONAR_USUARIOS + "- Gestionar usuarios");
			System.out.println(GESTIONAR_LIBROS + "- Gestionar libros");
			System.out.println(GESTIONAR_PRESTAMOS + "- Gestionar prestamos");
			System.out.println(SALIR + "- Salir");
			
			opcion = Integer.parseInt(scan.nextLine());
			
			switch (opcion) {
			case GESTIONAR_USUARIOS:
				
				break;
				
			case GESTIONAR_LIBROS:
				
				break;
				
			case GESTIONAR_PRESTAMOS:
				
				break;
				
			case SALIR:
				System.out.println("Saliendo...");

			default:
				System.out.println("Opcon mal");
				break;
			}
			
		} while (opcion != SALIR);
	}
}
