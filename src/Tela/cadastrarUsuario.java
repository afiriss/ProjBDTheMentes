package Tela;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Banco.FabricaConexao;
import Dominio.Usuario;
import util.CriptografiaUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

public class cadastrarUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldEmail;
	private JPasswordField passwordFieldSenha;
	private JTextField textFieldNome;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cadastrarUsuario frame = new cadastrarUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public cadastrarUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 532);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Login", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastro de Usuario");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(99, 29, 238, 87);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabelNome = new JLabel("Nome:");
		lblNewLabelNome.setForeground(new Color(255, 255, 255));
		lblNewLabelNome.setBounds(82, 127, 61, 14);
		lblNewLabelNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblNewLabelNome);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(82, 152, 255, 28);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		JLabel lblNewLabelEmail = new JLabel("E-mail:");
		lblNewLabelEmail.setForeground(new Color(255, 255, 255));
		lblNewLabelEmail.setBounds(82, 206, 46, 14);
		lblNewLabelEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblNewLabelEmail);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(82, 231, 255, 28);
		contentPane.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Senha:");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(82, 289, 61, 14);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblNewLabel_1);
		
		passwordFieldSenha = new JPasswordField();
		passwordFieldSenha.setBounds(82, 315, 255, 28);
		contentPane.add(passwordFieldSenha);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBackground(new Color(255, 255, 255));
		btnCadastrar.setForeground(new Color(0, 0, 0));
		btnCadastrar.setBounds(118, 378, 190, 74);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					cadastrarUsuario();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		contentPane.add(btnCadastrar);
	}

	protected void cadastrarUsuario() throws ClassNotFoundException, SQLException {
		
		String nome = textFieldNome.getText();
		String email = textFieldEmail.getText();
		String senha = new String(passwordFieldSenha.getPassword());
		String senhaCriptografada = CriptografiaUtils.criptografarMD5(senha);

		if (nome == null || nome.isEmpty()) {
			exibirMensagemErro("Nome não pode ser vazio");
			return;
		}

		if (email == null || email.isEmpty()) {
			exibirMensagemErro("Email não pode ser vazio");
			return;
		}

		if (senha == null || senha.isEmpty()) {
			exibirMensagemErro("Senha não pode ser vazio");
			return;
		}
		
		Usuario u = new Usuario();
		u.setNome(nome);
		u.setEmail(email);
		u.setSenha(senhaCriptografada);
		
		Connection conexao = FabricaConexao.criarConexao();
		
		String sql = "INSERT INTO usuario (nome,email,senha) VALUES (?,?,?)";

		PreparedStatement comando = conexao.prepareStatement(sql);
		
		comando.setString(1, u.getNome());
		comando.setString(2, u.getEmail());
		comando.setString(3, u.getSenha());
		comando.execute();
		
		comando.close();
		conexao.close();
		
		exibirMensagemErro("Usuário - " + nome + " - Cadastrado com Sucesso!");
		
	}

	private void exibirMensagemErro(String msg) {
		JOptionPane.showMessageDialog(null, msg);
		
	}

}
