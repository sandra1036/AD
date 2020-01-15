package Serpis.ad.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Serpis.ad.Clases.Categoria;
import Serpis.ad.Libreria.App;

public class CategoriaDao {
	
	public static EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("serpis.ad.ProyectoFinal");
	
	public static void insertar() {
		Scanner tcl=new Scanner(System.in);
		Categoria categoria=new Categoria();
		System.out.println("Dime el nombre de la categoria:");
		String nombre=tcl.nextLine();
		categoria.setNombre(nombre);
		EntityManager entityManager=entityManagerFactory.createEntityManager();//PreparedStatement para las consultas
		entityManager.getTransaction().begin();
		entityManager.persist(categoria);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
	}
	





}
