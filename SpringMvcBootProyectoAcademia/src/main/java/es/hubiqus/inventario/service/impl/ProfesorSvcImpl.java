package es.hubiqus.inventario.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.hubiqus.inventario.model.Profesor;
import es.hubiqus.inventario.model.dao.DaoException;
import es.hubiqus.inventario.model.dao.ProfesorDao;
import es.hubiqus.inventario.service.ProfesorSvc;
import es.hubiqus.inventario.service.SvcException;

@Service
@Transactional
public class ProfesorSvcImpl implements ProfesorSvc {

	@Autowired
	private ProfesorDao dao;

	public List<Profesor> verProfesores() throws SvcException {

		List<Profesor> res = null;

		try {
			res = dao.findAll();
		} catch (DaoException e) {
			throw new SvcException(e);
		}

		return res;
	}

	public List<Profesor> buscarPorMateria(String materia) throws SvcException {

		List<Profesor> res = null;

		try {
			res = dao.findByMateria(materia);
		} catch (DaoException e) {
			throw new SvcException(e);
		}

		return res;

	}

	public Profesor buscarPorId(Integer id) throws SvcException {

		Profesor res = null;
		try {
			res = dao.findById(id);
		} catch (DaoException e) {
			throw new SvcException(e);
		}

		return res;
	}

	public Profesor buscarPorUsuarioyContrasena(String user, String pass) throws SvcException {

		Profesor res = null;
		try {
			res = dao.findByUserAndPass(user, pass);
		} catch (DaoException e) {
			throw new SvcException(e);
		}

		return res;

	}

}
