package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class LibroModelo extends Conector {

		public ArrayList<Libro> selectAll(){
			//crear el arraylist
			ArrayList<Libro> libros = new ArrayList<Libro>();
			//ejecutar la consulta
			try {
				Statement st = super.conexion.createStatement();
				ResultSet rs = st.executeQuery("SELECT * FROM libros");
				//recorrer el resultset y rellenar el arraylist
				while(rs.next()){
					Libro lb = new Libro();
					lb.setId(rs.getInt("id"));
					lb.setTitulo(rs.getString("titulo"));
					lb.setAutor(rs.getString("autor"));
					//añadir libro a la lista
					libros.add(lb);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return libros;
			
		}
		public Libro select(int id){
			//crear libro
			Libro libro = new Libro();
			//ejecutar consulta
			try {
				Statement st = super.conexion.createStatement();
				ResultSet rs = st.executeQuery("SELECT * FROM libros WHERE id = " + id);
				libro.setId(id);
				libro.setTitulo(rs.getString("titulo"));
				libro.setAutor(rs.getString("autor"));
			} catch (SQLException e) {
				e.printStackTrace();
			}	
			return libro;
		}
		public Libro selectPorTitulo(String titulo){
			//crear libro
			Libro libro = new Libro();
			//ejecutar consulta
			try {
				PreparedStatement pst = super.conexion.prepareStatement("SELECT * FROM libros WHERE titulo = " + titulo);
				pst.setInt(1, libro.getId());
				pst.setString(2, libro.getTitulo());
				pst.setString(3, libro.getAutor());
				pst.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return libro;
			
		}
		public void update(Libro libro){
			try {
				PreparedStatement pst = super.conexion.prepareStatement("UPDATE libros WHERE id=?, titulo=?, autor=?");
				pst.setString(1, libro.getTitulo());
				pst.setString(2, libro.getAutor());
				pst.setInt(3, libro.getId());
				pst.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		public void insert(Libro libro){
			try {
				PreparedStatement pst = super.conexion.prepareStatement("INSERT INTO libros (id, titulo, autor) values(?,?,?)" );
				pst.setString(1, libro.getTitulo());
				pst.setString(2, libro.getAutor());
				pst.setInt(3, libro.getId());
				pst.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		public void delete(int id){
			try {
				Statement st = super.conexion.createStatement();
				ResultSet rs = st.executeQuery("DELETE * FROM libros WHERE ID =" + id);
				rs.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}

}
