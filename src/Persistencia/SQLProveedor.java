package Persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import Negocio.Proveedor;

public class SQLProveedor {
	
	private final static String SQL = PersistenciaSuperAndes.SQL;
	
	private PersistenciaSuperAndes pp;
	
	public SQLProveedor (PersistenciaSuperAndes pp)
	{
		this.pp = pp;
	}
	
	public long adicionarProveedor (PersistenceManager pm, long id, String pNombre) 
	{
		
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaProveedores() + "(id, nombre) values (?, ?)");
        q.setParameters(id, pNombre);
        return (long) q.executeUnique();
        
	}
	
	public Proveedor darProveedorPorId (PersistenceManager pm, long idProveedor) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaProveedores() + " WHERE id = ?");
		q.setResultClass(Proveedor.class);
		q.setParameters(idProveedor);
		return (Proveedor) q.executeUnique();
	}
	
	public List<Proveedor> darProveedores (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaProveedores());
		q.setResultClass(Proveedor.class);
		return (List<Proveedor>) q.executeList();
	}
	
	public List<Proveedor> darProveedoresPorNombre (PersistenceManager pm, String nombreProveedor) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaProveedores() + " WHERE nombre = ?");
		q.setResultClass(Proveedor.class);
		q.setParameters(nombreProveedor);
		return (List<Proveedor>) q.executeList();
	}
	
	public long eliminarProveedorPorId (PersistenceManager pm, long idProveedor)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaProveedores() + " WHERE id = ?");
        q.setParameters(idProveedor);
        return (long) q.executeUnique();            
	}

}
