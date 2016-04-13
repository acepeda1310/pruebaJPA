package com.adrian.pruebas.jpa;

import java.io.Serializable;
import javax.persistence.*;
import static javax.persistence.CascadeType.ALL;

/**
 * Entity implementation class for Entity: Venta
 *
 */
@Entity
@Table(name="VENTAS")
public class Venta implements Serializable {

	@Id
	@GeneratedValue
	private Long id;
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Articulo articulo;
	@ManyToOne(cascade = ALL)
	private Cliente cliente;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Articulo getArticulo() {
		return articulo;
	}

	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	private static final long serialVersionUID = 1L;

	public Venta() {
		super();
	}
   
}
