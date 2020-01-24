package Serpis.ad.DAO;

import java.time.LocalDateTime;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Serpis.ad.Clases.Cliente;
import Serpis.ad.Clases.Pedido;

public class PedidosDAO {

	public static void Insert(Cliente cli) {
		Scanner tcl=new Scanner(System.in);
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("serpis.ad.proyectofinal");
		Pedido ped=new Pedido();
		System.out.println("Dime cuantos quieres: ");
		Long cant=tcl.nextLong();
		ped.setCantidad(cant);
		System.out.println("Dime el precio");
		Long pre=tcl.nextLong();
		ped.setPrecio(pre);	
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(ped);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();

	}
}
