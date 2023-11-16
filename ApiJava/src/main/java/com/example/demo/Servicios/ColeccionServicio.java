package com.example.demo.Servicios;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.Modelos.Coleccion;
import com.example.demo.Modelos.ColeccionRepositorio;

public class ColeccionServicio {
	
	@Autowired
	ColeccionRepositorio coleccionRepositorio;
	
	public ArrayList<Coleccion> getColeccion()
	{
		return (ArrayList<Coleccion>)coleccionRepositorio.findAll();
	}
	
	public void insertarColeccion(Coleccion coleccion)
	{
		coleccionRepositorio.save(coleccion);
	}
	
	public Optional<Coleccion> getColeccionId(Long id)
	{
		return coleccionRepositorio.findById(id);
	}
	
	
	public void updateColeccion(Coleccion coleccion,Long id)
	{
		Coleccion coleccionObetnido=coleccionRepositorio.findById(id).get();
		coleccionObetnido.setNombre_coleccion(coleccion.getNombre_coleccion());
		coleccionRepositorio.save(coleccionObetnido);
	}
	
	public Boolean deleteColeccion(Long id) {
		try {
			coleccionRepositorio.deleteById(id);
			return true;
		}catch(IllegalArgumentException e)
		{
			return false;
		}
		
	}
}
