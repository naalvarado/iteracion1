package Persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import Negocio.Sucursal;

public class SQLSucursal {
	
	private final static String SQL = PersistenciaSuperAndes.SQL;
	
	private PersistenciaSuperAndes pp;
	
	public SQLSucursal(PersistenciaSuperAndes pPer) {
		this.pp = pPer;
	}
	
	public long adicionarSucursal(PersistenceManager pm, long idSucursal, String nombre,String ciudad, String direccion) {
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaSucursal() + "(id, nombre,ciudad, direccion) values (?,?,?,?)");
		q.setParameters(idSucursal, null, nombre, ciudad, direccion);
		return (long) q.executeUnique();
	}
	
	public Sucursal darSucursalPorId (PersistenceManager pm, long idSucursal) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaSucursal() + " WHERE id = ?");
		q.setResultClass(Sucursal.class);
		q.setParameters(idSucursal);
		return (Sucursal) q.executeUnique();
	}
	
	public List<Sucursal> darSucursales (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaSucursal());
		q.setResultClass(Sucursal.class);
		return (List<Sucursal>) q.executeList();
	}
	
	public List<Sucursal> darSucursalPorNombre (PersistenceManager pm, String nombreSucursal) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaSucursal() + " WHERE nombre = ?");
		q.setResultClass(Sucursal.class);
		q.setParameters(nombreSucursal);
		return (List<Sucursal>) q.executeList();
	}
	
	public long eliminarSucursalPorId (PersistenceManager pm, long idSucursal)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaSucursal() + " WHERE id = ?");
        q.setParameters(idSucursal);
        return (long) q.executeUnique();            
	}

}
