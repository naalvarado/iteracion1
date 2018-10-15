package Negocio;

import java.util.ArrayList;

public class ReordenBodega {
	
	private Long ID_Producto;
	private int nivelReorden;
	
	private BodegaPerecedero bodegaP;
	private BodegaNoPerecedero bodegaNoP;
	private ArrayList<Perecedero> productosP;
	private ArrayList<NoPerecedero> productosNoP;
	
	// Constructor para un producto perecedero
	public ReordenBodega(Long pID, int pNivelR, BodegaPerecedero pBodega) {
		this.ID_Producto = pID;
		this.nivelReorden  = pNivelR;
		this.bodegaP = pBodega;
		this.productosP = new ArrayList<>(); 
		this.bodegaNoP = null;
	}
	// Constructor para un producto NO perecedero
	public ReordenBodega(Long pID, int pNivelR, BodegaNoPerecedero pBodega) {
		this.ID_Producto = pID;
		this.nivelReorden  = pNivelR;
		this.bodegaNoP = pBodega;
		this.productosNoP = new ArrayList<>(); 
		this.productosP = null;
	}
	
	public Long getIdProducto() {
		return ID_Producto;
	}
	
	public int getNivelReorden() {
		return nivelReorden;
	}
	
	public int getCantidadProductos() {
		if(productosP == null) {
			return productosNoP.size();
		}
		else {
			return productosP.size();
		}
	}
	
	public void setIdProducto(Long pID) {
		this.ID_Producto = pID;
	}
	
	public void setNivelReorden(int pNivel) {
		this.nivelReorden = pNivel;
	}
	
	public void addPerecedero(Perecedero pProducto) {
		if(productosP != null) {
			productosP.add(pProducto);
		}
	}
	
	public void addNoPerecedero(NoPerecedero pProducto) {
		if(productosNoP != null) {
			productosNoP.add(pProducto);
		}
	}
	
	public void removePerecedero(Perecedero pPro) {
		if(productosP != null) {
			productosP.remove(pPro);
		}
		checkReorden();
	}
	
	public void removeNoPerecedero(NoPerecedero pPro) {
		if(productosNoP != null) {
			productosNoP.remove(pPro);
		}
		checkReorden();
	}
	
	private void checkReorden() {
		if(productosP != null) {
			if(productosP.size() <= nivelReorden) {
				// TODO llamar metodo en bodega
			}
		}
		else {
			if(productosNoP.size() <= nivelReorden) {
				// TODO
			}
		}
	}

}
