package dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/** Clase que se encarga de la plantilla de los datos de vehiculos */
public class VehiculoDto {

	long id;
	String matricula ="aaaaa";
	LocalDateTime fchMatriculacion = LocalDateTime.of(1999, 1, 31,0,0,0);
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMatriculaString() {
		return matricula;
	}
	public void setMatriculaString(String matriculaString) {
		this.matricula = matriculaString;
	}
	public LocalDateTime getFchMatriculacion() {
		return fchMatriculacion;
	}
	public void setFchMatriculacion(LocalDateTime fchMatriculacion) {
		this.fchMatriculacion = fchMatriculacion;
	}
	public VehiculoDto(long id, String matriculaString, LocalDateTime fchMatriculacion) {
		super();
		this.id = id;
		this.matricula = matriculaString;
		this.fchMatriculacion = fchMatriculacion;
	}
	
	
	
	@Override
	public String toString() {
		return "VehiculoDto [id=" + id + ", matriculaString=" + matricula + ", fchMatriculacion="
				+ fchMatriculacion + "]";
	}
	
	
	public String toString(String caracter) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String fechaString = fchMatriculacion.format(formatter);
		
		String toString = getMatriculaString().concat(caracter).concat(fechaString).concat(caracter);
		return fechaString;
	}
	
	

	
	
	
}
