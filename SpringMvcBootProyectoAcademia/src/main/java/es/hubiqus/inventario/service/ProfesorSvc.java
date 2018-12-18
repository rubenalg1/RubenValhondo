package es.hubiqus.inventario.service;

import java.util.List;

import es.hubiqus.inventario.model.Profesor;



public interface ProfesorSvc {
   
	/**
	 * ver todos los profesores de la pagina
	 * @return  lista de todos los profesores de la base de datos
	 * @throws SvcException
	 */
	
	public List <Profesor> verProfesores () throws SvcException;
	
	
	/**
	 * ver los profesores de la pagina que imparten una materia 
	 * @param materia  objeto por el que buscar
	 * @return    lista de profesores que imparten una materia
	 * @throws SvcException
	 */
	public List<Profesor> buscarPorMateria (String materia) throws SvcException ;
		
		
	/**
	 * busca el profesor que tiene un id
	 * @param id  parametro de busqueda
	 * @return  el profesor con dicho id
	 * @throws SvcException
	 */
	
	
	
	public Profesor buscarPorId (Integer id) throws SvcException ;

	/**
	 * metodo que devuelve un profesor que tiene un usuario y una contrasena
	 * @param user   parametro de busqueda
	 * @param pass   parametro de busqueda
	 * @return el profesor que tiene dicho usuario y contrasena
	 * @throws SvcException
	 */
	
	public Profesor buscarPorUsuarioyContrasena (String user, String pass) throws SvcException ;
	
	
}
