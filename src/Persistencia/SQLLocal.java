package Persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import Negocio.LocalVenta;

public class SQLLocal {
	
	private final static String SQL = PersistenciaSuperAndes.SQL;
	
	private PersistenciaSuperAndes pp;
	
	public SQLLocal(PersistenciaSuperAndes pPer) {
		this.pp = pPer;
	}
	
	public long adicionarLocal(PersistenceManager pm, long idLocal, String direccion) {
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaLocal() +  "(id, sucursal, direcion)"
				+ " values (?,?,?)");
		q.setParameters(idLocal, null, direccion);
		return (long) q.executeUnique();
	}
	
	public LocalVenta darLocalPorNombre(PersistenceManager pm, String pDireccion) {
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaLocal() + " WHERE direccion = ?");
		q.setResultClass(LocalVenta.class);
		q.setParameters(pDireccion);
		return (LocalVenta) q.executeUnique();
	}

}
