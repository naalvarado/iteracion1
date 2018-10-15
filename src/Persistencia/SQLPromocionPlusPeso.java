package Persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import Negocio.PromocionPlus;
import Negocio.PromocionPlusPeso;
import Negocio.SuperMercado;

public class SQLPromocionPlusPeso {

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
	public SQLPromocionPlusPeso(PersistenciaSuperAndes pp)
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
	public long adicionarPromocionPlusPeso(PersistenceManager pm, long id, Integer cvendidas, Integer cpagadas) 
	{
		
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaPromocionPlusPeso() + "(idpromocion, cvendidas, cpagadas) values (?,?,?)");
        q.setParameters(id,cvendidas,cpagadas);
        return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LOS BARES de la 
	 * base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos BAR
	 */
	public List<PromocionPlusPeso> darDescuentosPlus(PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaPromocionPlusPeso());
		q.setResultClass(SuperMercado.class);
		return (List<PromocionPlusPeso>) q.executeList();
	}
}
