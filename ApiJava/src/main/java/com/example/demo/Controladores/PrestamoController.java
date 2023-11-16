package com.example.demo.Controladores;

import java.util.ArrayList;
import java.util.Optional;


import org.springframework.web.bind.annotation.*;
import com.example.demo.Modelos.Prestamo;
import com.example.demo.Servicios.PrestamoServicio;


@RestController
@RequestMapping("/prestamoApi")
public class PrestamoController {

	
	private PrestamoServicio prestamoServicio;
	
	@GetMapping("/prestamoSelect")
	public ArrayList<Prestamo> obtenerPrestamo() {	
	return this.prestamoServicio.getPrestamo();
	}
	
	@GetMapping(path="/prestamoSelect/{id}")
	public Optional<Prestamo> obtenerPrestamoID(@PathVariable("id") Long id) {	
	return this.prestamoServicio.getPrestamoId(id);
	}
	
	@PostMapping("/prestamoInsertar")
	public void insertarPrestamo(@RequestBody Prestamo prestamo) {
		this.prestamoServicio.insertarPrestamo(prestamo);
	}
	@PutMapping(path="/prestamoActualizar/{id}")
	public void actualizarPrestamo(@RequestBody Prestamo prestamo,@PathVariable("id") Long id) {
		this.prestamoServicio.updatePrestamo(prestamo, id);
	}
	@DeleteMapping(path="/prestamoEliminar/{id}")
	public Boolean eliminarPrestamo(@PathVariable("id") Long id) {
		return this.prestamoServicio.deletePrestamo(id);
	}
}

