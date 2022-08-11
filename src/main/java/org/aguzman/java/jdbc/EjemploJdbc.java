package org.aguzman.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.aguzman.java.jdbc.util.ConexaoBaseDatos;

public class EjemploJdbc {
	public static void main(String[] args) {

		try (Connection myConnection = ConexaoBaseDatos.getInstance();//perfeito agora estamos reutilizando a Connection
				//e abaixo poderemos fazer consultas ao banco de dados 
				Statement stmt = myConnection.createStatement();
				ResultSet resultado = stmt.executeQuery("SELECT * FROM productos")) {

			while (resultado.next()) {
				System.out.print(resultado.getInt("id") + " ");
				System.out.print(resultado.getString("nombre") + " ");
				System.out.print(resultado.getDouble("precio") + " ");
				System.out.println(resultado.getDate("fecha_registro") + " ");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
