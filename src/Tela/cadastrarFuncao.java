package Tela;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import Banco.FuncaoDao;
import Banco.MembroDao;
import Dominio.Funcao;
import Dominio.Membro;
import ca.odell.glazedlists.BasicEventList;
import ca.odell.glazedlists.SortedList;
import ca.odell.glazedlists.swing.AutoCompleteSupport;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class cadastrarFuncao extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldTempo;
	private JComboBox comboBoxMembro;
	private JComboBox comboBoxFuncoes;
	
	private SortedList<Membro> membroSugeridos = new SortedList<Membro>(new BasicEventList<Membro>());

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cadastrarFuncao frame = new cadastrarFuncao();
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
	public cadastrarFuncao() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 289);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new TitledBorder(null, "Cadastro de Fun\u00E7\u00E3o", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome da Função: ");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(35, 37, 108, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tempo em que é membro:");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(35, 95, 166, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Membro:");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(35, 151, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		textFieldTempo = new JTextField();
		textFieldTempo.setForeground(new Color(64, 0, 64));
		textFieldTempo.setBounds(35, 120, 192, 20);
		contentPane.add(textFieldTempo);
		textFieldTempo.setColumns(10);
		
		comboBoxMembro = new JComboBox();
		comboBoxMembro.setForeground(new Color(64, 0, 64));
		comboBoxMembro.setBounds(35, 176, 192, 22);
		contentPane.add(comboBoxMembro);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrarFuncao();
			}
		});
		btnCadastrar.setBackground(new Color(255, 255, 255));
		btnCadastrar.setBounds(260, 109, 151, 43);
		contentPane.add(btnCadastrar);
		
		JLabel lblNewLabel_3 = new JLabel("Cadastrar Função");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(153, 11, 151, 24);
		contentPane.add(lblNewLabel_3);
		
		AutoCompleteSupport.install(comboBoxMembro, membroSugeridos);
		
		comboBoxFuncoes = new JComboBox();
		comboBoxFuncoes.setModel(new DefaultComboBoxModel(new String[] {"Programador", "Cozinheiro", "Hacker", "Provedor", "Técnico de Manutenção", "Nenhuma das Opções"}));
		comboBoxFuncoes.setForeground(new Color(64, 0, 64));
		comboBoxFuncoes.setBounds(35, 62, 192, 22);
		contentPane.add(comboBoxFuncoes);
		
		comboBoxMembro.getEditor().getEditorComponent().addKeyListener(new KeyAdapter(){
			@Override
			public void keyReleased(KeyEvent arg0) {
				try {
					buscarMembro();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}

	protected void cadastrarFuncao() {
		JComboBox<String> comboBox = comboBoxFuncoes;
        String itemSelecionado = (String) comboBox.getSelectedItem();	
		
		Funcao funcao = new Funcao();
		funcao.setNomeFuncao(itemSelecionado);
		funcao.setTempo(textFieldTempo.getText());

		Membro a = (Membro) comboBoxMembro.getSelectedItem();
		funcao.setMembro(a);

		try {
			FuncaoDao dao = new FuncaoDao();
			dao.cadastrarFuncao(funcao);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro no Sistema");
			e.printStackTrace();
		}
		
		

	}
		

	protected void buscarMembro() throws ClassNotFoundException {
		if (comboBoxMembro.getEditor().getItem() != null
				&& comboBoxMembro.getEditor().getItem().toString().length() >= 3) {
			MembroDao dao = new MembroDao();
			List<Membro> membrosEncontrados = new ArrayList<>();
			
			try {
				String nomeMembro = comboBoxMembro.getEditor().getItem().toString();
				membrosEncontrados = dao.buscarMembroPeloNome(nomeMembro);
				
				membroSugeridos.clear();
				membroSugeridos.addAll(membrosEncontrados);
				
				comboBoxMembro.showPopup();
			} catch (SQLException e) {
				e.printStackTrace();
				JOptionPane.showInternalMessageDialog(null, "Erro no Sistema");
			}
		}
		
	}
}
