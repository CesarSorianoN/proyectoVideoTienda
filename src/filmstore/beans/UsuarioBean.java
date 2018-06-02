package filmstore.beans;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import filmstore.dao.impl.PeliculaDAOImpl;
import filmstore.entity.Pelicula;
import filmstore.entity.Usuario;
import filmstore.service.PeliculaService;
import filmstore.service.UserService;

@ManagedBean
@SessionScoped
public class UsuarioBean {

	private Usuario usuario = new Usuario();
	private UserService ps = new UserService();
	private String nombre;
	private String contraseña;
	private DataModel listarUsuario;

	public String validar() {

		String resultado = "";

		if (nombre.equals("admin") && contraseña.equals("123456")) {

			resultado = "principal";
			return resultado;

		}

		else {
			resultado = "inicio";
			return resultado;
		}

	}

	public DataModel<Pelicula> getListarPelicula() {
		List<Pelicula> pelicula = new PeliculaDAOImpl().list();
		listarUsuario = new ListDataModel<>(pelicula);

		return listarUsuario;
	}

	public String prepararAdicionarPelicula() {
		usuario = new Usuario();
		return "hola";
	}

	public String adicionarPelicula() {
		ps.save(usuario);
		return "inicio";
	}

	public String prepararModificarPelicula() {
		List<Pelicula> pel = new PeliculaDAOImpl().list();
		DataModel listaPeliculas = new ListDataModel<>(pel);
		usuario = (Usuario) (listaPeliculas.getRowData());
		return " ";
	}

	public String modificarPelicula() {
		ps.update(usuario);
		return "pagina de retorno";
	}

	public String prepararEliminarPelicula() {
		List<Pelicula> pel = new PeliculaDAOImpl().list();
		DataModel listaPeliculas = new ListDataModel<>(pel);
		usuario = (Usuario) (listaPeliculas.getRowData());
		return " ";
	}

	public String eliminarpelicula() {

		ps.update(usuario);
		return "pagina";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public DataModel getListarUsuario() {
		return listarUsuario;
	}

	public void setListarUsuario(DataModel listarUsuario) {
		this.listarUsuario = listarUsuario;
	}

}
