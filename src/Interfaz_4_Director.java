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
		txtEdad.setBounds(533, 46, 85, 20);
		panel.add(txtEdad);
		txtEdad.setToolTipText("");
		txtEdad.setText("Nom. Emp. ");
		txtEdad.setForeground(Color.BLACK);
		txtEdad.setColumns(10);
		txtEdad.setBackground(Color.WHITE);

		txtNumExpediente = new JTextField();
		txtNumExpediente.setBounds(95, 46, 87, 20);
		panel.add(txtNumExpediente);
		txtNumExpediente.setBackground(Color.WHITE);
		txtNumExpediente.setForeground(Color.BLACK);
		txtNumExpediente.setText("DNI ");
		txtNumExpediente.setToolTipText("");
		txtNumExpediente.setColumns(10);

		btnFiltrar = new JButton("Filtrar");
		btnFiltrar.setBackground(SystemColor.inactiveCaption);
		btnFiltrar.setBounds(1073, 40, 100, 30);
		panel.add(btnFiltrar);
		btnFiltrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		btnGuardarFichero = new JButton("Guardar Fichero");
		btnGuardarFichero.setBounds(93, 544, 128, 23);
		panel.add(btnGuardarFichero);
		btnGuardarFichero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.GuardarListadoPracticasDirector();
			}
		});
		btnGuardarFichero.setFont(new Font("Arial", Font.PLAIN, 12));
		btnGuardarFichero.setBackground(SystemColor.info);

		txtNombre = new JTextField();
		txtNombre.setBounds(313, 46, 85, 20);
		panel.add(txtNombre);
		txtNombre.setToolTipText("");
		txtNombre.setText("Apell. Num.");
		txtNombre.setForeground(Color.BLACK);
		txtNombre.setColumns(10);
		txtNombre.setBackground(Color.WHITE);

		txtApellidos = new JTextField();
		txtApellidos.setBounds(204, 46, 85, 20);
		panel.add(txtApellidos);
		txtApellidos.setToolTipText("");
		txtApellidos.setText("Nom. Alum.");
		txtApellidos.setForeground(Color.BLACK);
		txtApellidos.setColumns(10);
		txtApellidos.setBackground(Color.WHITE);

		txtDNI = new JTextField();
		txtDNI.setBounds(426, 46, 85, 20);
		panel.add(txtDNI);
		txtDNI.setToolTipText("");
		txtDNI.setText("CIF Emp.");
		txtDNI.setForeground(Color.BLACK);
		txtDNI.setColumns(10);
		txtDNI.setBackground(Color.WHITE);

		txtNacionalidad = new JTextField();
		txtNacionalidad.setBounds(646, 46, 85, 20);
		panel.add(txtNacionalidad);
		txtNacionalidad.setToolTipText("");
		txtNacionalidad.setText("Resp. Emp");
		txtNacionalidad.setForeground(Color.BLACK);
		txtNacionalidad.setColumns(10);
		txtNacionalidad.setBackground(Color.WHITE);

		lblFondo = new JLabel("");
		lblFondo.setBounds(0, 87, 1275, 594);
		btnListTutores.add(lblFondo);
		lblFondo.setIcon(new ImageIcon(Interfaz_4.class.getResource("/Imagenes/fondoBueno.jpg")));

		lblTitulo = new JLabel("Listado de Practicas en Curso");
		lblTitulo.setBounds(176, 11, 491, 39);
		btnListTutores.add(lblTitulo);
		lblTitulo.setForeground(new Color(153, 0, 51));
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 37));

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
		btnCerrarSesion.setFont(new Font("Tahoma", Font.PLAIN, 12));
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
}