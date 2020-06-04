import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

/**
 * 
 * @author WomanDam
 *
 */
public class Interfaz_4_1 extends JFrame {

	private Controlador miControlador;
	private Modelo miModelo;
	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	private JLabel lblTitulo;
	private JButton btnFiltrar;
	private JButton btnBorrar;
	private JButton btnAtras;
	private JLabel lblFondo;
	private JPanel panel;
	private JTable table_2;
	private JScrollPane scrollPane_1;
	private JTable table_1;
	private JLabel lblNewLabel;
	private JButton btnGuardarTodo;
	private JPanel panel_1;

	/**
	 * Comunicaci�n para el Controlador
	 * 
	 * @param miControlador
	 */
	public void setMiControlador(Controlador miControlador) {
		this.miControlador = miControlador;
	}

	/**
	 * Comunicaci�n para el Modelo
	 * 
	 * @param miModelo
	 */
	public void setMiModelo(Modelo miModelo) {
		this.miModelo = miModelo;
	}

	/**
	 * Interfaz_4_1
	 */
	public Interfaz_4_1() {
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
				table.getSelectionModel().clearSelection();
				table_1.getSelectionModel().clearSelection();
				table_2.getSelectionModel().clearSelection();
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
				table.getSelectionModel().clearSelection();
				table_1.getSelectionModel().clearSelection();
				table_2.getSelectionModel().clearSelection();
			}
		});
		panel.setToolTipText("");
		panel.setBackground(new Color(192, 192, 192, 180));
		panel.setBounds(0, 87, 1275, 594);
		contentPane.add(panel);
		panel.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 40, 530, 185);
		panel.add(scrollPane);

		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		/**
		 * Obtener Datos Lista de Alumnos
		 */
		addWindowListener(new WindowAdapter() {
			public void windowActivated(WindowEvent e) {
				String ssql = miModelo.getListadoAlumnos();
				table.setModel(miModelo.getTabla(ssql));
			}
		});
		scrollPane.setViewportView(table);

		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(898, 544, 100, 30);
		panel.add(btnBorrar);
		btnBorrar.setBackground(SystemColor.inactiveCaption);
		/**
		 * Alert Borrar
		 * 
		 * Advierte de los fallos
		 */
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int fsel = table_1.getSelectedRow();
				int resp = JOptionPane.YES_NO_OPTION;
				int option;
				if (fsel == -1) {
					JOptionPane.showMessageDialog(null, "Debe seleccionar el producto a eliminar", "Advertencia",
							JOptionPane.WARNING_MESSAGE);
				} else {
					option = JOptionPane.showConfirmDialog(null, "�Est� seguro de eliminar este producto?", "Eliminar",
							resp);

					if (option == 0) {
						getNumExCif();
						JOptionPane.showMessageDialog(null, "La fila ha sido borrada con �xito", "Advertencia",
								JOptionPane.INFORMATION_MESSAGE);

					}

				}
			}
		});
		btnBorrar.setFont(new Font("Arial", Font.PLAIN, 14));

		btnFiltrar = new JButton("Unir");
		btnFiltrar.setBackground(SystemColor.inactiveCaption);
		btnFiltrar.setBounds(583, 107, 100, 30);
		panel.add(btnFiltrar);
		btnFiltrar.setFont(new Font("Arial", Font.PLAIN, 14));
		/**
		 * Alert Filtrar
		 * 
		 * Advierte de los fallos
		 */
		btnFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int resp = JOptionPane.YES_NO_OPTION;
				int option;
				option = JOptionPane.showConfirmDialog(null, "Est� seguro de guardar este producto?", "Guardar", resp);
				if (option == 0) {
					getSeleccion();
					boolean insertado = miModelo.malInsertado();
					if (insertado) {
						JOptionPane.showMessageDialog(null, "La nueva fila ha sido insertada con �xito", "Advertencia",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "La nueva fila no ha sido insertada", "Advertencia",
								JOptionPane.INFORMATION_MESSAGE);

					}
				}
			}
		});

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(710, 40, 530, 185);
		panel.add(scrollPane_1);

		table_2 = new JTable();
		table_2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_1.setViewportView(table_2);
		addWindowListener(new WindowAdapter() {
			public void windowActivated(WindowEvent e) {
				String ssql = miModelo.getListadoEmpresa();
				table_2.setModel(miModelo.getTabla(ssql));
			}
		});

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(289, 349, 709, 185);
		panel.add(scrollPane_2);

		table_1 = new JTable();
		table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_2.setViewportView(table_1);
		addWindowListener(new WindowAdapter() {
			public void windowActivated(WindowEvent e) {
				String ssql = miModelo.getListadoPracticas();
				table_1.setModel(miModelo.getTabla(ssql));
			}
		});

		lblNewLabel = new JLabel("Vista de Asignaci\u00F3n");
		lblNewLabel.setBounds(478, 291, 326, 45);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 37));
		lblNewLabel.setForeground(new Color(153, 0, 51));

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
				miControlador.adminPracticas();
			}
		});
		btnAtras.setFont(new Font("Arial", Font.PLAIN, 13));

		lblTitulo = new JLabel("Asignar Pr\u00E1cticas");
		lblTitulo.setBounds(449, 11, 491, 50);
		contentPane.add(lblTitulo);
		lblTitulo.setForeground(new Color(153, 0, 51));
		lblTitulo.setFont(new Font("Arial", Font.PLAIN, 37));
	}

	/**
	 * Seleccionar las filas para asignar pr�cticas
	 */

	private void getSeleccion() {
		try {
			int filaAumnos = table.getSelectedRow();
			int filaEmpresa = table_2.getSelectedRow();
			String exp = (String) table.getValueAt(filaAumnos, 0);
			String dni = (String) table.getValueAt(filaAumnos, 3);
			String nombreAl = (String) table.getValueAt(filaAumnos, 1);
			String apellido = (String) table.getValueAt(filaAumnos, 2);
			String cif = (String) table_2.getValueAt(filaEmpresa, 0);
			String nombreEm = (String) table_2.getValueAt(filaEmpresa, 1);
			String responsable = (String) table_2.getValueAt(filaEmpresa, 4);
			miModelo.datosPracticas(exp, dni, nombreAl, apellido, cif, nombreEm, responsable);
		} catch (Exception e) {
			System.out.println("Se debe seleccionar una fila por cada tabla a asignar(Alumno/Empresa)");
		}

	}

	/**
	 * Para poder borrar filas de tabla de Asignaci�n
	 */
	public void getNumExCif() {

		int fila = table_1.getSelectedRow();
		String numExp = (String) table_1.getValueAt(fila, 0);
		String cif = (String) table_1.getValueAt(fila, 4);
		miModelo.borrarPracticas(numExp, cif);
	}
}
