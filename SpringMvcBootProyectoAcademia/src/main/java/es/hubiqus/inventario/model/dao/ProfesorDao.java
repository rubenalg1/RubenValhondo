package es.hubiqus.inventario.model.dao;

import java.util.List;

import es.hubiqus.inventario.model.Profesor;


public interface ProfesorDao {

	/**
	 * lista con todos los profesores
	 * @return devuelve una lista de todos los profesores de la base de datos
	 * @throws DaoException     error de base de datos
	 */
	
	public List<Profesor> findAll () throws DaoException ;
	
	/**
	 *  lista de profesores por materia
	 * @param materia    por la que filtrar los profesores
	 * @return   devuelve una lista de los profesores que imparten una materia
	 * @throws DaoException    error de base de datos
	 */
	
	public List<Profesor> findByMateria (String materia) throws DaoException ;
	
	
	/**
	 * devuelve el profesor que tiene dicho id en la base de datos
	 * @param id   parametro por el que buscar
	 * @return   profesor con dicho id
	 * @throws DaoException     error de base de datos
	 */
	
	
	
	public Profesor findById (Integer id) throws DaoException ;
	
	/**
	 * devuelve el profesor que tiene ese user y pass
	 * @param user  parametro de busqueda
	 * @param pass   parametro de busqueda
	 * @return  profesor buscado
	 * @throws DaoException    error de base de datos
	 */
	
	
	public Profesor findByUserAndPass (String user, String pass) throws DaoException ;
	
	
}
