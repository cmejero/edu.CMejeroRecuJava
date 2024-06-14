package controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dtos.PropietarioDto;
import dtos.VehiculoDto;
import servicios.FicheroImplementacion;
import servicios.FicheroInterfaz;
import servicios.MenuImplementacion;
import servicios.MenuInterfaz;
import servicios.OperativaImplementacion;
import servicios.OperativaInterfaz;
import utiles.util;

/** Clase principal de nuestra aplicacion */
public class Inicio {

	static public final String RUTAFICHERO = "C:\\Users\\Carlos\\git\\edu.CMejero.Recu\\edu.CMejeroRecu\\Logs\\";
	static public final String RUTAFICHERODTOS = "C:\\Users\\Carlos\\git\\edu.CMejero.Recu\\edu.CMejeroRecu\\vehiculosYpropietarios.txt";
	static public final String RUTAFICHEROLOG = RUTAFICHERO.concat(util.nombreFicheroLog());
	static public final List<VehiculoDto> LI_VEHICULO_DTOS = new ArrayList<VehiculoDto>();
	static public final List<PropietarioDto> LISTA_PROPIETARIO_DTOS = new ArrayList<PropietarioDto>();

	/** Metodo principal de entrada de nuestra aplicacion */
	public static void main(String[] args) {

		MenuInterfaz mi = new MenuImplementacion();
		FicheroInterfaz fi = new FicheroImplementacion();
		OperativaInterfaz oi= new OperativaImplementacion();
		
		Scanner sc = new Scanner(System.in);
		int opcionUsusario;
		boolean cerrarMenu = false;
		fi.leerFichero();

		do {

			try {

				opcionUsusario = mi.menuYSeleccion(sc);

				switch (opcionUsusario) {

				case 0:
					System.out.println("Has seleccionado cerrar aplicacion");
					fi.escribirFicheroLog("Has seleccionado cerrar aplicacion");
					cerrarMenu = true;
					break;

				case 1:
					System.out.println("Has seleccionado venta de vehiculo");
					fi.escribirFicheroLog("Has seleccionado venta de vehiculo");
					oi.VentaVehiculo(sc);
					break;

				default:
					System.out.println("Has una opcion incorrecta");
					fi.escribirFicheroLog("Has una opcion incorrecta");
					break;

				}

			} catch (Exception e) {

				System.out.println("Se ha producido un error, intentelo más tarde");
				fi.escribirFicheroLog("Se ha producido un error en :".concat(e.getMessage()));
			}

		} while (!cerrarMenu);

	}

}
