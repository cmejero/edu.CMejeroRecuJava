package dtos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/** Clase que se encarga de la plantilla de los Datos de propietario*/
public class PropietarioDto {

	long id;
	String dni = "aaaaa";
	LocalDate fchCompra = LocalDate.of(1999, 1, 31);
	String matricula = "aaaaa";
	boolean esHistorico = false;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public LocalDate getFchCompra() {
		return fchCompra;
	}

	public void setFchCompra(LocalDate fchCompra) {
		this.fchCompra = fchCompra;
	}

	public String getMatriculaString() {
		return matricula;
	}

	public void setMatriculaString(String matriculaString) {
		this.matricula = matriculaString;
	}

	public boolean isEsHistorico() {
		return esHistorico;
	}

	public void setEsHistorico(boolean esHistorico) {
		this.esHistorico = esHistorico;
	}

	public PropietarioDto() {
		super();
	}

	@Override
	public String toString() {

		String toString = "[VEH] ".concat(matricula).concat("[PRO] ".concat(getDni()));
		return toString;

	}

	public String toString(String caracter) {
		
		DateTimeFormatter formatoDateTimeFormatter= DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String fechaString = getFchCompra().format(formatoDateTimeFormatter);

		String toString = getDni().concat(caracter).concat(caracter).concat(fechaString);
		return toString;

	}

}
