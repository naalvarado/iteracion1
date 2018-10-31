package Negocio;

import java.util.ArrayList;

public class ReordenBodega {
	
	private Long ID_Producto;
	private int nivelReorden;
	
	private Bodega bodega;
	private ArrayList<Producto> productos;
	
	public ReordenBodega(Long pID, int pNivelR, Bodega pBodega) {
		this.ID_Producto = pID;
		this.nivelReorden  = pNivelR;
		this.bodega = pBodega;
		this.productos = new ArrayList<>(); 
	}
	
	public Long getIdProducto() {
		return ID_Producto;
	}
	
	public int getNivelReorden() {
		return nivelReorden;
	}
	
	public int getCantidadProductos() {
		return productos.size();
	}
	
	public void setIdProducto(Long pID) {
		this.ID_Producto = pID;
	}
	
	public void setNivelReorden(int pNivel) {
		this.nivelReorden = pNivel;
	}
	
	public void addProducto(Producto pProducto) {
		productos.add(pProducto);
	}
	
	public void removeProducto(Producto pPro) {
		productos.remove(pPro);
		checkReorden();
	}
	
	private void checkReorden() {
		if(productos.size() <= nivelReorden) {
			// TODO llamar metodo en bodega
		}
	}

}
