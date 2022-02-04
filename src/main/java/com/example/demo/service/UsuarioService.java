package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuRepo;

	private HashSet<Usuario> listaUsuarios = new HashSet<>();

	/**
	 * Recibe un nombreUsuario y Contraseña. Devuelve true si existe ese usuario con
	 * esa contraseña
	 * 
	 * @param usuario
	 * @param password
	 * @return boolean respuesta
	 */
	public boolean compruebaUsuario(String usuario, String password) {

		boolean result = false;

		Usuario user = findById(usuario);

		if (user != null && user.getPassword().equals(password)) {

			result = true;

		}

		return result;

	}

	/**
	 * Recibe un nombreUsuario. Devuelve el usuario que tenga dicho nombre. Si no
	 * existe devuelve null.
	 * 
	 * @param nombreUsuario
	 * @return
	 */
	public Usuario obtenerUsuario(String nombreUsuario) {
		ArrayList<Usuario> arrayUsuarios = new ArrayList<>(listaUsuarios);

		Usuario result = null;

		boolean isEncontrado = false;
		int indice = 0;

		while (!isEncontrado && indice < arrayUsuarios.size()) {
			if ((nombreUsuario.equals(arrayUsuarios.get(indice).getUser()))) {
				isEncontrado = true;
				result = arrayUsuarios.get(indice);
			} else {
				indice++;
			}
		}

		return result;
	}

	public Usuario add(Usuario usuario) {
		return usuRepo.save(usuario);

	}

	public Usuario findById(String id) {
		return usuRepo.findById(id).orElse(null);
	}

	public Usuario saveUser(Usuario userLogado) {

		Usuario aux = usuRepo.getById(userLogado.getUser());
		aux.setListaPedidos(userLogado.getListaPedidos());

		return usuRepo.save(userLogado);
	}

}
