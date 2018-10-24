package Persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import Negocio.Proveedor;

public class SQLProveedorSupermercado {
	
	private final static String SQL = PersistenciaSuperAndes.SQL;
	
	private PersistenciaSuperAndes pp;
	
	public SQLProveedorSupermercado (PersistenciaSuperAndes pp)
	{
		this.pp = pp;
	}
	
	// TODO completar la clase ProveedorSupermercado para poder seguir aca
	
	public long adicionarProveedorSupermercado (PersistenceManager pm, long idProveedor, long idSupermercado) 
	{
		
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaProveedorSupermercado() + "(idProveedor, idSupermercado) values (?, ?)");
        q.setParameters(idProveedor, idSupermercado);
        return (long) q.executeUnique();
        
	}
	
	/**public List<> darProveedorPorId (PersistenceManager pm, long idProveedor) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaProveedores() + " WHERE id = ?");
		q.setResultClass(Proveedor.class);
		q.setParameters(idProveedor);
		return (Proveedor) q.executeUnique();
	}**/
	
	/**public List<Proveedor> darProveedoresPorNombre (PersistenceManager pm, String nombreProveedor) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaProveedores() + " WHERE nombre = ?");
		q.setResultClass(Proveedor.class);
		q.setParameters(nombreProveedor);
		return (List<Proveedor>) q.executeList();
	}**/
	
	public long eliminarProveedorPorId (PersistenceManager pm, long idProveedor)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaProveedores() + " WHERE id = ?");
        q.setParameters(idProveedor);
        return (long) q.executeUnique();            
	}

}
