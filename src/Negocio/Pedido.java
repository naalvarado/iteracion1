package Negocio;


import java.util.Date;

public class Pedido {
	
	private long id;
	private int cantidad;
	private double prescioAcordado;
	private Date fechaEntrega;
	private boolean estregada;
	private String nomProducto;
	
	
	private Sucursal sucursal;
	private Proveedor pro;
	
	public Pedido(int pCantidad, double pPre, Date pFecha, Sucursal pSu, Proveedor pPro){
		this.cantidad = pCantidad;
		this.prescioAcordado = pPre;
		this.fechaEntrega = pFecha;
		this.estregada = false;
		this.sucursal = pSu;
		this.pro = pPro;
	}
	public Pedido(long idProveedor,String nombreP ,Integer cat, boolean estado)
	{
		this.id = idProveedor;
		this.cantidad = cat;
		this.estregada = estado;
		this.nomProducto = nombreP;
	}
	
	public int getCantidad() {
		return cantidad;
	}
	
	public Date getDate() {
		return fechaEntrega;
	}
	
	public boolean getEntregada() {
		return estregada;
	}
	
	public Sucursal getSucursal() {
		return sucursal;
	}
	
	public Proveedor getProveedor() {
		return pro;
	}
	
	public void setCantidad(int pCant) {
		this.cantidad = pCant;
	}
	
	public void setPrecio(double pPrecio) {
		this.prescioAcordado = pPrecio;
	}
	
	public void setFecha(Date pFecha) {
		this.fechaEntrega = pFecha;
	}
	
	public void setEntregada(boolean pEntregada) {
		this.estregada = pEntregada;
	}
	
	public void setSucursal(Sucursal pSu) {
		this.sucursal = pSu;
	}
	
	public void setProveedor(Proveedor pPro) {
		this.pro = pPro;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
