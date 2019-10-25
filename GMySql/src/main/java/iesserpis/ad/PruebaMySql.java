package iesserpis.ad;

import java.sql.Connection;
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
		
		
		ShowAll();
		insert();
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
		preparedStatement.setObject(1, "cat 5");
		preparedStatement.executeUpdate();
		preparedStatement.close();
	}
	
	
	
}


