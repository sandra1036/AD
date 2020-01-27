package Serpis.ad.DAO;

import java.time.LocalDateTime;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Serpis.ad.Clases.Categoria;
import Serpis.ad.Clases.Cliente;
import Serpis.ad.Clases.Pedido;

public class PedidosDAO {

	public static EntityManagerFactory entityManagerFactory;
	public static EntityManager entityManager;
	public static void Insert() {
		Scanner tcl=new Scanner(System.in);
		entityManagerFactory=Persistence.createEntityManagerFactory("serpis.ad.proyectofinal");
		entityManager=entityManagerFactory.createEntityManager();
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
		entityManager.close();
		entityManagerFactory.close();

	}
}
