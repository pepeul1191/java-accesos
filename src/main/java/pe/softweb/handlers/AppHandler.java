package pe.softweb.handlers;

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
        model.put("partial", "templates/home/index.vm");
        model.put("title", "Mantenimiento - Accesós");
        model.put("css", Constantes.getMapita().get("STATIC_URL") + "dist/assets/mantenimiento.min.css");
        model.put("js", Constantes.getMapita().get("STATIC_URL") + "dist/assets/mantenimiento.min.js"); 
        model.put("data", "");
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

