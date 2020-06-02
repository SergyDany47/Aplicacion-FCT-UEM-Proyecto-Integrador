import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.text.ParseException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Modelo {

	private LogIn miLogin;
	private Interfaz_2 miInterfaz2;
	private Interfaz_2_Director miInterfaz2_Director;
	private Interfaz_2_1 miInterfaz2_1;
	private Interfaz_2_1_Director miInterfaz2_1_Director;
	private Interfaz_2_2 miInterfaz2_2;
	private Interfaz_3 miInterfaz3;
	private Interfaz_3_Director miInterfaz3_Director;
	private Interfaz_3_1 miInterfaz3_1;
	private Interfaz_4 miInterfaz4;
	private Interfaz_4_Director miInterfaz4_Director;
	private Interfaz_4_1 miInterfaz4_1;
	private Interfaz_5_Director miInterfaz5_Director;
	private Interfaz_5_1_Director miInterfaz5_1_Director;
	private Formulario miFormulario;
	private int fallos = 0;
	private String resultado;
	private boolean insertado;

	private DefaultTableModel table;
	private String listadoAlumno = "SELECT num_exp \"EXPEDIENTE\",nombre,apellidos,dni,"
			+ "trunc((to_date((to_char(sysdate,'yyyy')||'-'||to_char(sysdate,'mm')||'-'||to_char(sysdate,'dd')),'yyyy-mm-dd')-fec_naci)/365) \"EDAD\""
			+ ",nacionalidad FROM sebas.alumno";
	private String sqlListadoTutor = "SELECT dni_tutor \"DNI\", nombre, apellidos, centro_cod_centro \"Cï¿½DIGO CENTRO\"  FROM sebas.tutor";
	private String listadoEmpresa = "SELECT cif, nombre, direccion \"DIRECCIï¿½N\", telefono \"TELï¿½FONO\", resp_e \"RESPONSABLE\", localidad FROM sebas.empresa";
	private String listadoPracticas = "SELECT a.dni \"DNI\", a.nombre \"NOMBRE ALUMNO\", a.apellidos \"APELLIDOS ALUMNO\", e.cif \"CIF EMPRESA\", e.nombre \"NOMBRE EMPRESA\", e.resp_e \"RESPONSABLE EMPRESA\" \r\n"
			+ "FROM sebas.alumno a, sebas.empresa e, sebas.practica p\r\n"
			+ "WHERE a.num_exp=p.alumno_num_exp AND p.empresa_cif=e.cif";

	private String user = "";
	private String pas = "";
	private String miUrl = "";

	private Connection conexion;
	private Nuevo_Usuario miNuevo_Usuario;

	public void seleccionarFichero() {

		File file = new File("Ajustes.ini");

		int vez = 0;

		if (file.exists()) {

			try {
				Scanner sc = new Scanner(file);
				String[] texto = new String[3];
				while (sc.hasNext()) {

					texto[vez] = sc.nextLine();
					vez++;
				}
				this.user = texto[0];
				this.pas = texto[1];
				this.miUrl = texto[2];

			} catch (IOException e) {
				System.out.println("Error de Entrada/Salida");
			}
		} else {

			System.out.println("El fichero no existe");
		}

	}

	public String usuario() {
		return this.user;
	}

	public String password() {
		return this.pas;
	}

	public String UrlConexion() {
		return this.miUrl;
	}

	public void ConexionBBDD() {
		try {
			seleccionarFichero();
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conexion = DriverManager.getConnection(miUrl, user, pas);
			System.out.println("Conexion con ORACLE establecida");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver JDBC No encontrado");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Error al conectarse a la BBDD");
			e.printStackTrace();
		}

	}

	public void terminar() {
		try {
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void InicioSesion(String usr, String pwd) {

		String ssql = "SELECT * FROM sebas.users WHERE usr=? AND pwd=?";
		if (conexion == null) {
			ConexionBBDD();
		}
		try {
			PreparedStatement pstmt = conexion.prepareStatement(ssql);
			pstmt.setString(1, usr);
			pstmt.setString(2, pwd);
			ResultSet rset = pstmt.executeQuery();
			if (rset.next()) {
				fallos = 0;
				resultado = "correcto";
			} else {
				fallos++;
				if (fallos == 3) {
					System.exit(0);
					terminar();
				} else
					resultado = "incorrecto";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		miLogin.actualizar(usr);

	}

	public void consultaStatement(String usr) {

		String ssql = "SELECT rol FROM sebas.users WHERE usr='" + usr + "'";

		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(ssql);
			while (rset.next()) {
				if (rset.getString("rol").equals("tutor")) {
					miLogin.vistaTutor();
				} else {
					miLogin.vistaDirector();
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public String getResultado() {
		return this.resultado;
	}

	public void setMiLogin(LogIn miLogin) {
		this.miLogin = miLogin;
	}

	public void setMiInterfaz2(Interfaz_2 miInterfaz2) {
		this.miInterfaz2 = miInterfaz2;
	}

	public void setMiInterfaz2_Director(Interfaz_2_Director miInterfaz2_Director) {
		this.miInterfaz2_Director = miInterfaz2_Director;
	}

	public void setMiInterfaz2_1(Interfaz_2_1 miInterfaz2_1) {
		this.miInterfaz2_1 = miInterfaz2_1;
	}

	public void setMiInterfaz2_1_Director(Interfaz_2_1_Director miInterfaz2_1_Director) {
		this.miInterfaz2_1_Director = miInterfaz2_1_Director;
	}

	public void setMiInterfaz2_2(Interfaz_2_2 miInterfaz2_2) {
		this.miInterfaz2_2 = miInterfaz2_2;
	}

	public void setMiInterfaz3(Interfaz_3 miInterfaz3) {
		this.miInterfaz3 = miInterfaz3;
	}

	public void setMiInterfaz3_Director(Interfaz_3_Director miInterfaz3_Director) {
		this.miInterfaz3_Director = miInterfaz3_Director;
	}

	public void setMiInterfaz3_1(Interfaz_3_1 miInterfaz3_1) {
		this.miInterfaz3_1 = miInterfaz3_1;
	}

	public void setMiInterfaz4(Interfaz_4 miInterfaz4) {
		this.miInterfaz4 = miInterfaz4;
	}

	public void setMiInterfaz4_Director(Interfaz_4_Director miInterfaz4_Director) {
		this.miInterfaz4_Director = miInterfaz4_Director;
	}

	public void setMiInterfaz4_1(Interfaz_4_1 miInterfaz4_1) {
		this.miInterfaz4_1 = miInterfaz4_1;
	}

	public void setMiInterfaz5_Director(Interfaz_5_Director miInterfaz5_Director) {
		this.miInterfaz5_Director = miInterfaz5_Director;
	}

	public void setMiInterfaz5_1_Director(Interfaz_5_1_Director miInterfaz5_1_Director) {
		this.miInterfaz5_1_Director = miInterfaz5_1_Director;
	}

	public void setMiFormulario(Formulario miFormulario) {
		this.miFormulario = miFormulario;
	}

	public void setMiNuevo_Usuario(Nuevo_Usuario miNuevo_Usuario) {
		this.miNuevo_Usuario = miNuevo_Usuario;
	}

	private int getNumColumnas(String ssql) {
		int num = 0;
		try {
			PreparedStatement pstmt = conexion.prepareStatement(ssql);
			ResultSet rset = pstmt.executeQuery();
			ResultSetMetaData rsmd = rset.getMetaData();
			num = rsmd.getColumnCount();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}

	public DefaultTableModel getTabla(String ssql) {
		table = new DefaultTableModel();
		int numColumnas = getNumColumnas(ssql);
		Object[] contenido = new Object[numColumnas];
		PreparedStatement pstmt;
		try {
			pstmt = conexion.prepareStatement(ssql);
			ResultSet rset = pstmt.executeQuery();
			ResultSetMetaData rsmd = rset.getMetaData();
			for (int i = 0; i < numColumnas; i++) {
				table.addColumn(rsmd.getColumnName(i + 1));
			}
			while (rset.next()) {
				for (int col = 1; col <= numColumnas; col++) {
					contenido[col - 1] = rset.getString(col);
				}
				table.addRow(contenido);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return table;
	}

	public String getListadoAlumnos() {
		return listadoAlumno;
	}

	public String getListadoTutor() {
		return sqlListadoTutor;

	}

	public String getListadoEmpresa() {
		return listadoEmpresa;
	}

	public String getListadoPracticas() {
		return listadoPracticas;
	}

	public void modificarDatos(String usuario, String password, String url) {
		File archivo = new File("Ajustes.ini");
		try {
			FileOutputStream archivopas = new FileOutputStream(archivo);
			archivopas.write((usuario + "\n" + password + "\n" + url).getBytes());
			archivopas.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void GuardarListadoAlumnos(String tabla, String NombreArchivo) {
		File archivo = new File(NombreArchivo);
		try {
			FileOutputStream fos = new FileOutputStream(archivo);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(getTabla(tabla));
			fos.close();
			oos.close();
			System.out.println("guardado");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}

	public void insertarUsuario(String usuario, String password, String rol, String email) {
		String query = "INSERT INTO sebas.users(usr, rol, pwd, email) VALUES(?, ?, ?, ?)";
		try {
			if (conexion == null) {
				ConexionBBDD();
			}
			PreparedStatement stmt = conexion.prepareStatement(query);
			stmt.setString(1, usuario);
			stmt.setString(2, rol);
			stmt.setString(3, password);
			stmt.setString(4, email);
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Usuario existente o algun dato erroneo");
		}
		miNuevo_Usuario.actualizar();
	}

	public void insertarAlumnos(String nombre, String apellido, String fecha, String num_exp, String dni,
			String nacionalidad) {
		String sql = "INSERT INTO sebas.alumno (dni,nombre,apellidos,num_exp,fec_naci,nacionalidad) VALUES(?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement stmt = conexion.prepareStatement(sql);
			stmt.setString(1, dni);
			stmt.setString(2, nombre);
			stmt.setString(3, apellido);
			stmt.setString(4, num_exp);
			stmt.setString(5, fecha);
			stmt.setString(6, nacionalidad);
			stmt.executeUpdate();
			insertado = true;

			System.out.println("Guardado con exito");
		} catch (SQLException e) {
			insertado = false;
			System.out.println("Algun dato incorrecto.");
		}

	}

	public void borrarAlumnos(String num_exp) {
		String sql = "DELETE FROM sebas.alumno WHERE num_exp = ?";
		try {
			PreparedStatement stmt = conexion.prepareStatement(sql);
			stmt.setString(1, num_exp);
			stmt.executeUpdate();
			System.out.println("Eliminado con exito");

		} catch (SQLException e) {
			System.out.println("Algun dato incorrecto.");
		}

	}

	public void modificarAlumno(String nombre, String apellido, String fecha, String num_exp, String dni,
			String nacionalidad, String dniant) {
		String sql = "UPDATE sebas.alumno SET num_exp=?,dni=?,nombre=?,apellidos=?,fec_naci=?,nacionalidad=? WHERE dni=? ";
		try {
			PreparedStatement stmt = conexion.prepareStatement(sql);
			stmt.setString(1, num_exp);
			stmt.setString(2, dni);
			stmt.setString(3, nombre);
			stmt.setString(4, apellido);
			stmt.setString(5, fecha);
			stmt.setString(6, nacionalidad);
			stmt.setString(7, dniant);
			stmt.executeUpdate();
			System.out.println("Guardado con exito");
			insertado = true;

		} catch (SQLException e) {
			insertado = false;
			System.out.println("Algún dato incorrecto");
		}

	}

	public void insertarEmpresa(String nombre, String tlf, String cif, String localidad, String responsable,
			String direccion) {
		String sql = "INSERT INTO sebas.empresa (cif,nombre,direccion,telefono,resp_e,localidad) VALUES(?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement stmt = conexion.prepareStatement(sql);
			stmt.setString(1, cif);
			stmt.setString(2, nombre);
			stmt.setString(3, direccion);
			stmt.setString(4, tlf);
			stmt.setString(5, responsable);
			stmt.setString(6, localidad);
			stmt.executeUpdate();
			System.out.println("Guardado con exito");
			insertado = true;

		} catch (SQLException e) {
			insertado = false;
			System.out.println("Algún dato incorrecto.");
		}

	}

	public void borrarEmpresa(String cif) {
		String sql = "DELETE FROM sebas.empresa WHERE cif=?";
		try {
			PreparedStatement stmt = conexion.prepareStatement(sql);
			stmt.setString(1, cif);
			stmt.executeUpdate();
			System.out.println("Guardado con exito");

		} catch (SQLException e) {
			System.out.println("Algun dato incorrecto.");
		}

	}

	public void modificarEmpresa(String nombre, String tlf, String cif, String localidad, String responsable,
			String direccion, String cifOld) {
		String sql = "UPDATE sebas.empresa SET cif=?,nombre=?,direccion=?,telefono=?,resp_e=?,localidad=? WHERE cif=? ";
		try {
			PreparedStatement stmt = conexion.prepareStatement(sql);
			stmt.setString(1, cif);
			stmt.setString(2, nombre);
			stmt.setString(3, direccion);
			stmt.setString(4, tlf);
			stmt.setString(5, responsable);
			stmt.setString(6, localidad);
			stmt.setString(7, cifOld);
			stmt.executeUpdate();
			System.out.println("Guardado con exito");
			insertado = true;
		} catch (SQLException e) {
			insertado = false;
			System.out.println("Algun dato incorrecto.");
		}

	}

	public void insertarTutor(String nombre, String apellido, String cod, String dni) {
		String sql = "INSERT INTO sebas.tutor (dni_tutor,nombre,apellidos,centro_cod_centro) VALUES(?, ?, ?, ?)";
		try {
			PreparedStatement stmt = conexion.prepareStatement(sql);
			stmt.setString(1, dni);
			stmt.setString(2, nombre);
			stmt.setString(3, apellido);
			stmt.setString(4, cod);
			stmt.executeUpdate();
			System.out.println("Guardado con exito");
			insertado = true;

		} catch (SQLException e) {
			insertado = false;
			System.out.println("Algun dato incorrecto.");
		}

	}

	public void modificarTutor(String nombre, String apellido, String cod, String dni, String dniOld) {
		String sql = "UPDATE sebas.tutor SET dni_tutor=?,nombre=?,apellidos=?,centro_cod_centro=? WHERE dni_tutor=? ";
		try {
			PreparedStatement stmt = conexion.prepareStatement(sql);
			stmt.setString(1, dni);
			stmt.setString(2, nombre);
			stmt.setString(3, apellido);
			stmt.setString(4, cod);
			stmt.setString(5, dniOld);
			stmt.executeUpdate();
			System.out.println("Guardado con exito");
			insertado = true;

		} catch (SQLException e) {
			insertado = false;
			System.out.println("Algun dato incorrecto.");
		}

	}

	public void borrarTutor(String dni) {
		String sql = "DELETE FROM sebas.tutor WHERE dni_tutor=?";
		try {
			PreparedStatement stmt = conexion.prepareStatement(sql);
			stmt.setString(1, dni);
			stmt.executeUpdate();
			System.out.println("Guardado con exito");

		} catch (SQLException e) {
			System.out.println("Algun dato incorrecto.");
		}
	}

	public String[] updateAlumno(String dni) {
		String[] datos = new String[2];
		String updateAlumno = "Select dni, fec_naci from sebas.alumno where dni='" + dni + "'";
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rs = stmt.executeQuery(updateAlumno);
			while (rs.next()) {
				datos[0] = rs.getString("dni");
				datos[1] = rs.getString("fec_naci");
			}
		} catch (Exception e) {

		}
		return datos;
	}

	public boolean malInsertado() {
		boolean resultado;
		if (insertado == true) {
			resultado = true;
		} else {
			resultado = false;
		}
		return resultado;
	}
}
