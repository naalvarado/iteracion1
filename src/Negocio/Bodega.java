package Negocio;

public interface Bodega {

	/**
	 * Sucursal a la que pertenece 
	 */
	public Sucursal getSucursal();
	
	/**
	 * Sucursal a la que pertenece 
	 */
	public void setSucursal(Sucursal suc);
	/**
	 * La categoria a la que pertence la bodega
	 */
	public Integer getCategoria();
	
	/**
	 * El volumen de espacio que tiene de capacidad la bodega
	 */
	public double getVolumen();
	
	/**
	 * El peso maximo que puede tener la bodega
	 */
	public double maxPeso();
	/**
	 * Modifica la el volumen de la bodega
	 */
	public void setVolumen(double pVolm);
	/**
	 * Modifica la el peso maximo de la bodega
	 */
	public void setMaxPeso(double pMaxPeso);
}
