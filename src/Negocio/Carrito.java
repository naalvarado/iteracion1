package Negocio;

import java.util.ArrayList;

public class Carrito {
	
	private long ID;
	private Consumidor consumidor;
	
	private ArrayList<Producto> productos;
	
	public Carrito(long pId) {
		this.ID = pId;
		consumidor = null;
		this.productos = new ArrayList<>();
	}
	
	public long getId() {
		return ID;
	}
	
	public Consumidor getConsumidor() {
		return consumidor;
	}
	
	public ArrayList<Producto> getProductos(){
		return productos;
	}
	
	public void setConsumidor(Consumidor c) {
		consumidor = c;
	}
	
	public void addProducto(Producto p) {
		productos.add(p);
	}

}
