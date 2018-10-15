package Persistencia;

import java.sql.Timestamp;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

public class SQLProducto {
	
	private final static String SQL = PersistenciaSuperAndes.SQL;
	
	private PersistenciaSuperAndes pp;
	
	public SQLProducto(PersistenciaSuperAndes pPer) {
		this.pp = pPer;
	}
	
	public long adicionarProductoP(PersistenceManager pm, long idProducto, String nombre,
			String codigo, String marca, String presentacion, int cantidadPresentacion,
			int volumen, Timestamp fecha, int calificacion) {
		Query q = pm.newQuery(SQL, "INSERT INTO  " + pp.darTablaProducto() + "(id, sucursal,"
				+ " bodega, estante, nombre, codigo, marca, presentacion, cantidadP, volumen,"
				+ " fecha, calificacion) values (?,?,?,?,?,?,?,?,?,?,?,?)");
		q.setParameters(idProducto, null, null, null, nombre, codigo, marca, presentacion,
				 cantidadPresentacion, volumen, fecha, calificacion);
		return (long) q.executeUnique();
	}
	
	public long adicionarProductoNoP(PersistenceManager pm, long idProducto, String nombre,
			String codigo, String marca, String presentacion, int cantidadPresentacion,
			int volumen, int calificacion) {
		Query q = pm.newQuery(SQL, "INSERT INTO  " + pp.darTablaProducto() + "(id, sucursal,"
				+ " bodega, estante, nombre, codigo, marca, presentacion, cantidadP, volumen,"
				+ " fecha, calificacion) values (?,?,?,?,?,?,?,?,?,?,?,?)");
		q.setParameters(idProducto, null, null, null, nombre, codigo, marca, presentacion,
				 cantidadPresentacion, volumen, null, calificacion);
		return (long) q.executeUnique();
	}
	
	public long adicionarProductoA(PersistenceManager pm, long idProducto, String nombre,
			String codigo, String marca, String presentacion, int cantidadPresentacion,
			int volumen, int calificacion) {
		Query q = pm.newQuery(SQL, "INSERT INTO  " + pp.darTablaProducto() + "(id, sucursal,"
				+ " bodega, estante, nombre, codigo, marca, presentacion, cantidadP, volumen,"
				+ " fecha, calificacion) values (?,?,?,?,?,?,?,?,?,?,?,?)");
		q.setParameters(idProducto, null, null, null, nombre, codigo, marca, presentacion,
				 cantidadPresentacion, volumen, null, calificacion);
		return (long) q.executeUnique();
	}

}
