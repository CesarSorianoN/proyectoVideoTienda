package filmstore.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;

import filmstore.dao.impl.PeliculaDAOImpl;
import filmstore.entity.Pelicula;

@ManagedBean
public class PeliculaBean {

	private Pelicula pelicula;
	private List<Pelicula> peliculas;
	
	public Pelicula getPelicula() {
		return pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}
	
	public List<Pelicula> getListarPelicula(){
		
		peliculas = new PeliculaDAOImpl().list();
		
		return peliculas;
	}
	
	
	
}
