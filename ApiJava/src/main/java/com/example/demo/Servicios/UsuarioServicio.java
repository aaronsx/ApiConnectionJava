package com.example.demo.Servicios;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.Modelos.Usuario;
import com.example.demo.Modelos.UsuarioRepositorio;

@Service
public class UsuarioServicio {

	@Autowired
	UsuarioRepositorio usuarioRepositorio;
	
	public Iterable<Usuario> getUsuario()
	{
		return usuarioRepositorio.findAll();
	}
	
	public void insertarUsuario(Usuario usuario)
	{
		usuarioRepositorio.save(usuario);
	}
	
	public Optional<Usuario> getUsuarioId(Long id)
	{
		return usuarioRepositorio.findById(id);
	}
	
	
	public void updateUsuario(Usuario usuario,Long id)
	{
		Usuario usuarioObetnido=usuarioRepositorio.findById(id).get();
		
		usuarioObetnido.setDniUsuario(usuario.getDniUsuario());
		usuarioObetnido.setNombreUsuario(usuario.getNombreUsuario());
		usuarioObetnido.setApellidosUsuario(usuario.getApellidosUsuario());
		usuarioObetnido.setTlfUsuario(usuario.getTlfUsuario());
		usuarioObetnido.setEmailUsuario(usuario.getEmailUsuario());
		usuarioObetnido.setClaveUsuario(usuario.getClaveUsuario());
		usuarioRepositorio.save(usuarioObetnido);
	}
	
	public Boolean deleteUser(Long id) {
		try {
			usuarioRepositorio.deleteById(id);
			return true;
		}catch(IllegalArgumentException e)
		{
			return false;
		}
		
	}
}