package pe.softweb.handlers;

import java.util.HashMap;
import java.util.Map;
import spark.Request;
import spark.Response;
import spark.Route;
import org.json.JSONArray;
import org.json.JSONObject;

import pe.softweb.app.App;
import pe.softweb.utils.Constantes;

public class HomeHandler {
	public static Route index = (Request request, Response response) -> {
		JSONArray menuJSONArray = new JSONArray();
		JSONObject menuHomeJSONObject = new JSONObject();
		JSONObject buscarHomeJSONObject = new JSONObject();
		JSONObject contactoHomeJSONObject = new JSONObject();
		menuHomeJSONObject.put("url", "#/"); menuHomeJSONObject.put("nombre", "Home"); menuJSONArray.put(menuHomeJSONObject);
		buscarHomeJSONObject.put("url", "#/buscar"); buscarHomeJSONObject.put("nombre", "Buscar"); menuJSONArray.put(buscarHomeJSONObject);
		contactoHomeJSONObject.put("url", "#/contacto"); contactoHomeJSONObject.put("nombre", "Contacto"); menuJSONArray.put(contactoHomeJSONObject);
		
		Map<String, Object> model = new HashMap<>();
		model.put("partial", "templates/home/index.vm");
		model.put("title", "Departamentos del Perú");
		model.put("css", Constantes.getMapita().get("STATIC_URL") + "dist/assets/styles.min.css");
		model.put("js", Constantes.getMapita().get("STATIC_URL") + "dist/home/app.min.js");
		model.put("data", "");
		model.put("menu", menuJSONArray.toString());
		return App.renderTemplate("templates/layouts/blank-handlebars.vm", model);
	 };
}
