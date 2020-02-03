package Serpis.ad.DAO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.result.NoMoreReturnsException;

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
	
	public static void update() {
	
		Scanner tcl=new Scanner(System.in);
		System.out.println("¿Cual es el id que deseas cambiar?");
		Long idcliente=tcl.nextLong();	
		cli=entityManager.find(Cliente.class, idcliente);
		Scanner tcl2=new Scanner(System.in);
			System.out.println("Elige el nuevo nombre");
			entityManager.getTransaction().begin();
			cli.setNombre(tcl2.nextLine());
			entityManager.getTransaction().commit();
			entityManager.close();
	}
		
	
	
	public static void Delete() {
		Scanner tcl=new Scanner(System.in);
		System.out.println("Dime el id del cliente a eliminar");
		Long id=tcl.nextLong();
		cli=entityManager.find(Cliente.class, id);
    	entityManager.getTransaction().begin();
    	entityManager.remove(cli);
    	entityManager.getTransaction().commit();
    	entityManager.close();

		
	}
	

	public static void show() {
		List<Cliente> clientes= entityManager.createQuery("from Cliente order by id", Cliente.class).getResultList();
		System.out.println("ID "+" Nombre ");
		for (Cliente cliente : clientes)
			System.out.printf("%d  %s %n ", cliente.getId_cliente(), cliente.getNombre());			
		
	}

	
}
