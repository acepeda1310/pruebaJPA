package com.adrian.pruebas.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Direccion
 *
 */
@Entity
@Table(name="DIRECCIONES") 
public class Direccion implements Serializable {
	
	@Id
	@GeneratedValue
	private Long id;
	private String calle;
	private short numero;
	private String localidad;
	private short codPostal;
	private String provincia;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public short getNumero() {
		return numero;
	}

	public void setNumero(short numero) {
		this.numero = numero;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public short getCodPostal() {
		return codPostal;
	}

	public void setCodPostal(short codPostal) {
		this.codPostal = codPostal;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	private static final long serialVersionUID = 1L;

	public Direccion() {
		super();
	}
   
}
