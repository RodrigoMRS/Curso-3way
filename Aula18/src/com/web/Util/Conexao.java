package com.web.Util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	public static String url = "jdbc:postgresql://localhost:5432/3-way-Ter-Qui";
	public static String usuario = "postgres";
	public static String senha= "123456";
	
	public static Connection getConexao() throws SQLException{
		try {
			Class.forName("org.postgresql.Driver");
			return DriverManager.getConnection(url, usuario, senha);
		} catch (Exception e) {
			throw new SQLException();
		}
	}

}
