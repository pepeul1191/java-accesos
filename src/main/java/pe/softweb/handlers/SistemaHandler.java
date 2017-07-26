package pe.softweb.handlers;

import java.util.HashMap;
import java.util.Map;

import pe.softweb.app.App;
import spark.Request;
import spark.Response;
import spark.Route;
	
public class SistemaHandler{
	public static Route listar = (Request request, Response response) -> {
		 String rpta = "listarSistemaHandler";		 
		 return rpta;
	 };
	 
	public static Route index = (Request request, Response response) -> {
		Map<String, Object> model = new HashMap<>();
		model.put("partial", "templates/sistema/index.vm");
		return App.renderTemplate("templates/layouts/blank.vm", model);
	 };
}
