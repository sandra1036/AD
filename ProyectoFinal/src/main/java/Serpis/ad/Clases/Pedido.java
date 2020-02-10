package Serpis.ad.Clases;

import java.time.LocalDateTime;
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
import javax.print.attribute.standard.DateTimeAtCompleted;

@Entity(name="Pedido")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;


	@Column
	private LocalDateTime fecha;
	
	
	@Column
	private float importe;
	
	@ManyToOne
	@JoinColumn(name = "cliente")
	private Cliente cliente;
	
	@OneToMany(targetEntity=Linea_pedido.class,cascade=CascadeType.ALL,orphanRemoval=true)
	@JoinColumn(name ="pedido")
	
	
	private List<Linea_pedido> linea_pedido;
	
	public Long getId_pedido() {
		return id;
	}


	public void setId_pedido(Long id_pedido) {
		this.id = id_pedido;
	}




	public LocalDateTime getFecha() {
		return fecha;
	}


	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
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


	public float getImporte() {
		return importe;
	}


	public void setImporte(float importe) {
		this.importe = importe;
	}


	public void setLinea_pedido(List<Linea_pedido> linea_pedido) {
		this.linea_pedido = linea_pedido;
	}


	
}
