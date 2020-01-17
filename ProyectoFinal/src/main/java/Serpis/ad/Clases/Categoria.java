package Serpis.ad.Clases;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity(name="categoria")
public class Categoria {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_cat;
	
	@Column
	private String nombre;

	
	
	public long getId() {
		return id_cat;
	}
	
	public void setId(Long id) {
		this.id_cat = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	
	

}
