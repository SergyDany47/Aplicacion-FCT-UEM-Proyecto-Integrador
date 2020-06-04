
/**
 * @author SergioO
 */
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

public class Interfaz_2 extends JFrame {

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
	private JButton btnAnadirModificar;
	private JButton btnGenerarAnexo;
	private JButton btnAdmEmpresas;
	private JButton btnAtras;
	private JButton btnAsigPractica;
	private JLabel lblFondo;
	private JPanel panel;
	private JPanel panel_1;
	private JButton btnGuardarFichero;

	public void setMiControlador(Controlador miControlador) {
		this.miControlador = miControlador;
	}

	public void setMiModelo(Modelo miModelo) {
		this.miModelo = miModelo;
	}

	public Interfaz_2() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		setTitle("Interfaz 2: Adm.Alumnos");
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192, 180));
		panel.setBounds(0, 87, 1275, 594);
		contentPane.add(panel);
		panel.setLayout(null);

		panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 1265, 4);
		panel.add(panel_1);
		panel_1.setBackground(new Color(220, 20, 60));

		scrollPane = new JScrollPane();
		scrollPane.setBounds(93, 81, 1080, 440);
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
		txtEdad.setBounds(528, 37, 85, 20);
		panel.add(txtEdad);
		txtEdad.setToolTipText("");
		txtEdad.setText("Fecha.Nacimiento");
		txtEdad.setForeground(Color.BLACK);
		txtEdad.setColumns(10);
		txtEdad.setBackground(Color.WHITE);

		btnAnadirModificar = new JButton("A\u00F1adir / Modificar Alumno");
		btnAnadirModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				miControlador.modifAlumnos();
			}
		});
		btnAnadirModificar.setBounds(712, 538, 220, 30);
		panel.add(btnAnadirModificar);
		btnAnadirModificar.setBackground(SystemColor.info);
		btnAnadirModificar.setFont(new Font("Arial", Font.PLAIN, 14));

		btnGenerarAnexo = new JButton("Generar Anexos");
		btnGenerarAnexo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.generarAnexos();
			}
		});
		btnGenerarAnexo.setBounds(958, 538, 220, 30);
		panel.add(btnGenerarAnexo);
		btnGenerarAnexo.setBackground(SystemColor.info);
		btnGenerarAnexo.setFont(new Font("Arial", Font.PLAIN, 14));

		txtNumExpediente = new JTextField();
		txtNumExpediente.setFont(new Font("Arial", Font.PLAIN, 10));
		txtNumExpediente.setBounds(93, 37, 87, 20);
		panel.add(txtNumExpediente);
		txtNumExpediente.setBackground(Color.WHITE);
		txtNumExpediente.setForeground(Color.BLACK);
		txtNumExpediente.setText("Num.Expediente");
		txtNumExpediente.setToolTipText("");
		txtNumExpediente.setColumns(10);

		btnFiltrar = new JButton("Filtrar");
		btnFiltrar.setBackground(SystemColor.inactiveCaption);
		btnFiltrar.setBounds(1077, 31, 100, 30);
		panel.add(btnFiltrar);
		btnFiltrar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String inter = "inter2T";
				miControlador.filtrarLisAlum(getDatos(), inter);
			}
		});

		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Arial", Font.PLAIN, 10));
		txtNombre.setBounds(206, 37, 85, 20);
		panel.add(txtNombre);
		txtNombre.setToolTipText("");
		txtNombre.setText("Nombre");
		txtNombre.setForeground(Color.BLACK);
		txtNombre.setColumns(10);
		txtNombre.setBackground(Color.WHITE);

		txtApellidos = new JTextField();
		txtApellidos.setFont(new Font("Arial", Font.PLAIN, 10));
		txtApellidos.setBounds(313, 37, 85, 20);
		panel.add(txtApellidos);
		txtApellidos.setToolTipText("");
		txtApellidos.setText("Apellidos");
		txtApellidos.setForeground(Color.BLACK);
		txtApellidos.setColumns(10);
		txtApellidos.setBackground(Color.WHITE);

		txtDNI = new JTextField();
		txtDNI.setFont(new Font("Arial", Font.PLAIN, 10));
		txtDNI.setBounds(420, 37, 85, 20);
		panel.add(txtDNI);
		txtDNI.setToolTipText("");
		txtDNI.setText("DNI");
		txtDNI.setForeground(Color.BLACK);
		txtDNI.setColumns(10);
		txtDNI.setBackground(Color.WHITE);

		txtNacionalidad = new JTextField();
		txtNacionalidad.setFont(new Font("Arial", Font.PLAIN, 10));
		txtNacionalidad.setBounds(641, 37, 85, 20);
		panel.add(txtNacionalidad);
		txtNacionalidad.setToolTipText("");
		txtNacionalidad.setText("Nacionalidad");
		txtNacionalidad.setForeground(Color.BLACK);
		txtNacionalidad.setColumns(10);
		txtNacionalidad.setBackground(Color.WHITE);

		btnGuardarFichero = new JButton("Guardar Fichero");
		btnGuardarFichero.setBounds(93, 544, 128, 30);
		panel.add(btnGuardarFichero);
		btnGuardarFichero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.GuardarListadoAlumnos();
			}
		});
		btnGuardarFichero.setFont(new Font("Arial", Font.PLAIN, 12));
		btnGuardarFichero.setBackground(SystemColor.info);

		lblFondo = new JLabel("");
		lblFondo.setBounds(0, 87, 1275, 594);
		contentPane.add(lblFondo);
		lblFondo.setIcon(new ImageIcon(Interfaz_2.class.getResource("/Imagenes/fondoBueno.jpg")));

		btnAtras = new JButton("Cerrar Sesi\u00F3n");
		btnAtras.setBackground(SystemColor.info);
		btnAtras.setBounds(10, 11, 117, 30);
		contentPane.add(btnAtras);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cerrarSesion();
			}
		});
		btnAtras.setFont(new Font("Arial", Font.PLAIN, 13));

		lblTitulo = new JLabel("Listado de Alumnos");
		lblTitulo.setBounds(316, 11, 383, 39);
		contentPane.add(lblTitulo);
		lblTitulo.setForeground(new Color(153, 0, 51));
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 37));

		btnAdmEmpresas = new JButton("Administrar Empresas");
		btnAdmEmpresas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.adminEmpresas();
			}
		});
		btnAdmEmpresas.setBackground(SystemColor.info);
		btnAdmEmpresas.setBounds(873, 11, 180, 30);
		contentPane.add(btnAdmEmpresas);
		btnAdmEmpresas.setFont(new Font("Arial", Font.PLAIN, 14));

		btnAsigPractica = new JButton("Administrar Pr\u00E1cticas");
		btnAsigPractica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.adminPracticas();
			}
		});
		btnAsigPractica.setBackground(SystemColor.info);
		btnAsigPractica.setBounds(1074, 11, 180, 30);
		contentPane.add(btnAsigPractica);
		btnAsigPractica.setFont(new Font("Arial", Font.PLAIN, 14));
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