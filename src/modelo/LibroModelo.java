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
				ResultSet rs = st.executeQuery("SELECT * FROM libro");
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
				ResultSet rs = st.executeQuery("SELECT * FROM libro WHERE id = " + id);
				libro.setId(rs.getInt("id"));
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
				PreparedStatement pst = super.conexion.prepareStatement("SELECT * FROM libro WHERE titulo=?");
				pst.setString(1, titulo);
				ResultSet rs = pst.executeQuery();
				if(rs.next()){
					libro.setId(rs.getInt("id"));
					libro.setTitulo(rs.getString("titulo"));
					libro.setAutor(rs.getString("autor"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return libro;
			
		}
		public void update(Libro libro){
			try {
				PreparedStatement pst = super.conexion.prepareStatement("UPDATE libro WHERE id=?, titulo=?, autor=?");
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
				PreparedStatement pst = super.conexion.prepareStatement("INSERT INTO libro (id, titulo, autor) values(?,?,?)" );
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
				ResultSet rs = st.executeQuery("DELETE * FROM libro WHERE ID =" + id);
				rs.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}

}
