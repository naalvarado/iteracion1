package Negocio;

import java.util.ArrayList;

public class Proveedor {
	
	private int NIT;
	private String nombre;
	
	private ArrayList<SuperMercado> supermercados;
	private ArrayList<Pedido> pedidos;
	private ArrayList<Perecedero> productosPerecederos;
	private ArrayList<NoPerecedero> productosNoPerecederos;
	private ArrayList<Abarrote> abarrotes;
	
	public Proveedor(int pNIT, String pnombre) {
		this.NIT = pNIT;
		this.nombre = pnombre;
		this.supermercados = new ArrayList<>();
		this.pedidos = new ArrayList<>();
		this.productosPerecederos = new ArrayList<>();
		this.productosNoPerecederos = new ArrayList<>();
		this.abarrotes = new ArrayList<>();
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
	
	public ArrayList<Perecedero> getProductPerece(){
		return productosPerecederos;
	}
	
	public ArrayList<NoPerecedero> getProducNoPerece(){
		return productosNoPerecederos;
	}
	
	public ArrayList<Abarrote> getAbarrotes(){
		return abarrotes;
	}
	
	public void setNIT(int pNIT) {
		this.NIT = pNIT;
	}
	
	public void setNombre(String pNombre) {
		this.nombre = pNombre;
	}

}
