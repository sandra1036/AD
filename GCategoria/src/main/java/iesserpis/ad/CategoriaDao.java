package iesserpis.ad;

import java.sql.PreparedStatement;

public class CategoriaDao {
	
	
	
	/**
	 * Carga la categoria con el id indicado de la base de datos o null si no existe.
	 * @param id
	 * @return categoria con ese id o null si no existe
	 */
	
	public static Categoria load(Object id) {
		return null;
	}
	public static int save(Categoria categoria) {
		if(categoria.getId()==0) {
			insert(categoria);
		}else {
			update(categoria);
		}
	}
	private static String insertSql="insert into categoria(nombre) values (?)";
	private static int insert(Categoria categoria) {
		try(PreparedStatement preparedStatement=App.GetIntance().getConnection().prepareStatement(insertSql)){
			preparedStatement.setString(1, categoria.getNombre());
			return preparedStatement.executeUpdate();

		}
	}


}
