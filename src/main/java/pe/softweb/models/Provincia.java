package pe.softweb.models;

import java.io.Serializable;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "provincias")
public class Provincia implements Serializable {
	private static final long serialVersionUID = 1L;
	@DatabaseField(id = true)
	private int id;
	@DatabaseField(canBeNull = false, columnName = "nombre")
	private String nombre;
	@DatabaseField(canBeNull = false, foreign = true)
    private Departamento departamento;
	Provincia(){
		
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
	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	@Override
	public String toString() {
		return "Provincia [id=" + id + ", nombre=" + nombre + ", departamento=" + departamento + "]";
	}
}