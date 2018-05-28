package filmstore.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import filmstore.dao.impl.PeliculaDAOImpl;
import filmstore.entity.Pelicula;
import filmstore.service.PeliculaService;

@ManagedBean
public class PeliculaBean {

	private Pelicula pelicula;
	private DataModel<Pelicula> peliculas;
	private PeliculaService ps = new PeliculaService();
	
	public Pelicula getPelicula() {
		return pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}
	
	public DataModel<Pelicula> getListarPelicula(){
		List<Pelicula> pelicula = new PeliculaDAOImpl().list(); 
		peliculas = new ListDataModel<>(pelicula);
		
		return peliculas;
	}
	
	public String prepararAdicionarPelicula() {
		pelicula = new Pelicula();
		
		return "pagina de adicionar";
	}
	
	public String adicionarPelicula() {
		ps.save(pelicula);
		
		return "pagina inicio";
	}
	
	public String prepararModificarPelicula() {
		List<Pelicula> pel = new PeliculaDAOImpl().list();
		DataModel listaPeliculas = new ListDataModel<>(pel);
		pelicula = (Pelicula)(listaPeliculas.getRowData());
		return " ";
	}
	
}
