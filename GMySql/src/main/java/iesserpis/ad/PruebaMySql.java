package iesserpis.ad;

import java.sql.Connection;
import java.util.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.xdevapi.PreparableStatement;

public class PruebaMySql {

	private static Connection connection;
	
	public static void main(String[] args) throws SQLException{
		
		connection= DriverManager.getConnection("jdbc:mysql://localhost/dbprueba?serverTimezone=UTC",
				"root", "sistemas");
		
		insert();
		update();
		delete();
		ShowAll();
		connection.close();
		
	}
	private static void ShowAll() throws SQLException {
		Statement statement=connection.createStatement();
		ResultSet resultSet=statement.executeQuery("select * from categoria order by id");
		
		while(resultSet.next()) {
			
			System.out.printf("id=%s nombre=%s %n",resultSet.getObject(1),resultSet.getObject(2));
		}
		
		statement.close();
		
	}
	private static void insert() throws SQLException{
		
		PreparedStatement preparedStatement=connection.prepareStatement("insert into categoria(nombre) values (?)");
		preparedStatement.setObject(1, "cat 52");
		preparedStatement.executeUpdate();
		preparedStatement.close();
	}
	private static void update() throws SQLException{
		PreparedStatement preparedStatement=connection.prepareStatement("update categoria set nombre=? where id=?");
		Scanner tcl=new Scanner (System.in);
		System.out.println("Inserta el id que quieras cambiar:");
		int id=tcl.nextInt();
		preparedStatement.setObject(1, id);
		System.out.println("Inserta el nombre nuevo: ");
		String nombre=tcl.nextLine();
		preparedStatement.setObject(2,nombre);
		preparedStatement.executeUpdate();
		preparedStatement.close();
	}
	private static void delete()throws SQLException{
		PreparedStatement preparedStatement=connection.prepareStatement("delete from categoria where id=?");
		Scanner tcl=new Scanner(System.in);
		System.out.println("Inserta el id que quieras borrar");
		int id=tcl.nextInt();
		preparedStatement.setObject(1, id);
		preparedStatement.executeUpdate();
		preparedStatement.close();
	}
	
	
	
	
}


