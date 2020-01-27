package Serpis.ad.Clases;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity (name="producto")
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_producto;
	
	@Column 
	private String nombre;
	
	@Column 
	private float precio;

	
	@ManyToOne
	@JoinColumn(name = "categoria",foreignKey=@ForeignKey(name="producto_ibfk_1"))	
	
	private Categoria categoria;


	public Long getId_producto() {
		return id_producto;
	}


	public void setId_producto(Long id_producto) {
		this.id_producto = id_producto;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public float getPrecio() {
		return precio;
	}


	public void setPrecio(float precio) {
		this.precio = precio;
	}


	public Categoria getCat() {
		return categoria;
	}


	public void setCat(Categoria cat) {
		this.categoria= cat;
	}
	
	
	
	
	
}
