package es.hubiqus.inventario.service;

import es.hubiqus.inventario.model.Alumno;

public interface AlumnoSvc {


	/**
	 * metodo que busca un alumno por su usuario y contrasena
	 * @param user  parametro de busqueda
	 * @param pass   parametro de busqueda
	 * @return   el alumno con dicho usuario y contrasena
	 * @throws SvcException
	 */
	public Alumno buscarPorUsuarioyContrasena (String user, String pass) throws SvcException ;


	/**
	 * metodo que busca un alumno por su id
	 * @param id   parametro de busqueda
	 * @return  el alumno con dicho id
	 * @throws SvcException
	 */
	
	public Alumno buscarPorId(Integer id) throws SvcException ;
}
