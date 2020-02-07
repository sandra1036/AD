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
	private float importe;

	
	@ManyToOne
	@JoinColumn(name = "producto",foreignKey = @ForeignKey(name = "pedidolinea_ibfk_2"))
	

	private Producto producto;

	
	@ManyToOne
	@JoinColumn(name = "pedido",foreignKey = @ForeignKey(name = "pedidolinea_ibfk_1"))
	private Pedido pedido;
	
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
		
		
		
		return importe;
	}

	public void setImporte(float importe) {
		this.importe = importe;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}


	

	
	
	
	
}
