package com.adrian.pruebas.jpa;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Principal {

	static Scanner cin = new Scanner(System.in);

	public static Articulo generarArticulo() throws Exception {
		Articulo articulo = new Articulo();
		
		System.out.print("Introduzca el nombre del artículo comprado: ");
		articulo.setDescripcion(cin.nextLine());
		
		System.out.print("Introduzca el stock de dicho artículo: ");
		articulo.setStock(cin.nextInt());
		
		System.out.print("Introduzca el precio del artículo: ");
		articulo.setPrecio(cin.nextDouble());
		
		return articulo;
	}

	public static Cliente generarCliente() throws Exception {
		Cliente cliente=new Cliente();
		
		System.out.print("Introduzca el DNI del cliente: ");
		cliente.setDni(cin.nextLine());
		
		System.out.print("Introduzca el nombre del cliente: ");
		cliente.setNombre(cin.nextLine());
		
		System.out.print("Introduzca los apellidos del cliente: ");
		cliente.setApellidos(cin.nextLine());
		
		System.out.print("Introduzca el teléfono del cliente: ");
		cliente.setTelefono(cin.nextInt());
		cliente.setDireccion(generarDireccion());
		
		return cliente;
	}

	public static Direccion generarDireccion() throws Exception {
		Direccion direccion=new Direccion();
		// TODO
		System.out.print("Introduzca el nombre de la calle del cliente: ");
		direccion.setCalle(cin.nextLine());
		
		System.out.print("Introduzca el número de la calle: ");
		direccion.setNumero(cin.nextShort());
		
		System.out.print("Introduzca la localidad de residencia: ");
		direccion.setLocalidad(cin.nextLine());
		
		System.out.print("Introduzca el código postal de dicha ciudad: ");
		direccion.setCodPostal(cin.nextShort());
		
		System.out.print("Introduzca la provincia de dicha ciudad: ");
		direccion.setProvincia(cin.nextLine());
		
		return direccion;
	}

	public static Venta generarVenta() throws Exception {
		Venta venta=new Venta();
		// TODO
		venta.setArticulo(generarArticulo());
		venta.setCliente(generarCliente());
		
		return venta;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("PruebaPersistencia");
		EntityManager em=emf.createEntityManager();
		EntityTransaction tx=em.getTransaction();
		
		try {
			Venta venta=generarVenta();
			tx.begin();
			
			em.persist(venta);
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("Error a la hora de ejecutar");
			tx.rollback();
		} finally{
			em.close();
			emf.close();
		}
	}

}
