package com.example.demo.Controladores;

import java.util.ArrayList;
import java.util.Optional;


import org.springframework.web.bind.annotation.*;
import com.example.demo.Modelos.Autor;
import com.example.demo.Servicios.AutorServicio;


@RestController
@RequestMapping("/autorApi")
public class AutorController {


	private AutorServicio autorServicio;
	
	@GetMapping("/autorSelect")
	public ArrayList<Autor> obtenerAutor() {	
	return this.autorServicio.getAutor();
	}
	
	@GetMapping(path="/autorSelect/{id}")
	public Optional<Autor> obtenerAutorID(@PathVariable("id") Long id) {
	return this.autorServicio.getAutorId(id);
	}
	
	@PostMapping("/autorInsertar")
	public void insertarAutor(@RequestBody Autor autor) {
		this.autorServicio.insertarAutor(autor);
	}
	
	@PutMapping(path="/autorActualizar/{id}")
	public void actualizarAutor(@RequestBody Autor autor,@PathVariable("id") Long id) {
		this.autorServicio.updateAutor(autor, id);
	}
	
	@DeleteMapping(path="/autorEliminar/{id}")
	public Boolean eliminarAutor(@PathVariable("id") Long id) {
		return this.autorServicio.deleteAutor(id);
	}
}
