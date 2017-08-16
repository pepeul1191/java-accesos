package pe.softweb.models;

import java.io.Serializable;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "distritos")
public class Distrito implements Serializable {
	private static final long serialVersionUID = 1L;
	@DatabaseField(id = true)
	private int id;
	@DatabaseField(canBeNull = false, columnName = "nombre")
	private String nombre;
	@DatabaseField(canBeNull = false, foreign = true)
    private Departamento provincia;
	Distrito(){
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Departamento getProvincia() {
		return provincia;
	}
	public void setProvincia(Departamento provincia) {
		this.provincia = provincia;
	}
	@Override
	public String toString() {
		return "Distrito [id=" + id + ", nombre=" + nombre + ", provincia=" + provincia + "]";
	}
}