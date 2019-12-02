package Serpis.ad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="Pedidos")
public class Pedidos {

	@Id
	@GeneratedValue
	private Long id_pedido;
	
	@Column 
	private Long cantidad;
	

	@Column
	private Long precio;
	
	
	@Column
	private Long id_cliente;
	
	
	
	
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


	public Long getId_cliente() {
		return id_cliente;
	}


	public void setId_cliente(Long id_cliente) {
		this.id_cliente = id_cliente;
	}
	
}
