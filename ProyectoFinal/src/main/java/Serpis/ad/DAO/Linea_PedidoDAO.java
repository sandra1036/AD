package Serpis.ad.DAO;

import java.time.LocalDateTime;
import java.util.Scanner;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Persistence;

import Serpis.ad.Clases.Cliente;
import Serpis.ad.Clases.Linea_pedido;
import Serpis.ad.Clases.Pedido;
import Serpis.ad.Clases.Producto;


public class Linea_PedidoDAO {

	
public static EntityManagerFactory entityManagerFactory;
public static EntityManager entityManager;
public static void Insert() {
		Scanner tcl=new Scanner(System.in);
		entityManagerFactory=Persistence.createEntityManagerFactory("serpis.ad.proyectofinal");
		entityManager=entityManagerFactory.createEntityManager();
		Linea_pedido lped=new Linea_pedido();
		System.out.println("Pedido:");
		Pedido pedido=entityManager.find(Pedido.class,tcl.nextLong());
		lped.setPedido(pedido);
		System.out.println("Producto");
		Producto producto=entityManager.find(Producto.class,tcl.nextLong());
		lped.setProducto(producto);
		System.out.println("Precio");
		float precio=tcl.nextFloat();
		lped.setPrecio(precio);
		float unidades=tcl.nextFloat();
		lped.setUnidades(unidades);
		float importe=tcl.nextFloat();
		lped.setImporte(importe);
		entityManager.getTransaction().begin();
		entityManager.persist(lped);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();

}
	
	
	
	
	

}
