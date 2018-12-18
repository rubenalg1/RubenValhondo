package es.hubiqus.inventario.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="asignacion")
public class Asignacion {

	private Integer id ;
	private Date fecha ;
	private String ejercicio ;
	private Profesor profesor ;
	private Alumno alumno ;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	
	public String getEjercicio() {
		return ejercicio;
	}
	public void setEjercicio(String ejercicio) {
		this.ejercicio = ejercicio;
	}
	
	
	@ManyToOne
	@JoinColumn(name="profesoresId")
	public Profesor getProfesor() {
		return profesor;
	}
	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
	

	@ManyToOne
	@JoinColumn(name="alumnosId")
	public Alumno getAlumno() {
		return alumno;
	}
	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
