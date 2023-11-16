package com.example.demo.Modelos;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="colecciones", schema="gbp_almacen")
public class Coleccion {
	
	//ATRIBUTOS
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_coleccion", nullable=false)
	private long id_coleccion;
	

	@Column(name="nombre_coleccion", nullable=false)
	private String nombre_coleccion;
	
	

	

	

	
	@OneToMany(mappedBy="coleccion")
    List<Libro> librosConColeccion; 
	//GET
	public long getId_coleccion() {
		return id_coleccion;
	}
	public String getNombre_coleccion() {
		return nombre_coleccion;
	}

	public void setNombre_coleccion(String nombre_coleccion) {
		this.nombre_coleccion = nombre_coleccion;
	}
	//CONSTRUCTORES
	public Coleccion() {
		super();
	}
	
	public Coleccion(String nombre_coleccion) {
		super();
		this.nombre_coleccion = nombre_coleccion;
	}
	

}