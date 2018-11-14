package Negocio;

public class Estante {
	
	long id;
	long local;
	double volumen;
	double maxPeso;
	
	public Estante(long id, long local, double volumen, double maxPeso) {
		super();
		this.id = id;
		this.local = local;
		this.volumen = volumen;
		this.maxPeso = maxPeso;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getLocal() {
		return local;
	}

	public void setLocal(long local) {
		this.local = local;
	}

	public double getVolumen() {
		return volumen;
	}

	public void setVolumen(double volumen) {
		this.volumen = volumen;
	}

	public double getMaxPeso() {
		return maxPeso;
	}

	public void setMaxPeso(double maxPeso) {
		this.maxPeso = maxPeso;
	}
	
}
