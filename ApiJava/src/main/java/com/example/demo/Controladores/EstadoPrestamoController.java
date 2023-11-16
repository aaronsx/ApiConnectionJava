package com.example.demo.Controladores;

import java.util.ArrayList;
import java.util.Optional;


import org.springframework.web.bind.annotation.*;
import com.example.demo.Modelos.EstadoPrestamo;
import com.example.demo.Servicios.EstadoPrestamoServicio;


@RestController
@RequestMapping("/estadoPrestamoApi")
public class EstadoPrestamoController {

	
	private EstadoPrestamoServicio estadoPrestamoServicio;
	
	@GetMapping("/estadoPrestamoSelect")
	public ArrayList<EstadoPrestamo> obtenerEstadoPrestamo() {
	return this.estadoPrestamoServicio.getEstadoPrestamo();
	}
	
	@GetMapping(path="/estadoPrestamoSelect/{id}")
	public Optional<EstadoPrestamo> obtenerEstadoPrestamoID(@PathVariable("id") Long id) {	
	return this.estadoPrestamoServicio.getEstadoPrestamoId(id);
	}
	
	@PostMapping("/estadoPrestamoInsertar")
	public void insertarEstadoPrestamo(@RequestBody EstadoPrestamo estadoPrestamo) {
		this.estadoPrestamoServicio.insertarEstadoPrestamo(estadoPrestamo);
	}
	
	@PutMapping(path="/estadoPrestamoActualizar/{id}")
	public void actualizarEstadoPrestamo(@RequestBody EstadoPrestamo estadoPrestamo,@PathVariable("id") Long id) {
		this.estadoPrestamoServicio.updateEstadoPrestamo(estadoPrestamo, id);
	}
	
	@DeleteMapping(path="/estadoPrestamoEliminar/{id}")
	public Boolean eliminarEstadoPrestamo(@PathVariable("id") Long id) {
		return this.estadoPrestamoServicio.deleteEstadoPrestamo(id);
	}
}