package com.example.demo.Servicios;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.Modelos.Autor;
import com.example.demo.Modelos.AutorRepositorio;

public class AutorServicio {
	
	@Autowired
	AutorRepositorio autorRepositorio;
	
	public ArrayList<Autor> getAutor()
	{
		return (ArrayList<Autor>)autorRepositorio.findAll();
	}
	
	public void insertarAutor(Autor autor)
	{
		autorRepositorio.save(autor);
	}
	
	public Optional<Autor> getAutorId(Long id)
	{
		return autorRepositorio.findById(id);
	}
	
	
	public void updateAutor(Autor autor,Long id)
	{
		Autor autorObetnido=autorRepositorio.findById(id).get();
		autorObetnido.setNombreAutor(autor.getNombreAutor());
		autorObetnido.setApellidosAutor(autor.getApellidosAutor());
		autorRepositorio.save(autorObetnido);
	}
	
	public Boolean deleteAutor(Long id) {
		try {
			autorRepositorio.deleteById(id);
			return true;
		}catch(IllegalArgumentException e)
		{
			return false;
		}
		
	}
}
