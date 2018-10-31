package Persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import Negocio.Estante;
import Negocio.LocalVenta;

public class SQLEstante {
	
	private final static String SQL = PersistenciaSuperAndes.SQL;
	
	private PersistenciaSuperAndes pp;
	
	public SQLEstante(PersistenciaSuperAndes pPer) {
		this.pp = pPer;
	}
	
	public long adicionarEstante(PersistenceManager pm, long idEstante, long idLocal, int volumen, int maxPeso) {
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaEstante() + "(id, local, volumen, max_peso) values (?,?,?,?)");
		q.setParameters(idEstante, idLocal, volumen, maxPeso);
		return (long) q.executeUnique();
	}
	
	public Estante darEstantePorId (PersistenceManager pm, long idEstante) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaEstante() + " WHERE id = ?");
		q.setResultClass(Estante.class);
		q.setParameters(idEstante);
		return (Estante) q.executeUnique();
	}
	
	public long eliminarEstantePorId (PersistenceManager pm, long idEstante)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaEstante() + " WHERE id = ?");
        q.setParameters(idEstante);
        return (long) q.executeUnique();            
	}

}
