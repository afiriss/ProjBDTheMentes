package Banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dominio.Membro;

public class MembroDao {

	public List<Membro> buscarMembroPeloNome(String nome) throws SQLException, ClassNotFoundException {

		Connection conexao = FabricaConexao.criarConexao();
		
		String sql = " SELECT * FROM membro WHERE 1 = 1 ";

		if (nome != null && !nome.isEmpty()) {
			sql += " AND upper(nome) LIKE ? ";
		}

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		int i = 1;

		if (nome != null && !nome.isEmpty()) {
			comando.setString(i++, "%" + nome.toUpperCase() + "%");
		}

		ResultSet resultado = comando.executeQuery();

		List<Membro> membrosCadastrados = new ArrayList<>();

		while (resultado.next()) {
			Membro a = new Membro();
			a.setId(resultado.getInt("id_membro"));
			a.setNome(resultado.getString("nome"));
			a.setNomeGang(resultado.getString("nome_gang"));
			a.setIdade(resultado.getString("idade"));
			a.setCpf(resultado.getString("cpf"));

			membrosCadastrados.add(a);
		}

		return membrosCadastrados;
	}

	public List<Membro> buscarMembro(String nome, String nomeGang, String idade, String cpf)
			throws SQLException, ClassNotFoundException {

		Connection conexao = FabricaConexao.criarConexao();
		String sql = " SELECT * FROM membro WHERE 1 = 1 ";

		if (nome != null && !nome.isEmpty()) {
			sql += " AND nome LIKE ? ";
		}

		if (nomeGang != null && !nomeGang.isEmpty()) {
			sql += " AND nome_gang = ? ";
		}

		if (idade != null && !idade.isEmpty()) {
			sql += " AND idade = ? ";
		}

		if (cpf != null && !cpf.isEmpty()) {
			sql += " AND cpf = ? ";
		}
		
		

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		int i = 1;

		if (nome != null && !nome.isEmpty()) {
			comando.setString(i, "%" + nome.toUpperCase() + "%");
			i++;
		}

		if (nomeGang != null && !nomeGang.isEmpty()) {
			comando.setString(i, nomeGang);
			i++;
		}

		if (nomeGang != null && !nomeGang.isEmpty()) {
			comando.setString(i, nomeGang);
			i++;
		}
		
		if (cpf != null && !cpf.isEmpty()) {
			comando.setString(i, cpf);
			i++;
		}
		
		

		ResultSet resultado = comando.executeQuery();

		List<Membro> membrosCadastrados = new ArrayList<>();

		while (resultado.next()) {
			Membro a = new Membro();
			a.setId(resultado.getInt("id_membro"));
			a.setNome(resultado.getString("nome"));
			a.setNomeGang(resultado.getString("nome_gang"));
			a.setIdade(resultado.getString("idade"));
			a.setCpf(resultado.getString("cpf"));

			membrosCadastrados.add(a);
		}

		return membrosCadastrados;

	}
}
