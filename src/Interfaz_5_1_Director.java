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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class Interfaz_5_1_Director extends JFrame {

	private Controlador miControlador;
	private Modelo miModelo;
	private JPanel contentPane;
	private JTable tablaListaTutor;
	private JScrollPane scrollPane;
	private JLabel lblTitulo;
	private JTextField txtDNItutor_1;
	private JTextField txtApellido_1;
	private JTextField txtANombre1;
	private JTextField txtCodCentro_1;
	private JButton btnFiltrar;
	private JButton btnAtras;
	private JLabel lblFondo;
	private JPanel panel;
	private JTextField txtDniTutor;
	private JTextField txtApellidos_1;
	private JTextField txtNombre_1;
	private JTextField textCodCentro1;
	private JPanel panel_1;
	private JPanel panel_1_1;
	private JLabel lblEdicionAlumnos;
	private JButton btnGuardar;
	private JButton btnModificar;
	private JButton btnBorrar;

	public void setMiControlador(Controlador miControlador) {
		this.miControlador = miControlador;
	}

	public void setMiModelo(Modelo miModelo) {
		this.miModelo = miModelo;
	}

	public String getDNI() {
		String usuario = txtDniTutor.getText();
		return usuario;
	}

	public String getApellido() {
		String usuario = txtApellidos_1.getText();
		return usuario;
	}

	public String getNombre() {
		String usuario = txtNombre_1.getText();
		return usuario;
	}

	public String getCod() {
		String usuario = textCodCentro1.getText();
		return usuario;
	}

	public Interfaz_5_1_Director() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		setTitle("Interfaz 5.1: Añadir / Modificar Tutores");
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				tablaListaTutor.getSelectionModel().clearSelection();
				limpiarCampos();
			}
		});

		panel = new JPanel();
		panel.setBackground(new Color(70, 130, 180, 170));
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

		tablaListaTutor = new JTable();
		tablaListaTutor.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		addWindowListener(new WindowAdapter() {
			public void windowActivated(WindowEvent e) {
				String sql = miModelo.getListadoTutor();
				tablaListaTutor.setModel(miModelo.getTabla(sql));
			}
		});
		tablaListaTutor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				actualizarDatos();
			}
		});
		tablaListaTutor.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				actualizarDatos();
			}
		});

		scrollPane.setViewportView(tablaListaTutor);

		txtDNItutor_1 = new JTextField();
		txtDNItutor_1.setBounds(23, 59, 115, 20);
		panel.add(txtDNItutor_1);
		txtDNItutor_1.setBackground(Color.WHITE);
		txtDNItutor_1.setForeground(Color.BLACK);
		txtDNItutor_1.setText("DNI del tutor");
		txtDNItutor_1.setToolTipText("");
		txtDNItutor_1.setColumns(10);

		btnFiltrar = new JButton("Filtrar");
		btnFiltrar.setBackground(SystemColor.inactiveCaption);
		btnFiltrar.setBounds(747, 53, 100, 30);
		panel.add(btnFiltrar);
		btnFiltrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});

		txtApellido_1 = new JTextField();
		txtApellido_1.setBounds(243, 59, 85, 20);
		panel.add(txtApellido_1);
		txtApellido_1.setToolTipText("");
		txtApellido_1.setText("Apellidos");
		txtApellido_1.setForeground(Color.BLACK);
		txtApellido_1.setColumns(10);
		txtApellido_1.setBackground(Color.WHITE);

		txtANombre1 = new JTextField();
		txtANombre1.setBounds(148, 59, 85, 20);
		panel.add(txtANombre1);
		txtANombre1.setToolTipText("");
		txtANombre1.setText("Nombre");
		txtANombre1.setForeground(Color.BLACK);
		txtANombre1.setColumns(10);
		txtANombre1.setBackground(Color.WHITE);

		txtCodCentro_1 = new JTextField();
		txtCodCentro_1.setText("Código centro");
		txtCodCentro_1.setBounds(338, 59, 85, 20);
		panel.add(txtCodCentro_1);
		txtCodCentro_1.setToolTipText("");
		txtCodCentro_1.setForeground(Color.BLACK);
		txtCodCentro_1.setColumns(10);
		txtCodCentro_1.setBackground(Color.WHITE);

		panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(new Color(220, 20, 60, 190));
		panel_1_1.setBounds(873, 103, 371, 450);
		panel.add(panel_1_1);

		lblEdicionAlumnos = new JLabel("Edición Tutores");
		lblEdicionAlumnos.setForeground(Color.WHITE);
		lblEdicionAlumnos.setFont(new Font("Arial Black", Font.PLAIN, 30));
		lblEdicionAlumnos.setBounds(51, 34, 283, 38);
		panel_1_1.add(lblEdicionAlumnos);

		txtDniTutor = new JTextField();
		txtDniTutor.setBounds(38, 126, 182, 20);
		panel_1_1.add(txtDniTutor);
		txtDniTutor.setToolTipText("");
		txtDniTutor.setText("DNI del tutor");
		txtDniTutor.setForeground(Color.BLACK);
		txtDniTutor.setColumns(10);
		txtDniTutor.setBackground(Color.WHITE);

		btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnModificar.setBackground(SystemColor.inactiveCaption);
		btnModificar.setBounds(137, 364, 100, 30);
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int fsel = tablaListaTutor.getSelectedRow();
				int resp = JOptionPane.YES_NO_OPTION;
				int option;
				if (fsel == -1) {
					JOptionPane.showMessageDialog(null, "Debe seleccionar el producto a modificar", "Advertencia",
							JOptionPane.WARNING_MESSAGE);
				} else {
					option = JOptionPane.showConfirmDialog(null, "¿Está seguro de modificar este producto?",
							"Modificar", resp);
					if (option == 0) {
						String DniOld = getDniOld();
						miControlador.modificarTutor(DniOld);
						limpiarCampos();
						boolean insertado = miModelo.malInsertado();
						if (insertado) {
							JOptionPane.showMessageDialog(null, "La nueva fila ha sido insertada con éxito",
									"Advertencia", JOptionPane.INFORMATION_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(null,
									"La nueva fila no ha sido insertada, datos mal introducidos ", "Advertencia",
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
		btnBorrar.setBounds(27, 364, 100, 30);
		panel_1_1.add(btnBorrar);
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int fsel = tablaListaTutor.getSelectedRow();
				int resp = JOptionPane.YES_NO_OPTION;
				int option;
				if (fsel == -1) {
					JOptionPane.showMessageDialog(null, "Debe seleccionar el producto a eliminar", "Advertencia",
							JOptionPane.WARNING_MESSAGE);
				} else {
					option = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar este producto?", "Eliminar",
							resp);
					if (option == 0) {
						miControlador.borrarTutor();
						limpiarCampos();
						JOptionPane.showMessageDialog(null, "La fila ha sido borrada con éxito", "Advertencia",
								JOptionPane.INFORMATION_MESSAGE);

					}

				}
			}
		});

		txtNombre_1 = new JTextField();
		txtNombre_1.setBounds(38, 156, 182, 20);
		panel_1_1.add(txtNombre_1);
		txtNombre_1.setToolTipText("");
		txtNombre_1.setText("Nombre");
		txtNombre_1.setForeground(Color.BLACK);
		txtNombre_1.setColumns(10);
		txtNombre_1.setBackground(Color.WHITE);

		txtApellidos_1 = new JTextField();
		txtApellidos_1.setBounds(38, 187, 182, 20);
		panel_1_1.add(txtApellidos_1);
		txtApellidos_1.setToolTipText("");
		txtApellidos_1.setText("Apellidos");
		txtApellidos_1.setForeground(Color.BLACK);
		txtApellidos_1.setColumns(10);
		txtApellidos_1.setBackground(Color.WHITE);

		textCodCentro1 = new JTextField();
		textCodCentro1.setBounds(38, 218, 182, 20);
		panel_1_1.add(textCodCentro1);
		textCodCentro1.setToolTipText("");
		textCodCentro1.setText("Código del centro");
		textCodCentro1.setForeground(Color.BLACK);
		textCodCentro1.setColumns(10);
		textCodCentro1.setBackground(Color.WHITE);

		btnGuardar = new JButton("Insertar");
		btnGuardar.setBounds(247, 364, 100, 30);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int fsel = tablaListaTutor.getSelectedRow();
				int resp = JOptionPane.YES_NO_OPTION;
				int option;
				option = JOptionPane.showConfirmDialog(null, "¿Está seguro de guardar este producto?", "Guardar", resp);
				if (option == 0) {
					miControlador.insertarTutor();
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

		lblFondo = new JLabel("");
		lblFondo.setBounds(0, 87, 1275, 594);
		contentPane.add(lblFondo);
		lblFondo.setIcon(new ImageIcon(Interfaz_5_1_Director.class.getResource("/Imagenes/fondoBueno.jpg")));

		btnAtras = new JButton("Atrás");
		btnAtras.setBackground(SystemColor.info);
		btnAtras.setBounds(10, 11, 100, 30);
		contentPane.add(btnAtras);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.listadoTutores();
			}
		});
		btnAtras.setFont(new Font("Tahoma", Font.PLAIN, 12));

		lblTitulo = new JLabel("Añadir / Modificar Tutores");
		lblTitulo.setBounds(423, 11, 493, 39);
		contentPane.add(lblTitulo);
		lblTitulo.setForeground(new Color(153, 0, 51));
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 37));
	}

	private void limpiarCampos() {
		txtDniTutor.setText("DNI del tutor");
		txtApellidos_1.setText("Apellidos");
		txtNombre_1.setText("Nombre");
		textCodCentro1.setText("Código del centro");

	}

	private String getDniOld() {
		int fila = tablaListaTutor.getSelectedRow();
		String DniOld = (String) tablaListaTutor.getValueAt(fila, 0);
		return DniOld;
	}

	private void actualizarDatos() {
		int fila = tablaListaTutor.getSelectedRow();
		// Rellena campos de edicon
		txtDniTutor.setText((String) tablaListaTutor.getValueAt(fila, 0));
		txtNombre_1.setText((String) tablaListaTutor.getValueAt(fila, 1));
		txtApellidos_1.setText((String) tablaListaTutor.getValueAt(fila, 2));
		textCodCentro1.setText((String) tablaListaTutor.getValueAt(fila, 3));
		// Rellena campos de filtrado
		txtDNItutor_1.setText((String) tablaListaTutor.getValueAt(fila, 0));
		txtANombre1.setText((String) tablaListaTutor.getValueAt(fila, 1));
		txtApellido_1.setText((String) tablaListaTutor.getValueAt(fila, 2));
		txtCodCentro_1.setText((String) tablaListaTutor.getValueAt(fila, 3));
	}
}