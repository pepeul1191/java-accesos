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
import spark.Request;
import spark.Response;
import spark.Route;

import pe.softweb.app.App;
import pe.softweb.models.Departamento;
import pe.softweb.utils.Conexion;
import pe.softweb.utils.Constantes;
import pe.softweb.utils.Httparty;

public class DepartamentoHandler {
	public static Route index = (Request request, Response response) -> {
		Map<String, Object> model = new HashMap<>();
		model.put("partial", "templates/departamento/index.vm");
		model.put("title", "Departamentos del Perú");
		model.put("css", Constantes.getMapita().get("STATIC_URL") + "dist/assets/styles.min.css");
		model.put("js", Constantes.getMapita().get("STATIC_URL") + "dist/departamento/app.min.js");
		return App.renderTemplate("templates/layouts/blank.vm", model);
	 };
	 
	 public static Route buscar = (Request request, Response response) -> {
		 String nombre = request.queryParams("nombre");
		 Httparty buscarDepartamento = new Httparty("http://127.0.0.1:3000/ulima/practica2/departamento/buscar?nombre=" + nombre, "GET");
		 buscarDepartamento.action();
		 return buscarDepartamento.getRpta();
	 };
	 
	 public static Route listar = (Request request, Response response) -> {
		 String rpta = "";
		 
		 try {
				Conexion conexion = new Conexion();
				ConnectionSource connectionSource = conexion.getConnectionSource();
				
				List<JSONObject> rptaTemp = new ArrayList<JSONObject>();
				Dao<Departamento, String> departamentoDao = DaoManager.createDao(connectionSource, Departamento.class);
				QueryBuilder<Departamento, String> queryBuilder = departamentoDao.queryBuilder();
				PreparedQuery<Departamento> preparedQuery = queryBuilder.prepare();
				List<Departamento> departamentoList = departamentoDao.query(preparedQuery);
				
				for (Departamento departamento : departamentoList) {
				    JSONObject obj = new JSONObject();
			        obj.put("id", departamento.getId());
			        obj.put("nombre", departamento.getNombre());
			        rptaTemp.add(obj);
				}
				
				rpta = rptaTemp.toString();
			} catch (Exception e) {
				//e.printStackTrace();
				JSONObject rptaTemp = new JSONObject();
				rptaTemp.put("tipo_mensaje", "error");
		        String[] error = {"Se ha producido un error en  listar los departamentos", e.toString()};
		        rptaTemp.put("mensaje", error);
		        
		        System.out.println( rptaTemp.toString());
			}
		 
		 return rpta;
	 };
}
