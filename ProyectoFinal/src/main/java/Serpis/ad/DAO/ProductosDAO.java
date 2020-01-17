package Serpis.ad.DAO;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Serpis.ad.Clases.Categoria;
import Serpis.ad.Clases.Producto;

public class ProductosDAO {
	
	
	public static void insertar(Categoria cat) {
		Scanner tcl=new Scanner(System.in);
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("serpis.ad.proyectofinal");//conexion a la base de datos
		Producto pro=new Producto();
		System.out.println("Dime el nombre del Producto:");
		String nombre=tcl.nextLine();
		pro.setNombre(nombre);
		System.out.println("Dime el precio");
		float precio=tcl.nextFloat();
		pro.setPrecio(precio);
		System.out.println("Dime la id_categoria:");
		pro.setCat(cat);
		EntityManager entityManager=entityManagerFactory.createEntityManager();//PreparedStatement para las consultas
		entityManager.getTransaction().begin();
		entityManager.persist(pro);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
		
	}
	





}
