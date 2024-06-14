package utiles;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/** Clase que se encarga de los metodos que se van a usar mas de una vez en nuestra aplicacion */
public  class util {

	/** metodo que se encarga de crear nel nombre de fichero log */
	public static final String nombreFicheroLog() {
		
		String nombreRuta = "";
		try {
		LocalDate fecha = LocalDate.now();
		
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("ddMMyyyy");
		
		String fechaHoy = fecha.format(formato);
		
		nombreRuta = "log-".concat(fechaHoy).concat(".txt");
		
		
		
		}catch(Exception e) {
			
			System.out.println("Se ha producido un error, intentelo más tarde");
			
			
		}
		return nombreRuta;
		
	}
	
}
