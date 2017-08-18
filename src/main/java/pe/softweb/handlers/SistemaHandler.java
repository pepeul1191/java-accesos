package pe.softweb.handlers;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.support.ConnectionSource;
import org.json.JSONObject;
import pe.softweb.models.Sistema;
import pe.softweb.utils.Conexion;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.ArrayList;
import java.util.List;

public class SistemaHandler {
    public static Route listar = (Request request, Response response) -> {
        String rpta = "";

        try {
            Conexion conexion = new Conexion();
            ConnectionSource connectionSource = conexion.getConnectionSource();

            List<JSONObject> rptaTemp = new ArrayList<JSONObject>();
            Dao<Sistema, String> sistemaDao = DaoManager.createDao(connectionSource, Sistema.class);
            QueryBuilder<Sistema, String> queryBuilder = sistemaDao.queryBuilder();
            PreparedQuery<Sistema> preparedQuery = queryBuilder.prepare();
            List<Sistema> sistemaList = sistemaDao.query(preparedQuery);

            for (Sistema sistema : sistemaList) {
                JSONObject obj = new JSONObject();
                obj.put("id", sistema.getId());
                obj.put("nombre", sistema.getNombre());
                obj.put("version", sistema.getVersion());
                obj.put("repositorio", sistema.getRepositorio());
                rptaTemp.add(obj);
            }

            rpta = rptaTemp.toString();
        } catch (Exception e) {
            //e.printStackTrace();
            JSONObject rptaTry = new JSONObject();
            rptaTry.put("tipo_mensaje", "error");
            String[] error = {"Se ha producido un error en  listar los sistemas registrado", e.toString()};
            rptaTry.put("mensaje", error);
            System.out.println( rptaTry.toString());
            return rptaTry;
        }

        return rpta;
    };
}