package filmstore.beans;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import org.apache.log4j.Logger;
import filmstore.dao.impl.PeliculaDAOImpl;
import filmstore.entity.Pelicula;
import filmstore.service.PeliculaService;

@ManagedBean
@SessionScoped
public class PeliculaBean {

	private Pelicula pelicula;
	private DataModel<Pelicula> peliculas;
	private PeliculaService ps = new PeliculaService();
	private DataModel<Pelicula> buscada;
	private long precio;
	private String clasificacion;
	private Date anio;
	private String genero;
	private String titulo;
	
	final static Logger log = Logger.getLogger(PeliculaBean.class);

	public Pelicula getPelicula() {
		return pelicula;
	}

	public DataModel<Pelicula> getPeliculas() {
		return peliculas;
	}

	public void setPeliculas(DataModel<Pelicula> peliculas) {
		this.peliculas = peliculas;
	}

	public PeliculaService getPs() {
		return ps;
	}

	public void setPs(PeliculaService ps) {
		this.ps = ps;
	}

	public long getPrecio() {
		return precio;
	}

	public void setPrecio(long precio) {
		this.precio = precio;
	}

	public String getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}

	public Date getAnio() {
		return anio;
	}

	public void setAnio(Date anio) {
		this.anio = anio;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	public DataModel<Pelicula> getListarPelicula() {
		List<Pelicula> pelicula = new PeliculaDAOImpl().list();
		peliculas = new ListDataModel<>(pelicula);

		return peliculas;
	}

	public String prepararAdicionarPelicula() {
		pelicula = new Pelicula();
		pelicula.setAnio(new Date());
		return "agregarPelicula";
	}

	public String adicionarPelicula() {
		PeliculaService dao = new PeliculaService();
		dao.save(pelicula);
		return "principal";
	}

	public String prepararModificarPelicula() {
		List<Pelicula> pel = new PeliculaDAOImpl().list();
		DataModel listaPeliculas = new ListDataModel<>(pel);
		pelicula = (Pelicula) (listaPeliculas.getRowData());
		return "modificarPelicula";
	}

	public String modificarPelicula() {
		ps.update(pelicula);
		return "principal";
	}

	public String prepararEliminarPelicula() {
		List<Pelicula> pel = new PeliculaDAOImpl().list();
		DataModel listaPeliculas = new ListDataModel<>(pel);
		pelicula = (Pelicula) (listaPeliculas.getRowData());
		return " ";
	}

	public String eliminarpelicula() {
		Pelicula usuarioTemp = (Pelicula) (peliculas.getRowData());
		PeliculaService dao = new PeliculaService();
		dao.remove(usuarioTemp);
		return "inicio";
	}

	public DataModel<Pelicula> getBuscada() {
		return buscada;
	}

	public void setBuscada(DataModel<Pelicula> buscada) {
		this.buscada = buscada;
	}

	public String buscarPorPrecio() {
		List<Pelicula> pelicula = new PeliculaDAOImpl().peliculaPorPrecio(precio);
		buscada = new ListDataModel<>(pelicula);
		return "buscarTitulo";
	}

	public String buscarPorClasificacion() {
		List<Pelicula> pelicula = new PeliculaDAOImpl().peliculaPorClasificacion(clasificacion);
		buscada = new ListDataModel<>(pelicula);
		return "buscarTitulo";
	}

	public String buscarPorAnio() {
		List<Pelicula> pelicula = new PeliculaDAOImpl().peliculaPorAnio(anio);
		buscada = new ListDataModel<>(pelicula);
		return "buscarTitulo";
	}

	public String buscarPorGenero() {
		List<Pelicula> pelicula = new PeliculaDAOImpl().peliculaPorGenero(genero);
		buscada = new ListDataModel<>(pelicula);
		return "buscarTitulo";
	}

	public String buscarPorTitulo() {
		List<Pelicula> pelicula = new PeliculaDAOImpl().peliculaPorTitulo(titulo);
		buscada = new ListDataModel<>(pelicula);
		return "buscarTitulo";
	}
	
	public String rentar() {
		Pelicula usuarioTemp = (Pelicula) (peliculas.getRowData());
		BigInteger aux = new BigInteger("0");
		if(usuarioTemp.getCantidad().equals(aux)) {
			log.debug("Producto agotado");
			return "principalUser";
		}else {
			PeliculaService dao = new PeliculaService();
			usuarioTemp.setCantidad(usuarioTemp.getCantidad().subtract(new BigInteger("1")));
			dao.update(usuarioTemp);
			return "inicio";
		}
	}
}
