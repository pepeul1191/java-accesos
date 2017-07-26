package pe.softweb.handlers;

import java.util.HashMap;
import java.util.Map;

import pe.softweb.app.App;
import pe.softweb.utils.Constantes;
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
		model.put("constantes", Constantes.getMapita());
		return App.renderTemplate("templates/sistema/index.vm", model);
	 };
}
