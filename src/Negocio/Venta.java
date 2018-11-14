package Negocio;

import java.util.Date;

public class Venta {
	
	private long ID_Producto;
	private Date fecha;
	private long id;
	private long local;
	private long consumidor;
	
    

	
	public Venta(long pID, Date pFecha, long pProducto, long pLocal) {
		this.id = pID;
		this.fecha = pFecha;
		this.ID_Producto = pProducto;
		this.local = pLocal;
	}

	public Long getIdProducto() {
		return ID_Producto;
	}
	
	public Date getFecha() {
		return fecha;
	}
	
	public long getLocal() {
		return local;
	}
	
	public long getId() {
		return id;
	}
	
	public void setProducto(Long ID) {
		this.ID_Producto = ID;
	}
	
	public void setFecha(Date pFecha) {
		this.fecha = pFecha;
	}
	
	public String toString() {
		String re = "Producto: "+ID_Producto+" Fecha: "+fecha;
		return re;
	}

}
