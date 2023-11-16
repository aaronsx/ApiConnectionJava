package com.example.demo.Controladores;

import java.util.ArrayList;
import java.util.Optional;


import org.springframework.web.bind.annotation.*;
import com.example.demo.Modelos.Editorial;
import com.example.demo.Servicios.EditorialServicio;


@RestController
@RequestMapping("/editorialApi")
public class EditorialController {

	
	private EditorialServicio editorialServicio;
	
	@GetMapping("/editorialSelect")
	public ArrayList<Editorial> obtenerEditorial() {
	return this.editorialServicio.getEditorial();
	}
	
	@GetMapping(path="/editorialSelect/{id}")
	public Optional<Editorial> obtenerEditorialID(@PathVariable("id") Long id) {	
	return this.editorialServicio.getEditorialId(id);
	}
	
	@PostMapping("/editorialInsertar")
	public void insertarEditorial(@RequestBody Editorial editorial) {
		this.editorialServicio.insertarEditorial(editorial);
	}
	
	@PutMapping(path="/editorialActualizar/{id}")
	public void actualizarEditorial(@RequestBody Editorial editorial,@PathVariable("id") Long id) {
		this.editorialServicio.updateEditorial(editorial, id);
	}
	
	@DeleteMapping(path="/editorialEliminar/{id}")
	public Boolean eliminarEditorial(@PathVariable("id") Long id) {
		return this.editorialServicio.deleteEditorial(id);
	}
}
