package Serpis.ad.DAO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Serpis.ad.Clases.Cliente;
import Serpis.ad.Clases.Producto;

public class ClienteDAO {
	public static EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("serpis.ad.proyectofinal");;
	public static EntityManager entityManager=entityManagerFactory.createEntityManager();;
	public static Cliente cli =new Cliente();
	public static void Insert() {
		Scanner tcl=new Scanner(System.in);
		System.out.println("Nombre del cliente: ");
		String nombre=tcl.nextLine();
		cli.setNombre(nombre);
		entityManager.getTransaction().begin();
		entityManager.persist(cli);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
	}
	
	public static void Update() {
		
		Scanner tcl=new Scanner(System.in);
		System.out.println("¿Cual es el id que deseas cambiar?");
		Long idcliente=tcl.nextLong();	
		entityManager=entityManagerFactory.createEntityManager();
		entityManager.createQuery("from clientes where id_cliente=idcliente");
		System.out.println("¿Qué deseas cambiar?");
		System.out.println("1.Nombre");
		int op =tcl.nextInt();
		switch (op) {
		case 1:
			
			break;

		case 2:
			break;
			
			
		case 3:
			
			break;
		default:
			break;
		}
		
	}
	
	public static void Delete() {
		
	}
	

	public static void show() {
		List<Cliente> clientes= entityManager.createQuery("from Cliente order by id", Cliente.class).getResultList();
		System.out.println("ID "+" Nombre ");
		for (Cliente cliente : clientes)
			System.out.printf("%d  %s %n ", cliente.getId_cliente(), cliente.getNombre());			
		
	}

	
}
