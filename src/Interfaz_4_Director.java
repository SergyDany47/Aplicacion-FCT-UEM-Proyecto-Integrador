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

public class Interfaz_4_Director extends JFrame {

	private Controlador miControlador;
	private Modelo miModelo;
	private JPanel btnListTutores;
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
	private JButton btnListEmpresas;
	private JButton btnListAlumnos;
	private JLabel lblFondo;
	private JPanel panel;
	private JButton btnCerrarSesion;
	private JButton btnGuardarFichero;
	private JTextField txtExp;

	public void setMiControlador(Controlador miControlador) {
		this.miControlador = miControlador;
	}

	public void setMiModelo(Modelo miModelo) {
		this.miModelo = miModelo;
	}

	public Interfaz_4_Director() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		setTitle("Interfaz 4: Listado de Practicas");
		btnListTutores = new JPanel();
		btnListTutores.setBackground(Color.WHITE);
		btnListTutores.setForeground(new Color(0, 0, 0));
		btnListTutores.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(btnListTutores);
		btnListTutores.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 87, 1265, 4);
		btnListTutores.add(panel_1);
		panel_1.setBackground(new Color(220, 20, 60));
		panel_1.setLayout(null);

		panel = new JPanel();
		panel.setBackground(new Color(70, 130, 180, 170));
		panel.setBounds(0, 87, 1275, 594);
		btnListTutores.add(panel);
		panel.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(93, 81, 1080, 440);
		panel.add(scrollPane);

		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		addWindowListener(new WindowAdapter() {
			public void windowActivated(WindowEvent e) {
				String ssql = miModelo.getListadoPracticas();
				table.setModel(miModelo.getTabla(ssql));
			}
		});
		scrollPane.setViewportView(table);

		txtEdad = new JTextField();
		txtEdad.setFont(new Font("Arial", Font.PLAIN, 10));
		txtEdad.setBounds(650, 46, 85, 20);
		panel.add(txtEdad);
		txtEdad.setToolTipText("");
		txtEdad.setText("Nom. Emp.");
		txtEdad.setForeground(Color.BLACK);
		txtEdad.setColumns(10);
		txtEdad.setBackground(Color.WHITE);

		txtNumExpediente = new JTextField();
		txtNumExpediente.setFont(new Font("Arial", Font.PLAIN, 10));
		txtNumExpediente.setBounds(204, 46, 87, 20);
		panel.add(txtNumExpediente);
		txtNumExpediente.setBackground(Color.WHITE);
		txtNumExpediente.setForeground(Color.BLACK);
		txtNumExpediente.setText("DNI");
		txtNumExpediente.setToolTipText("");
		txtNumExpediente.setColumns(10);

		btnFiltrar = new JButton("Filtrar");
		btnFiltrar.setBackground(SystemColor.inactiveCaption);
		btnFiltrar.setBounds(1073, 40, 100, 30);
		panel.add(btnFiltrar);
		btnFiltrar.setFont(new Font("Arial", Font.PLAIN, 13));
		btnFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String inter = "inter4D";
				miControlador.filtrarLisPra(getDatos(), inter);
			}
		});

		btnGuardarFichero = new JButton("Guardar Fichero");
		btnGuardarFichero.setBounds(93, 539, 128, 30);
		panel.add(btnGuardarFichero);
		btnGuardarFichero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.GuardarListadoPracticasDirector();
			}
		});
		btnGuardarFichero.setFont(new Font("Arial", Font.PLAIN, 12));
		btnGuardarFichero.setBackground(SystemColor.info);

		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Arial", Font.PLAIN, 10));
		txtNombre.setBounds(428, 46, 85, 20);
		panel.add(txtNombre);
		txtNombre.setToolTipText("");
		txtNombre.setText("Apell. Alum");
		txtNombre.setForeground(Color.BLACK);
		txtNombre.setColumns(10);
		txtNombre.setBackground(Color.WHITE);

		txtApellidos = new JTextField();
		txtApellidos.setFont(new Font("Arial", Font.PLAIN, 10));
		txtApellidos.setBounds(317, 46, 85, 20);
		panel.add(txtApellidos);
		txtApellidos.setToolTipText("");
		txtApellidos.setText("Nom. Alum");
		txtApellidos.setForeground(Color.BLACK);
		txtApellidos.setColumns(10);
		txtApellidos.setBackground(Color.WHITE);

		txtDNI = new JTextField();
		txtDNI.setFont(new Font("Arial", Font.PLAIN, 10));
		txtDNI.setBounds(538, 46, 85, 20);
		panel.add(txtDNI);
		txtDNI.setToolTipText("");
		txtDNI.setText("CIF Emp.");
		txtDNI.setForeground(Color.BLACK);
		txtDNI.setColumns(10);
		txtDNI.setBackground(Color.WHITE);

		txtNacionalidad = new JTextField();
		txtNacionalidad.setFont(new Font("Arial", Font.PLAIN, 10));
		txtNacionalidad.setBounds(754, 46, 85, 20);
		panel.add(txtNacionalidad);
		txtNacionalidad.setToolTipText("");
		txtNacionalidad.setText("Resp. Emp");
		txtNacionalidad.setForeground(Color.BLACK);
		txtNacionalidad.setColumns(10);
		txtNacionalidad.setBackground(Color.WHITE);

		txtExp = new JTextField();
		txtExp.setFont(new Font("Arial", Font.PLAIN, 10));
		txtExp.setToolTipText("");
		txtExp.setText("Expediente");
		txtExp.setForeground(Color.BLACK);
		txtExp.setColumns(10);
		txtExp.setBackground(Color.WHITE);
		txtExp.setBounds(93, 46, 85, 20);
		panel.add(txtExp);
		
		JButton btnDatosHistoricos = new JButton("Datos Historicos");
		btnDatosHistoricos.setFont(new Font("Arial", Font.PLAIN, 12));
		btnDatosHistoricos.setBackground(SystemColor.info);
		btnDatosHistoricos.setBounds(1045, 539, 128, 30);
		panel.add(btnDatosHistoricos);

		lblFondo = new JLabel("");
		lblFondo.setBounds(0, 87, 1275, 594);
		btnListTutores.add(lblFondo);
		lblFondo.setIcon(new ImageIcon(Interfaz_4.class.getResource("/Imagenes/fondoBueno.jpg")));

		lblTitulo = new JLabel("Listado de Practicas en Curso");
		lblTitulo.setBounds(151, 11, 516, 39);
		btnListTutores.add(lblTitulo);
		lblTitulo.setForeground(new Color(153, 0, 51));
		lblTitulo.setFont(new Font("Arial", Font.PLAIN, 37));

		btnListEmpresas = new JButton("Listado Empresas");
		btnListEmpresas.setBackground(SystemColor.info);
		btnListEmpresas.setBounds(884, 11, 180, 30);
		btnListTutores.add(btnListEmpresas);
		btnListEmpresas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.listadoEmpresas();
			}
		});
		btnListEmpresas.setFont(new Font("Arial", Font.PLAIN, 14));

		btnListAlumnos = new JButton("Listado Alumnos");
		btnListAlumnos.setBackground(SystemColor.info);
		btnListAlumnos.setBounds(1074, 11, 180, 30);
		btnListTutores.add(btnListAlumnos);
		btnListAlumnos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.listadoAlumnos();
			}
		});
		btnListAlumnos.setFont(new Font("Arial", Font.PLAIN, 14));

		btnCerrarSesion = new JButton("Cerrar Sesión");
		btnCerrarSesion.setBackground(SystemColor.info);
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cerrarSesionDirector();
			}
		});
		btnCerrarSesion.setFont(new Font("Arial", Font.PLAIN, 13));
		btnCerrarSesion.setBounds(10, 11, 117, 30);
		btnListTutores.add(btnCerrarSesion);

		JButton btnListadoTutores = new JButton("Listado Tutores");
		btnListadoTutores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.listadoTutores();
			}
		});
		btnListadoTutores.setFont(new Font("Arial", Font.PLAIN, 14));
		btnListadoTutores.setBackground(SystemColor.info);
		btnListadoTutores.setBounds(694, 11, 180, 30);
		btnListTutores.add(btnListadoTutores);
	}

	public String[] getDatos() {
		String[] datos = new String[7];
		datos[0] = txtNumExpediente.getText(); // DNI
		datos[1] = txtApellidos.getText(); // nomb
		datos[2] = txtNombre.getText();// Apell
		datos[3] = txtDNI.getText(); // CIF
		datos[4] = txtEdad.getText(); // nom emp
		datos[5] = txtExp.getText();
		datos[6] = txtNacionalidad.getText(); // resp_esp
		return datos;
	}

	public void generaFiltro(DefaultTableModel tabla) {
		table.setModel(tabla);
	}
}