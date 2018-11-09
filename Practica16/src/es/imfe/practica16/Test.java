package es.imfe.practica16;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		
		Producto p = new Producto () ;
		p.setNombre("agua");
		p.setCantidad(10);
		p.setPrecio(0.75);
		p.setComentario("Mineral");
		p.setFecha(new Date ());
		ProductoDao dao = new ProductoDao ();
		try {
			dao.insertar(p);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Producto p2 = new Producto () ;
		p2.setNombre("zumo");
		p2.setCantidad(5);
		p2.setPrecio(0.55);
		p2.setComentario("Naranja");
		p2.setFecha(new Date ());
        try {
			dao.insertar(p2);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	   try {
		 List<Producto> lista = dao.listar("agua") ;
	     for(Producto ite : lista) {
		 System.out.println(p);
	    }
	   } catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	
	
	
	}
	
	
	}

}
