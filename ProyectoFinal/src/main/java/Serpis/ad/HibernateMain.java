package Serpis.ad;

import java.util.Scanner;

import Serpis.ad.Clases.Categoria;
import Serpis.ad.DAO.CategoriaDao;

public class HibernateMain {

	public static void main(String[] args) {
		Scanner tcl=new Scanner(System.in);
		System.out.println("======Menu=====");
		System.out.println("1.Categoria");
		System.out.println("2.Producto");
		System.out.println("3.Cliente");
		System.out.println("4.Pedido");
		System.out.println("5.Linea");
		System.out.println("0.Salida");
		
		try {
			int op=tcl.nextInt();
			
			switch (op) {
			case 1:
				System.out.println("Has entrado en Categoria");
				System.out.println("¿Qué desea hacer?");
				System.out.println("1.Insertar");
				System.out.println("2.Modificar");
				System.out.println("3.Borrar");
				System.out.println("4.Mostrar");
				System.out.println("0.Salir");
				int op2=tcl.nextInt();
				
				switch (op2) {
				case 1:
				
					break;

				case 2:
					
					break;
					
				case 3:
					
					break;
				case 4:
					
					break;
					
				case 0:
					
					System.exit(0);
					break;
				default:
					break;
				}
				
				break;

			case 2:
				System.out.println("Has entrado en Producto");
				System.out.println("¿Qué desea hacer?");
				System.out.println("1.Insertar");
				System.out.println("2.Modificar");
				System.out.println("3.Borrar");
				System.out.println("4.Mostrar");
				System.out.println("0.Salir");
				int op3=tcl.nextInt();
				
				switch (op3) {
				case 1:
					
					break;

				case 2:
					
					break;
					
				case 3:
					
					break;
				case 4:
					
					break;
					
				case 0:
					
					System.exit(0);
					break;
				default:
					break;
				}
				
				
				break;
			case 3:
				
				System.out.println("Has entrado en Cliente");
				System.out.println("¿Qué desea hacer?");
				System.out.println("1.Insertar");
				System.out.println("2.Modificar");
				System.out.println("3.Borrar");
				System.out.println("4.Mostrar");
				System.out.println("0.Salir");
				int op4=tcl.nextInt();
				
				switch (op4) {
				case 1:
					
					break;

				case 2:
					
					break;
					
				case 3:
					
					break;
				case 4:
					
					break;
					
				case 0:
					
					System.exit(0);
					break;
				default:
					break;
				}
				
				
				break;
			case 4:
				System.out.println("Has entrado en Pedido");
				System.out.println("¿Qué desea hacer?");
				System.out.println("1.Insertar");
				System.out.println("2.Modificar");
				System.out.println("3.Borrar");
				System.out.println("4.Mostrar");
				System.out.println("0.Salir");
				int op5=tcl.nextInt();
				
				switch (op5) {
				case 1:
					
					break;

				case 2:
					
					break;
					
				case 3:
					
					break;
				case 4:
					
					break;
					
				case 0:
					
					System.exit(0);
					break;
				default:
					break;
				}
				
				
				break;
			case 5:
				
				System.out.println("Has entrado en Linea_Pedido");
				System.out.println("¿Qué desea hacer?");
				System.out.println("1.Insertar");
				System.out.println("2.Modificar");
				System.out.println("3.Borrar");
				System.out.println("4.Mostrar");
				System.out.println("0.Salir");
				int op6=tcl.nextInt();
				
				switch (op6) {
				case 1:
					
					break;

				case 2:
					
					break;
					
				case 3:
					
					break;
				case 4:
					
					break;
					
				case 0:
					
					System.exit(0);
					break;
				default:
					break;
				}
				
				
				break;
				
			case 0:
				
				System.exit(0);
				
				break;
			default:
				break;
			}
			
			
			
		} catch (Exception e) {
				System.out.println("No se puede insertar letras");
		}
		
		
		
		

	}

}
