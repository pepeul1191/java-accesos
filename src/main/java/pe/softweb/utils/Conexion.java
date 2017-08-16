package pe.softweb.utils;

import java.sql.SQLException;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;

public class Conexion {
	private ConnectionSource connectionSource;
	public Conexion() throws SQLException{
		String databaseUrl = "jdbc:sqlite:db/db_ubicaciones.db";
		connectionSource = new JdbcConnectionSource(databaseUrl);
	}
	public ConnectionSource getConnectionSource() {
		return connectionSource;
	}
}
