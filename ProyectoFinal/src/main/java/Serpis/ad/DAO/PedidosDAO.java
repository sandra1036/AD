package Serpis.ad.DAO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Serpis.ad.Clases.Categoria;
import Serpis.ad.Clases.Cliente;
import Serpis.ad.Clases.Pedido;

public class PedidosDAO {

	public static EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("serpis.ad.proyectofinal");
	public static EntityManager entityManager=entityManagerFactory.createEntityManager();
	
	public static void Insert() {
		Scanner tcl=new Scanner(System.in);
		Pedido ped=new Pedido();
		System.out.println("Dime el precio");
		Long pre=tcl.nextLong();
		ped.setPrecio(pre);	
		LocalDateTime fecha=LocalDateTime.now();
		ped.setFecha(fecha);
		System.out.println("id del cliente:");
		Cliente cli=entityManager.find(Cliente.class,tcl.nextLong());
		ped.setCliente(cli);
		entityManager.getTransaction().begin();
		entityManager.persist(ped);
		entityManager.getTransaction().commit();

	}
	
	public  static void show(){
		List<Pedido>pedidos= entityManager.createQuery("from Pedido order by id", Pedido.class).getResultList();
		System.out.println("ID  "+"  Fecha  "+"  Nombre  "+"  Precio  ");
		for (Pedido pedido : pedidos)
			System.out.printf("%d  %s  %s %d %n", pedido.getId_pedido(), pedido.getFecha(),pedido.getCliente().getNombre(),pedido.getPrecio());	

	}
}
