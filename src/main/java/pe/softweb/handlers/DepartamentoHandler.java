package pe.softweb.handlers;

import java.util.HashMap;
import java.util.Map;

import pe.softweb.app.App;
import pe.softweb.utils.Constantes;
import spark.Request;
import spark.Response;
import spark.Route;

public class DepartamentoHandler {
	public static Route index = (Request request, Response response) -> {
		Map<String, Object> model = new HashMap<>();
		model.put("partial", "templates/departamento/index.vm");
		model.put("title", "Departamentos del Perú");
		model.put("css", Constantes.getMapita().get("STATIC_URL") + "dist/assets/styles.min.css");
		model.put("js", Constantes.getMapita().get("STATIC_URL") + "dist/departamento/app.min.js");
		return App.renderTemplate("templates/layouts/blank.vm", model);
	 };
}
