package es.hubiqus.inventario.model.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.hubiqus.inventario.model.Alumno;
import es.hubiqus.inventario.model.Asignacion;
import es.hubiqus.inventario.model.Profesor;
import es.hubiqus.inventario.model.dao.AsignacionDao;
import es.hubiqus.inventario.model.dao.DaoException;

@Repository
public class AsignacionDaoImpl implements AsignacionDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveAsignacion(Asignacion asignacion) throws DaoException {
		try {
			sessionFactory.getCurrentSession().save(asignacion);
		} catch (Exception ex) {
			throw new DaoException(ex);
		}
	}

	@Override
	public void updateAsignacion(Asignacion asignacion) throws DaoException {
		try {
			sessionFactory.getCurrentSession().update(asignacion);
		} catch (Exception ex) {
			throw new DaoException(ex);
		}

	}

	@Override
	public void deleteAsignacion(Asignacion asignacion) throws DaoException {
		try {
			sessionFactory.getCurrentSession().delete(asignacion);
		} catch (Exception ex) {
			throw new DaoException(ex);
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Asignacion> verAsignacionesByAlumno(Alumno alumno) throws DaoException {

		List<Asignacion> res = null;

		try {
			String hql = "FROM Asignacion a WHERE a.alumno = :alumno";
			res = sessionFactory.getCurrentSession().createQuery(hql).setParameter("alumno", alumno).list();
		} catch (Exception ex) {
			throw new DaoException(ex);
		}

		return res;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Asignacion> verAsignacionesByProfesor(Profesor profesor) throws DaoException {

		List<Asignacion> res = null;

		try {
			String hql = "FROM Asignacion a WHERE a.profesor = :profesor";
			res = sessionFactory.getCurrentSession().createQuery(hql).setParameter("profesor", profesor).list();
		} catch (Exception ex) {
			throw new DaoException(ex);
		}

		return res;

	}

	public Asignacion findById(int id) throws DaoException {

		Asignacion res = null;

		try {
			res = (Asignacion) sessionFactory.getCurrentSession().get(Asignacion.class, id);
		} catch (Exception ex) {
			throw new DaoException(ex);
		}

		return res;

	}

}
