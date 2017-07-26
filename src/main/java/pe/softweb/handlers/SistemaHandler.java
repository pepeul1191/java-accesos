package pe.softweb.handlers;

import spark.Request;
import spark.Response;
import spark.Route;
	
public class SistemaHandler{
	public static Route listar = (Request request, Response response) -> {
		 String rpta = "lisarSistemaHandler";		 
		 return rpta;
	 };
}
