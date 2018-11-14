package Persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import Negocio.ReordenBodega;
import Negocio.ReordenEstante;

public class SQLReordenEstante {
	
private final static String SQL = PersistenciaSuperAndes.SQL;
	
	private PersistenciaSuperAndes pp;
	
	public SQLReordenEstante(PersistenciaSuperAndes pPer) {
		this.pp = pPer;
	}
	
	public long adicionarReordenEstante(PersistenceManager pm, long idEstante, long idProducto, double cantidadMini) {
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaReordenEstante() + "(idEstante, idProducto, cantidadMinima) values (?, ?, ?)");
		q.setParameters(idEstante, idProducto, cantidadMini);
		return (long) q.executeUnique();
	}
	
	public ReordenEstante darReordenPorIds (PersistenceManager pm, long idEstante, long idProducto) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaReordenEstante() + " WHERE idEstante = ? AND idProducto = ?");
		q.setResultClass(ReordenEstante.class);
		q.setParameters(idEstante, idProducto);
		return (ReordenEstante) q.executeUnique();
	}

}
