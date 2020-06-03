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

public class Interfaz_3 extends JFrame {

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
	private JButton btnFiltrar;
	private JButton btnAnadirModificar;
	private JButton btnAdmEmpresas;
	private JButton btnAsigPractica;
	private JLabel lblFondo;
	private JPanel panel;
	private JPanel panel_1;
	private JButton btnCerrarSesion;
	private JButton btnGuardarFichero;
	private JTextField txtDireccion;
	
	public void setMiControlador(Controlador miControlador) {
		this.miControlador = miControlador;
	}

	public void setMiModelo(Modelo miModelo) {
		this.miModelo = miModelo;
	}

	public Interfaz_3() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		setTitle("Interfaz 3: Adm.Empresa");
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
				String ssql = miModelo.getListadoEmpresa();
				table.setModel(miModelo.getTabla(ssql));
			}
		});
		
		txtEdad = new JTextField();
		txtEdad.setBounds(542, 40, 85, 20);
		panel.add(txtEdad);
		txtEdad.setToolTipText("");
		txtEdad.setText("Responsable");
		txtEdad.setForeground(Color.BLACK);
		txtEdad.setColumns(10);
		txtEdad.setBackground(Color.WHITE);

		btnAnadirModificar = new JButton("A\u00F1adir / Modificar Empresa");
		btnAnadirModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.modifEmpresa();
			}
		});
		btnAnadirModificar.setBounds(958, 538, 220, 30);
		panel.add(btnAnadirModificar);
		btnAnadirModificar.setBackground(SystemColor.info);
		btnAnadirModificar.setFont(new Font("Tahoma", Font.PLAIN, 14));

		txtNumExpediente = new JTextField();
		txtNumExpediente.setBounds(93, 40, 87, 20);
		panel.add(txtNumExpediente);
		txtNumExpediente.setBackground(Color.WHITE);
		txtNumExpediente.setForeground(Color.BLACK);
		txtNumExpediente.setText("CIF");
		txtNumExpediente.setToolTipText("");
		txtNumExpediente.setColumns(10);

		btnFiltrar = new JButton("Filtrar");
		btnFiltrar.setBackground(SystemColor.inactiveCaption);
		btnFiltrar.setBounds(1073, 40, 100, 30);
		panel.add(btnFiltrar);
		btnFiltrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String inter = "inter3T";
				miControlador.filtrarLisEmpr(getDatos(),inter);
			}
		});

		txtNombre = new JTextField();
		txtNombre.setBounds(315, 40, 85, 20);
		panel.add(txtNombre);
		txtNombre.setToolTipText("");
		txtNombre.setText("Tel\u00E9fono");
		txtNombre.setForeground(Color.BLACK);
		txtNombre.setColumns(10);
		txtNombre.setBackground(Color.WHITE);

		txtApellidos = new JTextField();
		txtApellidos.setBounds(202, 40, 85, 20);
		panel.add(txtApellidos);
		txtApellidos.setToolTipText("");
		txtApellidos.setText("Nombre");
		txtApellidos.setForeground(Color.BLACK);
		txtApellidos.setColumns(10);
		txtApellidos.setBackground(Color.WHITE);

		txtDNI = new JTextField();
		txtDNI.setBounds(427, 40, 85, 20);
		panel.add(txtDNI);
		txtDNI.setToolTipText("");
		txtDNI.setText("Localidad");
		txtDNI.setForeground(Color.BLACK);
		txtDNI.setColumns(10);
		txtDNI.setBackground(Color.WHITE);
		
		btnGuardarFichero = new JButton("Guardar Fichero");
		btnGuardarFichero.setBounds(93, 544, 137, 23);
		panel.add(btnGuardarFichero);
		btnGuardarFichero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.GuardarListadoEmpresa();
			}
		});
		btnGuardarFichero.setBackground(SystemColor.info);
		btnGuardarFichero.setFont(new Font("Arial", Font.PLAIN, 12));
		
		txtDireccion = new JTextField();
		txtDireccion.setToolTipText("");
		txtDireccion.setText("Direccion");
		txtDireccion.setForeground(Color.BLACK);
		txtDireccion.setColumns(10);
		txtDireccion.setBackground(Color.WHITE);
		txtDireccion.setBounds(660, 40, 85, 20);
		panel.add(txtDireccion);

		lblFondo = new JLabel("");
		lblFondo.setBounds(0, 87, 1275, 594);
		contentPane.add(lblFondo);
		lblFondo.setIcon(new ImageIcon(Interfaz_3.class.getResource("/Imagenes/fondoBueno.jpg")));

		lblTitulo = new JLabel("Listado De Empresa");
		lblTitulo.setBounds(316, 11, 383, 39);
		contentPane.add(lblTitulo);
		lblTitulo.setForeground(new Color(153, 0, 51));
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 37));

		btnAdmEmpresas = new JButton("Administrar Alumnos");
		btnAdmEmpresas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.adminAlumnos();
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
		
		btnCerrarSesion = new JButton("Cerrar Sesión");
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cerrarSesion();
			}
		});
		btnCerrarSesion.setBackground(SystemColor.info);
		btnCerrarSesion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCerrarSesion.setBounds(10, 11, 117, 30);
		contentPane.add(btnCerrarSesion);
	}
	public String [] getDatos(){
		String [] datos = new String[6];
		datos[0]=txtNumExpediente.getText(); //CIF
		datos[3]=txtApellidos.getText(); //Nombre
		datos[2]=txtNombre.getText();//Tel
		datos[5]=txtDNI.getText(); //Localidad
		datos[4]=txtEdad.getText(); //resp_e
		datos[1]=txtDireccion.getText();
		return datos;
	}

	public void generaFiltro(DefaultTableModel tabla) {
		table.setModel(tabla);
	}
}
