package pe.softweb.handlers;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.support.ConnectionSource;
import spark.Request;
import spark.Response;
import spark.Route;
import pe.softweb.models.EstadoUsuario;
import pe.softweb.utils.Conexion;

public class EstadoUsuarioHandler {
    public static Route listar = (Request request, Response response) -> {
        String rpta = "";

        try {
            Conexion conexion = new Conexion();
            ConnectionSource connectionSource = conexion.getConnectionSource();

            List<JSONObject> rptaTemp = new ArrayList<JSONObject>();
            Dao<EstadoUsuario, String> departamentoDao = DaoManager.createDao(connectionSource, EstadoUsuario.class);
            QueryBuilder<EstadoUsuario, String> queryBuilder = departamentoDao.queryBuilder();
            PreparedQuery<EstadoUsuario> preparedQuery = queryBuilder.prepare();
            List<EstadoUsuario> estadoUsuariosList = departamentoDao.query(preparedQuery);

            for (EstadoUsuario estadoUsuario : estadoUsuariosList) {
                JSONObject obj = new JSONObject();
                obj.put("id", estadoUsuario.getId());
                obj.put("nombre", estadoUsuario.getNombre());
                rptaTemp.add(obj);
            }

            rpta = rptaTemp.toString();
        } catch (Exception e) {
            //e.printStackTrace();
            JSONObject rptaTry = new JSONObject();
            rptaTry.put("tipo_mensaje", "error");
            String[] error = {"Se ha producido un error en  listar los estados de usuario", e.toString()};
            rptaTry.put("mensaje", error);
            System.out.println( rptaTry.toString());
            return rptaTry;
        }

        return rpta;
    };
}