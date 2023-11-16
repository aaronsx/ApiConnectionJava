package com.example.demo.Servicios;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.Modelos.Genero;
import com.example.demo.Modelos.GeneroRepositorio;

public class GeneroServicio {
	@Autowired
	GeneroRepositorio generoRepositorio;
	
	public ArrayList<Genero> getGenero()
	{
		return (ArrayList<Genero>)generoRepositorio.findAll();
	}
	
	public void insertarGenero(Genero genero)
	{
		generoRepositorio.save(genero);
	}
	
	public Optional<Genero> getGeneroId(Long id)
	{
		return generoRepositorio.findById(id);
	}
	
	
	public void updateGenero(Genero genero,Long id)
	{
		Genero generoObtenido=generoRepositorio.findById(id).get();
		generoObtenido.setNombre_genero(genero.getNombre_genero());
		generoObtenido.setDescripcion_genero(genero.getDescripcion_genero());
		generoRepositorio.save(generoObtenido);
	}
	
	public Boolean deleteGenero(Long id) {
		try {
			generoRepositorio.deleteById(id);
			return true;
		}catch(IllegalArgumentException e)
		{
			return false;
		}
		
	}
}
