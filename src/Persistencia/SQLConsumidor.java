package Persistencia;

import java.util.ArrayList;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import Negocio.LocalVenta;

public class SQLConsumidor {

	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Cadena que representa el tipo de consulta que se va a realizar en las sentencias de acceso a la base de datos
	 * Se renombra acá para facilitar la escritura de las sentencias
	 */
	private final static String SQL = PersistenciaSuperAndes.SQL;

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El manejador de persistencia general de la aplicación
	 */
	private PersistenciaSuperAndes pp;
	
	/**
	 * Constructor
	 * @param pp - El Manejador de persistencia de la aplicación
	 */
	public SQLConsumidor (PersistenciaSuperAndes pp)
	{
		this.pp = pp;
	}
	
	/**
	 * Insertar un supermercado
	 * @param pm
	 * @param idBar
	 * @param nombre
	 * @return
	 */
	public long adicionarConsumidor (PersistenceManager pm, long id,int pDoc, String pNombre, String pEmail, String pDireccion) 
	{
		
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaConsumidor() + "(id, documento,nombre,email,direccion) values (?, ?, ?, ?, ?)");
        q.setParameters(id,pDoc, pNombre, pEmail,pDireccion);
        return (long) q.executeUnique();
        
	}
	
}
