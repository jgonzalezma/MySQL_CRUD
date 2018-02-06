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
			pst.setInt(1, prestamo.getIdLibro());
			pst.setInt(1, prestamo.getIdUsuario());
			pst.setDate(3, new java.sql.Date(prestamo.getFechaPrestamo().getTime()));
			pst.setDate(4, new java.sql.Date(prestamo.getFechaLimite().getTime()));
			pst.setBoolean(5, prestamo.isEntregado());
			pst.execute();
		} catch (SQLException e) {
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
				prestamo = new Prestamo();
				prestamo.setId(rs.getInt("id"));
				prestamo.setIdLibro(rs.getInt("id_libro"));
				prestamo.setIdUsuario(rs.getInt("id_usuario"));
				prestamo.setFechaPrestamo(rs.getDate("fecha_prestamo"));
				prestamo.setFechaLimite(rs.getDate("fecha_limite"));
				prestamo.setEntregado(rs.getBoolean("entregado"));
				prestamos.add(prestamo);
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
			pst.setInt(2, pr.getIdLibro());
			pst.setInt(3, pr.getIdUsuario());
			pst.setDate(4, new java.sql.Date(pr.getFechaPrestamo().getTime()));
			pst.setDate(5, new java.sql.Date(pr.getFechaLimite().getTime()));
			pst.setBoolean(6, pr.isEntregado());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return pr;
	}
}
