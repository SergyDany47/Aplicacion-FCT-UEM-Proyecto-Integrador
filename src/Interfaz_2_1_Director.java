import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;

public class Interfaz_2_1_Director extends JFrame {

	private Controlador miControlador;
	private Modelo miModelo;
	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	private JLabel lblTitulo;
	private JTextField txtNumExpediente;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtDNI;
	private JTextField txtEdad;
	private JTextField txtNacionalidad;
	private JButton btnFiltrar;
	private JButton btnAtras;
	private JLabel lblFondo;
	private JPanel panel;
	private JCheckBox chckbxNewCheckBox;
	private JCheckBox chckbxAnexo;
	private JCheckBox chckbxNewCheckBox_2;
	private JCheckBox chckbxNewCheckBox_3;
	private JCheckBox chckbxNewCheckBox_4;
	private JCheckBox chckbxNewCheckBox_5;
	private JCheckBox chckbxNewCheckBox_6;
	private JButton btnGenerar;
	private JPanel panel_1;

	public void setMiControlador(Controlador miControlador) {
		this.miControlador = miControlador;
	}

	public void setMiModelo(Modelo miModelo) {
		this.miModelo = miModelo;
	}

	public Interfaz_2_1_Director() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		setTitle("Interfaz 2.1: Generar Anexos");
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel();
		panel.setBackground(new Color(70, 130, 180, 170));
		panel.setBounds(0, 87, 1275, 594);
		contentPane.add(panel);
		panel.setLayout(null);

		panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 1265, 4);
		panel.add(panel_1);
		panel_1.setBackground(new Color(220, 20, 60));

		scrollPane = new JScrollPane();
		scrollPane.setBounds(81, 100, 822, 427);
		panel.add(scrollPane);

		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		addWindowListener(new WindowAdapter() {
			public void windowActivated(WindowEvent e) {
				String ssql = miModelo.getListadoAlumnos();
				table.setModel(miModelo.getTabla(ssql));
			}
		});

		txtEdad = new JTextField();
		txtEdad.setFont(new Font("Arial", Font.PLAIN, 10));
		txtEdad.setBounds(503, 59, 85, 20);
		panel.add(txtEdad);
		txtEdad.setToolTipText("");
		txtEdad.setText("Fecha.Nacimiento");
		txtEdad.setForeground(Color.BLACK);
		txtEdad.setColumns(10);
		txtEdad.setBackground(Color.WHITE);

		txtNumExpediente = new JTextField();
		txtNumExpediente.setFont(new Font("Arial", Font.PLAIN, 10));
		txtNumExpediente.setBounds(81, 59, 115, 20);
		panel.add(txtNumExpediente);
		txtNumExpediente.setBackground(Color.WHITE);
		txtNumExpediente.setForeground(Color.BLACK);
		txtNumExpediente.setText("Num.Expediente");
		txtNumExpediente.setToolTipText("");
		txtNumExpediente.setColumns(10);

		btnFiltrar = new JButton("Filtrar");
		btnFiltrar.setBackground(SystemColor.inactiveCaption);
		btnFiltrar.setBounds(803, 58, 100, 30);
		panel.add(btnFiltrar);
		btnFiltrar.setFont(new Font("Arial", Font.PLAIN, 13));
		btnFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String inter = "inter21D";
				miControlador.filtrarLisAlum(getDatos(), inter);
			}
		});

		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Arial", Font.PLAIN, 10));
		txtNombre.setBounds(216, 59, 85, 20);
		panel.add(txtNombre);
		txtNombre.setToolTipText("");
		txtNombre.setText("Nombre");
		txtNombre.setForeground(Color.BLACK);
		txtNombre.setColumns(10);
		txtNombre.setBackground(Color.WHITE);

		txtApellidos = new JTextField();
		txtApellidos.setFont(new Font("Arial", Font.PLAIN, 10));
		txtApellidos.setBounds(311, 59, 85, 20);
		panel.add(txtApellidos);
		txtApellidos.setToolTipText("");
		txtApellidos.setText("Apellidos");
		txtApellidos.setForeground(Color.BLACK);
		txtApellidos.setColumns(10);
		txtApellidos.setBackground(Color.WHITE);

		txtDNI = new JTextField();
		txtDNI.setFont(new Font("Arial", Font.PLAIN, 10));
		txtDNI.setBounds(406, 59, 85, 20);
		panel.add(txtDNI);
		txtDNI.setToolTipText("");
		txtDNI.setText("DNI");
		txtDNI.setForeground(Color.BLACK);
		txtDNI.setColumns(10);
		txtDNI.setBackground(Color.WHITE);

		txtNacionalidad = new JTextField();
		txtNacionalidad.setFont(new Font("Arial", Font.PLAIN, 10));
		txtNacionalidad.setBounds(600, 59, 100, 20);
		panel.add(txtNacionalidad);
		txtNacionalidad.setToolTipText("");
		txtNacionalidad.setText("Nacionalidad");
		txtNacionalidad.setForeground(Color.BLACK);
		txtNacionalidad.setColumns(10);
		txtNacionalidad.setBackground(Color.WHITE);

		chckbxNewCheckBox = new JCheckBox("Anexo 1");
		chckbxNewCheckBox.setBounds(944, 123, 141, 23);
		panel.add(chckbxNewCheckBox);

		chckbxAnexo = new JCheckBox("Anexo 2.1");
		chckbxAnexo.setBounds(944, 158, 141, 23);
		panel.add(chckbxAnexo);

		chckbxNewCheckBox_2 = new JCheckBox("Anexo 2.2");
		chckbxNewCheckBox_2.setBounds(944, 193, 141, 23);
		panel.add(chckbxNewCheckBox_2);

		chckbxNewCheckBox_3 = new JCheckBox("Anexo 3");
		chckbxNewCheckBox_3.setBounds(944, 228, 141, 23);
		panel.add(chckbxNewCheckBox_3);

		chckbxNewCheckBox_4 = new JCheckBox("Anexo 7");
		chckbxNewCheckBox_4.setBounds(944, 263, 141, 23);
		panel.add(chckbxNewCheckBox_4);

		chckbxNewCheckBox_5 = new JCheckBox("Anexo 8 ");
		chckbxNewCheckBox_5.setBounds(944, 298, 141, 23);
		panel.add(chckbxNewCheckBox_5);

		chckbxNewCheckBox_6 = new JCheckBox("Seleccionar Todos");
		chckbxNewCheckBox_6.setBounds(944, 333, 141, 23);
		panel.add(chckbxNewCheckBox_6);

		btnGenerar = new JButton("Generar");
		btnGenerar.setFont(new Font("Arial", Font.PLAIN, 13));
		btnGenerar.setBackground(SystemColor.inactiveCaption);
		btnGenerar.setBounds(944, 368, 100, 30);
		panel.add(btnGenerar);

		lblFondo = new JLabel("");
		lblFondo.setBounds(0, 87, 1275, 594);
		contentPane.add(lblFondo);
		lblFondo.setIcon(new ImageIcon(Interfaz_2_2.class.getResource("/Imagenes/fondoBueno.jpg")));

		btnAtras = new JButton("Atrás");
		btnAtras.setBackground(SystemColor.info);
		btnAtras.setBounds(10, 11, 100, 30);
		contentPane.add(btnAtras);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.listadoAlumnos();
			}
		});
		btnAtras.setFont(new Font("Arial", Font.PLAIN, 13));

		lblTitulo = new JLabel("Generar Anexos");
		lblTitulo.setBounds(526, 11, 275, 39);
		contentPane.add(lblTitulo);
		lblTitulo.setForeground(new Color(153, 0, 51));
		lblTitulo.setFont(new Font("Arial", Font.PLAIN, 37));
	}

	public String[] getDatos() {
		String[] datos = new String[6];
		datos[0] = txtNumExpediente.getText();
		datos[1] = txtApellidos.getText();
		datos[2] = txtNombre.getText();
		datos[3] = txtDNI.getText();
		datos[4] = txtEdad.getText();
		datos[5] = txtNacionalidad.getText();
		return datos;
	}

	public void generaFiltro(DefaultTableModel tabla) {
		table.setModel(tabla);
	}
}