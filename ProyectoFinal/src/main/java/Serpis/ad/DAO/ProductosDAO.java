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
	public static EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("serpis.ad.proyectofinal");;
	public static EntityManager entityManager=entityManagerFactory.createEntityManager();
	public static Producto pro=new Producto();
	public static Categoria cat;
	public static void insertar() throws SQLException {
		Scanner tcl=new Scanner(System.in);
		System.out.println("Dime el nombre del Producto:");
		String nombre=tcl.nextLine();
		pro.setNombre(nombre);
		System.out.println("Dime el precio");
		float precio=tcl.nextFloat();
		pro.setPrecio(precio);
		System.out.println("Dime categoria");
		cat=entityManager.find(Categoria.class,tcl.nextLong());
		pro.setCat(cat);
		
		entityManager.getTransaction().begin();
		entityManager.persist(pro);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
		
	}
	
	public static void update() {
		Scanner tcl=new Scanner(System.in);
		System.out.println("Id a cambiar");
		Long id_producto=tcl.nextLong();
		pro=entityManager.find(Producto.class, id_producto);
		entityManager.getTransaction().begin();
		Scanner tcl2=new Scanner(System.in);
		System.out.println("Nombre");
		pro.setNombre(tcl2.nextLine());
		System.out.println("Precio");
		pro.setPrecio(tcl.nextFloat());
		System.out.println("Id_Categoria:");
		cat=entityManager.find(Categoria.class,tcl.nextLong());
		pro.setCat(cat);
		entityManager.getTransaction().commit();
		entityManager.close();
		
		
		
		
		
		
		
	}
	
	
	
	
	public static void show() {
		entityManagerFactory=Persistence.createEntityManagerFactory("serpis.ad.proyectofinal");
		entityManager=entityManagerFactory.createEntityManager();
		List<Producto>productos= entityManager.createQuery("from producto order by id", Producto.class).getResultList();
		System.out.println("ID "+" Nombre "+" Precio ");
		for (Producto producto : productos)
			System.out.printf("%d  %s  %.2f %n ", producto.getId_producto(), producto.getNombre(),producto.getPrecio());	
	     entityManager.close();
		
		
	}
	
	
	





}
