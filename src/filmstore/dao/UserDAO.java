package filmstore.dao;

import java.util.List;

import estructuras.lineales.ListaEnlazadaSimpleRecursiva;
import filmstore.entity.Pelicula;
import filmstore.entity.Usuario;

public interface UserDAO {

	public void save(Usuario usuario);

	public Usuario getUsuario(long id);

	public List<Usuario> list();

	public void remove(Usuario usuario);
	
	public void update(Usuario usuario);
	
	public Usuario verificarUsuario(String userName);

}
