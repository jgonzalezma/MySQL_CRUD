package vista;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import modelo.Libro;
import modelo.LibroModelo;

public class LibroVista extends Libro {
	public void menuLibro(){
		Scanner scan = new Scanner(System.in);
		LibroModelo lm = new LibroModelo();
		
		final int INSERTAR = 1;
		final int LISTAR = 2;
		final int SALIR = 0;
		int opcion;
		do {
			System.out.println("---MENU---");
			System.out.println(INSERTAR + "- Insertar libro");
			System.out.println(LISTAR + "- Listar libros");
			System.out.println(SALIR + "- Salir");
			opcion = Integer.parseInt(scan.nextLine());
			
			switch (opcion) {
			case INSERTAR:
				crearLibro();
				break;
			case LISTAR:
				mostrarLibros();
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
	public Libro crearLibro(){
		Libro libro = new Libro();
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce el titulo del libro");
		String titulo = scan.nextLine();
		System.out.println("Introduce el autor del libro");
		String autor = scan.nextLine();
		return libro;
		
	}
	public void mostrarLibros(ArrayList <Libro> listaLibros){
		Libro lb = new Libro();
		Iterator <Libro> i = listaLibros.iterator();
		while(i.hasNext()){
			Libro libro = i.next();
			lb.mostrarLibros();
		}
	}
}
