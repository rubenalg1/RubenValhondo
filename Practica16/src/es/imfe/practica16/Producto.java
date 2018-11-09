package es.imfe.practica16;

import java.util.Date;

public class Producto {

	private int id ;
	private String nombre ;
	private int cantidad ;
	private double precio ;
	private String comentario ;
	private Date fecha ;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
	
	
  @Override
  public String toString () {
		  
	return "Producto:" + " " + id +" " + nombre + " " + cantidad + " " + precio + " "+ comentario + " " + fecha ;
		  
   }
	 	
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
