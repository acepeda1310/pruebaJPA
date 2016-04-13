package com.adrian.pruebas.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Cliente
 *
 */
@Entity
@Table(name="CLIENTES") 
public class Cliente implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	private String dni;
	private String nombre;
	private String apellidos;
	@OneToOne(cascade=CascadeType.PERSIST)
	private Direccion direccion;
	private int telefono;

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public Cliente() {
		super();
	}
   
}
