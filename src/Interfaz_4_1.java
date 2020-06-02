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

public class Interfaz_4_1 extends JFrame {

	private Controlador miControlador;
	private Modelo miModelo;
	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	private JLabel lblTitulo;
	private JButton btnFiltrar;
	private JButton btnGenerarAnexo;
	private JButton btnAtras;
	private JLabel lblFondo;
	private JPanel panel;
	private JTable table_2;
	private JScrollPane scrollPane_1;
	private JTable table_1;
	private JLabel lblNewLabel;
	private JButton btnGuardarTodo;
	private JPanel panel_1;

	public void setMiControlador(Controlador miControlador) {
		this.miControlador = miControlador;
	}

	public void setMiModelo(Modelo miModelo) {
		this.miModelo = miModelo;
	}

	public Interfaz_4_1() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		setTitle("Interfaz 4.1: Asignar Practicas");
		contentPane = new JPanel();
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
		panel.setToolTipText("");
		panel.setBackground(new Color(192, 192, 192, 180));
		panel.setBounds(0, 87, 1275, 594);
		contentPane.add(panel);
		panel.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 40, 526, 185);
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
		scrollPane.setViewportView(table);

		btnGenerarAnexo = new JButton("Borrar ");
		btnGenerarAnexo.setBounds(656, 545, 100, 30);
		panel.add(btnGenerarAnexo);
		btnGenerarAnexo.setBackground(SystemColor.inactiveCaption);
		btnGenerarAnexo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnGenerarAnexo.setFont(new Font("Tahoma", Font.PLAIN, 14));

		btnFiltrar = new JButton("Unir");
		btnFiltrar.setBackground(SystemColor.inactiveCaption);
		btnFiltrar.setBounds(546, 126, 100, 30);
		panel.add(btnFiltrar);
		btnFiltrar.setFont(new Font("Tahoma", Font.PLAIN, 12));

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(656, 40, 588, 185);
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
		scrollPane_2.setBounds(340, 349, 526, 185);
		panel.add(scrollPane_2);

		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, },
				new String[] { "Exp. ", "DNI ", "Nom. Alum. ", "Apell. Alum.", "CIF Emp.", "Nom. Emp.",
						"Resp. Emp." }));
		scrollPane_2.setViewportView(table_1);

		btnGuardarTodo = new JButton("Guardar ");
		btnGuardarTodo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGuardarTodo.setBackground(SystemColor.inactiveCaption);
		btnGuardarTodo.setBounds(766, 545, 100, 30);
		panel.add(btnGuardarTodo);

		lblNewLabel = new JLabel("Vista de Asignaci\u00F3n");
		lblNewLabel.setBounds(444, 293, 326, 45);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 37));
		lblNewLabel.setForeground(new Color(153, 0, 51));
		btnFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});

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
		btnAtras.setFont(new Font("Tahoma", Font.PLAIN, 12));

		lblTitulo = new JLabel("Asignar Pr\u00E1cticas");
		lblTitulo.setBounds(449, 11, 491, 50);
		contentPane.add(lblTitulo);
		lblTitulo.setForeground(new Color(153, 0, 51));
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 37));
	}
}
