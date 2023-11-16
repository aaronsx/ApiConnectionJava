package com.example.demo.Controladores;

import java.util.ArrayList;
import java.util.Optional;


import org.springframework.web.bind.annotation.*;
import com.example.demo.Modelos.Libro;
import com.example.demo.Servicios.LibroServicio;


@RestController
@RequestMapping("/libroApi")
public class LibroController {

	
	private LibroServicio libroServicio;
	
	@GetMapping("/libroSelect")
	public ArrayList<Libro> obtenerLibro() {	
	return this.libroServicio.getLibro();
	}
	
	@GetMapping(path="/libroSelect/{id}")
	public Optional<Libro> obtenerLibroID(@PathVariable("id") Long id) {
	return this.libroServicio.getLibroId(id);
	}
	
	@PostMapping("/libroInsertar")
	public void insertarLibro(@RequestBody Libro libro) {
		this.libroServicio.insertarLibro(libro);
	}
	
	@PutMapping(path="/libroActualizar/{id}")
	public void actualizarLibro(@RequestBody Libro libro,@PathVariable("id") Long id) {
		this.libroServicio.updateLibro(libro, id);
	}
	
	@DeleteMapping(path="/libroEliminar/{id}")
	public Boolean eliminarLibro(@PathVariable("id") Long id) {
		return this.libroServicio.deleteLibro(id);
	}
}
