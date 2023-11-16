package com.example.demo.Servicios;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Modelos.Acceso;
import com.example.demo.Modelos.AccesoRepositorio;

@Service
public class AccesoServicio {

	@Autowired
	AccesoRepositorio accesoRepositorio;
	
	
	public Iterable<Acceso> getAcceso()
	{
		return accesoRepositorio.findAll();
	}
	
	
	public void insertarAcceso(Acceso acceso)
	{
		accesoRepositorio.save(acceso);
	}
	
	public Optional<Acceso> getAccesoId(Long id)
	{
		return accesoRepositorio.findById(id);
	}
	
	
	public void updateAcceso(Acceso acceso,Long id)
	{
		Acceso accesoObetnido=accesoRepositorio.findById(id).get();
		accesoObetnido.setCodigo_acceso(acceso.getCodigo_acceso());
		accesoObetnido.setDescripcion_acceso(acceso.getDescripcion_acceso());
		accesoRepositorio.save(accesoObetnido);
	}
	
	public Boolean deleteAcceso(Long id) {
		try {
			accesoRepositorio.deleteById(id);
		}catch(IllegalArgumentException e)
		{
			return false;
		}
		return true;
		
	}
}
