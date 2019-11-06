package com.virtualcondo.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.virtualcondo.connection.FabricaDeConexao;
import com.virtualcondo.models.VagaEstacionamento;

public class JDBCVagaEstacionamentoService {

	private Connection connection = new FabricaDeConexao().getConnection();

	public List<VagaEstacionamento> listarDisponiveis(){

		List<VagaEstacionamento> lista = new ArrayList<VagaEstacionamento>();
		String sql = "Select * From vaga_estacionamento Where emuso = 0";

		try {

			PreparedStatement st = connection.prepareStatement(sql);
			ResultSet rs = st.executeQuery();

			while(rs.next()) {
				lista.add(new VagaEstacionamento(
						rs.getInt("id"),
						rs.getString("vaga"),
						rs.getBoolean("emuso")
					));
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try{
				connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}

		return lista;
	}
}
