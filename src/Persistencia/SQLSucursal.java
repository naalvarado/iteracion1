package Persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

public class SQLSucursal {
	
	private final static String SQL = PersistenciaSuperAndes.SQL;
	
	private PersistenciaSuperAndes pp;
	
	public SQLSucursal(PersistenciaSuperAndes pPer) {
		this.pp = pPer;
	}
	
	public long adicionarSucursal(PersistenceManager pm, long idSucursal, String nombre,
			String ciudad, String direccion) {
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaSucursal() + "(id, nombre,"
				+ "ciudad, direccion) values (?,?,?,?)");
		q.setParameters(idSucursal, null, nombre, ciudad, direccion);
		return (long) q.executeUnique();
	}

}
