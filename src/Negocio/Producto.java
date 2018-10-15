package Negocio;

public interface Producto {

	/**
	 * ID 
	 */
	public long geTID();
	/**
	 * ID del estante o bodega en la que se encuentra el producto
	 */
	public long getUbicacion();
	
	/**
	 * ID del estante o bodega en la que se encuentra el producto
	 */
	public void setUbicacion(long ID);
	/**
	 * Da la categoria del producto: 1. Perecedero, 2. No perecedero. 3 Abarrotes
	 */
	public Integer getCategoria();
	/**
	 * Nombre del producto
	 */
	public String getNombre();
	/**
	 * Marca del producto
	 */
	public String getMarca();
	/**
	 *Modificar el nombre del producto
	 */
	public void setNombre(String pNombre);
	/**
	 * Modificar la marca del producto
	 */
	public void setMarca(String pMarca);
	
	/**
	 * Precio por unidad del producto
	 */
	public double getPrecioUnitario();
	
	/**
	 * La presentacion del producto
	 */
	public String getPrecentacion();
	/**
	 * Modifica el precio por unidad
	 */
	public void setPrecioUnitario(double pPresentacion);
	/**
	 * Retorna el precio por el peso del producto
	 */
	public double getPrecioUnidadMedida();
	/**
	 * Modifica el precio por unidad de medida
	 */
	public void setPrecioUnidadMedida(double pPrecio);
	/**
	 * Da la cantidad de la presentacion
	 */
	public String getCantidadPresentacion();
	/**
	 * Modifica la cantidad de la presentacion
	 */
	public void setCantidadPresentacion();
	/**
	 * Retorna el volumen en cm3 del paquete
	 */
	public double getVolumenPaquete();
	/**
	 * Modifica el volumen del paquete 
	 */
	public void setVolumenPaquete(double pVolumen);
	/**
	 * Retorna el codigo de barras del producto, el cual es un hexadecimal
	 */
	public String getCodigo();
	/**
	 * Modifica el codigo de barras del producto, el cual es un hexadecimal
	 */
	public void setCodigo(String pCodigo);
	/**
	 * Modifica la Precentacion del producto
	 */
	public void setPresentacion(String pPresentacion);
	
}