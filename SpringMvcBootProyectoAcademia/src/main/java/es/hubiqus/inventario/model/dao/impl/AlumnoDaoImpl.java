package es.hubiqus.inventario.model.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.hubiqus.inventario.model.Alumno;
import es.hubiqus.inventario.model.dao.AlumnoDao;
import es.hubiqus.inventario.model.dao.DaoException;

@Repository
public class AlumnoDaoImpl implements AlumnoDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Alumno findByUserAndPass(String user, String pass) throws DaoException {

		Alumno res = null;

		try {
			String hql = "FROM Alumno a WHERE a.user=:user " + "AND a.pass=:pass";
			res = (Alumno) sessionFactory.getCurrentSession().createQuery(hql).setParameter("user", user)
					.setParameter("pass", pass).uniqueResult();
		} catch (Exception ex) {
			throw new DaoException(ex);
		}

		return res;

	}

	@Override
	public Alumno findById(Integer id) throws DaoException {
		Alumno res = null;

		try {
			res = (Alumno) sessionFactory.getCurrentSession().get(Alumno.class, id);
		} catch (Exception ex) {
			throw new DaoException(ex);
		}

		return res;
	}
}
