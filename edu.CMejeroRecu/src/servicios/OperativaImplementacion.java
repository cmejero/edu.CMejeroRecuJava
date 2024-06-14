package servicios;

import java.io.Console;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.time.LocalDate;
import java.util.Scanner;

import controladores.Inicio;
import dtos.PropietarioDto;
import dtos.VehiculoDto;

/** Clase que se encarga de implementar operativa Interfaz */
public class OperativaImplementacion implements OperativaInterfaz {

	
	public void VentaVehiculo(Scanner sc) {
		
		FicheroInterfaz fi = new FicheroImplementacion();
		String datoString ="";
		String datoString2 = "";
		LocalDate fechaHoyDate = LocalDate.now();
		System.out.println("Introduzca la matricula que desea consultar");
		for(PropietarioDto propietarioDto : Inicio.LISTA_PROPIETARIO_DTOS) {
			
			System.out.println(propietarioDto.toString());
			
		}
		boolean existe = false;
		
		do {
		
		
		for(PropietarioDto propietarioDto : Inicio.LISTA_PROPIETARIO_DTOS) {
					
			String matriculaUsu= sc.next();
			if(!matriculaUsu.equals(matriculaUsu)) {				
				existe= true;
				
				PropietarioDto propietarioDto2 = new PropietarioDto();
				System.out.println("Introduzca el nuevo dni");
				propietarioDto2.setId(crearIdPropietario());
				propietarioDto2.setDni(sc.next());
				propietarioDto2.setFchCompra(fechaHoyDate);
				
				
			}
			
		}
		
		}while(!existe);
		try {
		FileWriter fw= new FileWriter(Inicio.RUTAFICHERODTOS);
		
		for(PropietarioDto propietarioDto : Inicio.LISTA_PROPIETARIO_DTOS) {
			
			datoString = propietarioDto.toString(":");
			
		}
for(VehiculoDto vehiculo : Inicio.LI_VEHICULO_DTOS) {
			
			datoString2 = vehiculo.toString(":");
			
		}
		
		fw.write(datoString2.concat(datoString).concat(" /n"));
		fw.close();
		}catch(IOException io) {
			
			fi.escribirFicheroLog("Se ha producido un error: ".concat(io.getMessage()));
			System.out.println("Se ha producido un error, intentelo más tarde");
		}
		
	}
	/** Metodo que se encarga de generar un id a propietarioDto */
	private long crearIdPropietario() {
		long nuevoId ;
		int tamanioLista = Inicio.LISTA_PROPIETARIO_DTOS.size();
		
		if(tamanioLista < 100) {
			
			nuevoId =  Inicio.LISTA_PROPIETARIO_DTOS.get(tamanioLista -1).getId() -1;
			
			
		}
		else {
			
			
			nuevoId = 100;
		}
		return nuevoId;
		
	}
}
