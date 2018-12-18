package es.hubiqus.inventario.service;

import java.util.List;

import es.hubiqus.inventario.model.Alumno;
import es.hubiqus.inventario.model.Asignacion;
import es.hubiqus.inventario.model.Profesor;



public interface AsignacionSvc {

	/**
	 * ver todas las asignaciones de profesores que tiene un usuario alumno
	 * @param alumno   objeto por el que filtrar las asignaciones
	 * @return   lista con todas sus asignaciones
	 * @throws SvcException
	 */
	public List<Asignacion> verAsignacionesPorAlumno (Alumno alumno) throws SvcException ;
	
	/**
	 * ver todas las asignaciones de profesores que tiene un usuario profesor
	 * @param profesor   objeto por el que filtrar las asignaciones
	 * @return    lista con todas sus asignaciones
	 * @throws SvcException
	 */
	public List<Asignacion> verAsignacionesPorProfesor (Profesor profesor) throws SvcException ;
	
	
	/**
	 * el profesor podra borrar la asignacion que quiera
	 * @param asignacion    objeto que elimina el profesor
	 * @throws SvcException
	 */
	public void borrarAsignacion (Asignacion asignacion) throws SvcException ;
	
	
	/**
	 * el profesor modifica la asignacion que tiene para apuntar algun ejercicio a 
	 * su alumno
	 * @param asignacion   objeto que modifica el profesor
	 * @param ejercicio    objeto que actualiza en la asignacion (se lo pasaremos
	 * por una jsp)
	 * @throws SvcException
	 */
	public void modificarAsignacion (Asignacion asignacion) throws SvcException ;
	
	/**
	 * metodo para guardar una asignacion por parte del alumno
	 * @param asignacion   objeto que se guarda
	 * @throws SvcException
	 */
	public void guardarAsignacion (Asignacion asignacion) throws SvcException ;
	
	
	
	/**
	 * necesitamos este metodo para encontrar la asignacion que queremos borrar
	 * y luego borrarla
	 * @param id   es el id de la asignacion a borrar
	 * @return   asignacion con dicho id
	 * @throws SvcException
	 */
	public Asignacion buscarPorId (int id) throws SvcException ;
	
}
