package Serpis.ad.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.mysql.cj.Session;

import Serpis.ad.Clases.Categoria;
import Serpis.ad.Libreria.App;

public class CategoriaDao {
	
	public static EntityManagerFactory entityManagerFactory;
	public static EntityManager entityManager; 

	
	
	public static void insertar() {
		Scanner tcl=new Scanner(System.in);
		Categoria categoria=new Categoria();
		System.out.println("Dime el nombre de la categoria:");
		String nombre=tcl.nextLine();
		categoria.setNombre(nombre);
		entityManagerFactory=Persistence.createEntityManagerFactory("serpis.ad.proyectofinal");
		entityManager=entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(categoria);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();

	}

	public static void update() {
		entityManagerFactory=Persistence.createEntityManagerFactory("serpis.ad.proyectofinal");
		
		
	}
	public static void delete() {
		
	}
	
	
	public static void show() {
		entityManagerFactory=Persistence.createEntityManagerFactory("serpis.ad.proyectofinal");
		entityManager=entityManagerFactory.createEntityManager();
		List<Categoria>categorias= entityManager.createQuery("from categoria order by id", Categoria.class).getResultList();
		for (Categoria categoria : categorias)
			System.out.printf("%d %s %n", categoria.getId(), categoria.getNombre());	
	     entityManager.close();
	}
	
	





}
