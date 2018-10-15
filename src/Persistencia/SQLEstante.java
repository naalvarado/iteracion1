package Persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

public class SQLEstante {
	
	private final static String SQL = PersistenciaSuperAndes.SQL;
	
	private PersistenciaSuperAndes pp;
	
	public SQLEstante(PersistenciaSuperAndes pPer) {
		this.pp = pPer;
	}
	
	public long adicionarEstante(PersistenceManager pm, long idEstante, long idLocal, int volumen, int maxPeso) {
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaEstante() + "(id, local, volumen, max_peso)"
				+ " values (?,?,?,?)");
		q.setParameters(idEstante, idLocal, volumen, maxPeso);
		return (long) q.executeUnique();
	}

}
