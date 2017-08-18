package pe.softweb.handlers;

import org.json.JSONObject;
import spark.Request;
import spark.Response;
import spark.Route;

public class IndexHandler {
    public static Route index = (Request request, Response response) -> {
        JSONObject rptaTemp = new JSONObject();
        rptaTemp.put("tipo_mensaje", "error");
        String[] error = {"Error: URL vacía", ""};
        rptaTemp.put("mensaje", error);

        return rptaTemp.toString();
    };
}

