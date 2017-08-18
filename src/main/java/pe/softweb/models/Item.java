package pe.softweb.models;

import java.io.Serializable;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "items")
public class Item implements Serializable {
    private static final long serialVersionUID = 1L;
    @DatabaseField(id = true)
    private int id;
    @DatabaseField(canBeNull = false, columnName = "nombre")
    private String nombre;
    @DatabaseField(canBeNull = false, columnName = "url")
    private String url;
    @DatabaseField(canBeNull = false, foreign = true)
    private Subtitulo subtitulo;

    Item() {
    }
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }
    public Subtitulo getSubtitulo() { return subtitulo; }
    public void setSubtitulo(Subtitulo subtitulo) { this.subtitulo= subtitulo; }
}