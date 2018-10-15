package Negocio;

public class SuperMercado {
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El identificador ÚNICO de los bares
	 */
	private long id;
	
	/**
	 * El nombre del bar
	 */
	private String nombre;
	
	public SuperMercado(long idS, String nombre)
	{
		this.setId(idS);
		this.setNombre(nombre);
	}

	public long getId() {	
		return id;	
	}

	public void setId(long id) {	
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
