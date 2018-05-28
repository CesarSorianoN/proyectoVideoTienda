package filmstore.dao;

import java.util.List;

import estructuras.lineales.ListaEnlazadaSimpleRecursiva;
import filmstore.entity.Pelicula;


public interface PeliculaDAO {

	public void save(Pelicula pelicula);
	
	public Pelicula getUsuario(long id);
	
	public List<Pelicula> list();
	
	public ListaEnlazadaSimpleRecursiva<Pelicula> lista();
	
	public void remove(Pelicula pelicula);
	 
	
	public void update(Pelicula pelicula);
	
	
}
