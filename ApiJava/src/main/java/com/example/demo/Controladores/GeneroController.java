package com.example.demo.Controladores;

import java.util.ArrayList;
import java.util.Optional;


import org.springframework.web.bind.annotation.*;
import com.example.demo.Modelos.Genero;
import com.example.demo.Servicios.GeneroServicio;

@RestController
@RequestMapping("/generoApi")
public class GeneroController {

	
	private GeneroServicio generoServicio;
	
	@GetMapping("/generoSelect")
	public ArrayList<Genero> obtenerGenero() {
	return this.generoServicio.getGenero();
	}
	
	@GetMapping(path="/generoSelect/{id}")
	public Optional<Genero> obtenerGeneroID(@PathVariable("id") Long id) {
	return this.generoServicio.getGeneroId(id);
	}
	
	@PostMapping("/generoInsertar")
	public void insertarGenero(@RequestBody Genero genero) {
		this.generoServicio.insertarGenero(genero);
	}
	
	@PutMapping(path="/generoActualizar/{id}")
	public void actualizarGenero(@RequestBody Genero genero,@PathVariable("id") Long id) {
		this.generoServicio.updateGenero(genero, id);
	}
	
	@DeleteMapping(path="/generoEliminar/{id}")
	public Boolean eliminarGenero(@PathVariable("id") Long id) {
		return this.generoServicio.deleteGenero(id);
	}
}