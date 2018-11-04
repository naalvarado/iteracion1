package Persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import Negocio.Carrito;
import Negocio.Producto;

public class SQLCarrito {
	
	private final static String SQL = PersistenciaSuperAndes.SQL;
	
	private PersistenciaSuperAndes pp;
	
	public SQLCarrito(PersistenciaSuperAndes pPer) {
		this.pp = pPer;
	}
	
	public long adicionarCarrito(PersistenceManager pm, long ID) {
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaCarrito() + " (id, consumidor) values (?,?)");
		q.setParameters(ID,null);
		return (long) q.executeUnique();
	}
	
	public Carrito darCarritoId (PersistenceManager pm, long idCarrito) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaCarrito() + " WHERE id = ?");
		q.setResultClass(Carrito.class);
		q.setParameters(idCarrito);
		return (Carrito) q.executeUnique();
	}
	
	public long eliminarCarritoPorId (PersistenceManager pm, long idCarrito)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaCarrito() + " WHERE id = ?");
        q.setParameters(idCarrito);
        return (long) q.executeUnique();            
	}
	
	public long adicionarConsumidor(PersistenceManager pm, long idC, long IdConsumidor) {
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaCarrito() + " SET consumidor = ? WHERE id = ?");
		q.setParameters(IdConsumidor,idC);
		return (long) q.executeUnique();
	}

}
