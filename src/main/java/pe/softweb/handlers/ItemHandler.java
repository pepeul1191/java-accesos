package pe.softweb.handlers;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import org.json.JSONObject;
import pe.softweb.models.Item;
import pe.softweb.utils.Conexion;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.ArrayList;
import java.util.List;

public class ItemHandler {
    public static Route listar = (Request request, Response response) -> {
        String rpta = "";

        try {
            int subtituloId = Integer.parseInt(request.params(":subtitulo_id"));
            Conexion conexion = new Conexion();
            ConnectionSource connectionSource = conexion.getConnectionSource();

            List<JSONObject> rptaTemp = new ArrayList<JSONObject>();
            Dao<Item, String> itemDao = DaoManager.createDao(connectionSource, Item.class);
            List<Item> itemList = itemDao.queryBuilder().where().eq("subtitulo_id", subtituloId).query();

            for (Item item: itemList) {
                JSONObject obj = new JSONObject();
                obj.put("id", item.getId());
                obj.put("nombre", item.getNombre());
                obj.put("url", item.getUrl());
                rptaTemp.add(obj);
            }

            rpta = rptaTemp.toString();
        } catch (Exception e) {
            //e.printStackTrace();
            JSONObject rptaTry = new JSONObject();
            rptaTry.put("tipo_mensaje", "error");
            String[] error = {"Se ha producido un error en  listar los items", e.toString()};
            rptaTry.put("mensaje", error);
            System.out.println( rptaTry.toString());
            return rptaTry;
        }

        return rpta;
    };
}