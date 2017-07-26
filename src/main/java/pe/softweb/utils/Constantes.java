package pe.softweb.utils;

import java.util.HashMap;

public class Constantes {
	static HashMap<String, String> mapita = new HashMap<String, String>();
	
	public static HashMap getMapita() {
		mapita.put("BASE_URL", "http://127.0.0.1:2000/");
		mapita.put("STATIC_URL", "http://127.0.0.1:2000/");
		
		return mapita;
	}
}
