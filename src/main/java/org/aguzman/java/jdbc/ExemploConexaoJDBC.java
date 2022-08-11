package org.aguzman.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.ZoneId;
import java.util.Set;

import org.aguzman.java.jdbc.util.ConexaoBaseDatos;

public class ExemploConexaoJDBC {

	public static void main(String[] args) throws SQLException {

//		String url = "jdbc:mysql://localhost:3306/java_curso?serverTimezone=UTC";// precisamos indicar o fuso horario,
		// coloquei UTC pq é universal
//		String username = "root";
//		String password = "appjava123";
//		try (Connection conn = DriverManager.getConnection(url, username, password);
//				// vamos fazer uma pesquisa utilizando SELECT, então utilizamos o Statement
//				Statement stmt = conn.createStatement(); // agora já podemos fazer consultas atráves do objeto "stmt"
//				ResultSet resultado = stmt.executeQuery("SELECT * FROM productos")) {
//			while (resultado.next()) {// vai verificar quantos registros retornou dentro do objeto "resultado"
//				System.out.print("O id é: " + resultado.getInt("id"));
//				System.out.print("O nome é: " + resultado.getString("nombre"));
//				System.out.print("O preço é: " + resultado.getDouble("precio"));
//				System.out.println("A data é: " + resultado.getDate("fecha_registro"));
//				//Obs: aqui vai criar conexão, vai fazer a pesquisa e direto o proprio vai fechar os recursos
//			}
//		}
//		catch (SQLException e) {//e se entrar aqui no CATCH também vai fechar os recursos automáticamente
//			e.printStackTrace();
//		}

		//Com os resources do TRY é mais fácil pois já vai fechar as conexões para nós por padrão
		try (Connection myConnection = ConexaoBaseDatos.getInstance();
				Statement stmt = myConnection.createStatement();
				ResultSet resultado = stmt.executeQuery("SELECT * FROM productos")) {

			while (resultado.next()) {
				System.out.print(resultado.getInt("id") + " ");
				System.out.print(resultado.getString("nombre") +  " ");
				System.out.print(resultado.getDouble("precio") + " ");
				System.out.println(resultado.getDate("fecha_registro") + " ");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
