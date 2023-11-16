package com.example.demo.Servicios;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.Modelos.EstadoPrestamo;
import com.example.demo.Modelos.EstadoPrestamoRepositorio;

public class EstadoPrestamoServicio {

	@Autowired
	EstadoPrestamoRepositorio estadoPrestamoRepositorio;
	
	public ArrayList<EstadoPrestamo> getEstadoPrestamo()
	{
		return (ArrayList<EstadoPrestamo>)estadoPrestamoRepositorio.findAll();
	}
	
	public void insertarEstadoPrestamo(EstadoPrestamo estadoPrestamo)
	{
		estadoPrestamoRepositorio.save(estadoPrestamo);
	}
	
	public Optional<EstadoPrestamo> getEstadoPrestamoId(Long id)
	{
		return estadoPrestamoRepositorio.findById(id);
	}
	
	
	public void updateEstadoPrestamo(EstadoPrestamo estadoPrestamo,Long id)
	{
		EstadoPrestamo estadoPrestamoObtenida=estadoPrestamoRepositorio.findById(id).get();
		estadoPrestamoObtenida.setFchEntrePresta(estadoPrestamo.getFchEntrePresta());
		estadoPrestamoObtenida.setFchFinPresta(estadoPrestamo.getFchFinPresta());
		estadoPrestamoObtenida.setFchIniPresta(estadoPrestamo.getFchIniPresta());
		estadoPrestamoRepositorio.save(estadoPrestamoObtenida);
	}
	
	public Boolean deleteEstadoPrestamo(Long id) {
		try {
			estadoPrestamoRepositorio.deleteById(id);
			return true;
		}catch(IllegalArgumentException e)
		{
			return false;
		}
		
	}
}
