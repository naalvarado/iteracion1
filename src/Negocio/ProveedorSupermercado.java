package Negocio;

public class ProveedorSupermercado {
	
	long idProveedor;
	long idSupermercado;
	
	public ProveedorSupermercado(long pIdPro, long pIdSup) {
		this.idProveedor = pIdPro;
		this.idSupermercado = pIdSup;
	}
	
	public long getIdProveedor() {
		return this.idProveedor;
	}
	
	public long getIdSupermercado() {
		return this.idSupermercado;
	}
	
	public void setIdProveedor(long id) {
		this.idProveedor = id;
	}
	
	public void setIdSupermercado(long id) {
		this.idSupermercado = id;
	}

}
