package servicios;

import java.util.Scanner;
/** Clase que implementa al menu interfaz */


public class MenuImplementacion implements MenuInterfaz{

	
	public int menuYSeleccion(Scanner sc ) {
		
		int opcionUsuario;
		
		System.out.println("######################");
		System.out.println("0. Cerrar Aplicacion");
		System.out.println("1. Venta de vehiculo");
		System.out.println("######################");
		
		opcionUsuario = sc.nextInt();
		
		return opcionUsuario;
		
	}
	
}
