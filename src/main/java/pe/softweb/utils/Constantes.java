package pe.softweb.utils;

import java.util.HashMap;

public class Constantes {
    private static HashMap<String, String> mapa = new HashMap<String, String>();

    public static final String BASE_URL = "http://127.0.0.1:2000/";
    public static final String STATIC_URL = "http://127.0.0.1:2000/";

	public static void set(String llave, String valor){
	    mapa.put(llave, valor);
	}
	
	public static String get(String llave){
	    if(mapa.containsKey(llave)){
	        return mapa.get(llave);
	    }else{
	        return "null";
	    }
	}
}
