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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * 
 * @author WomanDam
 *
 */
public class Interfaz_2_1 extends JFrame {

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
	private JTextField txtFechaNacimiento;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JPanel panel_1;
	private JPanel panel_1_1;
	private JLabel lblEdicionAlumnos;
	private JButton btnGuardar;
	private JButton btnModificar;
	private JButton btnBorrar;

	/**
	 * Comunicación para el Controlador
	 * 
	 * @param miControlador
	 */
	public void setMiControlador(Controlador miControlador) {
		this.miControlador = miControlador;
	}

	/**
	 * Comunicación para el Controlador
	 * 
	 * @param miControlador
	 */
	public void setMiModelo(Modelo miModelo) {
		this.miModelo = miModelo;
	}

	/**
	 * Para conseguir los valores de cada textField
	 * 
	 * @return nombre
	 */
	public String getNombre() {
		String usuario = textField_2.getText();
		return usuario;
	}

	/**
	 * 
	 * @return Apellido
	 */
	public String getApellido() {
		String usuario = textField_3.getText();
		return usuario;
	}

	/**
	 * 
	 * @return DNI
	 */
	public String getDNI() {
		String usuario = textField_4.getText();
		return usuario;
	}

	/**
	 * 
	 * @return Número Expediente
	 */
	public String getNum_Exp() {
		String usuario = textField_1.getText();
		return usuario;
	}

	/**
	 * 
	 * @return Fecha
	 */
	public String getFecha() {
		String usuario = txtFechaNacimiento.getText();
		return usuario;
	}

	/**
	 * 
	 * @return Nacionalidad
	 */
	public String getNacionalidad() {
		String usuario = textField_5.getText();
		return usuario;
	}

	/**
	 * Interfaz_2_1
	 */
	public Interfaz_2_1() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		setTitle("Interfaz 2.1: Añadir / Modificar Alumnos");
		contentPane = new JPanel();
		
		/**
		 * Deseleccionar filas y limpiar campos
		 */
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				table.getSelectionModel().clearSelection();
				limpiarCampos();
			}
		});
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
		panel_1.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 103, 822, 450);
		panel.add(scrollPane);
		
		table = new JTable();
		
		/**
		 * permite utilizar las flechas de teclado para navegar en la tabla (Se le antojó al Iván)
		 */
		table.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				actualizarDatos();
			}
		});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		
		/**
		 * Conseguir sql Listado de alumnos 
		 */
		addWindowListener(new WindowAdapter() {
			public void windowActivated(WindowEvent e) {
				String ssql = miModelo.getListadoAlumnos();
				table.setModel(miModelo.getTabla(ssql));
			}
		});
		
		/**
		 * Actualiza los TextField 
		 */
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				actualizarDatos();
			}
		});

		txtEdad = new JTextField();
		txtEdad.setBounds(433, 59, 85, 20);
		panel.add(txtEdad);
		txtEdad.setToolTipText("");
		txtEdad.setText("Edad");
		txtEdad.setForeground(Color.BLACK);
		txtEdad.setColumns(10);
		txtEdad.setBackground(Color.WHITE);

		txtNumExpediente = new JTextField();
		txtNumExpediente.setBounds(23, 59, 115, 20);
		panel.add(txtNumExpediente);
		txtNumExpediente.setBackground(Color.WHITE);
		txtNumExpediente.setForeground(Color.BLACK);
		txtNumExpediente.setText("Num.Expediente");
		txtNumExpediente.setToolTipText("");
		txtNumExpediente.setColumns(10);

		btnFiltrar = new JButton("Filtrar");
		btnFiltrar.setBackground(SystemColor.inactiveCaption);
		btnFiltrar.setBounds(747, 53, 100, 30);
		panel.add(btnFiltrar);
		btnFiltrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});

		txtNombre = new JTextField();
		txtNombre.setBounds(243, 59, 85, 20);
		panel.add(txtNombre);
		txtNombre.setToolTipText("");
		txtNombre.setText("Nombre");
		txtNombre.setForeground(Color.BLACK);
		txtNombre.setColumns(10);
		txtNombre.setBackground(Color.WHITE);

		txtApellidos = new JTextField();
		txtApellidos.setBounds(148, 59, 85, 20);
		panel.add(txtApellidos);
		txtApellidos.setToolTipText("");
		txtApellidos.setText("Apellidos");
		txtApellidos.setForeground(Color.BLACK);
		txtApellidos.setColumns(10);
		txtApellidos.setBackground(Color.WHITE);

		txtDNI = new JTextField();
		txtDNI.setBounds(338, 59, 85, 20);
		panel.add(txtDNI);
		txtDNI.setToolTipText("");
		txtDNI.setText("DNI");
		txtDNI.setForeground(Color.BLACK);
		txtDNI.setColumns(10);
		txtDNI.setBackground(Color.WHITE);

		txtNacionalidad = new JTextField();
		txtNacionalidad.setBounds(534, 59, 100, 20);
		panel.add(txtNacionalidad);
		txtNacionalidad.setToolTipText("");
		txtNacionalidad.setText("Nacionalidad");
		txtNacionalidad.setForeground(Color.BLACK);
		txtNacionalidad.setColumns(10);
		txtNacionalidad.setBackground(Color.WHITE);

		panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(new Color(220, 20, 60, 190));
		panel_1_1.setBounds(873, 103, 371, 450);
		panel.add(panel_1_1);

		lblEdicionAlumnos = new JLabel("Edición Alumnos");
		lblEdicionAlumnos.setForeground(Color.WHITE);
		lblEdicionAlumnos.setFont(new Font("Arial Black", Font.PLAIN, 30));
		lblEdicionAlumnos.setBounds(51, 34, 283, 38);
		panel_1_1.add(lblEdicionAlumnos);

		textField_1 = new JTextField();
		textField_1.setBounds(38, 126, 182, 20);
		panel_1_1.add(textField_1);
		textField_1.setToolTipText("");
		textField_1.setText("Num.Expediente");
		textField_1.setForeground(Color.BLACK);
		textField_1.setColumns(10);
		textField_1.setBackground(Color.WHITE);

		textField_3 = new JTextField();
		textField_3.setBounds(38, 156, 182, 20);
		panel_1_1.add(textField_3);
		textField_3.setToolTipText("");
		textField_3.setText("Apellidos");
		textField_3.setForeground(Color.BLACK);
		textField_3.setColumns(10);
		textField_3.setBackground(Color.WHITE);

		textField_2 = new JTextField();
		textField_2.setBounds(38, 187, 182, 20);
		panel_1_1.add(textField_2);
		textField_2.setToolTipText("");
		textField_2.setText("Nombre");
		textField_2.setForeground(Color.BLACK);
		textField_2.setColumns(10);
		textField_2.setBackground(Color.WHITE);

		textField_4 = new JTextField();
		textField_4.setBounds(38, 218, 182, 20);
		panel_1_1.add(textField_4);
		textField_4.setToolTipText("");
		textField_4.setText("DNI");
		textField_4.setForeground(Color.BLACK);
		textField_4.setColumns(10);
		textField_4.setBackground(Color.WHITE);

		txtFechaNacimiento = new JTextField();
		txtFechaNacimiento.setBounds(38, 249, 182, 20);
		panel_1_1.add(txtFechaNacimiento);
		txtFechaNacimiento.setToolTipText("");
		txtFechaNacimiento.setText("Fecha Nacimiento");
		txtFechaNacimiento.setForeground(Color.BLACK);
		txtFechaNacimiento.setColumns(10);
		txtFechaNacimiento.setBackground(Color.WHITE);

		textField_5 = new JTextField();
		textField_5.setBounds(38, 280, 182, 20);
		panel_1_1.add(textField_5);
		textField_5.setToolTipText("");
		textField_5.setText("Nacionalidad");
		textField_5.setForeground(Color.BLACK);
		textField_5.setColumns(10);
		textField_5.setBackground(Color.WHITE);

		btnGuardar = new JButton("Insertar");
		btnGuardar.setBounds(250, 352, 100, 30);
		
		/**
		 * Alert Guardar
		 * 
		 * Advierte de los fallos
		 */
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int fsel = table.getSelectedRow();
				int resp = JOptionPane.YES_NO_OPTION;
				int option;
				option = JOptionPane.showConfirmDialog(null, "Está seguro de guardar este producto?", "Guardar", resp);
				if (option == 0) {
					miControlador.insertarAlumno();
					limpiarCampos();
					boolean insertado = miModelo.malInsertado();
					if (insertado) {
						JOptionPane.showMessageDialog(null, "La nueva fila ha sido insertada con éxito", "Advertencia",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null,
								"La nueva fila no ha sido insertada, datos mal introducidos ", "Advertencia",
								JOptionPane.INFORMATION_MESSAGE);
					}
				}

			}

		});

		panel_1_1.add(btnGuardar);
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnGuardar.setBackground(SystemColor.inactiveCaption);

		btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnModificar.setBackground(SystemColor.inactiveCaption);
		btnModificar.setBounds(140, 352, 100, 30);
		
		/**
		 * Alert Modificar
		 * 
		 * Advierte de los fallos
		 */
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int fsel = table.getSelectedRow();
				int resp = JOptionPane.YES_NO_OPTION;
				int option;
				if (fsel == -1) {
					JOptionPane.showMessageDialog(null, "Debe seleccionar el producto a modificar", "Advertencia",
							JOptionPane.WARNING_MESSAGE);
				} else {
					option = JOptionPane.showConfirmDialog(null, "Está seguro de modificar este producto?", "Modificar",
							resp);
					if (option == 0) {
						String dniOld = getDniOld();
						miControlador.modificarAlumno(dniOld);
						limpiarCampos();
						boolean insertado = miModelo.malInsertado();
						if (insertado) {
							JOptionPane.showMessageDialog(null, "La fila ha sido modificada con éxito", "Advertencia",
									JOptionPane.INFORMATION_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(null,
									"La fila no ha sido modificada, datos mal introducidos ", "Advertencia",
									JOptionPane.INFORMATION_MESSAGE);
						}
					}

				}
			}
		});
		panel_1_1.add(btnModificar);

		btnBorrar = new JButton("Borrar");
		btnBorrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnBorrar.setBackground(SystemColor.inactiveCaption);
		btnBorrar.setBounds(30, 352, 100, 30);
		panel_1_1.add(btnBorrar);
		
		/**
		 * Alert Borrar
		 * 
		 * Advierte de los fallos
		 */
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int fsel = table.getSelectedRow();
				int resp = JOptionPane.YES_NO_OPTION;
				int option;
				if (fsel == -1) {
					JOptionPane.showMessageDialog(null, "Debe seleccionar el producto a eliminar", "Advertencia",
							JOptionPane.WARNING_MESSAGE);
				} else {
					option = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar este producto?", "Eliminar",
							resp);

					if (option == 0) {
						miControlador.borrarAlumno();
						limpiarCampos();
						JOptionPane.showMessageDialog(null, "La fila ha sido borrada con éxito", "Advertencia",
								JOptionPane.INFORMATION_MESSAGE);

					}

				}
			}
		});

		lblFondo = new JLabel("");
		lblFondo.setBounds(0, 87, 1275, 594);
		contentPane.add(lblFondo);
		lblFondo.setIcon(new ImageIcon(Interfaz_2_1.class.getResource("/Imagenes/fondoBueno.jpg")));

		btnAtras = new JButton("Atrás");
		btnAtras.setBackground(SystemColor.info);
		btnAtras.setBounds(10, 11, 100, 30);
		contentPane.add(btnAtras);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.adminAlumnos();
			}
		});
		btnAtras.setFont(new Font("Tahoma", Font.PLAIN, 12));

		lblTitulo = new JLabel("Añadir / Modificar Alumnos");
		lblTitulo.setBounds(423, 11, 493, 39);
		contentPane.add(lblTitulo);
		lblTitulo.setForeground(new Color(153, 0, 51));
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 37));
	}
	/**
	 * Limpia los campos
	 */
	private void limpiarCampos() {
		txtFechaNacimiento.setText("Fecha Nacimiento");
		textField_1.setText("Num.Expediente");
		textField_2.setText("Nombre");
		textField_3.setText("Apellidos");
		textField_4.setText("DNI");
		textField_5.setText("Nacionalidad");

	}
	
	/**
	 * Permite modificar la fila obteniendo el DNI antiguo(Primary Key)
	 * 
	 * @return DNI
	 */
	private String getDniOld() {
		int fila = table.getSelectedRow();
		String dniOld = (String) table.getValueAt(fila, 3);
		return dniOld;
	}
	
	
	/**
	 * Rellena los textField
	 */
	private void actualizarDatos() {
		int fila = table.getSelectedRow();
		String[] datos = miModelo.updateAlumno(getDniOld());
		txtNumExpediente.setText((String) table.getValueAt(fila, 0));
		txtNombre.setText((String) table.getValueAt(fila, 1));
		txtApellidos.setText((String) table.getValueAt(fila, 2));
		txtDNI.setText((String) table.getValueAt(fila, 3));
		txtEdad.setText((String) table.getValueAt(fila, 4));
		txtNacionalidad.setText((String) table.getValueAt(fila, 5));
		textField_1.setText((String) table.getValueAt(fila, 0));
		textField_2.setText((String) table.getValueAt(fila, 1));
		textField_3.setText((String) table.getValueAt(fila, 2));
		textField_4.setText((String) table.getValueAt(fila, 3));
		String Fec_naci = datos[1].substring(0, 10);
		String[] fechaa = Fec_naci.split("-");
		Fec_naci = fechaa[2] + "/" + fechaa[1] + "/" + fechaa[0];
		txtFechaNacimiento.setText(Fec_naci);
		textField_5.setText((String) table.getValueAt(fila, 5));
	}
}