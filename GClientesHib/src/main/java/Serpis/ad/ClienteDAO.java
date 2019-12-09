package Serpis.ad;

import java.time.LocalDateTime;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ClienteDAO {
		public static EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("serpis.ad.gclienteshib");//crea la conexión a la base de datos
	public static void Insert() {
		Scanner tcl=new Scanner(System.in);
		Clientes cli=new Clientes();
		cli.setNombre("Cliente"+LocalDateTime.now());
		System.out.println("Dime tu DNI");
		String dni=tcl.nextLine();
		cli.setDni(dni);
		System.out.println("Dime tu telefono: ");
		Long tele=tcl.nextLong();
		cli.setTelefono(tele);
		EntityManager entityManager=entityManagerFactory.createEntityManager();//PreparedStatement para las consultas
		entityManager.getTransaction().begin();
		entityManager.persist(cli);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();

	}
	public static void Update() {
		
	}
	
	public static void Delete() {
		
	}
	
	public static void SelectAll() {
		
	}
	
	
	
	
	
	
	

}
