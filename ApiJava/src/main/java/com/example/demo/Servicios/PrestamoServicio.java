package com.example.demo.Servicios;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.Modelos.Prestamo;
import com.example.demo.Modelos.PrestamoRepositorio;

public class PrestamoServicio {
	@Autowired
	PrestamoRepositorio prestamoRepositorio;
	
	public ArrayList<Prestamo> getPrestamo()
	{
		return (ArrayList<Prestamo>)prestamoRepositorio.findAll();
	}
	
	public void insertarPrestamo(Prestamo prestamo)
	{
		prestamoRepositorio.save(prestamo);
	}
	
	public Optional<Prestamo> getPrestamoId(Long id)
	{
		return prestamoRepositorio.findById(id);
	}
	
	
	public void updatePrestamo(Prestamo prestamo,Long id)
	{
		Prestamo prestamoObtenido=prestamoRepositorio.findById(id).get();
		prestamoObtenido.setFchIniPresta(prestamo.getFchIniPresta());
		prestamoObtenido.setFchEntrePresta(prestamo.getFchEntrePresta());
		prestamoObtenido.setPrestamoLibro(prestamo.getPrestamoLibro());
		prestamoObtenido.setFchFinPresta(prestamo.getFchFinPresta());
		prestamoRepositorio.save(prestamoObtenido);
	}
	
	public Boolean deletePrestamo(Long id) {
		try {
			prestamoRepositorio.deleteById(id);
			return true;
		}catch(IllegalArgumentException e)
		{
			return false;
		}
		
	}
}
