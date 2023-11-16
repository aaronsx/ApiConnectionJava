package com.example.demo.Controladores;

import java.util.ArrayList;
import java.util.Optional;


import org.springframework.web.bind.annotation.*;
import com.example.demo.Modelos.Coleccion;
import com.example.demo.Servicios.ColeccionServicio;


@RestController
@RequestMapping("/coleccionApi")
public class ColeccionController {

	
	private ColeccionServicio coleccionServicio;
	
	@GetMapping("/coleccionSelect")
	public ArrayList<Coleccion> obtenerColeccion() {
	return this.coleccionServicio.getColeccion();
	}
	
	@GetMapping(path="/coleccionSelect/{id}")
	public Optional<Coleccion> obtenerColeccionID(@PathVariable("id") Long id) {	
	return this.coleccionServicio.getColeccionId(id);
	}
	
	@PostMapping("/coleccionInsertar")
	public void insertarColeccion(@RequestBody Coleccion coleccion) {
		this.coleccionServicio.insertarColeccion(coleccion);
	}
	
	@PutMapping(path="/coleccionActualizar/{id}")
	public void actualizarColeccion(@RequestBody Coleccion coleccion,@PathVariable("id") Long id) {
		this.coleccionServicio.updateColeccion(coleccion, id);
	}
	
	@DeleteMapping(path="/coleccionEliminar/{id}")
	public Boolean eliminarColeccion(@PathVariable("id") Long id) {
		return this.coleccionServicio.deleteColeccion(id);
	}
}
