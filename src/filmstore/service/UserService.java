package filmstore.service;

import java.util.List;


import filmstore.dao.impl.UserDAOImple;
import filmstore.entity.Usuario;

public class UserService {
private UserDAOImple dao = new UserDAOImple();
	
	
	public void save(Usuario usuario) {
		dao.save(usuario);
	}

	public Usuario getUsuario(long id) {
		return dao.getUsuario(id);
	}
	
	public List<Usuario> list(){
		return dao.list();
	}
	
	public void remove(Usuario usuario) {
		dao.remove(usuario);
	}
	
	public void update(Usuario usuario) {
		dao.update(usuario);
	}
	
	public Usuario verificarUsuario(String userName) {
		
		return dao.verificarUsuario(userName);
	}
}
