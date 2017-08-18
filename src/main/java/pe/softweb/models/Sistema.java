package pe.softweb.models;

import java.io.Serializable;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "sistemas")
public class Sistema implements Serializable {
    private static final long serialVersionUID = 1L;
    @DatabaseField(id = true)
    private int id;
    @DatabaseField(canBeNull = false, columnName = "nombre")
    private String nombre;
    @DatabaseField(canBeNull = false, columnName = "version")
    private String version;
    @DatabaseField(canBeNull = false, columnName = "respositorio")
    private String repositorio;
    Sistema(){

    }
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getVersion() { return version; }
    public void setVersion(String version) { this.version = version; }
    public String getRepositorio() { return repositorio; }
    public void setRepositorio(String repositorio) { this.repositorio = repositorio; }
    @Override
    public String toString() { return "Sistema{" + "id=" + id + ", nombre='" + nombre + '\'' + ", version='" + version + '\'' + ", repositorio='" + repositorio + '\'' + '}';
    }
}
