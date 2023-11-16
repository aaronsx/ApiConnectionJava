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
@Table(name="editoriales", schema="gbp_almacen")
public class Editorial {
	
	//ATRIBUTOS
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_editorial", nullable=false)
	private long id_editorial;
	

	

	@Column(name="nombre_editorial", nullable=false)
	private String nombre_editorial;
	 
	 

	

	@OneToMany(mappedBy="editorial")
	    List<Libro> librosConEditorial;
	 //GET
	public long getId_editorial() {
		return id_editorial;
	}
	public String getNombre_editorial() {
		return nombre_editorial;
	}
	public void setNombre_editorial(String nombre_editorial) {
		this.nombre_editorial = nombre_editorial;
	}
	 
	//CONSTRUCTORES
	public Editorial() {
		super();
	}

	public Editorial(String nombre_editorial) {
		super();
		this.nombre_editorial = nombre_editorial;
	}

}
