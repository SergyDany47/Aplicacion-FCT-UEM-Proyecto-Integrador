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

public class LogIn extends JFrame {

	private Controlador miControlador;
	private Modelo miModelo;
	private Interfaz_2 miInterfaz2 = new Interfaz_2();
	private JPanel contentPane;
	private JLabel lbUsuario;
	private JLabel lblContraseña;
	private JLabel lblTitulo;
	private JTextField txtUsuario;
	private JButton btnAcceder;
	private JPasswordField passwordField;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblFondoCuadro;
	private JLabel lblLogo;
	private JLabel lblRespuesta;
	private JButton btnAjustes;
	private Formulario miFormulario = new Formulario();

	public void setMiControlador(Controlador miControlador) {
		this.miControlador = miControlador;
	}

	public void setMiModelo(Modelo miModelo) {
		this.miModelo = miModelo;
	}

	public String getUsuario() {
		String usuario = txtUsuario.getText();
		return usuario;
	}

	public String getPassword() {
		String pwd = String.valueOf(passwordField.getPassword());
		return pwd;
	}

	public LogIn() {
		setTitle("Log In");
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
		panel_1.setBounds(24, 0, 343, 381);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		passwordField = new JPasswordField();
		passwordField.setBounds(36, 249, 216, 20);
		panel_1.add(passwordField);
		passwordField.setBackground(Color.WHITE);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(36, 177, 216, 20);
		panel_1.add(txtUsuario);
		txtUsuario.setBackground(Color.WHITE);
		txtUsuario.setColumns(10);

		btnAcceder = new JButton("Acceder");
		btnAcceder.setVerticalAlignment(SwingConstants.TOP);
		btnAcceder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.login();
				limpiarCampos();
			}
		});
		btnAcceder.setFont(new Font("Arial", Font.PLAIN, 11));
		btnAcceder.setBounds(230, 305, 82, 23);
		panel_1.add(btnAcceder);

		lbUsuario = new JLabel("Usuario ");
		lbUsuario.setForeground(new Color(255, 255, 255));
		lbUsuario.setBounds(41, 151, 82, 14);
		panel_1.add(lbUsuario);
		lbUsuario.setFont(new Font("Arial", Font.PLAIN, 16));

		lblContraseña = new JLabel("Contrase\u00F1a ");
		lblContraseña.setBounds(44, 224, 97, 14);
		panel_1.add(lblContraseña);
		lblContraseña.setForeground(new Color(255, 255, 255));
		lblContraseña.setFont(new Font("Arial", Font.PLAIN, 16));

		lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(LogIn.class.getResource("/Imagenes/LogUem.png")));
		lblLogo.setBounds(34, 11, 278, 121);
		panel_1.add(lblLogo);

		lblRespuesta = new JLabel("");
		lblRespuesta.setBounds(20, 340, 313, 30);
		panel_1.add(lblRespuesta);
		lblRespuesta.setForeground(Color.BLACK);

		btnAjustes = new JButton("");
		btnAjustes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.abrirFormulario();
				limpiarCampos();
				miModelo.seleccionarFichero();
			}
		});
		btnAjustes.setBounds(10, 321, 62, 50);
		panel_1.add(btnAjustes);
		btnAjustes.setContentAreaFilled(false);
		btnAjustes.setIcon(new ImageIcon(LogIn.class.getResource("/Imagenes/icons8-engranaje-48.png")));

		JButton btnCrearCuenta = new JButton("Crear cuenta");
		btnCrearCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.abrirNuevoUsuario();
			}
		});
		btnCrearCuenta.setVerticalAlignment(SwingConstants.TOP);
		btnCrearCuenta.setFont(new Font("Arial", Font.PLAIN, 11));
		btnCrearCuenta.setBounds(96, 305, 114, 23);
		panel_1.add(btnCrearCuenta);

		lblFondoCuadro = new JLabel("");
		lblFondoCuadro.setIcon(new ImageIcon(LogIn.class.getResource("/Imagenes/universidad-europea.jpg")));
		lblFondoCuadro.setBounds(0, 0, 706, 381);
		contentPane.add(lblFondoCuadro);

		lblTitulo = new JLabel("APP Gesti\u00F3n FCT");
		lblTitulo.setBounds(380, 55, 286, 58);
		contentPane.add(lblTitulo);
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setFont(new Font("Arial Black", Font.PLAIN, 30));
	}

	public void actualizar(String usr) {
		String resultado = miModelo.getResultado();
		if (resultado.equals("correcto")) {
			miModelo.consultaStatement(usr);
		} else if (resultado.equals("incorrecto")) {
			lblRespuesta.setText("Usuario o contraseña INCORRECTO!!!");
		}

	}

	private void limpiarCampos() {
		txtUsuario.setText(null);
		passwordField.setText(null);

	}

	public void vistaTutor() {
		miControlador.inicioSesionTutor();
	}

	public void vistaDirector() {
		miControlador.inicioSesionDirector();
	}
}
