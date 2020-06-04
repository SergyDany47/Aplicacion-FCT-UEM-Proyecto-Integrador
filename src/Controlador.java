public class Controlador {
	private LogIn miLogin;
	private Nuevo_Usuario miNuevo_Usuario;
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
	private InformesGenerales miGenerales;

	private Modelo miModelo;

	public void setMiLogin(LogIn miLogin) {
		this.miLogin = miLogin;
	}

	public void setMiNuevo_Usuario(Nuevo_Usuario miNuevo_Usuario) {
		this.miNuevo_Usuario = miNuevo_Usuario;
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

	public void setMiModelo(Modelo miModelo) {
		this.miModelo = miModelo;
	}
	
	public void setMiGenerales(InformesGenerales miGenerales) {
		this.miGenerales = miGenerales;
	}

	public void abrirFormulario() {
		miFormulario.setVisible(true);
		miLogin.setVisible(false);

	}

	public void abrirNuevoUsuario() {
		miNuevo_Usuario.setVisible(true);
		miLogin.setVisible(false);

	}

	public void inicioSesionTutor() {
		miInterfaz2.setVisible(true);
		miLogin.setVisible(false);
	}

	public void inicioSesionDirector() {
		miInterfaz2_Director.setVisible(true);
		miLogin.setVisible(false);
	}

	public void cerrarSesion() {
		miLogin.setVisible(true);
		miInterfaz2.setVisible(false);
		miInterfaz3.setVisible(false);
		miInterfaz4.setVisible(false);
		miFormulario.setVisible(false);
		miNuevo_Usuario.setVisible(false);
	}

	public void cerrarSesionDirector() {
		miLogin.setVisible(true);
		miInterfaz2_Director.setVisible(false);
		miInterfaz3_Director.setVisible(false);
		miInterfaz4_Director.setVisible(false);
		miInterfaz5_Director.setVisible(false);
	}

	public void generarAnexos() {
		miInterfaz2_2.setVisible(true);
		miInterfaz2.setVisible(false);
	}

	public void generarAnexosDirector() {
		miInterfaz2_1_Director.setVisible(true);
		miInterfaz2_Director.setVisible(false);
		miInterfaz5_Director.setVisible(false);
		miInterfaz4_Director.setVisible(false);
	}

	public void adminEmpresas() {
		miInterfaz3.setVisible(true);
		miInterfaz3_1.setVisible(false);
		miInterfaz2.setVisible(false);
		miInterfaz4.setVisible(false);
	}

	public void listadoEmpresas() {
		miInterfaz3_Director.setVisible(true);
		miInterfaz2_Director.setVisible(false);
		miInterfaz4_Director.setVisible(false);
		miInterfaz5_Director.setVisible(false);
	}

	public void adminAlumnos() {
		miInterfaz2.setVisible(true);
		miInterfaz2_1.setVisible(false);
		miInterfaz2_2.setVisible(false);
		miInterfaz4.setVisible(false);
		miInterfaz3.setVisible(false);
	}

	public void listadoAlumnos() {
		miInterfaz2_Director.setVisible(true);
		miInterfaz2_1_Director.setVisible(false);
		miInterfaz4_Director.setVisible(false);
		miInterfaz3_Director.setVisible(false);
		miInterfaz5_Director.setVisible(false);
		miGenerales.setVisible(false);
	}

	public void adminPracticas() {
		miInterfaz4.setVisible(true);
		miInterfaz4_1.setVisible(false);
		miInterfaz2.setVisible(false);
		miInterfaz3.setVisible(false);
	}

	public void listadoPracticas() {
		miInterfaz4_Director.setVisible(true);
		miInterfaz2_Director.setVisible(false);
		miInterfaz3_Director.setVisible(false);
		miInterfaz5_1_Director.setVisible(false);
		miInterfaz5_Director.setVisible(false);
	}

	public void listadoTutores() {
		miInterfaz5_Director.setVisible(true);
		miInterfaz4_Director.setVisible(false);
		miInterfaz2_Director.setVisible(false);
		miInterfaz3_Director.setVisible(false);
		miInterfaz2_1_Director.setVisible(false);
		miInterfaz5_1_Director.setVisible(false);
	}

	public void administrarTutores() {
		miInterfaz5_1_Director.setVisible(true);
		miInterfaz5_Director.setVisible(false);

	}

	public void modifEmpresa() {
		miInterfaz3_1.setVisible(true);
		miInterfaz3.setVisible(false);
	}

	public void modifAlumnos() {
		miInterfaz2_1.setVisible(true);
		miInterfaz2.setVisible(false);
	}

	public void asignarPracticas() {
		miInterfaz4_1.setVisible(true);
		miInterfaz4.setVisible(false);
	}
	
	public void informesGenerales() {
		miGenerales.setVisible(true);
		miInterfaz2_Director.setVisible(false);
		
	}

	public void login() {
		String usr = miLogin.getUsuario();
		String pwd = miLogin.getPassword();
		miModelo.InicioSesion(usr, pwd);

	}

	public void modificarDatos() {
		String usuario = miFormulario.getUsuario();
		String password = miFormulario.getPassword();
		String url = miFormulario.getUrl();
		miModelo.modificarDatos(usuario, password, url);
	}

	public void GuardarListadoAlumnos() {
		String tabla = miModelo.getListadoAlumnos();
		String archivo = "ListadoAlumnos.ini";
		miModelo.GuardarListadoAlumnos(tabla, archivo);

	}

	public void GuardarListadoEmpresa() {
		String tabla = miModelo.getListadoEmpresa();
		String archivo = "ListadoEmpresas.ini";
		miModelo.GuardarListadoAlumnos(tabla, archivo);

	}

	public void GuardarListadoPracticas() {
		String tabla = miModelo.getListadoPracticas();
		String archivo = "ListadoPracticas.ini";
		miModelo.GuardarListadoAlumnos(tabla, archivo);

	}

	public void GuardarListadoAlumnosDirector() {
		String tabla = miModelo.getListadoAlumnos();
		String archivo = "ListadoAlumnosDirector.ini";
		miModelo.GuardarListadoAlumnos(tabla, archivo);

	}

	public void GuardarListadoEmpresaDirector() {
		String tabla = miModelo.getListadoEmpresa();
		String archivo = "ListadoEmpresaDirector.ini";
		miModelo.GuardarListadoAlumnos(tabla, archivo);

	}

	public void GuardarListadoPracticasDirector() {
		String tabla = miModelo.getListadoPracticas();
		String archivo = "ListadoPracticasDirector.ini";
		miModelo.GuardarListadoAlumnos(tabla, archivo);

	}

	public void GuardarListadoTutoresDirector() {
		String tabla = miModelo.getListadoTutor();
		String archivo = "ListadoTutoresDirector.ini";
		miModelo.GuardarListadoAlumnos(tabla, archivo);
	}

	public void insertarUsuario() {
		String usuario = miNuevo_Usuario.getUsuario();
		String password = miNuevo_Usuario.getPassword();
		String rol = miNuevo_Usuario.getRol();
		String email = miNuevo_Usuario.getEmail();
		miModelo.insertarUsuario(usuario, password, rol, email);

	}

	public void insertarAlumno() {
		String nombre = miInterfaz2_1.getNombre();
		String apellido = miInterfaz2_1.getApellido();
		String fecha = miInterfaz2_1.getFecha();
		String num_exp = miInterfaz2_1.getNum_Exp();
		String dni = miInterfaz2_1.getDNI();
		String nacionalidad = miInterfaz2_1.getNacionalidad();
		miModelo.insertarAlumnos(nombre, apellido, fecha, num_exp, dni, nacionalidad);
	}

	public void modificarAlumno(String dniOld) {
		String[] datos = miModelo.updateAlumno(dniOld);
		String dnia = datos[0];
		String fecha = miInterfaz2_1.getFecha();
		String nombre = miInterfaz2_1.getNombre();
		String apellido = miInterfaz2_1.getApellido();
		String num_exp = miInterfaz2_1.getNum_Exp();
		String dni = miInterfaz2_1.getDNI();
		String nacionalidad = miInterfaz2_1.getNacionalidad();
		miModelo.modificarAlumno(nombre, apellido, fecha, num_exp, dni, nacionalidad, dnia);
	}

	public void insertarEmpresa() {
		String nombre = miInterfaz3_1.getNombre();
		String tlf = miInterfaz3_1.getTlf();
		String cif = miInterfaz3_1.getCIF();
		String localidad = miInterfaz3_1.getLocalidad();
		String responsable = miInterfaz3_1.getResponsable();
		String direccion = miInterfaz3_1.getDireccion();
		miModelo.insertarEmpresa(nombre, tlf, cif, localidad, responsable, direccion);
	}

	public void modificarEmpresa(String cifOld) {
		String nombre = miInterfaz3_1.getNombre();
		String tlf = miInterfaz3_1.getTlf();
		String cif = miInterfaz3_1.getCIF();
		String localidad = miInterfaz3_1.getLocalidad();
		String responsable = miInterfaz3_1.getResponsable();
		String direccion = miInterfaz3_1.getDireccion();
		miModelo.modificarEmpresa(nombre, tlf, cif, localidad, responsable, direccion, cifOld);
	}

	public void insertarTutor() {
		String nombre = miInterfaz5_1_Director.getNombre();
		String apellido = miInterfaz5_1_Director.getApellido();
		String cod = miInterfaz5_1_Director.getCod();
		String dni = miInterfaz5_1_Director.getDNI();
		miModelo.insertarTutor(nombre, apellido, cod, dni);
	}

	public void modificarTutor(String dniOld) {
		String nombre = miInterfaz5_1_Director.getNombre();
		String apellido = miInterfaz5_1_Director.getApellido();
		String cod = miInterfaz5_1_Director.getCod();
		String dni = miInterfaz5_1_Director.getDNI();
		miModelo.modificarTutor(nombre, apellido, cod, dni, dniOld);
	}

	public void borrarAlumno() {
		String num_exp = miInterfaz2_1.getNum_Exp();
		miModelo.borrarAlumnos(num_exp);
	}

	public void borrarEmpresa() {
		String cif = miInterfaz3_1.getCIF();
		miModelo.borrarEmpresa(cif);
	}

	public void borrarTutor() {
		String dni = miInterfaz5_1_Director.getDNI();
		miModelo.borrarTutor(dni);

	}

	public void filtrarLisAlum(String[] datos, String inter) {
		String where = "";
		if (!datos[0].equals("") && !datos[0].equals("Num.Expediente"))
			where += " lower(num_exp) LIKE lower('" + datos[0] + "') || '%' AND";
		if (!datos[3].equals("") && !datos[3].equals("DNI"))
			where += " lower(dni) LIKE lower('" + datos[3] + "') || '%' AND";
		if (!datos[2].equals("") && !datos[2].equals("Nombre"))
			where += " lower(nombre) LIKE lower('" + datos[2] + "') || '%' AND";
		if (!datos[1].equals("") && !datos[1].equals("Apellidos"))
			where += " lower(apellidos) LIKE lower('" + datos[1] + "') || '%' AND";
		if (!datos[4].equals("") && !datos[4].equals("Fecha.Nacimiento"))
			where += " lower(fec_naci) LIKE lower('" + datos[4] + "') || '%' AND";
		if (!datos[5].equals("") && !datos[5].equals("Nacionalidad"))
			where += " lower(nacionalidad) LIKE lower('" + datos[5] + "') || '%' AND";

		miModelo.filtrarLisAlum(where, inter);
	}

	public void filtrarLisEmpr(String[] datos, String inter) {
		String where = "";
		if (!datos[0].equals("") && !datos[0].equals("CIF"))
			where += " lower(cif) LIKE lower('" + datos[0] + "') || '%' AND";
		if (!datos[3].equals("") && !datos[3].equals("Nombre"))
			where += " lower(nombre) LIKE lower('" + datos[3] + "') || '%' AND";
		if (!datos[2].equals("") && !datos[2].equals("Teléfono"))
			where += " lower(telefono) LIKE lower('" + datos[2] + "') || '%' AND";
		if (!datos[1].equals("") && !datos[1].equals("Direccion"))
			where += " lower(direccion) LIKE lower('" + datos[1] + "') || '%' AND";
		if (!datos[4].equals("") && !datos[4].equals("Responsable"))
			where += " lower(resp_e) LIKE lower('" + datos[4] + "') || '%' AND";
		if (!datos[5].equals("") && !datos[5].equals("Localidad"))
			where += " lower(localidad) LIKE lower('" + datos[5] + "') || '%' AND";

		miModelo.filtrarLisEmp(where, inter);
	}

	public void filtrarLisPra(String[] datos, String inter) {
		String where = "";
		if (!datos[0].equals("") && !datos[0].equals("DNI"))
			where += " lower(dni_alumno) LIKE lower('" + datos[0] + "') || '%' AND";
		if (!datos[1].equals("") && !datos[1].equals("Nom. Alum."))
			where += " lower(nombre_al) LIKE lower('" + datos[1] + "') || '%' AND";
		if (!datos[2].equals("") && !datos[2].equals("Apellidos"))
			where += " lower(apellido_al) LIKE lower('" + datos[2] + "') || '%' AND";
		if (!datos[3].equals("") && !datos[3].equals("CIF Emp."))
			where += " lower(Empresa_cif) LIKE lower('" + datos[3] + "') || '%' AND";
		if (!datos[4].equals("") && !datos[4].equals("Nom. Emp."))
			where += " lower(nombre_emp) LIKE lower('" + datos[4] + "') || '%' AND";
		if (!datos[5].equals("") && !datos[5].equals("Expediente"))
			where += " lower(Alumno_num_exp) LIKE lower('" + datos[5] + "') || '%' AND";
		if (!datos[6].equals("") && !datos[6].equals("Resp. Emp"))
			where += " lower(responsable_emp) LIKE lower('" + datos[6] + "') || '%' AND";

		miModelo.filtrarLisPra(where, inter);
	}

	public void filtrarLisTut(String[] datos, String inter) {
		String where = "";
		if (!datos[0].equals("") && !datos[0].equals("DNI del tutor"))
			where += " lower(dni_tutor) LIKE lower('" + datos[0] + "') || '%' AND";
		if (!datos[1].equals("") && !datos[1].equals("Nombre"))
			where += " lower(nombre) LIKE lower('" + datos[1] + "') || '%' AND";
		if (!datos[2].equals("") && !datos[2].equals("Apellidos"))
			where += " lower(apellidos) LIKE lower('" + datos[2] + "') || '%' AND";
		if (!datos[3].equals("") && !datos[3].equals("Código centro"))
			where += " lower(centro_cod_centro) LIKE lower('" + datos[3] + "') || '%' AND";

		miModelo.filtrarLisTut(where, inter);
	}

}
