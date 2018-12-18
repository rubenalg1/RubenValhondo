package es.hubiqus.inventario.model.dao;

import es.hubiqus.inventario.model.Alumno;

public interface AlumnoDao {

	/**
	 * metodo que busca un alumno del sistema por su usuario y clave al hacer login
	 * @return   alumno que encuentra
	 * @throws DaoException   error de base de datos
	 */
	public Alumno findByUserAndPass (String user, String pass) throws DaoException ;
	
	/**
	 * metodo que busca un alumno del sistema por su id
	 * @param id   objeto por el que buscar
	 * @return   el alumno con ese id
	 * @throws DaoException    error de base de datos
	 */
	public Alumno findById(Integer id) throws DaoException ;
}
