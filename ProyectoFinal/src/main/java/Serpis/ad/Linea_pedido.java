package Serpis.ad;

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
	@JoinColumn(name = "id_pedido",foreignKey = @ForeignKey(name = "pedido"))
	

	@OneToMany(targetEntity=Producto.class,cascade=CascadeType.ALL,orphanRemoval=true)
	@JoinColumn(name ="id_producto")
	
	private Producto producto;
	
	private List<Producto> pro;
	
	
	
	

	
	
	
	
}
