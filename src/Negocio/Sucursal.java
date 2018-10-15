package Negocio;



public class Sucursal {

	private SuperMercado superM;
	/**
	 * Nombre de la sucursal
	 */
	private String nombre;
	/**
	 * Direccion de la sucursal
	 */
	private String direcccion;
	/**
	 * Ciudad de la sucursal
	 */
	private String ciudad;
	/**
	 * Retorna el nombre de la sucursal
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Modifica el nombre de la sucursal
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Retorna la direccion de la sucursal
	 */
	public String getDirecccion() {
		return direcccion;
	}
	/**
	 * Modifica la direccion de la sucursal
	 */
	public void setDirecccion(String direcccion) {
		this.direcccion = direcccion;
	}
	/**
	 * Retorna la ciudad de la sucursal
	 */
	public String getCiudad() {
		return ciudad;
	}
	/**
	 * Modifica la ciudad de la sucursal
	 */
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	/**
	 * Constructor vacio
	 */
	public Sucursal()
	{
		
	}
	/**
	 * Constructor completo de la sucursal
	 */
	public Sucursal(SuperMercado superM, String nombre,String ciudad, String pDireccion) {
		
		this.superM = superM;
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.direcccion = pDireccion;
	}
	/**
	 * Retorna el super mercado al que pertenece
	 */
	public SuperMercado getSuperM() {
		return superM;
	}
	/**
	 * Modifica la el super mercado al que pertenece
	 */
	public void setSuperM(SuperMercado superM) {
		this.superM = superM;
	}
}
