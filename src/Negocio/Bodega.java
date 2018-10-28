package Negocio;

public class Bodega {
	
	private long id;
	private long idSucursal;
	private String tipo;
	private int volumen;
	private int maxPeso;
	
	public Bodega(long pId, long pIdS, String pTipo, int pVol, int pMaxP) {
		this.id = pId;
		this.idSucursal = pIdS;
		this.tipo = pTipo;
		this.volumen = pVol;
		this.maxPeso = pMaxP;
	}
	
	public long getId() {
		return id;
	}
	
	public long gatIdSucursal() {
		return idSucursal;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public int getVolumen() {
		return volumen;
	}
	
	public int gatMaxPeso() {
		return maxPeso;
	}

}
