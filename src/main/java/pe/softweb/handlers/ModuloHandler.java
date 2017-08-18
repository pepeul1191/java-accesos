package pe.softweb.handlers;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.support.ConnectionSource;
import org.json.JSONObject;
import pe.softweb.models.Modulo;
import pe.softweb.utils.Conexion;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.ArrayList;
import java.util.List;

public class ModuloHandler {
    public static Route listar = (Request request, Response response) -> {
        String rpta = "";

        try {
            int sistemaId = Integer.parseInt(request.params(":sistema_id"));
            Conexion conexion = new Conexion();
            ConnectionSource connectionSource = conexion.getConnectionSource();

            List<JSONObject> rptaTemp = new ArrayList<JSONObject>();
            Dao<Modulo, String> moduloDao = DaoManager.createDao(connectionSource, Modulo.class);
            List<Modulo> moduloList = moduloDao.queryBuilder().where().eq("sistema_id", sistemaId).query();

            for (Modulo modulo: moduloList) {
                JSONObject obj = new JSONObject();
                obj.put("id", modulo.getId());
                obj.put("nombre", modulo.getNombre());
                obj.put("url", modulo.getUrl());
                rptaTemp.add(obj);
            }

            rpta = rptaTemp.toString();
        } catch (Exception e) {
            //e.printStackTrace();
            JSONObject rptaTry = new JSONObject();
            rptaTry.put("tipo_mensaje", "error");
            String[] error = {"Se ha producido un error en  listar los módulos", e.toString()};
            rptaTry.put("mensaje", error);
            System.out.println( rptaTry.toString());
            return rptaTry;
        }

        return rpta;
    };
}
