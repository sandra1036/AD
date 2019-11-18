package iesserpis.ad;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CategoriaDao {
	
	
	
	/**
	 * Carga la categoria con el id indicado de la base de datos o null si no existe.
	 * @param id
	 * @return categoria con ese id o null si no existe
	 */
	
	public static Categoria load(Object id) {
		return null;
	}
	public static int save(Categoria categoria) throws SQLException {
		if(categoria.getId()==0) {
			insert(categoria);
		}else {
			update(categoria);
		}
		return 0;
		
	}
	private static String insertSql="insert into categoria(nombre) values (?)";
	private static int insert(Categoria categoria) throws SQLException {
		
		try(PreparedStatement preparedStatement = App.getInstance().getConnection().prepareStatement(insertSql)){
			preparedStatement.setString(1, categoria.getNombre());
			return preparedStatement.executeUpdate();

		}
		
	}
	private static String updatesql="update categoria set nombre=? where id=?";
	private static int update(Categoria categoria)throws SQLException {
		
		try(PreparedStatement preparedStatement=App.getInstance().getConnection().prepareStatement(updatesql)){
			
			preparedStatement.setString(1, categoria.getNombre());
			preparedStatement.setObject(2, categoria.getId());
		
			return preparedStatement.executeUpdate();
		}
	
	}
	private static String deletesql="delete from categoria where id=?";
	private static int delete(Categoria categoria)throws SQLException {
		
		try(PreparedStatement preparedStatement=App.getInstance().getConnection().prepareStatement(deletesql)){
		
			preparedStatement.setObject(1, categoria.getId());
		
			return preparedStatement.executeUpdate();
		}
	
	}


}
