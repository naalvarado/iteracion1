package Negocio;

import java.sql.Timestamp;


public class Perecedero implements Producto {

	private long ID;
	/**
	 * ID  del estante o bodega en el que esta
	 */
	private long ubicacion;
	/**
	 * Contante de la categoria del producto 
	 */
	private final static Integer CATEGORIA =1;
	/**
	 * Nombre del producto
	 */	
	private String nombre;
	/**
	 * Marca del producto
	 */
	private String marca;
	/**
	 * Codigo de barras del producto
	 */
	private String codigo;
	
	/**
	 * Presentacion del producto
	 */
	private String presentacion;
	
	/**
	 * Precio por unidad
	 */
	private double precioUnitario;
	/**
	 * Precio po unidad de medida
	 */
	private double precionUnidadMedida;
	
	/**
	 * Volumen del producto en cm3
	 */
	
	private double volumen;
	/**
	 * La fecha de la visita
	 */
	private Timestamp fechaVencimiento;
	/**
	 * Constructor vacio
	 */
	public Perecedero()
	{
		
	}
	/**
	 * Constuctor completo del producto
	 */
	public Perecedero(long iD,long pID,String nombre,Timestamp fecha, String marca, double pPrecioUnidadMedida, double pPrecioUnitario, String pPresentacion, double pVolumen)
	{
		this.ubicacion = pID;
		this.nombre = nombre;
		this.fechaVencimiento = fecha;
		this.marca = marca;
		this.precionUnidadMedida =pPrecioUnidadMedida;
		this.precioUnitario = pPrecioUnitario;
		this.presentacion = pPresentacion;
		this.volumen = pVolumen;
		this.ID = iD;
	}
	/**
	 * Constuctor basico 
	 */
	public Perecedero(long iD, String nombre)
	{
		this.ID = iD;
		this.nombre = nombre;
	}
	
	
	@Override
	public Integer getCategoria() {
		return CATEGORIA;
	}

	@Override
	public String getNombre() {
		return nombre;
	}

	@Override
	public String getMarca() {
		return marca;
	}

	@Override
	public void setNombre(String pNombre) {
		this.nombre = pNombre;
		
	}

	@Override
	public void setMarca(String pMarca) {
		this.marca = pMarca;
	}

	@Override
	public double getPrecioUnitario() {
		return precioUnitario;
	}

	@Override
	public String getPrecentacion() {
		return presentacion;
	}

	@Override
	public void setPrecioUnitario(double pPresentacion) {
		this.precioUnitario = pPresentacion;
		
	}

	@Override
	public double getPrecioUnidadMedida() {
		return precionUnidadMedida;
	}

	@Override
	public void setPrecioUnidadMedida(double pPrecio) {
		this.precionUnidadMedida = pPrecio;
		
	}

	@Override
	public String getCantidadPresentacion() {
		return null;
	}

	@Override
	public void setCantidadPresentacion() {
		
	}

	@Override
	public double getVolumenPaquete() {
		return volumen;
	}

	@Override
	public void setVolumenPaquete(double pVolumen) {
		this.volumen=pVolumen;
	}

	@Override
	public String getCodigo() {
		return codigo;
	}

	@Override
	public void setCodigo(String pCodigo) {
		this.codigo = pCodigo;
	}

	@Override
	public void setPresentacion(String pPresentacion) {
		this.presentacion = pPresentacion;
	}
	@Override
	public long getUbicacion() {
		return ubicacion;
	}
	@Override
	public void setUbicacion(long ID) {
		 this.ubicacion = ID;
	}
	public Timestamp getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(Timestamp fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	@Override
	public long geTID() {
		// TODO Auto-generated method stub
		return ID;
	}

}
