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

public class Interfaz_4 extends JFrame {

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
	private JButton btnGenerarAnexo;
	private JButton btnAdmEmpresas;
	private JButton btnAsigPractica;
	private JLabel lblFondo;
	private JPanel panel;
	private JButton btnNewButton;
	private JButton btnGuardarFichero;
	private JTextField txtExp;

	public void setMiControlador(Controlador miControlador) {
		this.miControlador = miControlador;
	}

	public void setMiModelo(Modelo miModelo) {
		this.miModelo = miModelo;
	}

	public Interfaz_4() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		setTitle("Interfaz 4: Listado de Practicas");
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 87, 1265, 4);
		contentPane.add(panel_1);
		panel_1.setBackground(new Color(220, 20, 60));
		panel_1.setLayout(null);

		panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192, 180));
		panel.setBounds(0, 87, 1275, 594);
		contentPane.add(panel);
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
		txtEdad.setBounds(574, 46, 85, 20);
		panel.add(txtEdad);
		txtEdad.setToolTipText("");
		txtEdad.setText("Nom. Emp.");
		txtEdad.setForeground(Color.BLACK);
		txtEdad.setColumns(10);
		txtEdad.setBackground(Color.WHITE);

		btnGenerarAnexo = new JButton("Asignar Practicas");
		btnGenerarAnexo.setBounds(958, 538, 220, 30);
		panel.add(btnGenerarAnexo);
		btnGenerarAnexo.setBackground(SystemColor.info);
		btnGenerarAnexo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.asignarPracticas();
			}
		});
		btnGenerarAnexo.setFont(new Font("Arial", Font.PLAIN, 14));

		txtNumExpediente = new JTextField();
		txtNumExpediente.setFont(new Font("Arial", Font.PLAIN, 10));
		txtNumExpediente.setBounds(188, 46, 87, 20);
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
		btnFiltrar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String inter = "inter4T";
				miControlador.filtrarLisPra(getDatos(),inter);
			}
		});

		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Arial", Font.PLAIN, 10));
		txtNombre.setBounds(380, 46, 85, 20);
		panel.add(txtNombre);
		txtNombre.setToolTipText("");
		txtNombre.setText("Apellidos");
		txtNombre.setForeground(Color.BLACK);
		txtNombre.setColumns(10);
		txtNombre.setBackground(Color.WHITE);

		txtApellidos = new JTextField();
		txtApellidos.setFont(new Font("Arial", Font.PLAIN, 10));
		txtApellidos.setBounds(285, 46, 85, 20);
		panel.add(txtApellidos);
		txtApellidos.setToolTipText("");
		txtApellidos.setText("Nom. Alum.");
		txtApellidos.setForeground(Color.BLACK);
		txtApellidos.setColumns(10);
		txtApellidos.setBackground(Color.WHITE);

		txtDNI = new JTextField();
		txtDNI.setFont(new Font("Arial", Font.PLAIN, 10));
		txtDNI.setBounds(475, 46, 85, 20);
		panel.add(txtDNI);
		txtDNI.setToolTipText("");
		txtDNI.setText("CIF Emp.");
		txtDNI.setForeground(Color.BLACK);
		txtDNI.setColumns(10);
		txtDNI.setBackground(Color.WHITE);

		txtNacionalidad = new JTextField();
		txtNacionalidad.setFont(new Font("Arial", Font.PLAIN, 10));
		txtNacionalidad.setBounds(675, 46, 85, 20);
		panel.add(txtNacionalidad);
		txtNacionalidad.setToolTipText("");
		txtNacionalidad.setText("Resp. Emp");
		txtNacionalidad.setForeground(Color.BLACK);
		txtNacionalidad.setColumns(10);
		txtNacionalidad.setBackground(Color.WHITE);
		
		btnGuardarFichero = new JButton("Guardar Fichero");
		btnGuardarFichero.setBounds(93, 539, 137, 30);
		panel.add(btnGuardarFichero);
		btnGuardarFichero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.GuardarListadoPracticas();
			}
		});
		btnGuardarFichero.setBackground(SystemColor.info);
		btnGuardarFichero.setFont(new Font("Arial", Font.PLAIN, 12));
		
		txtExp = new JTextField();
		txtExp.setFont(new Font("Arial", Font.PLAIN, 10));
		txtExp.setToolTipText("");
		txtExp.setText("Expediente");
		txtExp.setForeground(Color.BLACK);
		txtExp.setColumns(10);
		txtExp.setBackground(Color.WHITE);
		txtExp.setBounds(93, 46, 85, 20);
		panel.add(txtExp);

		lblFondo = new JLabel("");
		lblFondo.setBounds(0, 87, 1275, 594);
		contentPane.add(lblFondo);
		lblFondo.setIcon(new ImageIcon(Interfaz_4.class.getResource("/Imagenes/fondoBueno.jpg")));

		lblTitulo = new JLabel("Listado de Pr\u00E1cticas en Curso");
		lblTitulo.setBounds(228, 11, 513, 39);
		contentPane.add(lblTitulo);
		lblTitulo.setForeground(new Color(153, 0, 51));
		lblTitulo.setFont(new Font("Arial", Font.PLAIN, 37));

		btnAdmEmpresas = new JButton("Administrar Empresas");
		btnAdmEmpresas.setBackground(SystemColor.info);
		btnAdmEmpresas.setBounds(873, 11, 180, 30);
		contentPane.add(btnAdmEmpresas);
		btnAdmEmpresas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.adminEmpresas();
			}
		});
		btnAdmEmpresas.setFont(new Font("Arial", Font.PLAIN, 14));

		btnAsigPractica = new JButton("Administrar Alumnos");
		btnAsigPractica.setBackground(SystemColor.info);
		btnAsigPractica.setBounds(1074, 11, 180, 30);
		contentPane.add(btnAsigPractica);
		btnAsigPractica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.adminAlumnos();
			}
		});
		btnAsigPractica.setFont(new Font("Arial", Font.PLAIN, 14));

		btnNewButton = new JButton("Cerrar Sesión");
		btnNewButton.setBackground(SystemColor.info);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				miControlador.cerrarSesion();
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 13));
		btnNewButton.setBounds(10, 11, 117, 30);
		contentPane.add(btnNewButton);
	}
	public String [] getDatos(){
		String [] datos = new String[7];
		datos[0]=txtNumExpediente.getText(); //DNI
		datos[1]=txtApellidos.getText(); //nomb
		datos[2]=txtNombre.getText();//Apell
		datos[3]=txtDNI.getText(); //CIF
		datos[4]=txtEdad.getText(); //nom emp
		datos[5]=txtExp.getText();
		datos[6]=txtNacionalidad.getText(); //resp_esp
		return datos;
	}

	public void generaFiltro(DefaultTableModel tabla) {
		table.setModel(tabla);
	}
}
