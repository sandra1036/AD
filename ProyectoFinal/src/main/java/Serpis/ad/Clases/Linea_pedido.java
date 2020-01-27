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


@Entity(name="lineapedido")
public class Linea_pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_lineapedido;
	
	
	@Column
	private float precio;
	
	@Column 
	private float unidades;
	
	@Column
	private float importe;

	
	@ManyToOne
	@JoinColumn(name = "id_producto",foreignKey = @ForeignKey(name = "pedidolinea_ibfk_2"))
	

	private Producto producto;

	
	@ManyToOne
	@JoinColumn(name = "id_pedido",foreignKey = @ForeignKey(name = "pedidolinea_ibfk_1"))
	private Pedido pedido;
	
	public Long getId_lineapedido() {
		return id_lineapedido;
	}

	public void setId_lineapedido(Long id_lineapedido) {
		this.id_lineapedido = id_lineapedido;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
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
