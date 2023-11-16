package com.example.demo.Controladores;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Modelos.Acceso;
import com.example.demo.Servicios.AccesoServicio;


@RestController
@RequestMapping("/accesoApi")
public class AccesoController {

	@Autowired
	private AccesoServicio accesoServicio;
	
	@GetMapping("/accesoSelect")
	public Iterable<Acceso> obtenerAcceso() {	
	return this.accesoServicio.getAcceso();
	}
	
	@GetMapping(path="/accesoSelect/{id}")
	public Optional<Acceso> obtenerAccesoID(@PathVariable("id") Long id) {	
	return this.accesoServicio.getAccesoId(id);
	}
	
	@PostMapping("/accesoInsertar")
	public void insertarAcceso(@RequestBody Acceso acceso) {
		this.accesoServicio.insertarAcceso(acceso);
	}
	
	@PutMapping(path="/accesoActualizar/{id}")
	public void actualizarAcceso(@RequestBody Acceso acceso,@PathVariable("id") Long id) {
		this.accesoServicio.updateAcceso(acceso, id);
	}
	
	@DeleteMapping(path="/accesoEliminar/{id}")
	public Boolean eliminarAcceso(@PathVariable("id") Long id) {
		return this.accesoServicio.deleteAcceso(id);
	}
}
