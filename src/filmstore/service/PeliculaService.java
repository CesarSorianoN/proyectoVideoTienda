package filmstore.service;

import java.util.List;

import estructuras.lineales.ListaEnlazadaSimpleRecursiva;
import filmstore.dao.impl.PeliculaDAOImpl;
import filmstore.entity.Pelicula;

public class PeliculaService {

	private PeliculaDAOImpl dao = new PeliculaDAOImpl();
		
	public void save(Pelicula pelicula) {
		dao.save(pelicula);
	}
	
	public Pelicula getUsuario(long id) {
		return dao.getUsuario(id);
	}
	
	public List<Pelicula> list(){
		return dao.list();
	}
	
	public ListaEnlazadaSimpleRecursiva<Pelicula> lista(){
		return dao.lista();
	}
	
	public void remove(Pelicula pelicula) {
		dao.remove(pelicula);
	}
	 
	
	public void update(Pelicula pelicula) {
		dao.update(pelicula);
	}
}
