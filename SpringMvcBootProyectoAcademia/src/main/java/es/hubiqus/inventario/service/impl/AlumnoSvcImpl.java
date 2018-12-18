package es.hubiqus.inventario.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.hubiqus.inventario.model.Alumno;
import es.hubiqus.inventario.model.dao.AlumnoDao;
import es.hubiqus.inventario.model.dao.DaoException;
import es.hubiqus.inventario.service.AlumnoSvc;
import es.hubiqus.inventario.service.SvcException;

@Service
@Transactional
public class AlumnoSvcImpl implements AlumnoSvc {

	@Autowired
	private AlumnoDao dao;

	@Override
	public Alumno buscarPorUsuarioyContrasena(String user, String pass) throws SvcException {

		Alumno res = null;
		try {
			res = dao.findByUserAndPass(user, pass);
		} catch (DaoException e) {
			throw new SvcException(e);
		}

		return res;
	}

	public Alumno buscarPorId(Integer id) throws SvcException {

		Alumno res = null;
		try {
			res = dao.findById(id);
		} catch (DaoException e) {
			throw new SvcException(e);
		}

		return res;

	}

}
