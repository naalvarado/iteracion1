package Negocio;

import java.util.Date;

public interface Promocion {

	public long getId();	
	
	public String getNombre();
	
	public void setNombre(String nombre);
	
	public Integer getTipo();
	
	public void setTipo(Integer tipo);
	
	public String getDescripcion();
	
	public void setDescripcion(String descripcion);
	
	public Date getFechaInicio();
	
	public void setFechaInicio(Date incio);
	
	public Date getFechaFinal();
	
	public void setFechaFinal(Date fina);
	
	public Integer getEstado();
	
	
}
