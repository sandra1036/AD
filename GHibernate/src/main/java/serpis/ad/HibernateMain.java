package serpis.ad;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateMain {

	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("serpis.ad.ghibernate");//conexion a la base de datos
		Categoria categoria=new Categoria();
		categoria.setNombre("cat 33"+ LocalDateTime.now());
		
		EntityManager entityManager=entityManagerFactory.createEntityManager();//PreparedStatement para las consultas
		entityManager.persist(categoria);
		entityManager.close();
		
		
		entityManagerFactory.close();

	}

}
