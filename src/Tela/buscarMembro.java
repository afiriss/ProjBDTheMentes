package Tela;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Banco.MembroDao;
import Dominio.Membro;

import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class buscarMembro extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldNomeGang;
	private JTextField textFieldCpf;
	private JTextField textFieldIdade;
	private JTable tableMembro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					buscarMembro frame = new buscarMembro();
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
	public buscarMembro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 852, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(233, 210, 50));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 0, 128));
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Buscar Membro Por:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
		panel.setBounds(10, 11, 214, 339);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(10, 29, 54, 15);
		panel.add(lblNewLabel);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(10, 55, 194, 20);
		panel.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		JLabel lblCpf = new JLabel("Nome de Gang:");
		lblCpf.setForeground(new Color(255, 255, 255));
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCpf.setBounds(10, 86, 115, 15);
		panel.add(lblCpf);
		
		textFieldNomeGang = new JTextField();
		textFieldNomeGang.setColumns(10);
		textFieldNomeGang.setBounds(10, 112, 194, 20);
		panel.add(textFieldNomeGang);
		
		JLabel lblCpf_1 = new JLabel("CPF:");
		lblCpf_1.setForeground(new Color(255, 255, 255));
		lblCpf_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCpf_1.setBounds(10, 143, 54, 15);
		panel.add(lblCpf_1);
		
		textFieldCpf = new JTextField();
		textFieldCpf.setBounds(10, 169, 194, 20);
		panel.add(textFieldCpf);
		textFieldCpf.setColumns(10);
		
		JLabel lblIdade = new JLabel("Idade: ");
		lblIdade.setForeground(new Color(255, 255, 255));
		lblIdade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIdade.setBounds(10, 200, 69, 15);
		panel.add(lblIdade);
		
		textFieldIdade = new JTextField();
		textFieldIdade.setColumns(10);
		textFieldIdade.setBounds(10, 226, 194, 20);
		panel.add(textFieldIdade);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					buscarMembro();
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnBuscar.setForeground(new Color(128, 0, 128));
		btnBuscar.setBounds(10, 295, 194, 33);
		panel.add(btnBuscar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(128, 0, 128));
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Listagem de Alunos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
		panel_1.setBounds(233, 11, 593, 339);
		contentPane.add(panel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 26, 573, 302);
		panel_1.add(scrollPane);
		
		tableMembro = new JTable();
		tableMembro.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome:", "Nome de Gang:", "Idade:", "CPf:"
			}
		));
		tableMembro.getColumnModel().getColumn(0).setPreferredWidth(95);
		tableMembro.getColumnModel().getColumn(1).setPreferredWidth(106);
		tableMembro.getColumnModel().getColumn(2).setPreferredWidth(89);
		tableMembro.getColumnModel().getColumn(3).setPreferredWidth(88);
		tableMembro.setToolTipText("");
		scrollPane.setViewportView(tableMembro);
	}
	
	protected void buscarMembro() throws ClassNotFoundException, SQLException {

		MembroDao dao = new MembroDao();

		List<Membro> membrosEncontrados = new ArrayList<Membro>();

		membrosEncontrados = dao.buscarMembro(textFieldNome.getText(), textFieldNomeGang.getText(),
				textFieldCpf.getText(), textFieldIdade.getText());

		DefaultTableModel modelo = new DefaultTableModel(new String[] { "Nome:", "Nome de Gang:", "Idade:", "CPf:"}, 0);

		for (int i = 0; i < membrosEncontrados.size(); i++) {
			Membro membro = membrosEncontrados.get(i);

			modelo.addRow(new String[] { membro.getNome(), membro.getNomeGang(), membro.getIdade(), membro.getCpf() });
		}

		tableMembro.setModel(modelo);
		
	}

		
	

	
	}

