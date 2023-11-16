package com.example.demo.Servicios;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.Modelos.Libro;
import com.example.demo.Modelos.LibroRepositorio;

public class LibroServicio {
	@Autowired
	LibroRepositorio libroRepositorio;
	
	public ArrayList<Libro> getLibro()
	{
		return (ArrayList<Libro>) libroRepositorio.findAll();
	}
	
	public void insertarLibro(Libro libro)
	{
		libroRepositorio.save(libro);
	}
	
	public Optional<Libro> getLibroId(Long id)
	{
		return libroRepositorio.findById(id);
	}
	
	
	public void updateLibro(Libro libro,Long id)
	{
		Libro libroObtenido=libroRepositorio.findById(id).get();
		libroObtenido.setCantidadLibro(libro.getCantidadLibro());
		libroObtenido.setEdicionLibro(libro.getEdicionLibro());
		libroObtenido.setIsbnLibro(libro.getIsbnLibro());
		libroObtenido.setTituloLibro(libro.getTituloLibro());
		libroObtenido.setLibroAutor(libro.getLibroAutor());
		libroRepositorio.save(libroObtenido);
	}
	
	public Boolean deleteLibro(Long id) {
		try {
			libroRepositorio.deleteById(id);
			return true;
		}catch(IllegalArgumentException e)
		{
			return false;
		}
		
	}
}
