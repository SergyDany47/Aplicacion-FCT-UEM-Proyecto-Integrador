
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

public class Interfaz_5_Director extends JFrame {

	private Controlador miControlador;
	private Modelo miModelo;
	private JPanel contentPane;
	private JTable tablaListaTutor;
	private JScrollPane scrollPane;
	private JLabel lblTitulo;
	private JTextField txtDNITutor;
	private JTextField txtApellidos;
	private JTextField txtNombre_1;
	private JTextField txtCodigoCentro;
	private JButton btnFiltrar;
	private JButton btnAñadirModificar;
	private JButton btnListEmpresas;
	private JButton btnAtrás;
	private JButton btnListPractica;
	private JLabel lblFondo;
	private JPanel panel;
	private JPanel panel_1;
	private JButton btnListAlumnos;
	private JButton btnGuardarFichero;

	public void setMiControlador(Controlador miControlador) {
		this.miControlador = miControlador;
	}

	public void setMiModelo(Modelo miModelo) {
		this.miModelo = miModelo;
	}

	public Interfaz_5_Director() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		setTitle("Interfaz 5: Adm.Tutores");
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
		scrollPane.setBounds(93, 81, 1080, 440);
		panel.add(scrollPane);

		tablaListaTutor = new JTable();
		tablaListaTutor.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		scrollPane.setViewportView(tablaListaTutor);

		addWindowListener(new WindowAdapter() {
			public void windowActivated(WindowEvent e) {
				String sql = miModelo.getListadoTutor();
				tablaListaTutor.setModel(miModelo.getTabla(sql));
			}
		});

		btnAñadirModificar = new JButton("Añadir / Modificar Tutor");
		btnAñadirModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				miControlador.administrarTutores();
			}
		});
		btnAñadirModificar.setBounds(953, 539, 220, 30);
		panel.add(btnAñadirModificar);
		btnAñadirModificar.setBackground(SystemColor.info);
		btnAñadirModificar.setFont(new Font("Tahoma", Font.PLAIN, 14));

		txtDNITutor = new JTextField();
		txtDNITutor.setFont(new Font("Arial", Font.PLAIN, 10));
		txtDNITutor.setBounds(93, 37, 87, 20);
		panel.add(txtDNITutor);
		txtDNITutor.setBackground(Color.WHITE);
		txtDNITutor.setForeground(Color.BLACK);
		txtDNITutor.setText("DNI del tutor");
		txtDNITutor.setToolTipText("");
		txtDNITutor.setColumns(10);

		btnFiltrar = new JButton("Filtrar");
		btnFiltrar.setBackground(SystemColor.inactiveCaption);
		btnFiltrar.setBounds(1077, 31, 100, 30);
		panel.add(btnFiltrar);
		btnFiltrar.setFont(new Font("Arial", Font.PLAIN, 13));
		btnFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String inter = "inter5D";
				miControlador.filtrarLisTut(getDatos(),inter);
			}
		});

		btnGuardarFichero = new JButton("Guardar Fichero");
		btnGuardarFichero.setBounds(93, 541, 128, 30);
		panel.add(btnGuardarFichero);
		btnGuardarFichero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.GuardarListadoTutoresDirector();
			}
		});
		btnGuardarFichero.setFont(new Font("Arial", Font.PLAIN, 12));
		btnGuardarFichero.setBackground(SystemColor.info);
		
		txtApellidos = new JTextField();
		txtApellidos.setFont(new Font("Arial", Font.PLAIN, 10));
		txtApellidos.setBounds(309, 37, 85, 20);
		panel.add(txtApellidos);
		txtApellidos.setToolTipText("");
		txtApellidos.setText("Apellidos");
		txtApellidos.setForeground(Color.BLACK);
		txtApellidos.setColumns(10);
		txtApellidos.setBackground(Color.WHITE);

		txtNombre_1 = new JTextField();
		txtNombre_1.setFont(new Font("Arial", Font.PLAIN, 10));
		txtNombre_1.setBounds(201, 37, 85, 20);
		panel.add(txtNombre_1);
		txtNombre_1.setToolTipText("");
		txtNombre_1.setText("Nombre");
		txtNombre_1.setForeground(Color.BLACK);
		txtNombre_1.setColumns(10);
		txtNombre_1.setBackground(Color.WHITE);

		txtCodigoCentro = new JTextField();
		txtCodigoCentro.setFont(new Font("Arial", Font.PLAIN, 10));
		txtCodigoCentro.setBounds(420, 37, 85, 20);
		panel.add(txtCodigoCentro);
		txtCodigoCentro.setToolTipText("");
		txtCodigoCentro.setText("Código centro");
		txtCodigoCentro.setForeground(Color.BLACK);
		txtCodigoCentro.setColumns(10);
		txtCodigoCentro.setBackground(Color.WHITE);

		lblFondo = new JLabel("");
		lblFondo.setBounds(0, 87, 1275, 594);
		contentPane.add(lblFondo);
		lblFondo.setIcon(new ImageIcon(Interfaz_5_Director.class.getResource("/Imagenes/fondoBueno.jpg")));

		btnAtrás = new JButton("Cerrar Sesión");
		btnAtrás.setBackground(SystemColor.info);
		btnAtrás.setBounds(10, 11, 117, 30);
		contentPane.add(btnAtrás);
		btnAtrás.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cerrarSesionDirector();
			}
		});
		btnAtrás.setFont(new Font("Arial", Font.PLAIN, 13));

		lblTitulo = new JLabel("Listado de Tutores");
		lblTitulo.setBounds(277, 11, 383, 39);
		contentPane.add(lblTitulo);
		lblTitulo.setForeground(new Color(153, 0, 51));
		lblTitulo.setFont(new Font("Arial", Font.PLAIN, 37));

		btnListEmpresas = new JButton("Listado  Empresas");
		btnListEmpresas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.listadoEmpresas();
			}
		});
		btnListEmpresas.setBackground(SystemColor.info);
		btnListEmpresas.setBounds(888, 11, 180, 30);
		contentPane.add(btnListEmpresas);
		btnListEmpresas.setFont(new Font("Arial", Font.PLAIN, 14));

		btnListPractica = new JButton("Listado Prácticas");
		btnListPractica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.listadoPracticas();
			}
		});
		btnListPractica.setBackground(SystemColor.info);
		btnListPractica.setBounds(1074, 11, 180, 30);
		contentPane.add(btnListPractica);
		btnListPractica.setFont(new Font("Arial", Font.PLAIN, 14));

		btnListAlumnos = new JButton("Listado Alumnos");
		btnListAlumnos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.listadoAlumnos();
			}
		});
		btnListAlumnos.setFont(new Font("Arial", Font.PLAIN, 14));
		btnListAlumnos.setBackground(SystemColor.info);
		btnListAlumnos.setBounds(698, 11, 180, 30);
		contentPane.add(btnListAlumnos);
	}
	public String [] getDatos(){
		String [] datos = new String[6];
		datos[0]=txtDNITutor.getText();
		datos[1]=txtNombre_1.getText();
		datos[2]=txtApellidos.getText();
		datos[3]=txtCodigoCentro.getText();
		return datos;
	}

	public void generaFiltro(DefaultTableModel tabla) {
		tablaListaTutor.setModel(tabla);
	}
}