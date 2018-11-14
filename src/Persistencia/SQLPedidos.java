package Persistencia;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import Negocio.SuperMercado;
import Negocio.Venta;

public class SQLPedidos {

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
	public SQLPedidos(PersistenciaSuperAndes pp)
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
	public long adicionarPedido (PersistenceManager pm, long pID, long idProducto, int cat, double precioA, Timestamp fechaEn, char estado, long idSucursal, long idProveedor) 
	{
		
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaPedidos() + "(id, idProducto, cantidad, precioacordado, fechaEntrega, entregado, sucursal, proveedor) values (?,?,?,?,?,?,?,?)");
        q.setParameters(pID, idProducto, cat, precioA, fechaEn, estado, idSucursal, idProveedor);
        return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la informaci�n de LOS BARES de la 
	 * base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos BAR
	 */
	public List<Venta> darPedidos (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaPedidos());
		q.setResultClass(SuperMercado.class);
		return (List<Venta>) q.executeList();
	}
}
