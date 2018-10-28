package Persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import Negocio.Bodega;

public class SQLBodega {
	
	private final static String SQL = PersistenciaSuperAndes.SQL;
	
	private PersistenciaSuperAndes pp;
	
	public SQLBodega (PersistenciaSuperAndes pp)
	{
		this.pp = pp;
	}
	
	public long adicionarBodega (PersistenceManager pm, long id, long idSucursal, String tipo, int volumen, int maxpeso) 
	{
		
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaBodegas() + "(id, id_sucursal, tipo, volumen, max_peso) values (?, ?, ?, ?, ?)");
        q.setParameters(id, idSucursal, tipo, volumen, maxpeso);
        return (long) q.executeUnique();
        
	}
	
	public Bodega darBodegaPorId (PersistenceManager pm, long idBodega) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaBodegas() + " WHERE id = ?");
		q.setResultClass(Bodega.class);
		q.setParameters(idBodega);
		return (Bodega) q.executeUnique();
	}
	
	public List<Bodega> darBodegas (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaBodegas());
		q.setResultClass(Bodega.class);
		return (List<Bodega>) q.executeList();
	}
	
	public List<Bodega> darBodegasPorIdSucursal (PersistenceManager pm, long idSuc) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaBodegas() + " WHERE id_sucursal = ?");
		q.setResultClass(Bodega.class);
		q.setParameters(idSuc);
		return (List<Bodega>) q.executeList();
	}
	
	public long eliminarBodegaPorId (PersistenceManager pm, long idBodega)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaBodegas() + " WHERE id = ?");
        q.setParameters(idBodega);
        return (long) q.executeUnique();            
	}

}
