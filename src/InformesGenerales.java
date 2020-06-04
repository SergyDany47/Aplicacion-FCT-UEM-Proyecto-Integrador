import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

public class InformesGenerales extends JFrame {

	private JPanel contentPane;
	private JTable tableAlumnosTutor;
	private JTable tableTutoresCiclo;
	private JTable tableAlumnosEmpresa;
	private JTable tableAlumnosPractica;
	private JPanel panel_1;
	private JPanel panel;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JLabel lblTutorCiclo;
	private JLabel lblFondo;
	private JButton btnAtras;
	private JLabel lblTitulo;
	private Controlador miControlador;
	private Modelo miModelo;
	private JLabel lblAlumnosPorEmpresa;
	private JLabel lblAlumnosPorTutor;
	private JScrollPane scrollPane_1_1;
	private JLabel lblAlumnosEnPracticas;
	private JScrollPane scrollPane_2;
	
	
	/**
	 * Comunicación para el Controlador
	 * 
	 * @param miControlador
	 */
	public void setMiControlador(Controlador miControlador) {
		this.miControlador = miControlador;
	}

	/**
	 * Comunicación para el Modelo
	 * 
	 * @param miModelo
	 */
	public void setMiModelo(Modelo miModelo) {
		this.miModelo = miModelo;
	}

	public InformesGenerales() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		setTitle("Interfaz 4.1: Asignar Practicas");
		contentPane = new JPanel();

		/**
		 * Deseleccionar filas
		 */
		contentPane.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent arg0) {
				tableAlumnosTutor.getSelectionModel().clearSelection();
				tableTutoresCiclo.getSelectionModel().clearSelection();
				tableAlumnosEmpresa.getSelectionModel().clearSelection();
				tableAlumnosPractica.getSelectionModel().clearSelection();
			}
		});
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel_1 = new JPanel();
		panel_1.setBounds(0, 87, 1265, 4);
		contentPane.add(panel_1);
		panel_1.setBackground(new Color(220, 20, 60));
		panel_1.setLayout(null);

		panel = new JPanel();

		/**
		 * Deseleccionar filas
		 */
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				tableAlumnosTutor.getSelectionModel().clearSelection();
				tableTutoresCiclo.getSelectionModel().clearSelection();
				tableAlumnosEmpresa.getSelectionModel().clearSelection();
				tableAlumnosPractica.getSelectionModel().clearSelection();
			}
		});
		panel.setToolTipText("");
		panel.setBackground(new Color(70, 130, 180, 170));
		panel.setBounds(0, 87, 1275, 594);
		contentPane.add(panel);
		panel.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 88, 530, 185);
		panel.add(scrollPane);

		tableAlumnosTutor = new JTable();
		tableAlumnosTutor.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(tableAlumnosTutor);
		/**
		 * Obtener Datos Lista de Alumnos
		 */
		addWindowListener(new WindowAdapter() {
			public void windowActivated(WindowEvent e) {
				String ssql = miModelo.getAlumnosTutor();
				tableAlumnosTutor.setModel(miModelo.getTabla(ssql));
			}
		});
		scrollPane.setViewportView(tableAlumnosTutor);

		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(696, 88, 530, 185);
		panel.add(scrollPane_1);

		tableAlumnosEmpresa = new JTable();
		tableAlumnosEmpresa.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_1.setViewportView(tableAlumnosEmpresa);
		addWindowListener(new WindowAdapter() {
			public void windowActivated(WindowEvent e) {
				String ssql = miModelo.getAlumnoEmpresa();
				tableAlumnosEmpresa.setModel(miModelo.getTabla(ssql));
			}
		});

		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(29, 370, 530, 185);
		panel.add(scrollPane_2);

		tableTutoresCiclo = new JTable();
		tableTutoresCiclo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_2.setViewportView(tableTutoresCiclo);
		addWindowListener(new WindowAdapter() {
			public void windowActivated(WindowEvent e) {
				String ssql = miModelo.getTutorCiclo();
				tableTutoresCiclo.setModel(miModelo.getTabla(ssql));
			}
		});

		lblTutorCiclo = new JLabel("Tutores Por Ciclo");
		lblTutorCiclo.setBounds(115, 310, 326, 45);
		panel.add(lblTutorCiclo);
		lblTutorCiclo.setFont(new Font("Arial", Font.PLAIN, 37));
		lblTutorCiclo.setForeground(new Color(153, 0, 51));
		
		lblAlumnosPorTutor = new JLabel("Alumnos Por Tutor");
		lblAlumnosPorTutor.setBounds(115, 32, 326, 45);
		panel.add(lblAlumnosPorTutor);
		lblAlumnosPorTutor.setForeground(new Color(153, 0, 51));
		lblAlumnosPorTutor.setFont(new Font("Arial", Font.PLAIN, 37));
		
		lblAlumnosPorEmpresa = new JLabel("Alumnos Por Empresa");
		lblAlumnosPorEmpresa.setForeground(new Color(153, 0, 51));
		lblAlumnosPorEmpresa.setFont(new Font("Arial", Font.PLAIN, 37));
		lblAlumnosPorEmpresa.setBounds(775, 32, 377, 45);
		panel.add(lblAlumnosPorEmpresa);
		
		scrollPane_1_1 = new JScrollPane();
		scrollPane_1_1.setBounds(696, 370, 530, 185);
		panel.add(scrollPane_1_1);
		
		tableAlumnosPractica = new JTable();
		tableAlumnosPractica.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_1_1.setViewportView(tableAlumnosPractica);
		addWindowListener(new WindowAdapter() {
			public void windowActivated(WindowEvent e) {
				String ssql = miModelo.getAlumnosPractica();
				tableAlumnosPractica.setModel(miModelo.getTabla(ssql));
			}
		});
		
		lblAlumnosEnPracticas = new JLabel("Alumnos En Practicas");
		lblAlumnosEnPracticas.setForeground(new Color(153, 0, 51));
		lblAlumnosEnPracticas.setFont(new Font("Arial", Font.PLAIN, 37));
		lblAlumnosEnPracticas.setBounds(775, 310, 377, 45);
		panel.add(lblAlumnosEnPracticas);

		lblFondo = new JLabel("");
		lblFondo.setBounds(0, 87, 1275, 594);
		contentPane.add(lblFondo);
		lblFondo.setIcon(new ImageIcon(Interfaz_4_1.class.getResource("/Imagenes/fondoBueno.jpg")));

		btnAtras = new JButton("Atr\u00E1s");
		btnAtras.setBackground(SystemColor.info);
		btnAtras.setBounds(10, 11, 100, 30);
		contentPane.add(btnAtras);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.listadoAlumnos();
			}
		});
		btnAtras.setFont(new Font("Arial", Font.PLAIN, 13));

		lblTitulo = new JLabel("Informes Generales");
		lblTitulo.setBounds(449, 11, 378, 50);
		contentPane.add(lblTitulo);
		lblTitulo.setForeground(new Color(153, 0, 51));
		lblTitulo.setFont(new Font("Arial", Font.PLAIN, 37));
	}
}
