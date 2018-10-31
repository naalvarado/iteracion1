package Negocio;

import java.util.ArrayList;

public class Proveedor {
	
	private int NIT;
	private String nombre;
	
	private ArrayList<SuperMercado> supermercados;
	private ArrayList<Pedido> pedidos;
	private ArrayList<Producto> productos;
	
	public Proveedor(int pNIT, String pnombre) {
		this.NIT = pNIT;
		this.nombre = pnombre;
		this.supermercados = new ArrayList<>();
		this.pedidos = new ArrayList<>();
		this.productos = new ArrayList<>();
	}
	
	public int datNIT() {
		return NIT;
	}
	
	public String darNombre() {
		return nombre;
	}
	
	public ArrayList<SuperMercado> getSupermercados(){
		return supermercados;
	}
	
	public ArrayList<Pedido> getPedidos(){
		return pedidos;
	}
	
	public ArrayList<Producto> getProductos(){
		return productos;
	}
	
	public void setNIT(int pNIT) {
		this.NIT = pNIT;
	}
	
	public void setNombre(String pNombre) {
		this.nombre = pNombre;
	}

}
