package es.imfe.practica16;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;




public class ProductoDao {

	public void insertar (Producto producto) throws ClassNotFoundException, SQLException {
		
		Conexion cnn = new Conexion();
		Connection conn = cnn.conectar() ;
		PreparedStatement st = conn.prepareStatement("INSERT INTO producto (nombre,cantidad,precio,comentario,fecha) VALUES (?,?,?,?,?)");
		Date fecha = producto.getFecha() ;
		java.sql.Timestamp dt = new Timestamp(fecha.getTime());
		
		st.setString(1,producto.getNombre());
		st.setInt(2, producto.getCantidad());
		st.setDouble(3,producto.getPrecio());
		st.setString(4,producto.getComentario());
		st.setTimestamp(5, dt);
		
		st.executeUpdate();
		st.close() ;
		conn.close() ;
		cnn.desconectar();
		
	}
	
	public List <Producto> listar (String nombre) throws ClassNotFoundException, SQLException {
		List <Producto> lista = new ArrayList<Producto> ();
		Conexion cnn = new Conexion();
		Connection conn = cnn.conectar() ;
		PreparedStatement st = conn.prepareStatement("SELECT * FROM producto WHERE nombre LIKE ?");
		st.setString(1, "%" + nombre + "%"); //Los comodines no pueden ir en la sentencia del LIKE
		ResultSet rs = st.executeQuery() ;
		
		while(rs.next()) {
				Producto p = new Producto();
				p.setId(rs.getInt(1));
				p.setNombre(nombre);
				p.setCantidad(rs.getInt(3));
				p.setPrecio(rs.getDouble(4));
				p.setComentario(rs.getString(5));
				p.setFecha(rs.getDate(6));
			    lista.add(p) ;	
		}
		
		rs.close();
		st.close();
		conn.close();
		return lista ;
	}

	
}
