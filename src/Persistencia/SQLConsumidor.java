package Persistencia;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import Negocio.Consumidor;
import Negocio.LocalVenta;

public class SQLConsumidor {

	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Cadena que representa el tipo de consulta que se va a realizar en las sentencias de acceso a la base de datos
	 * Se renombra ac� para facilitar la escritura de las sentencias
	 */
	private final static String SQL = PersistenciaSuperAndes.SQL;

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El manejador de persistencia general de la aplicaci�n
	 */
	private PersistenciaSuperAndes pp;
	
	/**
	 * Constructor
	 * @param pp - El Manejador de persistencia de la aplicaci�n
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
	public long adicionarConsumidorCedula (PersistenceManager pm, long id, int pDoc, String pNombre, String pEmail, String pDireccion) 
	{
		
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaConsumidor() + "(id, documentoide, nit, nombre, email, direccion, puntos) values (?,?,?,?,?,?,?)");
        q.setParameters(id, pDoc, null, pNombre, pEmail, pDireccion, 0);
        return (long) q.executeUnique();
        
	}
	
	public long adicionarConsumidorNIT (PersistenceManager pm, long id, int pDoc, String pNombre, String pEmail, String pDireccion) 
	{
		
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaConsumidor() + "(id, documentoide, nit, nombre, email, direccion, puntos) values (?,?,?,?,?,?,?)");
        q.setParameters(id, null, pDoc, pNombre, pEmail, pDireccion, 0);
        return (long) q.executeUnique();
        
	}
	
	public Consumidor darConsumidorPorId (PersistenceManager pm, long idConsumidor) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaConsumidor() + " WHERE id = ?");
		q.setResultClass(Consumidor.class);
		q.setParameters(idConsumidor);
		return (Consumidor) q.executeUnique();
	}
	
	public List<Consumidor> darConsumidores (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaConsumidor());
		q.setResultClass(Consumidor.class);
		return (List<Consumidor>) q.executeList();
	}
	
	public List<Consumidor> darConsumidoresPorNombre (PersistenceManager pm, String nombreConsumidor) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaConsumidor() + " WHERE nombre = ?");
		q.setResultClass(Consumidor.class);
		q.setParameters(nombreConsumidor);
		return (List<Consumidor>) q.executeList();
	}
	
	public long eliminarConsumidorPorId (PersistenceManager pm, long idConsumidor)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaConsumidor() + " WHERE id = ?");
        q.setParameters(idConsumidor);
        return (long) q.executeUnique();            
	}
	
}
