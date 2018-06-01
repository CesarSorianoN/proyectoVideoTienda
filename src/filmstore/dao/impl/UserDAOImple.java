package filmstore.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import estructuras.lineales.ListaEnlazadaSimpleRecursiva;
import filmstore.dao.UserDAO;
import filmstore.entity.Pelicula;
import filmstore.entity.Usuario;
import filmstore.util.HibernateUtil;

public class UserDAOImple implements UserDAO {

	@Override
	public void save(Usuario usuario) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(usuario);
		t.commit();
	}

	@Override
	public List<Usuario> list() {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		List lista = session.createQuery("from Usuario").list();
		t.commit();
		return lista;
	}

	@Override
	public void remove(Usuario usuario) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.update(usuario);
		t.commit();
	}

	@Override
	public void update(Usuario usuario) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.update(usuario);
		t.commit();
	}

	@Override
	public Usuario getUsuario(long id) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		return (Usuario) session.load(Usuario.class, id);
	}
	
	@Override
	public Usuario verificarUsuario(String userName) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		return  (Usuario) session.createQuery("from usuario WHERE nombre = '" + userName + "'").uniqueResult();

	}

}
