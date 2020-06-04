import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.text.ParseException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
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
	private datosHistoricos historicos;
	private Formulario miFormulario;
	private int fallos = 0;
	private String resultado;
	private boolean insertado;

	private DefaultTableModel table;
	// Aqui estan todas las SQl que hemos tenido que ir a�adiendo
	private String listadoAlumno = "SELECT num_exp \"EXPEDIENTE\",nombre,apellidos,dni,"
			+ "trunc((to_date((to_char(sysdate,'yyyy')||'-'||to_char(sysdate,'mm')||'-'||to_char(sysdate,'dd')),'yyyy-mm-dd')-fec_naci)/365) \"EDAD\""
			+ ",nacionalidad FROM ivan.alumno";

	private String sqlListadoTutor = "SELECT dni_tutor \"DNI\", nombre, apellidos, centro_cod_centro \"C�DIGO CENTRO\"  FROM ivan.tutor";
	private String listadoEmpresa = "SELECT cif, nombre, direccion \"DIRECCI�N\", telefono \"TEL�FONO\", resp_e \"RESPONSABLE\", localidad "
			+ "FROM ivan.empresa";
	private String listadoPracticas = "SELECT alumno_num_exp \"EXPEDIENTE\", dni_alumno \"DNI\", nombre_al \"NOMBRE ALUMNO\", "
			+ "apellido_al \"APELLIDOS ALUMNO\", empresa_cif \"CIF EMPRESA\", nombre_emp \"NOMBRE EMPRESA\","
			+ " responsable_emp \"RESPONSABLE EMPRESA\" \r\n" + "FROM ivan.practica";
	private String alumnosTutor = "SELECT p.Anio_academico \"A�o\", t.nombre \"Tutor\", g.nombre_ciclo \"Ciclo\", CONCAT(CONCAT(a.nombre,' '),a.apellidos) \"Alumno\", e.nombre \"Empresa\", pr.anexo_2_1, pr.anexo_3, pr.anexo_7, pr.anexo_8 \r\n"
			+ "FROM ivan.pertenece p, ivan.tutor t, ivan.grupo g, ivan.alumno a, ivan.empresa e, ivan.practica pr,ivan.gestiona ge \r\n"
			+ "WHERE p.grupo_cod_grupo=g.cod_grupo AND p.alumno_num_exp=a.num_exp AND e.cif = pr.empresa_cif AND pr.alumno_num_exp=a.num_exp AND t.dni_tutor=ge.tutor_dni_tutor AND \r\n"
			+ "g.cod_grupo=ge.grupo_cod_grupo";
	private String alumnoEmpresa = "SELECT p.Anio_academico \"A�o\", c.numConv \"N� Conv\", e.nombre \"Empresa\", a.dni \"DNI\", CONCAT(CONCAT(a.nombre,' '),a.apellidos) \"Alumno\", g.nom_grupo \"Grupo\", t.nombre \"Tutor C.\", p.tutorE \"Tutor E.\" \r\n"
			+ "FROM ivan.practica p, ivan.colabora c, ivan.empresa e, ivan.alumno a, ivan.grupo g, ivan.tutor t, ivan.pertenece pe, ivan.centro ce, ivan.gestiona ge \r\n"
			+ "WHERE t.centro_cod_centro=ce.cod_centro AND ce.cod_centro=c.centro_cod_centro AND c.empresa_cif=e.cif AND e.cif=p.empresa_cif AND p.alumno_num_exp=a.num_exp AND a.num_exp=pe.alumno_num_exp \r\n"
			+ "AND pe.grupo_cod_grupo=g.cod_grupo AND g.cod_grupo=ge.grupo_cod_grupo AND ge.tutor_dni_tutor=t.dni_tutor\r\n"
			+ "ORDER BY e.nombre";
	private String alumnosPractica = "SELECT p.Anio_academico \"A�o\", t.nombre \"Tutor C.\", CONCAT(CONCAT(a.nombre,' '),a.apellidos) \"Alumno\", e.nombre \"Empresa\", c.numConv \"N� Conv\", CONCAT(CONCAT(p.fecha_ini,' - '),p.fecha_fin) \"Fechas\", p.horario \"Horario\", p.tutorE \"Tutor E.\"\r\n"
			+ "FROM ivan.practica p, ivan.colabora c, ivan.empresa e, ivan.alumno a, ivan.grupo g, ivan.tutor t, ivan.pertenece pe, ivan.gestiona ge \r\n"
			+ "WHERE c.empresa_cif=e.cif AND e.cif=p.empresa_cif AND p.alumno_num_exp=a.num_exp AND a.num_exp=pe.alumno_num_exp \r\n"
			+ "AND pe.grupo_cod_grupo=g.cod_grupo AND g.cod_grupo=ge.grupo_cod_grupo AND ge.tutor_dni_tutor=t.dni_tutor\r\n"
			+ "ORDER BY p.tutorE";
	private String TutorCiclo = "SELECT ge.Anio_academico \"A�o\", g.nombre_ciclo \"Ciclo\", t.dni_tutor \"DNI\", t.nombre \"Nombre\", t.apellidos \"Apellidos\", c.cod_centro \"Centro\", g.cod_grupo \"Grupo\" \r\n"
			+ "FROM ivan.gestiona ge, ivan.grupo g, ivan.tutor t, ivan.centro c\r\n"
			+ "WHERE g.cod_grupo=ge.grupo_cod_grupo AND ge.tutor_dni_tutor=t.dni_tutor AND t.centro_cod_centro=c.cod_centro";
	private String InformeFct = "SELECT p.Anio_academico \"A�o\", a.num_exp \"Exp.\", CONCAT(CONCAT(a.nombre,' '),a.apellidos) \"Alumno\", g.nombre_ciclo \"Ciclo\", g.nom_grupo \"Grupo\", e.nombre \"Empresa\", e.localidad \"Provincia\", e.resp_e \"Resp E.\", p.tutorE \"Tutor E.\", e.telefono \"TLF.\", CONCAT(CONCAT(p.fecha_ini,' - '),p.fecha_fin) \"F. Ini-Fin\", t.nombre \"Tutor C.\", p.email_t \"Email\" \r\n"
			+ "FROM ivan.practica p, ivan.empresa e, ivan.alumno a, ivan.grupo g, ivan.tutor t, ivan.pertenece pe, ivan.gestiona ge \r\n"
			+ "WHERE e.cif=p.empresa_cif AND p.alumno_num_exp=a.num_exp AND a.num_exp=pe.alumno_num_exp AND pe.grupo_cod_grupo=g.cod_grupo AND g.cod_grupo=ge.grupo_cod_grupo AND ge.tutor_dni_tutor=t.dni_tutor";
	private String Aseguradoras = "SELECT p.Anio_academico \"A�o\", a.num_exp \"Exp.\", CONCAT(CONCAT(a.nombre,' '),a.apellidos) \"Alumno\", g.nombre_ciclo \"Ciclo\", a.dni \"DNI\", e.localidad \"Localidad\", e.nombre \"Empresa\", a.nacionalidad \"Nacional.\", trunc((to_date((to_char(sysdate,'yyyy')||'-'||to_char(sysdate,'mm')||'-'||to_char(sysdate,'dd')),'yyyy-mm-dd')-fec_naci)/365) \"Edad\", CONCAT(CONCAT(p.fecha_ini,' - '),p.fecha_fin) \"Periodo\"  \r\n"
			+ "FROM ivan.practica p, ivan.empresa e, ivan.alumno a, ivan.grupo g, ivan.pertenece pe\r\n"
			+ "WHERE e.cif=p.empresa_cif AND p.alumno_num_exp=a.num_exp AND a.num_exp=pe.alumno_num_exp  AND pe.grupo_cod_grupo=g.cod_grupo";
	private String historico="SELECT alumno_num_exp Anio_academico \"A�o\", \"EXPEDIENTE\", dni_alumno \"DNI\", nombre_al \"NOMBRE ALUMNO\", "
			+ "apellido_al \"APELLIDOS ALUMNO\", empresa_cif \"CIF EMPRESA\", nombre_emp \"NOMBRE EMPRESA\","
			+ " responsable_emp \"RESPONSABLE EMPRESA\" \r\n" + "FROM ivan.practica";


	private String user = "";
	private String pas = "";
	private String miUrl = "";

	private Connection conexion;
	private Nuevo_Usuario miNuevo_Usuario;
	private InformesGenerales miGenerales;
	private InformesFCT miFCT;
	private InformeAseguradoras miAseguradora;

	/**
	 * Este metodo seleccona e fichero ini y recoge datos de el.
	 */
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

	/**
	 * Este metodo es para la conexion con la BBDD.
	 */
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

	/**
	 * Este metodo es para el inicio de sesion como tutor/director.
	 * 
	 * @param usr
	 * @param pwd
	 */
	public void InicioSesion(String usr, String pwd) {

		String ssql = "SELECT * FROM ivan.users WHERE usr=? AND pwd=?";
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

	/**
	 * Este metodo es para saber el rol en el que debe entrar la aplicacion.
	 * 
	 * @param usr
	 */
	public void consultaStatement(String usr) {

		String ssql = "SELECT rol FROM ivan.users WHERE usr='" + usr + "'";

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

	/**
	 * 
	 * setters para que el modelo y las diversas interfaces se conozcan.
	 */

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
	public void setMisDatos(datosHistoricos misDatos) {
		this.historicos = misDatos;
	}

	public void setMiFormulario(Formulario miFormulario) {
		this.miFormulario = miFormulario;
	}

	public void setMiNuevo_Usuario(Nuevo_Usuario miNuevo_Usuario) {
		this.miNuevo_Usuario = miNuevo_Usuario;
	}

	public void setMiGenerales(InformesGenerales miGenerales) {
		this.miGenerales = miGenerales;
	}

	public void setMiFCT(InformesFCT miFCT) {
		this.miFCT = miFCT;
	}

	public void setMiAseguradora(InformeAseguradoras miAseguradora) {
		this.miAseguradora = miAseguradora;
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

	/**
	 * Este metodo lo que hace es recuperar y expner la tabla en las interfaces
	 * recogiendola de la BBDD.
	 * 
	 * @param ssql
	 * @return tabla
	 */
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

	/**
	 * 
	 * Aqui manadamos las sql de arriba hacia las diversas tablas repartidas en las
	 * interfaes
	 * 
	 */
	public String getInformeFct() {
		return InformeFct;
	}
	public String getHistor() {
		return historico;
	}

	public String getAseguradoras() {
		return Aseguradoras;
	}

	public String getAlumnosTutor() {
		return alumnosTutor;
	}

	public String getAlumnoEmpresa() {
		return alumnoEmpresa;
	}

	public String getAlumnosPractica() {
		return alumnosPractica;
	}

	public String getTutorCiclo() {
		return TutorCiclo;
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

	// Los siguientes metodos son para la modificacion,eliminacion e insertado de
	// Alumnos/Empresa/Practicas/Tutor.
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

	/**
	 * 
	 * @param usuario
	 * @param password
	 * @param rol
	 * @param email
	 */
	public void insertarUsuario(String usuario, String password, String rol, String email) {
		String query = "INSERT INTO ivan.users(usr, rol, pwd, email) VALUES(?, ?, ?, ?)";
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

	/**
	 * 
	 * @param nombre
	 * @param apellido
	 * @param fecha
	 * @param num_exp
	 * @param dni
	 * @param nacionalidad
	 */
	public void insertarAlumnos(String nombre, String apellido, String fecha, String num_exp, String dni,
			String nacionalidad) {
		String sql = "INSERT INTO ivan.alumno (dni,nombre,apellidos,num_exp,fec_naci,nacionalidad) VALUES(?, ?, ?, ?, ?, ?)";
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

	/**
	 * 
	 * @param num_exp
	 */
	public void borrarAlumnos(String num_exp) {
		String sql = "DELETE FROM ivan.alumno WHERE num_exp = ?";
		try {
			PreparedStatement stmt = conexion.prepareStatement(sql);
			stmt.setString(1, num_exp);
			stmt.executeUpdate();
			insertado = true;
			System.out.println("Eliminado con exito");

		} catch (SQLException e) {
			insertado = false;
			System.out.println("Algun dato incorrecto.");
		}

	}

	/**
	 * 
	 * @param nombre
	 * @param apellido
	 * @param fecha
	 * @param num_exp
	 * @param dni
	 * @param nacionalidad
	 * @param dniant
	 */
	public void modificarAlumno(String nombre, String apellido, String fecha, String num_exp, String dni,
			String nacionalidad, String dniant) {
		String sql = "UPDATE ivan.alumno SET num_exp=?,dni=?,nombre=?,apellidos=?,fec_naci=?,nacionalidad=? WHERE dni=? ";
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
			System.out.println("Alg�n dato incorrecto");
		}

	}

	/**
	 * 
	 * @param nombre
	 * @param tlf
	 * @param cif
	 * @param localidad
	 * @param responsable
	 * @param direccion
	 */
	public void insertarEmpresa(String nombre, String tlf, String cif, String localidad, String responsable,
			String direccion) {
		String sql = "INSERT INTO ivan.empresa (cif,nombre,direccion,telefono,resp_e,localidad) VALUES(?, ?, ?, ?, ?, ?)";
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
			System.out.println("Alg�n dato incorrecto.");
		}

	}

	/**
	 * 
	 * @param cif
	 */
	public void borrarEmpresa(String cif) {
		String sql = "DELETE FROM ivan.empresa WHERE cif=?";
		try {
			PreparedStatement stmt = conexion.prepareStatement(sql);
			stmt.setString(1, cif);
			stmt.executeUpdate();
			insertado = true;
			System.out.println("Guardado con exito");

		} catch (SQLException e) {
			insertado = false;
			System.out.println("Algun dato incorrecto.");
		}

	}

	/**
	 * 
	 * @param nombre
	 * @param tlf
	 * @param cif
	 * @param localidad
	 * @param responsable
	 * @param direccion
	 * @param cifOld
	 */
	public void modificarEmpresa(String nombre, String tlf, String cif, String localidad, String responsable,
			String direccion, String cifOld) {
		String sql = "UPDATE ivan.empresa SET cif=?,nombre=?,direccion=?,telefono=?,resp_e=?,localidad=? WHERE cif=? ";
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

	/**
	 * 
	 * @param nombre
	 * @param apellido
	 * @param cod
	 * @param dni
	 */
	public void insertarTutor(String nombre, String apellido, String cod, String dni) {
		String sql = "INSERT INTO ivan.tutor (dni_tutor,nombre,apellidos,centro_cod_centro) VALUES(?, ?, ?, ?)";
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

	/**
	 * 
	 * @param nombre
	 * @param apellido
	 * @param cod
	 * @param dni
	 * @param dniOld
	 */
	public void modificarTutor(String nombre, String apellido, String cod, String dni, String dniOld) {
		String sql = "UPDATE ivan.tutor SET dni_tutor=?,nombre=?,apellidos=?,centro_cod_centro=? WHERE dni_tutor=? ";
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

	/**
	 * 
	 * @param dni
	 */
	public void borrarTutor(String dni) {
		String sql = "DELETE FROM ivan.tutor WHERE dni_tutor=?";
		try {
			PreparedStatement stmt = conexion.prepareStatement(sql);
			stmt.setString(1, dni);
			stmt.executeUpdate();
			insertado = true;
			System.out.println("Guardado con exito");

		} catch (SQLException e) {
			insertado = false;
			System.out.println("Algun dato incorrecto.");
		}
	}

	/**
	 * 
	 * @param dni
	 * @return Array para sacar bien la edad y su fecha
	 */
	public String[] updateAlumno(String dni) {
		String[] datos = new String[2];
		String updateAlumno = "Select dni, fec_naci from ivan.alumno where dni='" + dni + "'";
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

	/**
	 * Insertado en practica mediante boton de unir
	 * 
	 * @param exp
	 * @param dni
	 * @param nombreAl
	 * @param apellido
	 * @param cif
	 * @param nombreEm
	 * @param responsable
	 */
	public void datosPracticas(String exp, String dni, String nombreAl, String apellido, String cif, String nombreEm,
			String responsable) {
		String sql = "INSERT INTO ivan.practica (empresa_cif, alumno_num_exp, dni_alumno, nombre_al, apellido_al, nombre_emp, responsable_emp) "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement stmt = conexion.prepareStatement(sql);
			stmt.setString(1, cif);
			stmt.setString(2, exp);
			stmt.setString(3, dni);
			stmt.setString(4, nombreAl);
			stmt.setString(5, apellido);
			stmt.setString(6, nombreEm);
			stmt.setString(7, responsable);
			stmt.executeUpdate();
			System.out.println("Guardado con exito");
			insertado = true;

		} catch (SQLException e) {
			insertado = false;
			System.out.println("Alg�n dato incorrecto.");
		} catch (Exception es) {
			System.out.println("Alg�n dato incorrecto.");
		}

	}

	/**
	 * 
	 * @param exp
	 * @param cif
	 */
	public void borrarPracticas(String exp, String cif) {
		String sql = "DELETE FROM ivan.practica WHERE empresa_cif = ? and alumno_num_exp = ?";
		try {
			PreparedStatement stmt = conexion.prepareStatement(sql);
			stmt.setString(1, cif);
			stmt.setString(2, exp);
			stmt.executeUpdate();
			insertado = true;
		} catch (Exception e) {
			insertado = false;
			System.out.println("Alg�n dato incorrecto.");
		}

	}

	// Los siguientes metodos son para realizar el filtardo en las diversas tablas.
	/**
	 * 
	 * @param where
	 * @param inter
	 */
	public void filtrarLisAlum(String where, String inter) {
		if (where == "")
			JOptionPane.showMessageDialog(null, "Debe introducir algun dato para filtrar", "Adevertencia",
					JOptionPane.WARNING_MESSAGE);
		else {
			// Quitamos el ultimo AND sobrante
			int cant = where.length();
			where = where.subSequence(0, cant - 4).toString();
			// Creamos la consulta y pasamos la condici�n where y devolvemos el filtrado a
			// la interfaz que sea
			if (inter.equals("inter2T")) {
				miInterfaz2.generaFiltro(getTabla(listadoAlumno + " where" + where));
			}
			if (inter.equals("inter21T"))
				miInterfaz2_1.generaFiltro(getTabla(listadoAlumno + " where" + where));
			if (inter.equals("inter22T"))
				miInterfaz2_2.generaFiltro(getTabla(listadoAlumno + " where" + where));
			if (inter.equals("inter2D"))
				miInterfaz2_Director.generaFiltro(getTabla(listadoAlumno + " where" + where));
			if (inter.equals("inter21D"))
				miInterfaz2_1_Director.generaFiltro(getTabla(listadoAlumno + " where" + where));

		}

	}

	/**
	 * 
	 * @param where
	 * @param inter
	 */
	public void filtrarLisEmp(String where, String inter) {
		if (where == "")
			JOptionPane.showMessageDialog(null, "Debe introducir algun dato para filtrar", "Adevertencia",
					JOptionPane.WARNING_MESSAGE);
		else {
			// Quitamos el ultimo AND sobrante
			int cant = where.length();
			where = where.subSequence(0, cant - 4).toString();
			// Creamos la consulta y pasamos la condici�n where y devolvemos el filtrado a
			// la interfaz que sea
			if (inter.equals("inter3T")) {
				miInterfaz3.generaFiltro(getTabla(listadoEmpresa + " where" + where));
			}
			if (inter.equals("inter31T"))
				miInterfaz3_1.generaFiltro(getTabla(listadoEmpresa + " where" + where));
			if (inter.equals("inter3D"))
				miInterfaz3_Director.generaFiltro(getTabla(listadoEmpresa + " where" + where));

		}

	}

	/**
	 * 
	 * @param where
	 * @param inter
	 */
	public void filtrarLisPra(String where, String inter) {
		if (where == "")
			JOptionPane.showMessageDialog(null, "Debe introducir algun dato para filtrar", "Adevertencia",
					JOptionPane.WARNING_MESSAGE);
		else {
			// Quitamos el ultimo AND sobrante
			int cant = where.length();
			where = where.subSequence(0, cant - 4).toString();
			// Creamos la consulta y pasamos la condici�n where y devolvemos el filtrado a
			// la interfaz que sea
			if (inter.equals("inter4T")) {
				miInterfaz4.generaFiltro(getTabla(listadoPracticas + " where" + where));
			}
			if (inter.equals("inter4D")) {
				miInterfaz4_Director.generaFiltro(getTabla(listadoPracticas + " where" + where));
			}

		}

	}

	/**
	 * 
	 * @param where
	 * @param inter
	 */
	public void filtrarLisTut(String where, String inter) {
		if (where == "")
			JOptionPane.showMessageDialog(null, "Debe introducir algun dato para filtrar", "Adevertencia",
					JOptionPane.WARNING_MESSAGE);
		else {
			// Quitamos el ultimo AND sobrante
			int cant = where.length();
			where = where.subSequence(0, cant - 4).toString();
			// Creamos la consulta y pasamos la condici�n where y devolvemos el filtrado a
			// la interfaz que sea
			if (inter.equals("inter5D")) {
				miInterfaz5_Director.generaFiltro(getTabla(sqlListadoTutor + " where" + where));
			}
			if (inter.equals("inter51D"))
				miInterfaz5_1_Director.generaFiltro(getTabla(sqlListadoTutor + " where" + where));
		}

	}
	
	public void filtrarHis(String where) {
		if (where == "")
			JOptionPane.showMessageDialog(null, "Debe introducir el a�o para filtrar", "Adevertencia",
					JOptionPane.WARNING_MESSAGE);
		else {
			// Quitamos el ultimo AND sobrante
			int cant = where.length();
			where = where.subSequence(0, cant - 4).toString();
			// Creamos la consulta y pasamos la condici�n where y devolvemos el filtrado a
			// la interfaz que sea
			
				historicos.generaFiltro(getTabla(historico + " where" + where));
			
		}

	}
}
