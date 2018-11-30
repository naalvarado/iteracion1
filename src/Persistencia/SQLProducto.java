package Persistencia;

import java.sql.Timestamp;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import Negocio.*;

public class SQLProducto {
	
	private final static String SQL = PersistenciaSuperAndes.SQL;
	
	private PersistenciaSuperAndes pp;
	
	public SQLProducto(PersistenciaSuperAndes pPer) {
		this.pp = pPer;
	}
	
	public long adicionarProducto(PersistenceManager pm, long idProducto, String nombre, String codigo, String marca, String presentacion, int cantidadPresentacion, int volumen, int calificacion, 
			Timestamp fecha, double precioU, String tipo, String subTipo) {
		System.out.println("Entra a adicionar Producto");
		Query q = pm.newQuery(SQL, "INSERT INTO  " + pp.darTablaProducto() + "(id, sucursal, bodega, estante, nombre, codigo, marca, presentacion, cantidadP, volumen,"
				+ " calificacion, fecha, precioUnidad, tipo, subTipo) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		System.out.println("Crea la query");
		q.setParameters(idProducto, null, null, null, nombre, codigo, marca, presentacion, cantidadPresentacion, volumen, calificacion, fecha, precioU, tipo, subTipo);
		System.out.println("Le pone los parametros a la query");
		return (long) q.executeUnique();
	}
	
	public Producto darProductoId (PersistenceManager pm, long idProducto) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaProducto() + " WHERE id = ?");
		q.setResultClass(Producto.class);
		q.setParameters(idProducto);
		return (Producto) q.executeUnique();
	}
	
	public Producto darProductoPorCodigo(PersistenceManager pm, String pCodigo) {
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaProducto() + " WHERE codigo = ?");
		q.setResultClass(Producto.class);
		q.setParameters(pCodigo);
		return (Producto) q.executeUnique();
	}
	
	public List<Producto> darProductos(PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaProducto());
		q.setResultClass(Producto.class);
		return (List<Producto>) q.executeList();
	}
	
	public long eliminarProductoPorId (PersistenceManager pm, long idProducto)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaProducto() + " WHERE id = ?");
        q.setParameters(idProducto);
        return (long) q.executeUnique();            
	}

}
