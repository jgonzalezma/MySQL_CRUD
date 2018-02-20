package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PrestamoModelo extends Conector {
	public void insertar(Prestamo prestamo){
		try {
			PreparedStatement pst = super.conexion.prepareStatement("insert into prestamos(id_libro, id_usuario, fecha_prestamo, fecha_limite, entregado) values (?,?,?,?,?)");
			pst.setInt(1, prestamo.getLibro().getId());
			pst.setInt(2, prestamo.getUsuario().getId());
			pst.setDate(3, new java.sql.Date(prestamo.getFechaPrestamo().getTime()));
			pst.setDate(4, new java.sql.Date(prestamo.getFechaLimite().getTime()));
			pst.setBoolean(5, prestamo.isEntregado());
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public ArrayList<Prestamo> selectAll(){
		Statement st;
		Prestamo prestamo;
		ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();
		try {
			st = super.conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from prestamos");
			while(rs.next()){
				Prestamo p = new Prestamo();
				p.setId(rs.getInt("id"));
				p.getLibro().setId(rs.getInt("id_libro"));
				p.getUsuario().setId(rs.getInt("id_usuario"));
				p.setFechaPrestamo(rs.getDate("fecha_prestamo"));
				p.setFechaLimite(rs.getDate("fecha_limite"));
				p.setEntregado(rs.getBoolean("entregado"));
				prestamos.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return prestamos;
	}
	public Prestamo select(int id){
		Prestamo pr = new Prestamo();
		try {
			PreparedStatement pst = super.conexion.prepareStatement("select * from prestamos where id = " + id);
			pst.setInt(1, pr.getId());
			pst.setInt(2, pr.getLibro().getId());
			pst.setInt(3, pr.getUsuario().getId());
			pst.setDate(4, new java.sql.Date(pr.getFechaPrestamo().getTime()));
			pst.setDate(5, new java.sql.Date(pr.getFechaLimite().getTime()));
			pst.setBoolean(6, pr.isEntregado());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return pr;
	}
	public Prestamo prestamoNoFinalizado(Libro libro, Usuario usuario) {
		PreparedStatement pst;
		try {
			pst = super.conexion.prepareStatement("SELECT * FROM prestamos WHERE id_libro=? and id_usuario=? and entregado=?");
			pst.setInt(1, libro.getId());
			pst.setInt(2, usuario.getId());
			pst.setBoolean(3, false);
			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				Prestamo prestamo = new Prestamo();
				prestamo.setId(rs.getInt("id"));
				prestamo.getLibro().setId(rs.getInt("id_libro"));
				prestamo.getUsuario().setId(rs.getInt("id_usuario"));
				prestamo.setFechaPrestamo(rs.getDate("fecha_prestamo"));
				prestamo.setFechaLimite(rs.getDate("fecha_limite"));
				prestamo.setEntregado(rs.getBoolean("entregado"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	public void update(Prestamo prestamo) {
		PreparedStatement pst;
		try {
			pst = super.conexion.prepareStatement("UPDATE prestamos SET id_libro=?,id_usuario=?,fecha_prestamo=?,fecha_limite=?,entregado=? WHERE id=?");
			pst.setInt(1, prestamo.getLibro().getId());
			pst.setInt(2, prestamo.getUsuario().getId());
			java.sql.Date fecha_prestamo = new java.sql.Date(prestamo.getFechaPrestamo().getTime());
			pst.setDate(3, fecha_prestamo);
			java.sql.Date fecha_limite = new java.sql.Date(prestamo.getFechaLimite().getTime());
			pst.setDate(4, fecha_limite);
			pst.setBoolean(5, prestamo.isEntregado());
			pst.setInt(6, prestamo.getId());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
}
