import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class Nuevo_Usuario extends JFrame {

	private Controlador miControlador;
	private Modelo miModelo;
	private Interfaz_2 miInterfaz2 = new Interfaz_2();
	private JPanel contentPane;
	private JLabel lblTitulo;
	private JTextField txtUsuario;
	private JButton btnAcceder;
	private JPasswordField passwordField;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblFondoCuadro;
	private JLabel lblLogo;
	private Formulario miFormulario = new Formulario();
	private JTextField txtEmail;
	private JPasswordField passwordField_1;
	private JLabel lblContrasena;
	private JLabel lblApellidos;
	private JLabel lblContrasena_3;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton btnVolver;
	private JRadioButton rdbtnTutor;
	private JRadioButton rdbtnDirector;
	

	public void setMiControlador(Controlador miControlador) {
		this.miControlador = miControlador;
	}

	public void setMiModelo(Modelo miModelo) {
		this.miModelo = miModelo;
	}
	
	public String getEmail() {
		String email = txtEmail.getText();
		return email;
	}

	public String getUsuario() {
		String usuario = txtUsuario.getText();
		return usuario;
	}

	public String getPassword() {
		String pwd = String.valueOf(passwordField.getPassword());
		if (String.valueOf(passwordField.getPassword()).equals(String.valueOf(passwordField_1.getPassword()))) {
			return pwd;
		}
		else {
			return null;
		}
	}
	public String getRol() {
		if (rdbtnTutor.isSelected()) {
			return "tutor";
		}
		else if (rdbtnDirector.isSelected()) {
			return "director";
		}
		return null;
	}

	public Nuevo_Usuario() {
		setTitle("Registro de Usuarios");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 720, 420);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 0, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel();
		panel.setForeground(Color.BLACK);
		panel.setBackground(UIManager.getColor("CheckBox.highlight"));
		panel.setBounds(0, 0, 411, 380);
		panel.setLayout(null);

		panel_1 = new JPanel();
		panel_1.setBackground(new Color(153, 0, 51, 220));
		panel_1.setBounds(24, 0, 375, 398);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		passwordField = new JPasswordField();
		passwordField.setBounds(74, 233, 226, 20);
		panel_1.add(passwordField);
		passwordField.setBackground(Color.WHITE);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(74, 125, 226, 20);
		panel_1.add(txtUsuario);
		txtUsuario.setBackground(Color.WHITE);
		txtUsuario.setColumns(10);

		btnAcceder = new JButton("Crear");
		btnAcceder.setVerticalAlignment(SwingConstants.TOP);
		btnAcceder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.insertarUsuario();
			}
		});
		btnAcceder.setFont(new Font("Arial", Font.PLAIN, 11));
		btnAcceder.setBounds(205, 342, 82, 23);
		panel_1.add(btnAcceder);

		lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(LogIn.class.getResource("/Imagenes/LogUem.png")));
		lblLogo.setBounds(54, 10, 299, 68);
		panel_1.add(lblLogo);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBackground(Color.WHITE);
		txtEmail.setBounds(74, 179, 226, 20);
		panel_1.add(txtEmail);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBackground(Color.WHITE);
		passwordField_1.setBounds(74, 287, 226, 20);
		panel_1.add(passwordField_1);
		
		JLabel lblContrasena_1 = new JLabel("Repetir Contrase\u00F1a ");
		lblContrasena_1.setForeground(Color.WHITE);
		lblContrasena_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblContrasena_1.setBounds(74, 263, 152, 14);
		panel_1.add(lblContrasena_1);
		
		lblContrasena = new JLabel("Contrase\u00F1a");
		lblContrasena.setForeground(Color.WHITE);
		lblContrasena.setFont(new Font("Arial", Font.PLAIN, 16));
		lblContrasena.setBounds(74, 209, 97, 14);
		panel_1.add(lblContrasena);
		
		lblApellidos = new JLabel("Email");
		lblApellidos.setForeground(Color.WHITE);
		lblApellidos.setFont(new Font("Arial", Font.PLAIN, 16));
		lblApellidos.setBounds(74, 155, 97, 14);
		panel_1.add(lblApellidos);
		
		lblContrasena_3 = new JLabel("Usuario");
		lblContrasena_3.setForeground(Color.WHITE);
		lblContrasena_3.setFont(new Font("Arial", Font.PLAIN, 16));
		lblContrasena_3.setBounds(74, 101, 97, 14);
		panel_1.add(lblContrasena_3);
		
		rdbtnTutor = new JRadioButton("Tutor");
		rdbtnTutor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnTutor.setForeground(Color.WHITE);
		rdbtnTutor.setBackground(new Color(153, 0, 51, 220));
		buttonGroup.add(rdbtnTutor);
		rdbtnTutor.setBounds(109, 313, 61, 23);
		panel_1.add(rdbtnTutor);
		
		rdbtnDirector = new JRadioButton("Director");
		rdbtnDirector.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnDirector.setForeground(Color.WHITE);
		rdbtnDirector.setBackground(new Color(153, 0, 51));
		buttonGroup.add(rdbtnDirector);
		rdbtnDirector.setBounds(181, 313, 68, 23);
		panel_1.add(rdbtnDirector);
		
		btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cerrarSesion();
			}
		});
		btnVolver.setVerticalAlignment(SwingConstants.TOP);
		btnVolver.setFont(new Font("Arial", Font.PLAIN, 11));
		btnVolver.setBounds(89, 342, 82, 23);
		panel_1.add(btnVolver);
		
		

		lblFondoCuadro = new JLabel("");
		lblFondoCuadro.setIcon(new ImageIcon(LogIn.class.getResource("/Imagenes/universidad-europea.jpg")));
		lblFondoCuadro.setBounds(0, 0, 720, 398);
		contentPane.add(lblFondoCuadro);

		lblTitulo = new JLabel("APP Gesti\u00F3n FCT");
		lblTitulo.setBounds(380, 55, 286, 58);
		contentPane.add(lblTitulo);
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setFont(new Font("Arial Black", Font.PLAIN, 30));
	}

	public void actualizar() {
		System.out.println("Usuario creado correctamente.");
		miControlador.cerrarSesion();
	}
}

