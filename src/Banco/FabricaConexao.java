package Banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {
		
		public static Connection criarConexao() throws SQLException, ClassNotFoundException {
			
			String stringConexao = "jdbc:mysql://localhost/theMentes?useTimezone=true&serverTimezone=UTC";
			String usuario = "root";
			String senha = "Naoya81194*";
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conexao = DriverManager.getConnection(stringConexao, usuario, senha);
			
			return conexao;
			  
			}

	}


