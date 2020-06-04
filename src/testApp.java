import java.sql.*;

public class testApp {

	public static void main(String[] args) throws SQLException {

		/**
		 * Inicilizamos todas la Interfaces y Clases.
		 */
		Controlador miControlador = new Controlador();
		Modelo miModelo = new Modelo();

		LogIn miLogin = new LogIn();
		Interfaz_2 miInterfaz2 = new Interfaz_2();
		Interfaz_2_Director miInterfaz2_Director = new Interfaz_2_Director();
		Interfaz_2_1 miInterfaz2_1 = new Interfaz_2_1();
		Interfaz_2_1_Director miInterfaz2_1_Director = new Interfaz_2_1_Director();
		Interfaz_2_2 miInterfaz2_2 = new Interfaz_2_2();
		Interfaz_3 miInterfaz3 = new Interfaz_3();
		Interfaz_3_Director miInterfaz3_Director = new Interfaz_3_Director();
		Interfaz_3_1 miInterfaz3_1 = new Interfaz_3_1();
		Interfaz_4 miInterfaz4 = new Interfaz_4();
		Interfaz_4_Director miInterfaz4_Director = new Interfaz_4_Director();
		Interfaz_4_1 miInterfaz4_1 = new Interfaz_4_1();
		Interfaz_5_Director miInterfaz5_Director = new Interfaz_5_Director();
		Interfaz_5_1_Director miInterfaz5_1_Director = new Interfaz_5_1_Director();
		Formulario miFormulario = new Formulario();
		datosHistoricos misDatos = new datosHistoricos();
		Nuevo_Usuario miNuevo_Usuario = new Nuevo_Usuario();
		InformesGenerales miGenerales = new InformesGenerales();
		InformeAseguradoras miAseguradora = new InformeAseguradoras();
		InformesFCT miFCT = new InformesFCT();

		/**
		 * Aqui le marcamos al controlador todas las clases e interfaces que debe
		 * conocer.
		 */
		miControlador.setMiModelo(miModelo);
		miControlador.setMisDatos(misDatos);
		miControlador.setMiInterfaz2(miInterfaz2);
		miControlador.setMiInterfaz2_Director(miInterfaz2_Director);
		miControlador.setMiInterfaz2_1(miInterfaz2_1);
		miControlador.setMiInterfaz2_1_Director(miInterfaz2_1_Director);
		miControlador.setMiInterfaz2_2(miInterfaz2_2);
		miControlador.setMiInterfaz3(miInterfaz3);
		miControlador.setMiInterfaz3_Director(miInterfaz3_Director);
		miControlador.setMiInterfaz3_1(miInterfaz3_1);
		miControlador.setMiInterfaz4(miInterfaz4);
		miControlador.setMiInterfaz4_Director(miInterfaz4_Director);
		miControlador.setMiInterfaz4_1(miInterfaz4_1);
		miControlador.setMiInterfaz5_Director(miInterfaz5_Director);
		miControlador.setMiInterfaz5_1_Director(miInterfaz5_1_Director);
		miControlador.setMiLogin(miLogin);
		miControlador.setMiFormulario(miFormulario);
		miControlador.setMiNuevo_Usuario(miNuevo_Usuario);
		miControlador.setMiGenerales(miGenerales);
		miControlador.setMiAseguradora(miAseguradora);
		miControlador.setMiFCT(miFCT);

		/**
		 * Aqui le marcamos al modelo todas las clases e interfaces que debe conocer.
		 */
		miModelo.setMisDatos(misDatos);
		miModelo.setMiInterfaz2(miInterfaz2);
		miModelo.setMiInterfaz2_Director(miInterfaz2_Director);
		miModelo.setMiInterfaz2_1(miInterfaz2_1);
		miModelo.setMiInterfaz2_1_Director(miInterfaz2_1_Director);
		miModelo.setMiInterfaz2_2(miInterfaz2_2);
		miModelo.setMiInterfaz3(miInterfaz3);
		miModelo.setMiInterfaz3_Director(miInterfaz3_Director);
		miModelo.setMiInterfaz3_1(miInterfaz3_1);
		miModelo.setMiInterfaz4(miInterfaz4);
		miModelo.setMiInterfaz4_Director(miInterfaz4_Director);
		miModelo.setMiInterfaz4_1(miInterfaz4_1);
		miModelo.setMiInterfaz5_Director(miInterfaz5_Director);
		miModelo.setMiInterfaz5_1_Director(miInterfaz5_1_Director);
		miModelo.setMiFormulario(miFormulario);
		miModelo.setMiNuevo_Usuario(miNuevo_Usuario);
		miModelo.setMiGenerales(miGenerales);
		miModelo.setMiAseguradora(miAseguradora);
		miModelo.setMiFCT(miFCT);
		miModelo.setMiLogin(miLogin);

		/**
		 * Es aqui donde hacemos que las interfaces conozcan a modelo y a controlador
		 * 
		 */
		miLogin.setMiControlador(miControlador);
		miLogin.setMiModelo(miModelo);

		miFormulario.setMiControlador(miControlador);
		miFormulario.setMiModelo(miModelo);

		miNuevo_Usuario.setMiControlador(miControlador);
		miNuevo_Usuario.setMiModelo(miModelo);

		miInterfaz2.setMiControlador(miControlador);
		miInterfaz2.setMiModelo(miModelo);

		miInterfaz2_Director.setMiControlador(miControlador);
		miInterfaz2_Director.setMiModelo(miModelo);

		miInterfaz2_1.setMiControlador(miControlador);
		miInterfaz2_1.setMiModelo(miModelo);

		miInterfaz2_1_Director.setMiControlador(miControlador);
		miInterfaz2_1_Director.setMiModelo(miModelo);

		miInterfaz2_2.setMiControlador(miControlador);
		miInterfaz2_2.setMiModelo(miModelo);

		miInterfaz3.setMiControlador(miControlador);
		miInterfaz3.setMiModelo(miModelo);

		miInterfaz3_Director.setMiControlador(miControlador);
		miInterfaz3_Director.setMiModelo(miModelo);

		miInterfaz3_1.setMiControlador(miControlador);
		miInterfaz3_1.setMiModelo(miModelo);

		miInterfaz4.setMiControlador(miControlador);
		miInterfaz4.setMiModelo(miModelo);

		miInterfaz4_Director.setMiControlador(miControlador);
		miInterfaz4_Director.setMiModelo(miModelo);

		miInterfaz4_1.setMiControlador(miControlador);
		miInterfaz4_1.setMiModelo(miModelo);

		miInterfaz5_Director.setMiControlador(miControlador);
		miInterfaz5_Director.setMiModelo(miModelo);

		miInterfaz5_1_Director.setMiControlador(miControlador);
		miInterfaz5_1_Director.setMiModelo(miModelo);

		miGenerales.setMiControlador(miControlador);
		miGenerales.setMiModelo(miModelo);

		miAseguradora.setMiControlador(miControlador);
		miAseguradora.setMiModelo(miModelo);

		miFCT.setMiControlador(miControlador);
		miFCT.setMiModelo(miModelo);

		miLogin.setVisible(true);
	}

}
