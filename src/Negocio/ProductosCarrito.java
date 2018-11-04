package Negocio;

public class ProductosCarrito {
	
	private long carrito;
	private long producto;
	
	public ProductosCarrito(long pCar, long pPro) {
		this.carrito = pCar;
		this.producto = pPro;
	}
	
	public long getCarrito() {
		return carrito;
	}
	
	public long getProducto() {
		return producto;
	}

}
