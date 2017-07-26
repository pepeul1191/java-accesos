package pe.softweb.handlers;

import spark.Request;
import spark.Response;
import spark.Route;

public class EstadoUsuarioHandler {	
	public static Route listar = (Request request, Response response) -> {
		 String rpta = "listarEstadoUsuarioHandler";
		 return rpta;
	 };
}
