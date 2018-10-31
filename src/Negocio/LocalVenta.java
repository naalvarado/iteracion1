package Negocio;

import java.util.ArrayList;

public class LocalVenta {
	
	private long id;
	private String direccion;
	
	private Sucursal sucursal;
	private ArrayList<Venta> ventas;
	private ArrayList<Estante> estantes;
	
	public LocalVenta(String pDireccion, Sucursal pSucursal){
		this.direccion = pDireccion;
		this.sucursal = pSucursal;
		ventas = new ArrayList<>();
		estantes = new ArrayList<>();
	}
	
	public LocalVenta(long pID, String pDireccion) {
		this.id = pID;
		this.direccion = pDireccion;
		ventas = new ArrayList<>();
		estantes = new ArrayList<>();
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
	
	public ArrayList<Estante> getEstantes(){
		return estantes;
	}
	
	public void setDireccion(String pDir){
		this.direccion = pDir;
	}
	
	public void setSucursal(Sucursal su){
		this.sucursal = su;
	}
	
	public void setEstantesP(ArrayList<Estante> pEst){
		this.estantes = pEst;
	}
	
	private Producto searchProducto(Producto p){
		//TODO this
		return null;
	}
	
	public void vender(Producto p, int c){
		//TODO this
	}

}
