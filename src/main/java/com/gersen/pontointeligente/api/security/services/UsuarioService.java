package com.gersen.pontointeligente.api.security.services;

import java.util.Optional;

import com.gersen.pontointeligente.api.security.entities.Usuario;

public interface UsuarioService {

	/**
	 * Busca e retorna um usuário dado um email.
	 * 
	 * @param email
	 * @return Optional<Usuario>
	 */
	Optional<Usuario> buscarPorEmail(String email);

}
