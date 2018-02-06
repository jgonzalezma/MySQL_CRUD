package modelo;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioModelo extends Conector{
		public ArrayList<Usuario> selectAll(){
			//crear arraylist
			ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
			//ejecutar la consulta
			try {
			
				Statement st = super.conexion.createStatement();
				ResultSet rs = st.executeQuery("SELECT * FROM usuarios");
				
				//recorrer el resultset y rellenar el arraylist	
				while(rs.next()){
					Usuario us = new Usuario();
					us.setId(rs.getInt("id"));
					us.setNombre(rs.getString("nombre"));
					us.setApellido(rs.getString("apellido"));
					us.setEdad(rs.getInt("edad"));
					us.setDni(rs.getString("dni"));
					
					us.setFechaNacimiento(rs.getDate("fechaNacimiento"));
					
					//añadir usuario a la lista
					usuarios.add(us);

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			//devolver el arraylist
			return usuarios;	
			
		}
		public Usuario select(int id){
			//crear usuario
			Usuario usuario = new Usuario();
			//ejecutar consulta
			try {
				Statement st = super.conexion.createStatement();
				ResultSet rs = st.executeQuery("SELECT * FROM usuarios WHERE ID = " + id);
				usuario.setId(id);
				usuario.setNombre(rs.getString("nombre"));
				usuario.setApellido(rs.getString("apellido"));
				usuario.setEdad(rs.getInt("edad"));
				usuario.setDni(rs.getString("dni"));
				usuario.setFechaNacimiento(rs.getDate("fechaNacimiento"));
				
			} catch (Exception e) {

			}
			
			return usuario;
		}
		public void delete (int id){
			try {
				Statement st = super.conexion.createStatement();
				ResultSet rs = st.executeQuery("DELETE * FROM usuarios WHERE ID =" + id);
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		public void update(Usuario usuario){
			try {
				PreparedStatement pst = super.conexion.prepareStatement("UPDATE usuarios WHERE id=?, nombre=?, apellido=?, edad=?");
				pst.setString(1, usuario.getNombre());
				pst.setString(2, usuario.getApellido());
				pst.setInt(3, usuario.getEdad());
				pst.setString(4, usuario.getDni());
				java.sql.Date sqlData = new java.sql.Date(usuario.getFechaNacimiento().getTime());
				pst.setDate(5, sqlData);
				pst.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		public void insert(Usuario usuario){
			try {
				PreparedStatement pst = super.conexion.prepareStatement("INSERT INTO usuarios (nombre, apellido, edad, dni, fechaNacimiento) values(?,?,?,?,?)" );
				pst.setString(1, usuario.getNombre());
				pst.setString(2, usuario.getApellido());
				pst.setInt(3, usuario.getEdad());
				pst.setString(4, usuario.getDni());
				java.sql.Date sqlData = new java.sql.Date(usuario.getFechaNacimiento().getTime());
				pst.setDate(5, sqlData);
				pst.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		public ArrayList<Usuario> selectPorNombre(String nombre){
			ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
			try {
				Statement st = super.conexion.createStatement();
				//recorrer el resultset y seleccionarlos por nombre
				ResultSet rs = st.executeQuery("SELECT * FROM usuarios WHERE nombre= " + nombre);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return usuarios;
		}
		public ArrayList<Usuario> selectMenorDeEdad(){
			ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
			try {
				Statement st = super.conexion.createStatement();
				ResultSet rs = st.executeQuery("SELECT * FROM usuarios WHERE edad<18");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return usuarios;
		}
		
		
		public ArrayList<Usuario> selectContieneEnApellido(String apellido){
			ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
			try {
				Statement st = super.conexion.createStatement();
				//recorrer el resultset y seleccionarlos por nombre
				ResultSet rs = st.executeQuery("SELECT * FROM usuarios WHERE apellido LIKE '%"+ apellido +"%'");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return usuarios;
		}
		public Usuario selectPorDNI(String dni) {
			try {
				PreparedStatement pst = super.conexion.prepareStatement("select * from usuarios where dni = ?");
				pst.setString(1, dni);
				ResultSet rs = pst.executeQuery();
				
				if(rs.next()){
					Usuario usuario = new Usuario();
					usuario.setId(rs.getInt("id"));
					usuario.setNombre(rs.getString("nombre"));
					usuario.setApellido(rs.getString("apellido"));
					usuario.setDni(rs.getString("dni"));
					usuario.setEdad(rs.getInt("edad"));
					usuario.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
}
