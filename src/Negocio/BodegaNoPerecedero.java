package Negocio;

public class BodegaNoPerecedero implements Bodega{

	/**
	 * La categoria a la que pertence la bodega
	 */
	private Sucursal sucursal;
	/**
	 * Categoria de la bodega la cual es 2 que indica que es de no perecederos
	 */
	private final static Integer CATEGORIA = 2;
	/**
	 * El volumen en cm3 de la bodega
	 */
	private Integer tipo;
	
	/**
	 * El volumen en cm3 de la bodega
	 */
	private double volumen;
	/**
	 * El peso maximo de capacidad
	 */
	private double maxPeso;
	
	/**
	 * Constructor
	 */
	public BodegaNoPerecedero(double pVol, double pMaxPeso) {
		
		this.volumen = pVol;
		this.maxPeso = pMaxPeso;
	}
	/**
	 *Contuctor vacio
	 */
	public BodegaNoPerecedero() {
		
	}
	
	
	@Override
	public Integer getCategoria() {
		return CATEGORIA;
	}

	@Override
	public double getVolumen() {
		return volumen;
	}

	@Override
	public double maxPeso() {
		return maxPeso;
	}

	@Override
	public void setVolumen(double pVolm) {
		this.volumen = pVolm;
	}

	@Override
	public void setMaxPeso(double pMaxPeso) {
		this.maxPeso = pMaxPeso;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}
	@Override
	public Sucursal getSucursal() {
		return sucursal;
	}
	@Override
	public void setSucursal(Sucursal suc) {
		this.sucursal= suc;
	}

}
