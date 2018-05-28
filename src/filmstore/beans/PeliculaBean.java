package filmstore.beans;

import java.util.Date;
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
	
	private long precio;
	private String clasificacion;
	private Date anio;
	private String genero;
	private String titulo;
	
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
	
	public String modificarPelicula() {
		ps.update(pelicula);
		return "pagina de retorno";
	}
	
	public String prepararEliminarPelicula() {
		List<Pelicula> pel = new PeliculaDAOImpl().list();
		DataModel listaPeliculas = new ListDataModel<>(pel);
		pelicula = (Pelicula)(listaPeliculas.getRowData());
		return " ";
	}
	
	public String eliminarpelicula() {
		
		pelicula.setEstado("A");
		ps.update(pelicula);
		return "pagina";
	}
	
	public DataModel<Pelicula> buscarPorPrecio() {
		List<Pelicula> pelicula = new PeliculaDAOImpl().peliculaPorPrecio(precio); 
		peliculas = new ListDataModel<>(pelicula);
		
		return peliculas;
	}
	
	public DataModel<Pelicula> buscarPorClasificacion() {
		List<Pelicula> pelicula = new PeliculaDAOImpl().peliculaPorClasificacion(clasificacion); 
		peliculas = new ListDataModel<>(pelicula);
		
		return peliculas;
	}
	
	public DataModel<Pelicula> buscarPorAnio() {
		List<Pelicula> pelicula = new PeliculaDAOImpl().peliculaPorAnio(anio); 
		peliculas = new ListDataModel<>(pelicula);
		
		return peliculas;
	
		
	}
	
	public DataModel<Pelicula> buscarPorGenero() {
		List<Pelicula> pelicula = new PeliculaDAOImpl().peliculaPorGenero(genero)
				; 
		peliculas = new ListDataModel<>(pelicula);
		
		return peliculas;
	
		
	}
	
	public DataModel<Pelicula> buscarPorTitulo() {
		List<Pelicula> pelicula = new PeliculaDAOImpl().peliculaPorTitulo(titulo); 
		peliculas = new ListDataModel<>(pelicula);
		
		return peliculas;
	
		
	}
}
