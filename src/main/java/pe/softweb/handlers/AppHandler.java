package pe.softweb.handlers;

import org.json.JSONArray;
import org.json.JSONObject;
import pe.softweb.app.App;
import pe.softweb.utils.Constantes;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.HashMap;
import java.util.Map;

public class AppHandler {
    public static Route index = (Request request, Response response) -> {
    		Map<String, Object> model = new HashMap<>();
    		JSONArray menuJSONArray = new JSONArray();
    		JSONObject tempJSONObject = new JSONObject();
    		
    		JSONObject usuariosJSONObject = new JSONObject(); JSONArray usuariosJSONArrayItems = new JSONArray();
    		tempJSONObject.put("item", "Listado"); tempJSONObject.put("url", "#/accesos/usuarios"); 
    		usuariosJSONArrayItems.put(tempJSONObject);
    		usuariosJSONObject.put("subtitulo", "Usuarios"); usuariosJSONObject.put("items", usuariosJSONArrayItems); 
    		menuJSONArray.put(usuariosJSONObject);
    		
    		JSONObject sistemasJSONObject = new JSONObject(); JSONArray sistemasJSONArrayItems = new JSONArray();
    		tempJSONObject.put("item", "Listado"); tempJSONObject.put("url", "#/accesos/sistemas"); 
    		sistemasJSONArrayItems.put(tempJSONObject);
    		sistemasJSONObject.put("subtitulo", "Sistemas"); usuariosJSONObject.put("items", sistemasJSONArrayItems); 
    		menuJSONArray.put(sistemasJSONObject);
    		
    		JSONObject logsJSONObject = new JSONObject(); JSONArray logsJSONArrayItems = new JSONArray();
    		tempJSONObject.put("item", "Errores"); tempJSONObject.put("url", "#/log/errores"); 
    		logsJSONArrayItems.put(tempJSONObject);
    		JSONObject temp2JSONObject = new JSONObject(); temp2JSONObject.put("item", "Operaciones"); temp2JSONObject.put("url", "#/log/operaciones"); 
    		logsJSONArrayItems.put(temp2JSONObject);
    		logsJSONObject.put("subtitulo", "Logs"); logsJSONObject.put("items", logsJSONArrayItems); 
    		menuJSONArray.put(logsJSONObject);
    		
        model.put("partial", "templates/home/index.vm");
        model.put("title", "Mantenimiento - Accesós");
        model.put("css", Constantes.getMapita().get("STATIC_URL") + "dist/assets/mantenimiento.min.css");
        model.put("js", Constantes.getMapita().get("STATIC_URL") + "dist/assets/mantenimiento.min.js"); 
        model.put("data", "");
        model.put("submenu", menuJSONArray.toString());
        return App.renderTemplate("templates/layouts/home.vm", model);
    };

    public static Route login = (Request request, Response response) -> {
        Map<String, Object> model = new HashMap<>();
        model.put("partial", "templates/login/index.vm");
        model.put("title", "Mantenimiento - Accesos");
        model.put("css", Constantes.getMapita().get("STATIC_URL") + "dist/assets/login.min.css");
        model.put("js", "");
        model.put("data", "");
        return App.renderTemplate("templates/layouts/blank.vm", model);
    };
}

