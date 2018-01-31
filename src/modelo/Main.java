package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		final int CREAR = 1;
		final int LISTAR = 2;
		final int ACTUALIZAR = 3;
		final int ELIMINAR = 4;
		final int SALIR = 0;

		int opcion;
		do {
			System.out.println("---Menu---");
			System.out.println(CREAR + " Crear usuario");
			System.out.println(LISTAR + " Listar usuarios");
			System.out.println(ACTUALIZAR + " Actualizar usuarios");
			System.out.println(ELIMINAR + " Eliminar usuarios");
			System.out.println(SALIR + " Salir");
			Scanner lector = new Scanner(System.in);
			opcion = Integer.parseInt(lector.nextLine());

			switch (opcion) {
			case CREAR:
				crearUsuario();
				System.out.println("Usuario creado");
				break;
			case LISTAR:
				imprimirLista();
				break;

			case ACTUALIZAR:
				updateUsuario();
				break;

			case ELIMINAR:
				eliminarUsuario();
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

	public static void imprimirLista() {
		try {
			// se carga el driver
			Class.forName("com.mysql.jdbc.Driver");
			// crear la conexion con la BBDD biblioteca
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/biblioteca", "root", "");
			// statement para ejecutar querys
			Statement st = con.createStatement();
			// ejecutar query
			ResultSet rs = st.executeQuery("select * from usuarios");
			// imprimir en pantalla el resultado de la consulta

			while (rs.next()) {
				System.out.println(rs.getInt("id") + " " + rs.getString("nombre") + " " + rs.getString("apellido") + " "
						+ rs.getInt("edad"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void crearUsuario() {
		try {
			// ejecutar un insert
			// pedir datos por pantalla
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/biblioteca", "root", "");
			Scanner scan = new Scanner(System.in);
			System.out.println("Introduce un nombre");
			String nombre = scan.nextLine();
			System.out.println("Introduce un apellido");
			String apellido = scan.nextLine();
			System.out.println("Introduce una edad");
			int edad = scan.nextInt();
			// st.execute("INSERT INTO usuarios(id, nombre, apellido, edad)
			// VALUES (NULL, '" + nombre + "', '" + apellido + "', '" + edad +
			// "')");

			PreparedStatement pst = con
					.prepareStatement("INSERT INTO usuarios(id, nombre, apellido, edad) VALUES (NULL,?,?,?)");
			pst.setString(1, nombre);
			pst.setString(2, apellido);
			pst.setInt(3, edad);

			pst.execute();
		} catch (Exception e) {
		}
	}

	public static void updateUsuario() {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/biblioteca", "root", "");
			Scanner scan = new Scanner(System.in);
			System.out.println("Introduce el id que quieres cambiar");
			int idactualizado = Integer.parseInt(scan.nextLine());
			System.out.println("Introduce el nuevo nombre");
			String nuevonombre = scan.nextLine();
			System.out.println("Introduce el nuevo apellido");
			String nuevoapellido = scan.nextLine();
			System.out.println("Introduce la nueva edad");
			int nuevaedad = Integer.parseInt(scan.nextLine());

			PreparedStatement upt = con.prepareStatement("UPDATE `usuarios` SET nombre=?,apellido=?,edad=? WHERE id =?;");
			upt.setString(1, nuevonombre);
			upt.setString(2, nuevoapellido);
			upt.setInt(3, nuevaedad);
			upt.setInt(4, idactualizado);
			upt.execute();
		}

		catch (Exception e) {

		}
	}
	public static void eliminarUsuario(){
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/biblioteca", "root", "");
			Scanner scan = new Scanner(System.in);
			System.out.println("Introduce el id que quieres eliminar");
			int iddelete = Integer.parseInt(scan.nextLine());
			
			PreparedStatement dpt = con.prepareStatement("DELETE FROM usuarios WHERE id=?;");
			dpt.setInt(1, iddelete);
			dpt.execute();
			
			System.out.println("El id " + iddelete + " ha sido eliminado");
		} catch (Exception e) {

		}
		
	}
	
	
}
