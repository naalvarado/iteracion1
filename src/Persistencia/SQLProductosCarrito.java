package Persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import Negocio.ProductosCarrito;

public class SQLProductosCarrito {
	
	private final static String SQL = PersistenciaSuperAndes.SQL;
	
	private PersistenciaSuperAndes pp;
	
	public SQLProductosCarrito(PersistenciaSuperAndes pPer) {
		this.pp = pPer;
	}
	
	public long adicionarProductoCarrito(PersistenceManager pm, long pId, long IdCarrito, long IdProducto) {
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaProductosCarrito() + " (id, idCarrito, idProducto) values (?,?,?)");
		q.setParameters(pId,IdCarrito,IdProducto);
		return (long) q.executeUnique();
	}
	
	public List<ProductosCarrito> darProductosCarrito(PersistenceManager pm, long ID) {
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaProductosCarrito() + " WHERE idCarrito = ?");
		q.setResultClass(ProductosCarrito.class);
		q.setParameters(ID);
		return (List<ProductosCarrito>) q.executeList();
	}
	
	public long eliminarProductoCarrito(PersistenceManager pm, long IdCarrito, long IdProducto) {
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaProductosCarrito() + " WHERE idCarrito = ? AND idProducto = ?");
		q.setParameters(IdCarrito,IdProducto);
		return (long) q.executeUnique();
	}
	
	public long eliminarCarrito(PersistenceManager pm, long id) {
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaProductosCarrito() + " WHERE idCarrito = ?");
		q.setParameters(id);
		return (long) q.executeUnique();
	}

}
