package Banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Dominio.Funcao;
import Dominio.Membro;

public class FuncaoDao {

	public void cadastrarFuncao(Funcao f) throws SQLException, ClassNotFoundException {
		
		Connection conexao = FabricaConexao.criarConexao();

		String sql = " INSERT INTO funcao (nome_funcao,tempo,id_membro) VALUES (?,?,?) ";

		PreparedStatement comando = conexao.prepareStatement(sql);
		comando.setString(1, f.getNomeFuncao());
		comando.setString(2, f.getTempo());
		comando.setInt(3, f.getMembro().getId());
		comando.execute();


		comando.close();
		conexao.close();

		JOptionPane.showMessageDialog(null, "Função Cadastrada com Sucesso");
		
	}

	
}
