package pe.softweb.handlers;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import org.json.JSONObject;
import pe.softweb.models.Subtitulo;
import pe.softweb.utils.Conexion;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.ArrayList;
import java.util.List;

public class SubtituloHandler {
    public static Route listar = (Request request, Response response) -> {
        String rpta = "";

        try {
            int moduloId = Integer.parseInt(request.params(":modulo_id"));
            Conexion conexion = new Conexion();
            ConnectionSource connectionSource = conexion.getConnectionSource();

            List<JSONObject> rptaTemp = new ArrayList<JSONObject>();
            Dao<Subtitulo, String> subtituloDao = DaoManager.createDao(connectionSource, Subtitulo.class);
            List<Subtitulo> subtituloList = subtituloDao.queryBuilder().where().eq("modulo_id", moduloId).query();

            for (Subtitulo subtitulo: subtituloList) {
                JSONObject obj = new JSONObject();
                obj.put("id", subtitulo.getId());
                obj.put("nombre", subtitulo.getNombre());
                rptaTemp.add(obj);
            }

            rpta = rptaTemp.toString();
        } catch (Exception e) {
            //e.printStackTrace();
            JSONObject rptaTry = new JSONObject();
            rptaTry.put("tipo_mensaje", "error");
            String[] error = {"Se ha producido un error en  listar los subtitulos", e.toString()};
            rptaTry.put("mensaje", error);
            System.out.println( rptaTry.toString());
            return rptaTry;
        }

        return rpta;
    };
}