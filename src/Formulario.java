import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class Formulario extends JFrame {
	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblFondo;
	private JLabel lblURL;
	private JTextField textUsuario;
	private JTextField textContrasena;
	private JTextField textURL;
	private JLabel lblUsuario;
	private JLabel lblIconoContrasena;
	private JLabel lblIconoURL;
	private JLabel lblIconoUsuario;
	private JButton btnModificar;
	private JButton btnReiniciar;
	private JLabel lblContrasena;
	private Controlador miControlador;
	private Modelo miModelo;
	private JLabel lblNewLabel;

	public void setMiControlador(Controlador miControlador) {
		this.miControlador = miControlador;
	}

	public void setMiModelo(Modelo miModelo) {
		this.miModelo = miModelo;
	}

	public String[] nombre() {
		File fichero = new File("Ajustes.ini");
		int vez = 0;
		String[] texto = new String[3];
		;
		if (fichero.exists()) {
			try {
				Scanner sc = new Scanner(fichero);

				while (sc.hasNext()) {

					texto[vez] = sc.nextLine();
					vez++;

				}
				sc.close();
			} catch (IOException e) {
				System.out.println("Error de Entrada/Salida");
			}
		} else {

			System.out.println("El fichero no existe");
		}
		return texto;
	}

	public Formulario() {
		String[] user = nombre();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Ajustes de Conexión");
		setBounds(100, 100, 550, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel();
		panel.setBackground(new Color(105, 105, 105, 230));
		panel.setBounds(0, 69, 536, 294);
		contentPane.add(panel);
		panel.setLayout(null);

		lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBackground(Color.WHITE);
		lblUsuario.setBounds(74, 57, 75, 27);
		lblUsuario.setFont(new Font("Arial", Font.PLAIN, 18));
		lblUsuario.setForeground(Color.WHITE);
		panel.add(lblUsuario);

		lblContrasena = new JLabel("Contraseña:");
		lblContrasena.setForeground(Color.WHITE);
		lblContrasena.setFont(new Font("Arial", Font.PLAIN, 18));
		lblContrasena.setBackground(Color.WHITE);
		lblContrasena.setBounds(74, 94, 120, 27);
		panel.add(lblContrasena);

		lblURL = new JLabel("URL:");
		lblURL.setForeground(Color.WHITE);
		lblURL.setFont(new Font("Arial", Font.PLAIN, 18));
		lblURL.setBackground(Color.WHITE);
		lblURL.setBounds(74, 131, 75, 27);
		panel.add(lblURL);

		textUsuario = new JTextField();
		textUsuario.setBounds(204, 64, 199, 19);
		panel.add(textUsuario);
		textUsuario.setColumns(10);
		textUsuario.setText(user[0]);

		textContrasena = new JTextField();
		textContrasena.setColumns(10);
		textContrasena.setBounds(204, 101, 199, 19);
		panel.add(textContrasena);
		textContrasena.setText(user[1]);

		textURL = new JTextField();
		textURL.setColumns(10);
		textURL.setBounds(204, 138, 199, 19);
		panel.add(textURL);
		textURL.setText(user[2]);

		btnReiniciar = new JButton("Volver");
		btnReiniciar.setFont(new Font("Arial Black", Font.PLAIN, 11));
		btnReiniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cerrarSesion();
			}
		});
		btnReiniciar.setBounds(412, 252, 98, 21);
		panel.add(btnReiniciar);

		btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Arial Black", Font.PLAIN, 11));
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.modificarDatos();
				JOptionPane.showMessageDialog(null, "Modificado con éxito", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnModificar.setBounds(204, 186, 98, 21);
		panel.add(btnModificar);

		lblIconoUsuario = new JLabel("");
		lblIconoUsuario.setIcon(new ImageIcon(Formulario.class.getResource("/Imagenes/icons8-usuario-30.png")));
		lblIconoUsuario.setBounds(28, 48, 36, 36);
		panel.add(lblIconoUsuario);

		lblIconoContrasena = new JLabel("");
		lblIconoContrasena.setIcon(
				new ImageIcon(Formulario.class.getResource("/Imagenes/icons8-mostrar-contrase\u00F1a-30.png")));
		lblIconoContrasena.setBounds(28, 98, 36, 23);
		panel.add(lblIconoContrasena);

		lblIconoURL = new JLabel("");
		lblIconoURL.setIcon(new ImageIcon(Formulario.class.getResource("/Imagenes/icons8-base-de-datos-30.png")));
		lblIconoURL.setBounds(28, 133, 36, 36);
		panel.add(lblIconoURL);

		lblFondo = new JLabel("New label");
		lblFondo.setBounds(0, 69, 531, 294);
		contentPane.add(lblFondo);
		lblFondo.setIcon(new ImageIcon(Formulario.class.getResource("/Imagenes/fondo-tecnologico-brillante-azul.jpg")));

		lblNewLabel = new JLabel("Configuraci\u00F3n de Conexi\u00F3n");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(81, 10, 375, 35);
		contentPane.add(lblNewLabel);

	}

	public String getUsuario() {
		String usuario = textUsuario.getText();
		return usuario;
	}

	public String getPassword() {
		String password = textContrasena.getText();
		return password;
	}

	public String getUrl() {
		String url = textURL.getText();
		return url;
	}
}
