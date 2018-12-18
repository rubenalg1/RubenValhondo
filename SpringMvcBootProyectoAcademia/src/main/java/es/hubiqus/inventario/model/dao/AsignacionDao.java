package es.hubiqus.inventario.model.dao;

import java.util.List;

import es.hubiqus.inventario.model.Alumno;
import es.hubiqus.inventario.model.Asignacion;
import es.hubiqus.inventario.model.Profesor;


public interface AsignacionDao {
  
	/**
    *  ver las asignaciones de un usuario alumno
    * @param idalumno   se veran las asignaciones del alumno de esta id
    * @return    lista de sus asignaciones
    * @throws DaoException   error de base de datos
   */
	
	public List<Asignacion> verAsignacionesByAlumno (Alumno alumno) throws DaoException ;
	
	/**
	 * ver las asignaciones de un usuario profesor
	 * @param idprofesor    se veran las asignaciones del profesor con esa id
	 * @return     lista de sus asignaciones
	 * @throws DaoException    error de base de datos
	 */
	
	public List<Asignacion> verAsignacionesByProfesor (Profesor profesor) throws DaoException ;
	
	/**
	 * borra una asignacion
	 * @param id     elemento a borrar (borra una asignacion que tenga un profesor)
	 * @throws DaoException   error de base de datos
	 */
	
	
	public void deleteAsignacion (Asignacion asignacion) throws DaoException ;
	
	/**
	 * modifica una asignacion (el registro ejercicio)
	 * @param id    modifica la asignacion con esta id
	 * @param ejercicio    escribe el ejercicio correspondiente  (se le pasa desde
	 * una jsp)
	 * @throws DaoException    error de base de datos
	 */
	
	//Esto tendra que ser el update de Hibernate, y la actualiza entera (el 
	//String ejercicio se le pasara desde una jsp) Asi que tendremos que el modificar
	// solo toma como parametro una Asignacion.
	public void updateAsignacion (Asignacion asignacion) throws DaoException ;
		
	/**
	 * metodo para guardar una asignacion
	 * @param asignacion  objeto que se guarda
	 * @throws DaoException   error de base de datos
	 */
	public void saveAsignacion (Asignacion asignacion) throws DaoException ;
	
	/**
	 * metodo que devuelve una asignacion que tiene un id dado en la base de datos
	 * @param id  parametro de busqueda
	 * @return  la asignacion que tiene dicho id
	 * @throws DaoException
	 */
	
	public Asignacion findById (int id) throws DaoException;
}
