package Negocio;

import java.util.ArrayList;

public class LocalVenta {
	
	private long id;
	private String direccion;
	
	private Sucursal sucursal;
	private ArrayList<Venta> ventas;
	private ArrayList<EstantePerecedero> estantesPerecedero;
	private ArrayList<EstanteNoPerecedero> estantesNoPerecederos;
	
	public LocalVenta(String pDireccion, Sucursal pSucursal){
		this.direccion = pDireccion;
		this.sucursal = pSucursal;
		ventas = new ArrayList<>();
		estantesPerecedero = new ArrayList<>();
		estantesNoPerecederos = new ArrayList<>();
	}
	
	public LocalVenta(long pID, String pDireccion) {
		this.id = pID;
		this.direccion = pDireccion;
		ventas = new ArrayList<>();
		estantesPerecedero = new ArrayList<>();
		estantesNoPerecederos = new ArrayList<>();
	}
	
	public long getID() {
		return id;
	}
	
	public String getDireccion(){
		return direccion;
	}
	
	public Sucursal getSucursal(){
		return sucursal;
	}
	
	public ArrayList<Venta> getVentas(){
		return ventas;
	}
	
	public ArrayList<EstantePerecedero> getEstantesP(){
		return estantesPerecedero;
	}
	
	public ArrayList<EstanteNoPerecedero> getEstantesNoP(){
		return estantesNoPerecederos;
	}
	
	public void setDireccion(String pDir){
		this.direccion = pDir;
	}
	
	public void setSucursal(Sucursal su){
		this.sucursal = su;
	}
	
	public void setEstantesP(ArrayList<EstantePerecedero> pEstP){
		this.estantesPerecedero = pEstP;
	}
	
	public void setEstantesNoP(ArrayList<EstanteNoPerecedero> pEstNoP){
		this.estantesNoPerecederos = pEstNoP;
	}
	
	private Producto searchProducto(Producto p){
		//TODO
		return null;
	}
	
	public void vender(Producto p, int c){
		//TODO 
	}

}
