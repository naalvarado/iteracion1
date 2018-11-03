package Persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import Negocio.Producto;
import Negocio.ReordenBodega;

public class SQLReordenBodega {
	
	private final static String SQL = PersistenciaSuperAndes.SQL;
	
	private PersistenciaSuperAndes pp;
	
	public SQLReordenBodega(PersistenciaSuperAndes pPer) {
		this.pp = pPer;
	}
	
	public long adicionarReordenBodega(PersistenceManager pm, long idBodega, long idProducto, double cantidadMini) {
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaReordenBodega() + "(idBodega, idProducto, cantidadMinima) values (?, ?, ?)");
		q.setParameters(idBodega, idProducto, cantidadMini);
		return (long) q.executeUnique();
	}
	
	public ReordenBodega darReordenPorIds (PersistenceManager pm, long idBodega, long idProducto) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaReordenBodega() + " WHERE idBodega = ? AND idProducto = ?");
		q.setResultClass(ReordenBodega.class);
		q.setParameters(idBodega, idProducto);
		return (ReordenBodega) q.executeUnique();
	}

}
