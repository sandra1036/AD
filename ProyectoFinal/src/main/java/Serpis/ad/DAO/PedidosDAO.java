package Serpis.ad.DAO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Serpis.ad.Clases.Categoria;
import Serpis.ad.Clases.Cliente;
import Serpis.ad.Clases.Linea_pedido;
import Serpis.ad.Clases.Pedido;
import Serpis.ad.Clases.Producto;

public class PedidosDAO {

	public static EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("serpis.ad.proyectofinal");
	public static EntityManager entityManager=entityManagerFactory.createEntityManager();		
	public static Pedido ped=new Pedido();
	public static Linea_pedido li=new Linea_pedido();
	public static Cliente cli;
	public static Producto producto;
	public static void Insert() {
		Scanner tcl=new Scanner(System.in);
		LocalDateTime fecha=LocalDateTime.now();
		ped.setFecha(fecha);
		System.out.println("id del cliente:");
		cli=entityManager.find(Cliente.class,tcl.nextLong());
		ped.setCliente(cli);
		li.setPedido(ped);
		Scanner tcl2=new Scanner(System.in);
		System.out.println("id producto:");
		Long id_producto=tcl.nextLong();
		producto=entityManager.find(Producto.class, id_producto);
		li.setProducto(producto);
		li.setPrecio(producto.getPrecio());
		Scanner tcl3=new Scanner(System.in);
		System.out.println("Unidades:");
		float unidades=tcl3.nextFloat();
		li.setUnidades(unidades);
		ped.setImporte(producto.getPrecio()*li.getUnidades());
		li.setImporte(li.getPrecio()*li.getUnidades());
		entityManager.getTransaction().begin();
		entityManager.persist(ped);
		entityManager.persist(li);
		entityManager.getTransaction().commit();

	}
	
	public static void update() {
		Scanner tcl=new Scanner(System.in);
		System.out.println("¿Cual es el id que deseas cambiar?");
		Long id_pedido=tcl.nextLong();
		ped=entityManager.find(Pedido.class, id_pedido);
		Scanner tcl2=new Scanner(System.in);
		entityManager.getTransaction().begin();
		
		System.out.println("Id Cliente");
		cli=entityManager.find(Cliente.class, tcl.nextLong());
		ped.setCliente(cli);
		entityManager.getTransaction().commit();
		entityManager.close();
		
		
	}
	
	
	public  static void show(){
		List<Pedido>pedidos= entityManager.createQuery("from Pedido order by id", Pedido.class).getResultList();
		System.out.println("ID  "+"  Fecha  "+"  Nombre  "+"  Precio  ");
		for (Pedido pedido : pedidos)
			System.out.printf("%d  %s  %s %d %n", pedido.getId_pedido(), pedido.getFecha(),pedido.getCliente().getNombre());	

	}
}
