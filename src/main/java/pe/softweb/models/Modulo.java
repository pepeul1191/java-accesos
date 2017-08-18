package pe.softweb.models;

import java.io.Serializable;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "modulos")
public class Modulo implements Serializable {
    private static final long serialVersionUID = 1L;
    @DatabaseField(id = true)
    private int id;
    @DatabaseField(canBeNull = false, columnName = "nombre")
    private String nombre;
    @DatabaseField(canBeNull = false, columnName = "url")
    private String url;
    @DatabaseField(canBeNull = false, columnName = "icono")
    private String icono;
    @DatabaseField(canBeNull = false, foreign = true)
    private Sistema sistema;

    Modulo() {
    }
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }
    public String getIcono() { return icono; }
    public void setIcono(String icono) { this.icono = icono; }
    public Sistema getSistema() { return sistema; }
    public void setSistema(Sistema sistema) { this.sistema = sistema; }
}