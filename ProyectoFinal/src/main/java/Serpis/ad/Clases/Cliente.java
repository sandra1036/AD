package Serpis.ad.Clases;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity(name="Cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_cliente;
	
	@Column
	private String nombre;
	
	@OneToMany(targetEntity=Pedido.class,cascade=CascadeType.ALL,orphanRemoval=true)
	@JoinColumn(name ="id_cliente")
	
	public Long getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Long id) {
		this.id_cliente = id;
	}



	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}

