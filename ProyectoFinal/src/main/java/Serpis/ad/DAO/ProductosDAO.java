package Serpis.ad.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Serpis.ad.Clases.Categoria;
import Serpis.ad.Clases.Pedido;
import Serpis.ad.Clases.Producto;

public class ProductosDAO {
	public static EntityManagerFactory entityManagerFactory;
	public static EntityManager entityManager;
	
	public static void insertar() throws SQLException {
		Scanner tcl=new Scanner(System.in);
		entityManagerFactory=Persistence.createEntityManagerFactory("serpis.ad.proyectofinal");
		entityManager=entityManagerFactory.createEntityManager();
		Producto pro=new Producto();
		
		System.out.println("Dime el nombre del Producto:");
		String nombre=tcl.nextLine();
		pro.setNombre(nombre);
		
		System.out.println("Dime el precio");
		float precio=tcl.nextFloat();
		pro.setPrecio(precio);
		System.out.println("Dime categoria");
		Categoria cat=entityManager.find(Categoria.class,tcl.nextLong());
		pro.setCat(cat);
		entityManager.getTransaction().begin();
		entityManager.persist(pro);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
		
	}
	
	
	
	
	
	public static void show() {
		entityManagerFactory=Persistence.createEntityManagerFactory("serpis.ad.proyectofinal");
		entityManager=entityManagerFactory.createEntityManager();
		List<Producto>productos= entityManager.createQuery("from producto order by id", Producto.class).getResultList();
		System.out.println("ID "+" Nombre "+" Precio ");
		for (Producto producto : productos)
			System.out.printf("%d  %s  %f %n ", producto.getId_producto(), producto.getNombre(),producto.getPrecio());	
	     entityManager.close();
		
		
	}
	
	
	





}
