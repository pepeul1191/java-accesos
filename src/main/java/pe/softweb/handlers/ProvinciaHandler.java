package pe.softweb.handlers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.support.ConnectionSource;

import pe.softweb.app.App;
import pe.softweb.models.Provincia;
import pe.softweb.utils.Conexion;
import pe.softweb.utils.Constantes;
import pe.softweb.utils.Httparty;
import spark.Request;
import spark.Response;
import spark.Route;

public class ProvinciaHandler {	 
	 public static Route listar = (Request request, Response response) -> {
		 String rpta = "";
		 
		 try {
			 	int departamentoId = Integer.parseInt(request.params(":departamento_id"));
				Conexion conexion = new Conexion();
				ConnectionSource connectionSource = conexion.getConnectionSource();
				
				List<JSONObject> rptaTemp = new ArrayList<JSONObject>();
				Dao<Provincia, String> provinciaDao = DaoManager.createDao(connectionSource, Provincia.class);
				QueryBuilder<Provincia, String> queryBuilder = provinciaDao.queryBuilder();
				List<Provincia> provinciaList = provinciaDao.queryBuilder().where().eq("departamento_id", departamentoId).query();
				
				for (Provincia provincia : provinciaList) {
				    JSONObject obj = new JSONObject();
			        obj.put("id", provincia.getId());
			        obj.put("nombre", provincia.getNombre());
			        rptaTemp.add(obj);
				}
				
				rpta = rptaTemp.toString();
			} catch (Exception e) {
				//e.printStackTrace();
				JSONObject rptaTemp = new JSONObject();
				rptaTemp.put("tipo_mensaje", "error");
		        String[] error = {"Se ha producido un error en  listar las provincias de un determinado departamento", e.toString()};
		        rptaTemp.put("mensaje", error);
		        
		        System.out.println( rptaTemp.toString());
			}
		 
		 return rpta;
	 };
}
