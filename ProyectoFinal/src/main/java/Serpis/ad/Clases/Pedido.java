package Serpis.ad.Clases;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name="Pedido")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_pedido;
	
	@Column 
	private Long cantidad;
	

	@Column
	private Long precio;
	
	@ManyToOne
	@JoinColumn(name = "cliente")
	private Cliente cliente;
	
	@OneToMany(targetEntity=Linea_pedido.class,cascade=CascadeType.ALL,orphanRemoval=true)
	@JoinColumn(name ="pedido")
	
	
	private List<Linea_pedido> linea_pedido;
	
	public Long getId_pedido() {
		return id_pedido;
	}


	public void setId_pedido(Long id_pedido) {
		this.id_pedido = id_pedido;
	}


	public Long getCantidad() {
		return cantidad;
	}


	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}


	public Long getPrecio() {
		return precio;
	}


	public void setPrecio(Long precio) {
		this.precio = precio;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public List<Linea_pedido> getLinea_pedido() {
		return linea_pedido;
	}


	public void setLinea_pedido(List<Linea_pedido> linea_pedido) {
		this.linea_pedido = linea_pedido;
	}


	
}
