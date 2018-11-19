package Persistencia;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import Negocio.Producto;
import Negocio.SuperMercado;
import Negocio.Venta;

public class SQLVentas {

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
	public SQLVentas(PersistenciaSuperAndes pp)
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
	public long adicionarVentas (PersistenceManager pm, long pID, Timestamp pFecha, long idProducto, long idLocal, long idConsumidor) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaVentas() + "(id, fecha, id_Producto, local, consumidor) values (?,?,?,?,?)");
        q.setParameters(pID,pFecha, idProducto, idLocal, idConsumidor);
        return (long) q.executeUnique();
	}
	
	public Venta darVentaId (PersistenceManager pm, long idVenta) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaVentas() + " WHERE id = ?");
		q.setResultClass(Venta.class);
		q.setParameters(idVenta);
		return (Venta) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la informaci�n de LOS BARES de la 
	 * base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos BAR
	 */
	public List<Venta> darVentas (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaVentas());
		q.setResultClass(Venta.class);
		return (List<Venta>) q.executeList();
	}
	
	public long eliminarVentaPorId (PersistenceManager pm, long idVenta)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaVentas() + " WHERE id = ?");
        q.setParameters(idVenta);
        return (long) q.executeUnique();            
	}
	
	public List<Venta> darVentasProductoFechas(PersistenceManager pm, long pProducto, Timestamp fechaIn, Timestamp fechaFin){
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaVentas() + " WHERE idProducto = ? AND BETWEEN ? AND ?");
		q.setResultClass(Venta.class);
		q.setParameters(pProducto,fechaIn,fechaFin);
		return (List<Venta>) q.executeList();
	}
	
}
