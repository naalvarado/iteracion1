package Negocio;

import java.sql.Timestamp;

public interface VOProducto {
	
	public long getID();
	public long getSucursal();
	public long getBodega();
	public long getEstante();
	public String getNombre();
	public String getCodigo();
	public String getMarca();
	public String getPresentacion();
	public int getCantidad();
	public int getVolumen();
	public int getCalificacion();
	public Timestamp getFechaVencimiento();
	public double getPrecioUnidad();
	public String getTipo();
	public String getSubTipo();

}
