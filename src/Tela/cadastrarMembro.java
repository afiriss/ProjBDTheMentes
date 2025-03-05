package Tela;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import Banco.FabricaConexao;
import Dominio.Membro;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class cadastrarMembro extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldNomeGang;
	private JTextField textFieldIdade;
	private JTextField textFieldCpf;
	@SuppressWarnings("rawtypes")
	private JList listarMembro;
	private Membro membroEdicao; 
	
	private JButton ButaoCadastrar;
	private JButton btnNewButtonExibirDados;
	private JButton btnNewButtonExcluir;
	private JButton btnBuscarMembro;
	private JButton btnCadastrarFun;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cadastrarMembro frame = new cadastrarMembro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public cadastrarMembro() throws ClassNotFoundException, SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 872, 522);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(68, 45, 49));
		contentPane.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Cadastrar", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(129, 100, 168));
		panel.setBounds(10, 25, 384, 447);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Dados", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome: ");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(10, 29, 79, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome de Gang: ");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(10, 80, 141, 14);
		panel.add(lblNewLabel_1);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(10, 49, 189, 20);
		panel.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldNomeGang = new JTextField();
		textFieldNomeGang.setBounds(10, 105, 189, 20);
		panel.add(textFieldNomeGang);
		textFieldNomeGang.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Idade: ");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(10, 136, 68, 14);
		panel.add(lblNewLabel_2);
		
		textFieldIdade = new JTextField();
		textFieldIdade.setBounds(10, 161, 189, 20);
		panel.add(textFieldIdade);
		textFieldIdade.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("CPF:");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(10, 192, 46, 14);
		panel.add(lblNewLabel_3);
		
		textFieldCpf = new JTextField();
		textFieldCpf.setBounds(10, 217, 189, 20);
		panel.add(textFieldCpf);
		textFieldCpf.setColumns(10);
		
		ButaoCadastrar = new JButton("Cadastrar");
		ButaoCadastrar.setBackground(new Color(0, 0, 0));
		ButaoCadastrar.setForeground(new Color(255, 255, 255));
		ButaoCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					cadastraMembro();
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		ButaoCadastrar.setBounds(233, 45, 128, 84);
		panel.add(ButaoCadastrar);
		
		JButton btnNewButtonEditar = new JButton("Editar");
		btnNewButtonEditar.setBackground(new Color(0, 0, 0));
		btnNewButtonEditar.setForeground(new Color(255, 255, 255));
		btnNewButtonEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iniciarEdicaoMembro();
			}
		});
		btnNewButtonEditar.setBounds(233, 157, 128, 84);
		panel.add(btnNewButtonEditar);
		
		btnBuscarMembro = new JButton("Buscar Membro");
		btnBuscarMembro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarMembro cm = null;
				cm = new buscarMembro();
				
				cm.setLocationRelativeTo(null);
				cm.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				cm.setVisible(true);
			}
		});
		btnBuscarMembro.setForeground(Color.WHITE);
		btnBuscarMembro.setBackground(Color.BLACK);
		btnBuscarMembro.setBounds(25, 307, 147, 84);
		panel.add(btnBuscarMembro);
		
		btnCadastrarFun = new JButton("Cadastrar Função");
		btnCadastrarFun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrarFuncao cm = null;
				cm = new cadastrarFuncao();
				
				cm.setLocationRelativeTo(null);
				cm.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				cm.setVisible(true);
			}
		});
		btnCadastrarFun.setForeground(Color.WHITE);
		btnCadastrarFun.setBackground(Color.BLACK);
		btnCadastrarFun.setBounds(206, 307, 147, 84);
		panel.add(btnCadastrarFun);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(129, 100, 168));
		panel_1.setBounds(462, 25, 384, 447);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Membros Cadastrados", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 24, 364, 271);
		panel_1.add(scrollPane);
		
		listarMembro = new JList();
		scrollPane.setViewportView(listarMembro);
		
		btnNewButtonExibirDados = new JButton("Exibir Dados");
		btnNewButtonExibirDados.setForeground(new Color(255, 255, 255));
		btnNewButtonExibirDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (listarMembro.getSelectedIndex() == -1) {
					exibirMensagemErro("Selecione um aluno");
				}
				
				Membro membroSelecionado = (Membro) listarMembro.getSelectedValue();

				String msg = "Nome: " + membroSelecionado.getNome() + "\nNome de Gang: " + membroSelecionado.getNomeGang()
						+ "\nIdade: " + membroSelecionado.getIdade() + "\nCPF: " + membroSelecionado.getCpf() + "\nFunção: " + membroSelecionado.getNomeFuncao() 
						+ "\nTempo como Membro: " + membroSelecionado.getTempo();

				ExibirMensagem(msg);

			}
		});
		btnNewButtonExibirDados.setBackground(new Color(0, 0, 0));
		btnNewButtonExibirDados.setBounds(43, 330, 128, 84);
		panel_1.add(btnNewButtonExibirDados);
		
		btnNewButtonExcluir = new JButton("Excluir Membro");
		btnNewButtonExcluir.setForeground(new Color(255, 255, 255));
		btnNewButtonExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					removerDados();
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButtonExcluir.setBackground(new Color(0, 0, 0));
		btnNewButtonExcluir.setBounds(218, 330, 128, 84);
		panel_1.add(btnNewButtonExcluir);
		
		atualizarListagemMembro();
		
		
	}
	

	private void exibirMensagemErro(String msg) {
		JOptionPane.showMessageDialog(null, msg, "ERRO", JOptionPane.ERROR_MESSAGE);

	}
	
	private void ExibirMensagem(String msg) {
		JOptionPane.showMessageDialog(null, msg, "Info", JOptionPane.INFORMATION_MESSAGE);
	}

	protected void cadastraMembro() throws ClassNotFoundException, SQLException {
		if (textFieldNome.getText() == null || textFieldNome.getText().isEmpty()) {
			exibirMensagemErro("Nome não pode ser vazio");
			return;
		}
		
		if (textFieldNomeGang.getText() == null || textFieldNomeGang.getText().isEmpty()) {
			exibirMensagemErro("Nome de Gang não pode ser vazio");
			return;
		}
		
		if (textFieldIdade.getText() == null || textFieldIdade.getText().isEmpty()) {
			exibirMensagemErro("Idade não pode ser vazio");
			return;
		}
		
		if (textFieldCpf.getText() == null || textFieldCpf.getText().isEmpty()) {
			exibirMensagemErro("Cpf não pode ser vazio");
			return;
		}
		
		if (ButaoCadastrar.getText().equals("Cadastrar")) {

			Connection conexao = FabricaConexao.criarConexao();

			String sql = "INSERT INTO membro (nome, nome_gang, idade, cpf) VALUES (?,?,?,?)";

			Membro a = new Membro();

			a.setNome(textFieldNome.getText());
			a.setNomeGang(textFieldNomeGang.getText());
			a.setIdade(textFieldIdade.getText());
			a.setCpf(textFieldCpf.getText());

			PreparedStatement comando = conexao.prepareStatement(sql);

			comando.setString(1, a.getNome());
			comando.setString(2, a.getNomeGang());
			comando.setString(3, a.getIdade());
			comando.setString(4, a.getCpf());
			comando.execute();

			System.out.println("Fechando Conexão...");

			comando.close();
			conexao.close();

			JOptionPane.showMessageDialog(null, "Membro foi cadastrado com sucesso", "Info",
					JOptionPane.INFORMATION_MESSAGE);

		} else if (ButaoCadastrar.getText().equals("Editar Dados")) {

			Connection conexao = FabricaConexao.criarConexao();

			membroEdicao.setNome(textFieldNome.getText());
			membroEdicao.setNomeGang(textFieldNomeGang.getText());
			membroEdicao.setIdade(textFieldIdade.getText());
			membroEdicao.setCpf(textFieldCpf.getText());

			String sql = "UPDATE membro SET nome=?, nome_gang=?, idade=?, cpf=? WHERE id_membro=?";

			PreparedStatement comando = conexao.prepareStatement(sql);
			comando.setString(1, membroEdicao.getNome());
			comando.setString(2, membroEdicao.getNomeGang());
			comando.setString(3, membroEdicao.getIdade());
			comando.setString(4, membroEdicao.getCpf());
			comando.setInt(5, membroEdicao.getId());
			comando.executeUpdate();

			ExibirMensagem("Dados Alterado");
			
			ButaoCadastrar.setText("Cadastrar");

			comando.close();
			conexao.close();

			membroEdicao = null;

		}

		atualizarListagemMembro();
		
		textFieldNome.setText("");
		textFieldNomeGang.setText("");
		textFieldIdade.setText("");
		textFieldCpf.setText("");

	}
	
	protected void iniciarEdicaoMembro() {
		if (listarMembro.getSelectedIndex() == -1) {
			exibirMensagemErro("Selecione um membro");
		}

		membroEdicao = (Membro) listarMembro.getSelectedValue();
		textFieldNome.setText(membroEdicao.getNome());
		textFieldNomeGang.setText(membroEdicao.getNomeGang());
		textFieldIdade.setText(membroEdicao.getIdade());
		textFieldCpf.setText(membroEdicao.getCpf());

		ButaoCadastrar.setText("Editar Dados");
		
	}
	
	@SuppressWarnings("unchecked")
	private void atualizarListagemMembro() throws ClassNotFoundException, SQLException {

		Connection conexao = FabricaConexao.criarConexao();

		String sql = "SELECT * FROM membro";

		PreparedStatement comando = conexao.prepareStatement(sql);

		ResultSet resultado = comando.executeQuery();

		List<Membro> membrosCadastrados = new ArrayList<Membro>();

		while (resultado.next()) {
			Membro a = new Membro();

			a.setId(resultado.getInt("id_membro"));
			a.setNome(resultado.getString("nome"));
			a.setNomeGang(resultado.getString("nome_gang"));
			a.setIdade(resultado.getString("idade"));
			a.setCpf(resultado.getString("cpf"));

			membrosCadastrados.add(a);
		}

		DefaultListModel<Membro> modelo = new DefaultListModel<>();

		for (int i = 0; i < membrosCadastrados.size(); i++) {
			Membro a = membrosCadastrados.get(i);
			modelo.addElement(a);
		}

		listarMembro.setModel(modelo);

		comando.close();
		conexao.close();

	}
	
	protected void removerDados() throws ClassNotFoundException, SQLException {
		if (listarMembro.getSelectedIndex() == -1) {
			exibirMensagemErro("Selecione um membro");
		}
		
		String senha = "AiPapai";
		  
		String pedesenha = JOptionPane.showInputDialog("informe  a senha:");
		
		if (pedesenha.contains(senha)) {
			
			membroEdicao = (Membro) listarMembro.getSelectedValue();
			
			Connection conexao = FabricaConexao.criarConexao();
			
			String sql = "DELETE FROM membro WHERE id_membro = ? ";

			PreparedStatement comando = conexao.prepareStatement(sql);
			
			comando.setInt(1, membroEdicao.getId());
			comando.executeUpdate();

			ExibirMensagem("Dados Removidos");
			
			atualizarListagemMembro();

			comando.close();
			conexao.close();
		}else {
			exibirMensagemErro("Senha Incorreta");
		}

		

		}
	}

	
	

	
	


