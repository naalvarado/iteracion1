package Persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import Negocio.Bodega;
import Negocio.LocalVenta;
import Negocio.Producto;

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
	
	public LocalVenta darLocalPorId (PersistenceManager pm, long idLocal) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaLocal() + " WHERE id = ?");
		q.setResultClass(LocalVenta.class);
		q.setParameters(idLocal);
		return (LocalVenta) q.executeUnique();
	}
	
	public LocalVenta darLocalPorDireccion(PersistenceManager pm, String pDireccion) {
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaLocal() + " WHERE direccion = ?");
		q.setResultClass(LocalVenta.class);
		q.setParameters(pDireccion);
		return (LocalVenta) q.executeUnique();
	}
	
	public List<LocalVenta> darLocalesPorIdSucursal (PersistenceManager pm, long idSuc) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaLocal() + " WHERE id_sucursal = ?");
		q.setResultClass(LocalVenta.class);
		q.setParameters(idSuc);
		return (List<LocalVenta>) q.executeList();
	}
	
	public long eliminarLocalPorId (PersistenceManager pm, long idLocal)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaLocal() + " WHERE id = ?");
        q.setParameters(idLocal);
        return (long) q.executeUnique();            
	}
	
	public List<LocalVenta> darLocales(PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaLocal());
		q.setResultClass(LocalVenta.class);
		return (List<LocalVenta>) q.executeList();
	}

}
