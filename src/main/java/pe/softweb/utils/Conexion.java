package pe.softweb.utils;

import java.sql.SQLException;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;

public class Conexion {
	private ConnectionSource connectionSource;
	public Conexion(){
		String databaseUrl = "jdbc:sqlite:db_ubicaciones.db";
		try {
			connectionSource = new JdbcConnectionSource(databaseUrl);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public ConnectionSource getConnectionSource() {
		return connectionSource;
	}
}
