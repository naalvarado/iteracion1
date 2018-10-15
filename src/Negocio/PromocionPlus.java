package Negocio;

import java.util.Date;

public class PromocionPlus implements Promocion{

	private long id;
	
	private String nombre;
	
	private final static Integer tipo = 1;
	
	private String descripcion;
	
	private Date fechaInicio;
	
	private Date fechaFin;

	private Integer unidadesVendidas;
	
	private Integer unidadesPagadas; 
	
	private Integer estado;
	
    public PromocionPlus() {
		
	}
	
    public PromocionPlus(long id, String nombre, String descripcion, Date fechaInicio, Date fechaFin)
    {
    	this.id = id;
    	this.descripcion = descripcion;
    	this.nombre = nombre;
    	this.fechaInicio = fechaInicio;
    	this.fechaFin = fechaFin;
    }
    
	@Override
	public long getId() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return nombre;
	}

	@Override
	public void setNombre(String nombre) {
		// TODO Auto-generated method stub
		this.nombre = nombre;
	}

	@Override
	public Integer getTipo() {
		// TODO Auto-generated method stub
		return tipo;
	}

	@Override
	public void setTipo(Integer tipo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getDescripcion() {
		// TODO Auto-generated method stub
		return descripcion;
	}

	@Override
	public void setDescripcion(String descripcion) {
		// TODO Auto-generated method stub
		this.descripcion = descripcion;
	}

	@Override
	public Date getFechaInicio() {
		// TODO Auto-generated method stub
		return fechaInicio;
	}

	@Override
	public void setFechaInicio(Date incio) {
		// TODO Auto-generated method stub
		this.fechaInicio = incio;
	}

	@Override
	public Date getFechaFinal() {
		// TODO Auto-generated method stub
		return fechaFin;
	}

	@Override
	public void setFechaFinal(Date fina) {
		// TODO Auto-generated method stub
		this.fechaFin = fina;
	}

	public Integer getUnidadesVendidas() {
		return unidadesVendidas;
	}

	public void setUnidadesVendidas(Integer unidadesVendidas) {
		this.unidadesVendidas = unidadesVendidas;
	}

	public Integer getUnidadesPagadas() {
		return unidadesPagadas;
	}

	public void setUnidadesPagadas(Integer unidadesPagadas) {
		this.unidadesPagadas = unidadesPagadas;
	}

	@Override
	public Integer getEstado() {
		// TODO Auto-generated method stub
		return estado;
	}

}
