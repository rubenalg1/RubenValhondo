package es.hubiqus.inventario.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="profesores")
public class Profesor {
	
	private Integer id ;
	private String user ;
	private String pass ;
	private String nombre ;
	private String materia ;
	private String curso ;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@NotEmpty
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	
	@NotEmpty
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	@NotEmpty
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	@NotEmpty
	public String getMateria() {
		return materia;
	}
	public void setMateria(String materia) {
		this.materia = materia;
	}
	
	@NotEmpty
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	
	
	
	
	
	
	
	
	
	
	

}
