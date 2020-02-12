package Serpis.ad.Clases;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;


@Entity(name="pedidolinea")
public class Linea_pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@Column
	private float precio;
	
	@Column 
	private float unidades;
	
	@Column
	private float importe=0f;

	
	@ManyToOne
	@JoinColumn(name = "producto")
	

	private Producto producto;

	
	@ManyToOne
	@JoinColumn(name = "pedido")
	private Pedido pedido;
	
	
	public Linea_pedido(Pedido pedido) {
		this.pedido=pedido;
		pedido.getLinea_pedido().add(this);
		
	}
	
	
	
	
	public Linea_pedido() {
	}




	public Long getId_lineapedido() {
		return id;
	}

	public void setId_lineapedido(Long id_lineapedido) {
		this.id = id_lineapedido;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public float getUnidades() {
		return unidades;
	}

	public void setUnidades(float unidades) {
		this.unidades = unidades;
	}

	public float getImporte() {
		if(this.importe==0f) 
			this.setImporte();
	
		return importe;
	}

	

	@PreUpdate
	public void setImporte() {
		this.importe = unidades*precio;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}


	

	
	
	
	
}
