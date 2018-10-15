package Persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import Negocio.PromocionDescuento;
import Negocio.PromocionPlusDescuento;
import Negocio.SuperMercado;

public class SQLPromocionPlusDescuento {

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
	public SQLPromocionPlusDescuento(PersistenciaSuperAndes pp)
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
	public long adicionarPromocionPlusDescuento (PersistenceManager pm, long id, Integer decuent, Integer cvendidas) 
	{
		
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaPromocionPlusDescuento() + "(idpromocion, uvendidas,descuento) values (?,?,?)");
        q.setParameters(id,cvendidas,decuent);
        return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LOS BARES de la 
	 * base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos BAR
	 */
	public List<PromocionPlusDescuento> darVentas (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaPromocionPlusDescuento());
		q.setResultClass(SuperMercado.class);
		return (List<PromocionPlusDescuento>) q.executeList();
	}
}
