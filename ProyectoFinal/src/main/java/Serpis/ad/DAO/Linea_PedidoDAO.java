package Serpis.ad.DAO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="lineapedido")
public class Linea_PedidoDAO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_linea;
	
	
	
	

}
