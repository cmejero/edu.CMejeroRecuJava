package servicios;
/** CLase que se encarga de los metodos relacionados con ficheros */
public interface FicheroInterfaz {
	
	
/** Metodo que se encarga de escribir en fichero log */
	public void escribirFicheroLog(String mensaje);
	
	/**Metodo que se encarga de leer un fichero*/
	public void leerFichero();
}
