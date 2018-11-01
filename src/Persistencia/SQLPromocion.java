package Persistencia;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import Negocio.Consumidor;
import Negocio.Promocion;
import Negocio.SuperMercado;
import Negocio.Venta;

public class SQLPromocion {
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
	public SQLPromocion(PersistenciaSuperAndes pp)
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
	public long adicionarPromocion (PersistenceManager pm, long pID, String descripcion, String nombre, String tipo, Timestamp fechaIni, Timestamp fechaFinal, double cantV, double cantP, double porcentaje) 
	{
		
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaPromocion() + "(id, nombre, descripcion,tipo,fechainicio,fechafinalizacion,estado) values (?,?,?,?,?,?,?,?,?)");
        q.setParameters(pID, descripcion, nombre, tipo, fechaIni, fechaFinal, cantV, cantP, porcentaje);
        return (long) q.executeUnique();
	}
	
	public Promocion darPromocionPorId (PersistenceManager pm, long idPromocion) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaPromocion() + " WHERE id = ?");
		q.setResultClass(Promocion.class);
		q.setParameters(idPromocion);
		return (Promocion) q.executeUnique();
	}
	
	public List<Promocion> darPromocionesPorNombre (PersistenceManager pm, String nombrePromo) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaPromocion() + " WHERE nombre = ?");
		q.setResultClass(Promocion.class);
		q.setParameters(nombrePromo);
		return (List<Promocion>) q.executeList();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la informaci�n de LOS BARES de la 
	 * base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos BAR
	 */
	public List<Promocion> darPromociones (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaPromocion());
		q.setResultClass(Promocion.class);
		return (List<Promocion>) q.executeList();
	}
	
	public long eliminarConsumidorPorId (PersistenceManager pm, long idConsumidor)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaPromocion() + " WHERE id = ?");
        q.setParameters(idConsumidor);
        return (long) q.executeUnique();            
	}
}
