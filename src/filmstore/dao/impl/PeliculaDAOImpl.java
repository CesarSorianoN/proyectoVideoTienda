package filmstore.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import estructuras.lineales.ListaEnlazadaSimpleIterativa;
import estructuras.lineales.ListaEnlazadaSimpleRecursiva;
import filmstore.dao.PeliculaDAO;
import filmstore.entity.Pelicula;
import filmstore.util.HibernateUtil;
import interfaces.IListaEnlazada;

public class PeliculaDAOImpl implements PeliculaDAO {

	@Override
	public void save(Pelicula pelicula) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(pelicula);
		t.commit();
	}

	@Override
	public Pelicula getUsuario(long id) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		return (Pelicula) session.load(Pelicula.class, id);
	}

	@Override
	public List<Pelicula> list() {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		List lista = session.createQuery("from Pelicula").list();
		t.commit();
		return lista;
	}

	@Override
	public ListaEnlazadaSimpleRecursiva<Pelicula> lista() {

		// se realiza de esta manera porque nuestras listas no implementan la interface
		// list
		ListaEnlazadaSimpleRecursiva<Pelicula> pelicula = new ListaEnlazadaSimpleRecursiva<>();
		List<Pelicula> pel = list();
		for (int i = 0; i < pel.size(); i++) {
			pelicula.agregar(pel.get(i));
		}
		return pelicula;
	}

	@Override
	public void remove(Pelicula pelicula) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.delete(pelicula);
		t.commit();

	}

	@Override
	public void update(Pelicula pelicula) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.update(pelicula);
		t.commit();
	}

	@Override
	public List<Pelicula> peliculaPorPrecio(long precio) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		List lista = session.createQuery("from Pelicula WHERE precio = '" + precio+"'").list();
		t.commit();
		return lista;
	}

	@Override
	public List<Pelicula> peliculaPorClasificacion(String clasificacion) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		List lista = session.createQuery("from Pelicula WHERE clasificacion = '"+ clasificacion+"'").list();
		t.commit();
		return lista;
	}

	@Override
	public List<Pelicula> peliculaPorAnio(Date anio) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		List lista = session.createQuery("from Pelicula WHERE anio = '"+ anio +"'").list();
		t.commit();
		return lista;
	}

	@Override
	public List<Pelicula> peliculaPorGenero(String genero) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		List lista = session.createQuery("from Pelicula WHERE genero = '"+genero +"'").list();
		t.commit();
		return lista;
	}

	@Override
	public List<Pelicula> peliculaPorTitulo(String titulo) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		List lista = session.createQuery("from Pelicula WHERE titulo ='" + titulo +"'").list();
		t.commit();
		return lista;
	}
}
