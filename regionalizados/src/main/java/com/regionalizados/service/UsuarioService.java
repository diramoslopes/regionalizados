package com.regionalizados.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.regionalizados.model.Usuario;
import com.regionalizados.repository.UsuarioRepository;

@Service
public class UsuarioService implements UserDetailsService {
	
	@Autowired
	private UsuarioRepository usuarios;
	
	@Transactional(readOnly = true)
	public Usuario buscarPorUsuario(String usuario) {
		return usuarios.findByUsuario(usuario);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario usuario = usuarios.findByUsuario(username);
		
		return new User(
					usuario.getUsuario(),
					usuario.getSenha(), AuthorityUtils.NO_AUTHORITIES);
	}
	
}