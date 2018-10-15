package Negocio;

import java.util.Date;

public class Venta {
	
	private long ID_Producto;
	private Date fecha;
	
	private LocalVenta local;
	
	private String formaPago;
	
	private Integer valorTotal;
	
    private Integer consumidor;
    

	
	public Venta(long pID, Date pFecha, LocalVenta pLocal) {
		this.ID_Producto = pID;
		this.fecha = pFecha;
		this.local = pLocal;
	}
	public Venta(long pID, Date pFecha, String formaPago, Integer valotTotal, Integer consumidor)
	{
		this.ID_Producto = pID;
		this.fecha = pFecha;
		this.setFormaPago(formaPago);
		this.setValorTotal(valotTotal);
		this.setConsumidor(consumidor);
	}
	public Long getIdProducto() {
		return ID_Producto;
	}
	
	public Date getFecha() {
		return fecha;
	}
	
	public LocalVenta getLocal() {
		return local;
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
	public String getFormaPago() {
		return formaPago;
	}
	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}
	public Integer getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(Integer valorTotal) {
		this.valorTotal = valorTotal;
	}
	public Integer getConsumidor() {
		return consumidor;
	}
	public void setConsumidor(Integer consumidor) {
		this.consumidor = consumidor;
	}

}
