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
import pe.softweb.models.Distrito;
import pe.softweb.utils.Conexion;
import pe.softweb.utils.Constantes;
import pe.softweb.utils.Httparty;
import spark.Request;
import spark.Response;
import spark.Route;

public class DistritoHandler {	 
	 public static Route listar = (Request request, Response response) -> {
		 String rpta = "";
		 
		 try {
			 	int provinciaId = Integer.parseInt(request.params(":provincia_id"));
				Conexion conexion = new Conexion();
				ConnectionSource connectionSource = conexion.getConnectionSource();
				
				List<JSONObject> rptaTemp = new ArrayList<JSONObject>();
				Dao<Distrito, String> distritoDao = DaoManager.createDao(connectionSource, Distrito.class);
				QueryBuilder<Distrito, String> queryBuilder = distritoDao.queryBuilder();
				List<Distrito> distritoList = distritoDao.queryBuilder().where().eq("provincia_id", provinciaId).query();
				
				for (Distrito distrito : distritoList) {
				    JSONObject obj = new JSONObject();
			        obj.put("id", distrito.getId());
			        obj.put("nombre", distrito.getNombre());
			        rptaTemp.add(obj);
				}
				
				rpta = rptaTemp.toString();
			} catch (Exception e) {
				//e.printStackTrace();
				JSONObject rptaTemp = new JSONObject();
				rptaTemp.put("tipo_mensaje", "error");
		        String[] error = {"Se ha producido un error en  listar los distritos de un determinada provincia", e.toString()};
		        rptaTemp.put("mensaje", error);
		        
		        System.out.println( rptaTemp.toString());
			}
		 
		 return rpta;
	 };
}
