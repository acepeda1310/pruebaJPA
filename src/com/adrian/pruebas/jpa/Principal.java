package com.adrian.pruebas.jpa;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

public class Principal {

	private static final String PERSISTENCE_UNIT_NAME = "empresa";
	private static EntityManagerFactory factory;

	static Scanner cin = new Scanner(System.in);

	public static Articulo generarArticulo() throws Exception {
		Articulo articulo = new Articulo();

		System.out.print("Introduzca el nombre del artículo comprado: ");
		articulo.setDescripcion(cin.nextLine());

		System.out.print("Introduzca el stock de dicho artículo: ");
		articulo.setStock(Integer.parseInt(cin.nextLine()));

		System.out.print("Introduzca el precio del artículo: ");
		articulo.setPrecio(Double.parseDouble(cin.nextLine()));

		return articulo;
	}

	public static Cliente generarCliente() throws Exception {
		Cliente cliente = new Cliente();

		System.out.print("Introduzca el DNI del cliente: ");
		cliente.setDni(cin.nextLine());

		System.out.print("Introduzca el nombre del cliente: ");
		cliente.setNombre(cin.nextLine());

		System.out.print("Introduzca los apellidos del cliente: ");
		cliente.setApellidos(cin.nextLine());

		System.out.print("Introduzca el teléfono del cliente: ");
		cliente.setTelefono(Integer.parseInt(cin.nextLine()));
		cliente.setDireccion(generarDireccion());

		return cliente;
	}

	public static Direccion generarDireccion() throws Exception {
		Direccion direccion = new Direccion();
		// TODO
		System.out.print("Introduzca el nombre de la calle del cliente: ");
		direccion.setCalle(cin.nextLine());

		System.out.print("Introduzca el número de la calle: ");
		direccion.setNumero(Short.parseShort(cin.nextLine()));

		System.out.print("Introduzca la localidad de residencia: ");
		direccion.setLocalidad(cin.nextLine());

		System.out.print("Introduzca el código postal de dicha ciudad: ");
		direccion.setCodPostal(Short.parseShort(cin.nextLine()));

		System.out.print("Introduzca la provincia de dicha ciudad: ");
		direccion.setProvincia(cin.nextLine());

		return direccion;
	}

	public static Venta generarVenta() throws Exception {
		Venta venta = new Venta();
		// TODO
		venta.setArticulo(generarArticulo());
		venta.setCliente(generarCliente());

		return venta;
	}

	public static void main(String[] args) throws PersistenceException {
		// TODO Auto-generated method stub
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			Venta venta = generarVenta();
			tx.begin();

			em.persist(venta);
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("Error a la hora de ejecutar");
		}
		// finally{
		em.close();
		factory.close();
		// }
	}

}
