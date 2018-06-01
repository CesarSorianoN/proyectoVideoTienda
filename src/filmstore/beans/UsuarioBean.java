package filmstore.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;

import filmstore.entity.Usuario;
import filmstore.service.UserService;

@ManagedBean
@SessionScoped
public class UsuarioBean {

	private Usuario usuario;
	private String nombre;
	private String contraseña;
	private DataModel listarUsuario;

	public String validar() {
		
		UserService us = new UserService();
		usuario = us.verificarUsuario(nombre);
		String resultado = "";

		if (usuario.getNombre().equals(nombre) && usuario.getContraseña().equals(contraseña)) {

			resultado = "principal";
			return resultado;

		}

		else {
			resultado = "inicio";
			return resultado;
		}

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
