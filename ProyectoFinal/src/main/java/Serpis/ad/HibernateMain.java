package Serpis.ad;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;

import Serpis.ad.Clases.Categoria;
import Serpis.ad.Clases.Cliente;
import Serpis.ad.Clases.Pedido;
import Serpis.ad.DAO.CategoriaDao;
import Serpis.ad.DAO.ClienteDAO;
import Serpis.ad.DAO.Linea_PedidoDAO;
import Serpis.ad.DAO.PedidosDAO;
import Serpis.ad.DAO.ProductosDAO;

public class HibernateMain {
	
	
	public static void main(String[] args) {
		Scanner tcl=new Scanner(System.in);
		System.out.println("======Menu=====");
		System.out.println("1.Categoria");
		System.out.println("2.Producto");
		System.out.println("3.Cliente");
		System.out.println("4.Pedido");
		System.out.println("0.Salida");
		
		try {
			int op=tcl.nextInt();
			
			switch (op) {
			case 1:
				System.out.println("Has entrado en Categoria");
				System.out.println("¿Qué desea hacer?");
				System.out.println("1.Insertar");
				System.out.println("2.Modificar");
				System.out.println("3.Mostrar");
				System.out.println("0.Salir");
				int op2=tcl.nextInt();
				
				switch (op2) {
				case 1:
					CategoriaDao.insertar();
					break;

				case 2:
					
					break;
					
				case 3:
					CategoriaDao.show();
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
				System.out.println("3.Mostrar");
				System.out.println("0.Salir");
				int op3=tcl.nextInt();
				
				switch (op3) {
				case 1:
					ProductosDAO.insertar();
					break;

				case 2:
					ProductosDAO.update();
					break;
					
				case 4:
					ProductosDAO.show();
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
				System.out.println("3.Mostrar");
				System.out.println("0.Salir");
				int op4=tcl.nextInt();
				
				switch (op4) {
				case 1:
					ClienteDAO.Insert();
					break;

				case 2:
					ClienteDAO.update();
					break;
					

				case 4:
					ClienteDAO.show();
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
						PedidosDAO.Insert();
					break;

				case 2:
					PedidosDAO.update();
					break;
					
				case 3:
					PedidosDAO.show();
					break;

					
				case 0:
					
					System.exit(0);
					break;
				default:
					break;
				}
				
				
				break;
			}
			
			
		} catch (Exception e) {
				e.printStackTrace();
		}
		
		
		
		

	}

}
