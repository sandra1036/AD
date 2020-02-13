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
	
	public static EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("serpis.ad.proyectofinal");;
	public static EntityManager entityManager =entityManagerFactory.createEntityManager();
	public static Categoria categoria;
	
	
	public static void insertar() {
		Scanner tcl=new Scanner(System.in);
		categoria=new Categoria();
		System.out.println("Dime el nombre de la categoria:");
		String nombre=tcl.nextLine();
		categoria.setNombre(nombre);
		entityManager.getTransaction().begin();
		entityManager.persist(categoria);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();

	}

	public static void update() {
		Scanner tcl=new Scanner(System.in);
		System.out.println("Categoria a cambiar");
		Long id_cat=tcl.nextLong();
		categoria=entityManager.find(Categoria.class, id_cat);
		Scanner tcl2=new Scanner(System.in);
		System.out.println("Elige el nuevo nombre:");
		entityManager.getTransaction().begin();
		categoria.setNombre(tcl2.nextLine());
		entityManager.getTransaction().commit();
		entityManager.close();
		
		
	}
	
	public static void show() {
		List<Categoria>categorias= entityManager.createQuery("from categoria order by id", Categoria.class).getResultList();
		for (Categoria categoria : categorias)
			System.out.printf("%d %s %n", categoria.getId(), categoria.getNombre());	
	    
	}
	
	





}
