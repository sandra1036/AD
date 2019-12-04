package Serpis.ad;

import java.time.LocalDateTime;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateMain {

	public static void main(String[] args) {
		
//		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("serpis.ad.gclienteshib");//crea la conexión a la base de datos
//		Clientes cli=new Clientes();
//		cli.setNombre("Cliente"+LocalDateTime.now());
//		EntityManager entityManager=entityManagerFactory.createEntityManager();//PreparedStatement para las consultas
//		entityManager.getTransaction().begin();
//		entityManager.persist(cli);
//		entityManager.getTransaction().commit();
//		entityManager.close();
//		entityManagerFactory.close();

		Scanner tcl=new Scanner(System.in);
		System.out.println("=========Menu======");
		System.out.println("1.Clientes");
		System.out.println("2.Pedidos");
		int op=tcl.nextInt();
		switch(op) {
		  case 1:
			System.out.println("Has entrado en Clientes");
			System.out.println("¿Qué deseas hacer?");
			System.out.println("1.Intertar");
			System.out.println("2.Modificar");
			System.out.println("3.Borrar");
			System.out.println("4.Visualizar");
			System.out.println("0.Salir");
			Scanner tcl2=new Scanner(System.in);
			int op2=tcl2.nextInt();
			switch (op2) {
			case 1:
				
				System.out.println("Has entrado en Insertar");
				
				break;

			case 2:
				
				System.out.println("Has entrado en Modificar");
				
			case 3:
				
				System.out.println("Has entrado en Borrar");
				
			case 4:
				System.out.println("Has entrado en Mostrar");
				
			case 0:
				
				System.out.println("Salir");
				System.exit(0);
				

			}
			break;
			
			
			
			
			
		
		  case 2:
				System.out.println("Has entrado en Clientes");
				System.out.println("¿Qué deseas hacer?");
				System.out.println("1.Intertar");
				System.out.println("2.Modificar");
				System.out.println("3.Borrar");
				System.out.println("4.Visualizar");
				System.out.println("0.Salir");
				Scanner tcl3=new Scanner(System.in);
				int op3=tcl3.nextInt();
				switch (op3) {
				case 1:
					System.out.println("Has entrado en Insertar");
					break;

				case 2:
					
					System.out.println("Has entrado en Modificar");
					
				case 3:
					
					System.out.println("Has entrado en Borrar");
					
				case 4:
					System.out.println("Has entrado en Mostrar");
					
				case 0:
					System.out.println("Salir");
					System.exit(0);

				}
			  break;
			
		}
		
		
	}

}
