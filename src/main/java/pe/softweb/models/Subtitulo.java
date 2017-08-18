package pe.softweb.models;

import java.io.Serializable;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "subtitulos")
public class Subtitulo implements Serializable {
    private static final long serialVersionUID = 1L;
    @DatabaseField(id = true)
    private int id;
    @DatabaseField(canBeNull = false, columnName = "nombre")
    private String nombre;
    @DatabaseField(canBeNull = false, foreign = true)
    private Modulo modulo;

    Subtitulo() {

    }
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public Modulo getModulo() { return modulo; }
    public void setModulo(Modulo modulo) { this.modulo = modulo; }
    @Override
    public String toString() { return "Subtitulo{" + "id=" + id + ", nombre='" + nombre + '\'' + ", modulo=" + modulo + '}';
    }
}