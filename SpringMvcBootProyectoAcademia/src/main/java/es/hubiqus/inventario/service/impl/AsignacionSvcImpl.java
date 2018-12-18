package es.hubiqus.inventario.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import es.hubiqus.inventario.model.Alumno;
import es.hubiqus.inventario.model.Asignacion;
import es.hubiqus.inventario.model.Profesor;
import es.hubiqus.inventario.model.dao.AsignacionDao;
import es.hubiqus.inventario.model.dao.DaoException;
import es.hubiqus.inventario.service.AsignacionSvc;
import es.hubiqus.inventario.service.SvcException;

@Service
@Transactional
public class AsignacionSvcImpl implements AsignacionSvc {

	@Autowired
	private AsignacionDao dao;

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void borrarAsignacion(Asignacion asignacion) throws SvcException {

		try {
			asignacion = buscarPorId(asignacion.getId());
			dao.deleteAsignacion(asignacion);
		} catch (Exception ex) {
			throw new SvcException(ex);
		}

	}

	@Override
	public Asignacion buscarPorId(int id) throws SvcException {

		Asignacion res = null;

		try {
			res = dao.findById(id);
		} catch (Exception ex) {
			throw new SvcException(ex);
		}

		return res;

	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void guardarAsignacion(Asignacion asignacion) throws SvcException {

		try {
			dao.saveAsignacion(asignacion);
		} catch (DaoException ex) {
			throw new SvcException(ex);
		}

	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void modificarAsignacion(Asignacion asignacion) throws SvcException {

		try {
			dao.updateAsignacion(asignacion);
		} catch (DaoException ex) {
			throw new SvcException(ex);
		}

	}

	@Override
	public List<Asignacion> verAsignacionesPorProfesor(Profesor profesor) throws SvcException {
		List<Asignacion> res = null;
		try {
			res = dao.verAsignacionesByProfesor(profesor);
		} catch (DaoException ex) {
			throw new SvcException(ex);
		}

		return res;
	}

	@Override
	public List<Asignacion> verAsignacionesPorAlumno(Alumno alumno) throws SvcException {
		List<Asignacion> res = null;
		try {
			res = dao.verAsignacionesByAlumno(alumno);
		} catch (DaoException ex) {
			throw new SvcException(ex);
		}

		return res;
	}

}
