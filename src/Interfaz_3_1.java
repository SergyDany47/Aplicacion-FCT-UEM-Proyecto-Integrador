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
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

public class Interfaz_3_1 extends JFrame {

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
	private JButton btnAtras;
	private JLabel lblFondo;
	private JPanel panel;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JPanel panel_1;
	private JPanel panel_1_1;
	private JLabel lblNewLabel;
	private JTextField txtDireccion;
	private JButton btnGuardar;
	private JButton btnModificar;
	private JButton btnBorrar;

	public void setMiControlador(Controlador miControlador) {
		this.miControlador = miControlador;
	}

	public void setMiModelo(Modelo miModelo) {
		this.miModelo = miModelo;
	}

	public String getTlf() {
		String usuario = textField_2.getText();
		return usuario;
	}

	public String getNombre() {
		String usuario = textField_3.getText();
		return usuario;
	}

	public String getCIF() {
		String usuario = textField_4.getText();
		return usuario;
	}

	public String getLocalidad() {
		String usuario = textField_1.getText();
		return usuario;
	}

	public String getResponsable() {
		String usuario = textField.getText();
		return usuario;
	}

	public String getDireccion() {
		String usuario = txtDireccion.getText();
		return usuario;
	}

	public Interfaz_3_1() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		setTitle("Interfaz 3.1: Registrar/Modificar Empresa");
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				table.getSelectionModel().clearSelection();
				limpiarCampos();
			}
		});
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
		scrollPane.setBounds(25, 93, 822, 450);
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
		table.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				actualizarDatos();
			}
		});
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				actualizarDatos();
			}
		});

		txtEdad = new JTextField();
		txtEdad.setBounds(455, 59, 85, 20);
		panel.add(txtEdad);
		txtEdad.setToolTipText("");
		txtEdad.setText("Responsable");
		txtEdad.setForeground(Color.BLACK);
		txtEdad.setColumns(10);
		txtEdad.setBackground(Color.WHITE);

		txtNumExpediente = new JTextField();
		txtNumExpediente.setBounds(25, 59, 87, 20);
		panel.add(txtNumExpediente);
		txtNumExpediente.setBackground(Color.WHITE);
		txtNumExpediente.setForeground(Color.BLACK);
		txtNumExpediente.setText("CIF");
		txtNumExpediente.setToolTipText("");
		txtNumExpediente.setColumns(10);

		btnFiltrar = new JButton("Filtrar");
		btnFiltrar.setBackground(SystemColor.inactiveCaption);
		btnFiltrar.setBounds(745, 53, 100, 30);
		panel.add(btnFiltrar);
		btnFiltrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});

		txtNombre = new JTextField();
		txtNombre.setBounds(242, 59, 85, 20);
		panel.add(txtNombre);
		txtNombre.setToolTipText("");
		txtNombre.setText("Teléfono");
		txtNombre.setForeground(Color.BLACK);
		txtNombre.setColumns(10);
		txtNombre.setBackground(Color.WHITE);

		txtApellidos = new JTextField();
		txtApellidos.setBounds(131, 59, 85, 20);
		panel.add(txtApellidos);
		txtApellidos.setToolTipText("");
		txtApellidos.setText("Nombre");
		txtApellidos.setForeground(Color.BLACK);
		txtApellidos.setColumns(10);
		txtApellidos.setBackground(Color.WHITE);

		txtDNI = new JTextField();
		txtDNI.setBounds(348, 59, 85, 20);
		panel.add(txtDNI);
		txtDNI.setToolTipText("");
		txtDNI.setText("Localidad");
		txtDNI.setForeground(Color.BLACK);
		txtDNI.setColumns(10);
		txtDNI.setBackground(Color.WHITE);

		panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(new Color(220, 20, 60, 190));
		panel_1_1.setBounds(869, 93, 371, 450);
		panel.add(panel_1_1);

		btnGuardar = new JButton("Insertar");
		btnGuardar.setBounds(247, 364, 100, 30);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int fsel = table.getSelectedRow();
				int resp = JOptionPane.YES_NO_OPTION;
				int option;
				option = JOptionPane.showConfirmDialog(null, "¿Está seguro de insetar este producto?", "Insertar",
						resp);
				if (option == 0) {
					miControlador.insertarEmpresa();
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
		btnGuardar.setBackground(SystemColor.inactiveCaption);
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 12));

		btnBorrar = new JButton("Borrar");
		btnBorrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnBorrar.setBackground(SystemColor.inactiveCaption);
		btnBorrar.setBounds(27, 364, 100, 30);
		panel_1_1.add(btnBorrar);
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int fsel = table.getSelectedRow();
				int resp = JOptionPane.YES_NO_OPTION;
				int option;
				if (fsel == -1) {
					JOptionPane.showMessageDialog(null, "Debe seleccionar el producto a eliminar", "Advertencia",
							JOptionPane.WARNING_MESSAGE);
				} else {
					option = JOptionPane.showConfirmDialog(null, "Está seguro de eliminar este producto?", "Eliminar",
							resp);
					if (option == 0) {
						miControlador.borrarEmpresa();
						limpiarCampos();
						JOptionPane.showMessageDialog(null, "La fila ha sido borrada con éxito", "Advertencia",
								JOptionPane.INFORMATION_MESSAGE);

					}

				}
			}
		});

		btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnModificar.setBackground(SystemColor.inactiveCaption);
		btnModificar.setBounds(137, 364, 100, 30);
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int fsel = table.getSelectedRow();
				int resp = JOptionPane.YES_NO_OPTION;
				int option;
				if (fsel == -1) {
					JOptionPane.showMessageDialog(null, "Debe seleccionar el producto a modificar", "Advertencia",
							JOptionPane.WARNING_MESSAGE);
				} else {
					option = JOptionPane.showConfirmDialog(null, "¿Está seguro de modificar este producto?",
							"Modificar", resp);
					if (option == 0) {
						String cifOld = getCifOld();
						miControlador.modificarEmpresa(cifOld);
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

		textField_4 = new JTextField();
		textField_4.setFont(new Font("Arial", Font.PLAIN, 11));
		textField_4.setBounds(56, 148, 182, 20);
		panel_1_1.add(textField_4);
		textField_4.setToolTipText("");
		textField_4.setText("CIF");
		textField_4.setForeground(Color.BLACK);
		textField_4.setColumns(10);
		textField_4.setBackground(Color.WHITE);

		textField_3 = new JTextField();
		textField_3.setFont(new Font("Arial", Font.PLAIN, 11));
		textField_3.setBounds(56, 179, 182, 20);
		panel_1_1.add(textField_3);
		textField_3.setToolTipText("");
		textField_3.setText("Nombre");
		textField_3.setForeground(Color.BLACK);
		textField_3.setColumns(10);
		textField_3.setBackground(Color.WHITE);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("Arial", Font.PLAIN, 11));
		textField_2.setBounds(56, 210, 182, 20);
		panel_1_1.add(textField_2);
		textField_2.setToolTipText("");
		textField_2.setText("Teléfono");
		textField_2.setForeground(Color.BLACK);
		textField_2.setColumns(10);
		textField_2.setBackground(Color.WHITE);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Arial", Font.PLAIN, 11));
		textField_1.setBounds(56, 246, 182, 20);
		panel_1_1.add(textField_1);
		textField_1.setToolTipText("");
		textField_1.setText("Localidad");
		textField_1.setForeground(Color.BLACK);
		textField_1.setColumns(10);
		textField_1.setBackground(Color.WHITE);

		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 11));
		textField.setBounds(56, 277, 182, 20);
		panel_1_1.add(textField);
		textField.setToolTipText("");
		textField.setText("Responsable");
		textField.setForeground(Color.BLACK);
		textField.setColumns(10);
		textField.setBackground(Color.WHITE);

		lblNewLabel = new JLabel("Edición Empresa");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 30));
		lblNewLabel.setBounds(51, 34, 283, 38);
		panel_1_1.add(lblNewLabel);

		txtDireccion = new JTextField();
		txtDireccion.setText("Dirección");
		txtDireccion.setBounds(56, 116, 182, 20);
		panel_1_1.add(txtDireccion);
		txtDireccion.setColumns(10);

		lblFondo = new JLabel("");
		lblFondo.setBounds(0, 87, 1275, 594);
		contentPane.add(lblFondo);
		lblFondo.setIcon(new ImageIcon(Interfaz_3_1.class.getResource("/Imagenes/fondoBueno.jpg")));

		btnAtras = new JButton("Atrás");
		btnAtras.setBackground(SystemColor.info);
		btnAtras.setBounds(10, 11, 100, 30);
		contentPane.add(btnAtras);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.adminEmpresas();
			}
		});
		btnAtras.setFont(new Font("Tahoma", Font.PLAIN, 12));

		lblTitulo = new JLabel("Registrar/Modificar Empresa");
		lblTitulo.setBounds(316, 11, 535, 52);
		contentPane.add(lblTitulo);
		lblTitulo.setForeground(new Color(153, 0, 51));
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 37));
	}

	private void limpiarCampos() {
		textField.setText("Responsable");
		textField_1.setText("Localidad");
		textField_2.setText("Teléfono");
		textField_3.setText("Nombre");
		textField_4.setText("CIF");
		txtDireccion.setText("Dirección");

	}

	private String getCifOld() {
		int fila = table.getSelectedRow();
		String cifOld = (String) table.getValueAt(fila, 0);
		return cifOld;
	}

	private void actualizarDatos() {
		int fila = table.getSelectedRow();
		textField.setText((String) table.getValueAt(fila, 4));
		textField_1.setText((String) table.getValueAt(fila, 5));
		textField_2.setText((String) table.getValueAt(fila, 3));
		textField_3.setText((String) table.getValueAt(fila, 1));
		textField_4.setText((String) table.getValueAt(fila, 0));
		txtDireccion.setText((String) table.getValueAt(fila, 2));
		txtApellidos.setText((String) table.getValueAt(fila, 1));
		txtDNI.setText((String) table.getValueAt(fila, 5));
		txtEdad.setText((String) table.getValueAt(fila, 4));
		txtNombre.setText((String) table.getValueAt(fila, 3));
		txtNumExpediente.setText((String) table.getValueAt(fila, 0));
	}
}
