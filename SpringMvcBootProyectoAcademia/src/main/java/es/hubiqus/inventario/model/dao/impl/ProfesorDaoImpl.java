package es.hubiqus.inventario.model.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.hubiqus.inventario.model.Profesor;
import es.hubiqus.inventario.model.dao.DaoException;
import es.hubiqus.inventario.model.dao.ProfesorDao;

@Repository
public class ProfesorDaoImpl implements ProfesorDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Profesor> findAll() throws DaoException {
		List<Profesor> res = null;

		try {
			String hql = "FROM Profesor";
			res = sessionFactory.getCurrentSession().createQuery(hql).list();
		} catch (Exception ex) {
			throw new DaoException(ex);
		}

		return res;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Profesor> findByMateria(String materia) throws DaoException {

		List<Profesor> res = null;

		try {
			String hql = "FROM Profesor p WHERE p.materia LIKE :materia";
			res = sessionFactory.getCurrentSession().createQuery(hql).setParameter("materia", "%" + materia + "%")
					.list();
		} catch (Exception ex) {
			throw new DaoException(ex);
		}

		return res;

	}

	@Override
	public Profesor findById(Integer id) throws DaoException {

		Profesor res = null;

		try {
			res = (Profesor) sessionFactory.getCurrentSession().get(Profesor.class, id);
		} catch (Exception ex) {
			throw new DaoException(ex);
		}

		return res;

	}

	@Override
	public Profesor findByUserAndPass(String user, String pass) throws DaoException {

		Profesor res = null;

		try {
			String hql = "FROM Profesor p WHERE p.user=:user " + "AND p.pass=:pass";
			res = (Profesor) sessionFactory.getCurrentSession().createQuery(hql).setParameter("user", user)
					.setParameter("pass", pass).uniqueResult();
		} catch (Exception ex) {
			throw new DaoException(ex);
		}

		return res;

	}

}
