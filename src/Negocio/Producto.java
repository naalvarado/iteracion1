package Negocio;

import java.sql.Timestamp;

public class Producto {
	
	private long ID;
	private long sucursal;
	private long bodega;
	private long estante;
	private String nombre;
	private String codigo;
	private String marca;
	private String presentacion;
	private int cantidad;
	private int volumen;
	private int calificacion;
	private Timestamp fechaVencimiento;
	private double precioUnidad;
	private String tipo;
	private String subTipo;
	
	
	public Producto(long iD, String nombre, String codigo, String marca, String presentacion, int cantidad, int volumen,
			int calificacion, Timestamp fechaVencimiento, double precioUnidad, String tipo, String subTipo) {
		ID = iD;
		this.nombre = nombre;
		this.codigo = codigo;
		this.marca = marca;
		this.presentacion = presentacion;
		this.cantidad = cantidad;
		this.volumen = volumen;
		this.calificacion = calificacion;
		this.fechaVencimiento = fechaVencimiento;
		this.precioUnidad = precioUnidad;
		this.tipo = tipo;
		this.subTipo = subTipo;
	}


	public long getID() {
		return ID;
	}


	public long getSucursal() {
		return sucursal;
	}


	public long getBodega() {
		return bodega;
	}


	public long getEstante() {
		return estante;
	}


	public String getNombre() {
		return nombre;
	}


	public String getCodigo() {
		return codigo;
	}


	public String getMarca() {
		return marca;
	}


	public String getPresentacion() {
		return presentacion;
	}


	public int getCantidad() {
		return cantidad;
	}


	public int getVolumen() {
		return volumen;
	}


	public int getCalificacion() {
		return calificacion;
	}


	public Timestamp getFechaVencimiento() {
		return fechaVencimiento;
	}


	public double getPrecioUnidad() {
		return precioUnidad;
	}


	public String getTipo() {
		return tipo;
	}


	public String getSubTipo() {
		return subTipo;
	}
	
	
}
