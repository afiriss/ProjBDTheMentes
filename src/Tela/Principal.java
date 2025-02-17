package Tela;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.TitledBorder;

import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 934, 565);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Tela Inicial", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton Login = new JButton("Login");
		Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l = new Login();
				l.setVisible(true);
				l.setLocationRelativeTo(null);
				l.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				
			}
		});
		Login.setForeground(new Color(0, 0, 0));
		Login.setBackground(new Color(255, 255, 255));
		Login.setBounds(180, 366, 206, 59);
		contentPane.add(Login);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Principal.class.getResource("/img/ainn.png")));
		lblNewLabel.setBounds(315, 88, 275, 226);
		contentPane.add(lblNewLabel);
		
		JButton Cadastrar = new JButton("Cadastrar");
		Cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrarUsuario cm = null;
				cm = new cadastrarUsuario();
				
				cm.setLocationRelativeTo(null);
				cm.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				cm.setVisible(true);
			}
		});
		Cadastrar.setForeground(Color.BLACK);
		Cadastrar.setBackground(Color.WHITE);
		Cadastrar.setBounds(502, 366, 206, 59);
		contentPane.add(Cadastrar);
	}
}
