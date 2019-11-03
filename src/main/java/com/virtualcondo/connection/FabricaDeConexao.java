package com.virtualcondo.connection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Responsável por criar a conexão jdbc
 * @author Gabriel
 *
 */
public class FabricaDeConexao {

	private String banco = "jdbc:mysql://localhost:3306/virtualcondo?useTimezone=true&serverTimezone=UTC";
	private String user = "virtualcondo";
	private String senha = "pim4sem";
	private Connection connection = null;

	public FabricaDeConexao() {
		conectar();
	}

	private void conectar() {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(banco, user, senha);
			connection.setAutoCommit(false);

		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Erro ao conectar com o banco de dados");
		}
	}

	public Connection getConnection() {
		return connection;
	}

}
