package Persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import Negocio.SuperMercado;


public class SQLSuperMercados {

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
	public SQLSuperMercados (PersistenciaSuperAndes pp)
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
	public long adicionarSuperMercado (PersistenceManager pm, long idSuperMercado, String nombre) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaSuperMercados() + "(id, nombre) values (?, ?)");
        q.setParameters(idSuperMercado, nombre);
        return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la informaci�n de LOS BARES de la 
	 * base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos BAR
	 */
	public List<SuperMercado> darSupers (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaSuperMercados());
		q.setResultClass(SuperMercado.class);
		return (List<SuperMercado>) q.executeList();
	}
	
	public SuperMercado darSuperMercadoPorId (PersistenceManager pm, long idSuperMercado) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaSuperMercados() + " WHERE id = ?");
		q.setResultClass(SuperMercado.class);
		q.setParameters(idSuperMercado);
		return (SuperMercado) q.executeUnique();
	}
	
	public List<SuperMercado> darConsumidoresPorNombre (PersistenceManager pm, String nombreSuperMercado) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaSuperMercados() + " WHERE nombre = ?");
		q.setResultClass(SuperMercado.class);
		q.setParameters(nombreSuperMercado);
		return (List<SuperMercado>) q.executeList();
	}
	
	public long eliminarSuperMercadoPorId (PersistenceManager pm, long idSuperMercado)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaSuperMercados() + " WHERE id = ?");
        q.setParameters(idSuperMercado);
        return (long) q.executeUnique();            
	}

}
