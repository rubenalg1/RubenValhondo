package es.imfe.practica16;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	private Connection conne ;
	
	
	
	public Connection conectar () throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver") ;
		conne = DriverManager.getConnection("jdbc:mysql://127.0.0.1/inventario","root","root") ;
		return conne ;
	}
	
	public void desconectar () throws SQLException {
		
		conne.close();
		
	}
	
	
	
	
}
