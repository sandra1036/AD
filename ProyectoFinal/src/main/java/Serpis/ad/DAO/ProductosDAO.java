package Serpis.ad.DAO;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Serpis.ad.Clases.Categoria;
import Serpis.ad.Clases.Producto;

public class ProductosDAO {
	
	
	public static void insertar() {
		Scanner tcl=new Scanner(System.in);
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("serpis.ad.ProyectoFinal");//conexion a la base de datos
		Producto pro=new Producto();
		System.out.println("Dime el nombre de la categoria:");
		String nombre=tcl.nextLine();
		pro.setNombre(nombre);
		System.out.println("Dime el precio");
		float precio=tcl.nextFloat();
		System.out.println("Dime la cantidad");
		float cant=tcl.nextFloat();
		EntityManager entityManager=entityManagerFactory.createEntityManager();//PreparedStatement para las consultas
		entityManager.getTransaction().begin();
		entityManager.persist(pro);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
		
	}
	





}
