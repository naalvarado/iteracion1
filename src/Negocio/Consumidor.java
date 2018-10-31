package Negocio;

import java.util.ArrayList;

public class Consumidor {
	/**
	 * ID 
	 */
	private long ID;
	/**
	 * documento de identidad
	 */
	private int documentoIdent;
	/**
	 * Nombre del cliente
	 */
	private String nombre;
	/**
	 * Email del cliente
	 */
	private String email;

	private int NIT;
	
	private String direccion;
	
	private ArrayList<LocalVenta> localesVenta;
	/**
	 * Constructor
	 */
	//Constructor para un usuario SIN email
	public Consumidor(long id, int pDoc, String pNombre, String pDireccion, ArrayList<LocalVenta> pLocales){
		
		this.documentoIdent = pDoc;
		this.nombre = pNombre;
		this.direccion = pDireccion;
		this.localesVenta = pLocales;
		this.ID = id;
	
	}
	/**
	 * Constructor 
	 */
	//Constructor para un usuario CON email
	public Consumidor(long id,int pDoc, String pNombre, String pEmail, String pDireccion){
		
		this.ID = id;
		this.documentoIdent = pDoc;
		this.nombre = pNombre;
		this.email = pEmail;
		this.direccion = pDireccion;
		
	}
	/**
	 * Constructor 
	 */
	//Constructor para un usuario CON email
	public Consumidor(long id,int pDoc, String pNombre, String pEmail, String pDireccion, ArrayList<LocalVenta> pLocales){
		
		this.ID = id;
		this.documentoIdent = pDoc;
		this.nombre = pNombre;
		this.email = pEmail;
		this.direccion = pDireccion;
		this.localesVenta = pLocales;
	}
	/**
	 * Constructor
	 */
	//Constructor para una empresa
	public Consumidor(long id,String pNombre, String pEmail, int pNIT, String pDireccion, ArrayList<LocalVenta> pLocales){
		
		this.ID = id;
		this.nombre = pNombre;
		this.email = pEmail;
		this.NIT = pNIT;
		this.direccion = pDireccion;
		this.localesVenta = pLocales;
	}
	/**
	 * Constuctor vacio
	 */
	public Consumidor()
	{
		
	}
	/**
	 * Documento 
	 */
	public int darDoc(){
		return documentoIdent;
	}
	/**
	 * Nombre
	 */
	public String darNombre(){
		return nombre;
	}
	
	public String darEmail(){
		return email;
	}
	
	public int darNIT(){
		return NIT;
	}
	
	public String darDireccion(){
		return direccion;
	}
	
	public void setNombre(String pNombre){
		this.nombre = pNombre;
	}
	
	public void setEmail(String pEmail){
		this.email = pEmail;
	}
	
	public void setDireccion(String pDireccion){
		this.direccion = pDireccion;
	}
	
	public void setLocalesVenta(ArrayList<LocalVenta> pLocales){
		this.localesVenta = pLocales;
	}
	
	private LocalVenta searchLocal(LocalVenta pLV){
		int re = localesVenta.indexOf(pLV);
		return localesVenta.get(re);
	}
	
	public void comprar(LocalVenta pLV, Producto pProducto, int cantidad){
		//TODO this
	}

	public long getID() {
		return ID;
	}

	public void setID(long iD) {
		ID = iD;
	}
	
}
