package com.example.demo.Servicios;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.Modelos.Editorial;
import com.example.demo.Modelos.EditorialRepositorio;

public class EditorialServicio {
	@Autowired
	EditorialRepositorio editorialRepositorio;
	
	public ArrayList<Editorial> getEditorial()
	{
		return (ArrayList<Editorial>) editorialRepositorio.findAll();
	}
	
	public void insertarEditorial(Editorial editorial)
	{
		editorialRepositorio.save(editorial);
	}
	
	public Optional<Editorial> getEditorialId(Long id)
	{
		return editorialRepositorio.findById(id);
	}
	
	
	public void updateEditorial(Editorial editorial,Long id)
	{
		Editorial editorialObetnido=editorialRepositorio.findById(id).get();
		editorialObetnido.setNombre_editorial(editorial.getNombre_editorial());
		editorialRepositorio.save(editorialObetnido);
	}
	
	public Boolean deleteEditorial(Long id) {
		try {
			editorialRepositorio.deleteById(id);
			return true;
		}catch(IllegalArgumentException e)
		{
			return false;
		}
		
	}
}
