package pe.softweb.app;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.support.ConnectionSource;

import pe.softweb.models.Departamento;
import pe.softweb.utils.Conexion;

public class Test {

	public static void main(String[] args) {		
		try {
			Conexion conexion = new Conexion();
			ConnectionSource connectionSource = conexion.getConnectionSource();
			
			List<JSONObject> rpta = new ArrayList<JSONObject>();
			Dao<Departamento, String> departamentoDao = DaoManager.createDao(connectionSource, Departamento.class);
			QueryBuilder<Departamento, String> queryBuilder = departamentoDao.queryBuilder();
			PreparedQuery<Departamento> preparedQuery = queryBuilder.prepare();
			List<Departamento> departamentoList = departamentoDao.query(preparedQuery);
			
			for (Departamento departamento : departamentoList) {
			    JSONObject obj = new JSONObject();
		        obj.put("id", departamento.getId());
		        obj.put("nombre", departamento.getNombre());
		        rpta.add(obj);
			}
			System.out.println(rpta.toString());
		} catch (Exception e) {
			//e.printStackTrace();
			JSONObject rpta = new JSONObject();
	        rpta.put("tipo_mensaje", "error");
	        String[] error = {"Se ha producido un error en  listar los departamentos", e.toString()};
	        rpta.put("mensaje", error);
	        System.out.println(rpta.toString());
		}
	}

}
