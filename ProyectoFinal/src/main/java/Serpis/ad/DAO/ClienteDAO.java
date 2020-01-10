package Serpis.ad.DAO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Serpis.ad.Clases.Cliente;

public class ClienteDAO {
	
		public static EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("serpis.ad.gclienteshib");//crea la conexión a la base de datos
		public static EntityManager entityManager=entityManagerFactory.createEntityManager();//PreparedStatement para las consultas
		
	public static void Insert() {
		Scanner tcl=new Scanner(System.in);
		Cliente cli=new Cliente();
		cli.setNombre("Cliente"+LocalDateTime.now());
		System.out.println("Dime tu DNI");
		String dni=tcl.nextLine();
		cli.setDni(dni);
		System.out.println("Dime tu telefono: ");
		Long tele=tcl.nextLong();
		cli.setTelefono(tele);
		entityManager=entityManagerFactory.createEntityManager();
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
		entityManager.createQuery("from clientes where id_cliente=idcliente");
		System.out.println("¿Qué deseas cambiar?");
		System.out.println("1.Nombre");
		System.out.println("2.DNI");
		System.out.println("3.Telefono");
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
	
//	public static void ShowAll(List<Clientes> clientes) {
//
//		for ( Clientes cliente : clientes )
//			System.out.printf("%3d %s %s %n",cliente.getId_cliente(),cliente.getDni(), cliente.getNombre(),cliente.getTelefono());
//		
//		
//	}

	public static List<Cliente> ShowAll(Cliente cli) {

		Scanner tcl=new Scanner(System.in);
		entityManager.getTransaction().begin();
		List<Cliente>list=entityManager.createQuery("from Clientes ",Cliente.class).getResultList();
		
		
		entityManager.getTransaction().commit();
		entityManager.close();
		return list; 
	}
}
