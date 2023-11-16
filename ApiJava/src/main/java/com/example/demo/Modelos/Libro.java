  package com.example.demo.Modelos;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="libros", schema="gbp_almacen")
public class Libro {
	
	//ATRIBUTOS
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_libro", nullable=false)
	private long idLibro;
	


	@Column(name="isbn_libro", nullable=false)
	private String isbnLibro;
	
	
	@Column(name="titulo_libro")
	private String tituloLibro;

	@Column(name="edicion_libro")
	private String edicionLibro;
	
	@Column(name="cantidad_libro")
	private int cantidadLibro;
	
    @ManyToOne
    @JoinColumn(name="id_editorial")
    Editorial editorial; 

	@ManyToOne
    @JoinColumn(name="id_genero")
    Genero genero;
	
	
	@ManyToOne
    @JoinColumn(name="id_coleccion")
    Coleccion coleccion;
	
	@ManyToMany(mappedBy = "prestamoLibro")
	 private List<Prestamo> prestamo;
	 
	@ManyToMany(cascade = {
	        CascadeType.PERSIST,
	        CascadeType.MERGE
	    })
	    @JoinTable(
	        name = "Rel_Autores_Libros",schema="gbp_almacen",
	        joinColumns = @JoinColumn(name = "id_libro"),
	        inverseJoinColumns = @JoinColumn(name = "id_autor")
	    )
	    private List<Autor> libroAutor;
	   
	//GET
	public String getIsbnLibro() {
		return isbnLibro;
	}
	public void setIsbnLibro(String isbnLibro) {
		this.isbnLibro = isbnLibro;
	}
	public String getTituloLibro() {
		return tituloLibro;
	}
	public void setTituloLibro(String tituloLibro) {
		this.tituloLibro = tituloLibro;
	}
	public String getEdicionLibro() {
		return edicionLibro;
	}
	public void setEdicionLibro(String edicionLibro) {
		this.edicionLibro = edicionLibro;
	}
	public int getCantidadLibro() {
		return cantidadLibro;
	}
	public void setCantidadLibro(int cantidadLibro) {
		this.cantidadLibro = cantidadLibro;
	}
	
	public List<Autor> getLibroAutor() {
		return libroAutor;
	}
	public void setLibroAutor(List<Autor> libroAutor) {
		this.libroAutor = libroAutor;
	}
	public long getIdLibro() {
		return idLibro;
	}
	//CONSTRUCTORES
	public Libro() {
		super();
	}
	public Libro(String isbnLibro, String tituloLibro, String edicionLibro, Editorial editorial,
			Genero genero, Coleccion coleccion,int cantidadLibro,List<Autor> libroAutor) {
		super();
		this.isbnLibro = isbnLibro;
		this.tituloLibro = tituloLibro;
		this.edicionLibro = edicionLibro;
		this.editorial = editorial;
		this.genero = genero;
		this.coleccion = coleccion;
		this.cantidadLibro=cantidadLibro;
		this.libroAutor=libroAutor;
	}
	
	

}
