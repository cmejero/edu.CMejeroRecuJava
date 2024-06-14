package servicios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import controladores.Inicio;
import dtos.PropietarioDto;
import dtos.VehiculoDto;
/** Clase que implementa a fichero interfaz */
public class FicheroImplementacion implements FicheroInterfaz {

	
	public void escribirFicheroLog(String mensaje) {
		
		FileWriter fWriter = null;
		
		try {
			fWriter = new FileWriter(Inicio.RUTAFICHEROLOG , true);
			fWriter.write(mensaje.concat(" \n"));
			
			
			
			fWriter.close();
			
		}catch (Exception e) {
			System.out.println("Se ha producido un error, intentelo más tarde");
		}
		
		
	}
	
	public void leerFichero() {
		
		try {
			
			
			File archivo = new File(Inicio.RUTAFICHERODTOS);
			BufferedReader bf = new BufferedReader(new FileReader(archivo));
			
			String lineas = "";
			
			while((lineas = bf.readLine()) != null) {
				
				String[] lineaString = lineas.split(":");
				
				Long nuevoId = crearIdVehiculo();
				String matriculaString = lineaString[0].trim();
				String fechaMaString =lineaString[1].trim();
				DateTimeFormatter formato= DateTimeFormatter.ofPattern("dd-MM-yyyy");
				LocalDateTime fechaDate= LocalDateTime.parse(fechaMaString,formato);
				
				VehiculoDto vehiculoDto= new VehiculoDto(nuevoId, matriculaString, fechaDate);
				
						Inicio.LI_VEHICULO_DTOS.add(vehiculoDto);
				
				
						PropietarioDto propietarioDto= new PropietarioDto();
				
				propietarioDto.setId(crearIdPropietario());
				propietarioDto.setDni(lineaString[2].trim());
				String fechaC= lineaString[3].trim();
				DateTimeFormatter formato2= DateTimeFormatter.ofPattern("dd-MM-yyyy");
				LocalDate fechaCompra = LocalDate.parse(fechaC, formato2);
				propietarioDto.setFchCompra(fechaCompra);
				propietarioDto.setMatriculaString(lineaString[0].trim());
				
				LocalDateTime fechaHoyDate = LocalDateTime.now();
				DateTimeFormatter formato3= DateTimeFormatter.ofPattern("dd-MM-yyyy");
				String fechaString3 = fechaHoyDate.format(formato3);
				LocalDateTime fechaActuaLocalDate = LocalDateTime.parse(fechaString3,formato3);
				
				
				
				
				Inicio.LISTA_PROPIETARIO_DTOS.add(propietarioDto);
				
			}
			
			
			
		}catch(IOException io) {
			
			
			
		}
		
		
		
		
		
	}
	/** Metodo que se encarga de generar un id a vehiculosDto */
	private long crearIdVehiculo() {
		long nuevoId ;
		int tamanioLista = Inicio.LI_VEHICULO_DTOS.size();
		
		if(tamanioLista < 100) {
			
			nuevoId = Inicio.LI_VEHICULO_DTOS.get(tamanioLista -1).getId() -1;
			
			
		}
		else {
			
			
			nuevoId = 100;
		}
		return nuevoId;
		
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
