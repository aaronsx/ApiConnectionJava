package com.example.demo.Controladores;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Servicios.UsuarioServicio;

import com.example.demo.Modelos.Usuario;


@RestController
@RequestMapping("/usuarioApi")
public class UsuarioController {
	
	@Autowired
	private UsuarioServicio usuarioServicio;
	
	@GetMapping("/usuarioSelect")
	public Iterable<Usuario> obtenerUsuario() {
		
		
	return this.usuarioServicio.getUsuario();
	}
	
	@GetMapping(path="/usuarioSelect/{id}")
	public Optional<Usuario> obtenerUsuarioID(@PathVariable("id") Long id) {
		
		
	return this.usuarioServicio.getUsuarioId(id);
	}
	@PostMapping("/usuarioInsertar")
	public void insertarUsuario(@RequestBody Usuario usuario) {
		this.usuarioServicio.insertarUsuario(usuario);
	}
	@PutMapping(path="/usuarioActualizar/{id}")
	public void actualizarUsuario(@RequestBody Usuario usuario,@PathVariable("id") Long id) {
		this.usuarioServicio.updateUsuario(usuario, id);
	}
	@DeleteMapping(path="/usuarioEliminar/{id}")
	public Boolean eliminarUsuario(@PathVariable("id") Long id) {
		return this.usuarioServicio.deleteUser(id);
	}
}
