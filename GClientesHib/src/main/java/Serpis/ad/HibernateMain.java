package Serpis.ad;

import java.time.LocalDateTime;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateMain {

	public static void main(String[] args) {
		Clientes cli=new Clientes();
	
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
				ClienteDAO.Insert();
				
				
				break;

			case 2:
				
				System.out.println("Has entrado en Modificar");
				break;
			case 3:
				
				System.out.println("Has entrado en Borrar");
				break;
			case 4:
				System.out.println("Has entrado en Mostrar");
				break;
			case 0:
				
				System.out.println("Salir");
				System.exit(0);
				
				break;
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
					PedidosDAO.Insert(cli);
					break;

				case 2:
					
					System.out.println("Has entrado en Modificar");
					break;
				case 3:
					
					System.out.println("Has entrado en Borrar");
					break;
				case 4:
					System.out.println("Has entrado en Mostrar");
					break;
				case 0:
					System.out.println("Salir");
					System.exit(0);
					break;
			
				}
			
		}
	}

}
