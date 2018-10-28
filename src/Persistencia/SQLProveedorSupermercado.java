package Persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import Negocio.Proveedor;
import Negocio.ProveedorSupermercado;

public class SQLProveedorSupermercado {
	
	private final static String SQL = PersistenciaSuperAndes.SQL;
	
	private PersistenciaSuperAndes pp;
	
	public SQLProveedorSupermercado (PersistenciaSuperAndes pp)
	{
		this.pp = pp;
	}
	
	
	public long adicionarProveedorSupermercado (PersistenceManager pm, long idProveedor, long idSupermercado) 
	{
		
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaProveedorSupermercado() + "(idProveedor, idSupermercado) values (?, ?)");
        q.setParameters(idProveedor, idSupermercado);
        return (long) q.executeUnique();
        
	}
	
	public List<ProveedorSupermercado> darProveedoresSuperPorProveedor (PersistenceManager pm, long pID) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaProveedorSupermercado() + " WHERE id_proveedor = ?");
		q.setResultClass(ProveedorSupermercado.class);
		q.setParameters(pID);
		return (List<ProveedorSupermercado>) q.executeList();
	}
	
	public List<ProveedorSupermercado> darProveedoresSuperPorSuper (PersistenceManager pm, long pID) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaProveedorSupermercado() + " WHERE id_supermercado = ?");
		q.setResultClass(ProveedorSupermercado.class);
		q.setParameters(pID);
		return (List<ProveedorSupermercado>) q.executeList();
	}
	
	public long eliminarProveedorSupermercado (PersistenceManager pm, long idProveedor, long idSuper)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaProveedores() + " WHERE id_proveedor = ? AND id_supermercado = ?");
        q.setParameters(idProveedor,idSuper);
        return (long) q.executeUnique();            
	}

}
