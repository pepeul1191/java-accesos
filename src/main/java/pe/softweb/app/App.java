package pe.softweb.app;

import static spark.Spark.*;
import spark.*;
import spark.template.velocity.*;
import java.util.Map;
import pe.softweb.handlers.EstadoUsuarioHandler;
import pe.softweb.handlers.SistemaHandler;

public class App{
    public static void main(String[] args) {
	    	exception(Exception.class, (e, req, res) -> e.printStackTrace()); 
	    	staticFiles.location("/public");
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
	        response.header("Server",  "Ubuntu, Jetty");
	        // Note: this may or may not be necessary in your particular application
	        //response.type("application/json");
	    });
	    
		get("/sistema", SistemaHandler.index);
	    	get("/sistema/listar", SistemaHandler.listar);
	    	get("/estado_usuario/listar", EstadoUsuarioHandler.listar);
    }   
    
    public static String renderTemplate(String template, Map model) {
        return new VelocityTemplateEngine().render(new ModelAndView(model, template));
    }
}
