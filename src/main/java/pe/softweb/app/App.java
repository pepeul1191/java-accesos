package pe.softweb.app;

import static spark.Spark.*;
import spark.*;
import spark.template.velocity.*;
import java.util.Map;
import pe.softweb.utils.Constantes;
import pe.softweb.handlers.IndexHandler;
import pe.softweb.handlers.EstadoUsuarioHandler;
import pe.softweb.handlers.ItemHandler;
import pe.softweb.handlers.ModuloHandler;
import pe.softweb.handlers.SubtituloHandler;

public class App{
	public static void main(String[] args) {
		exception(Exception.class, (e, req, res) -> e.printStackTrace());
		staticFiles.location("/public");
		staticFiles.header("Access-Control-Allow-Origin", "*");
		staticFiles.header("Access-Control-Request-Method",  "*");
		staticFiles.header("Access-Control-Allow-Headers",  "*");
		staticFiles.expireTime(600);
		port(2000);

		options("/*", (request, response) -> {
			String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
			if (accessControlRequestHeaders != null) {
				response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
			}

			String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
			if (accessControlRequestMethod != null) {
				response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
			}

			return "OK";
		});

		before((request, response) -> {
			response.header("Access-Control-Allow-Origin", "*");
			response.header("Access-Control-Request-Method",  "*");
			response.header("Access-Control-Allow-Headers",  "*");
			response.header("Access-Control-Allow-Credentials", "true");
			response.header("Server",  "Ubuntu, Jetty");
			// Note: this may or may not be necessary in your particular application
			//response.type("application/json");
		});

		get("/", IndexHandler.index);
		get("/estado_usuario/listar", EstadoUsuarioHandler.listar);
		get("/item/listar/:subtitulo_id", ItemHandler.listar);
		get("/modulo/listar/:sistema_id", ModuloHandler.listar);
		get("/subtitulo/listar/:modulo_id", SubtituloHandler.listar);
	}
    
    public static String renderTemplate(String template, Map model) {
		model.put("constantes", Constantes.getMapita());
        return new VelocityTemplateEngine().render(new ModelAndView(model, template));
    }
}
