package Persistencia;



import org.apache.log4j.Logger;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import Negocio.Abarrote;
import Negocio.Consumidor;
import Negocio.EstanteNoPerecedero;
import Negocio.EstantePerecedero;
import Negocio.LocalVenta;
import Negocio.NoPerecedero;
import Negocio.Pedido;
import Negocio.Perecedero;
import Negocio.Promocion;
import Negocio.PromocionDescuento;
import Negocio.PromocionPlus;
import Negocio.PromocionPlusDescuento;
import Negocio.PromocionPlusPeso;
import Negocio.Sucursal;
import Negocio.SuperMercado;
import Negocio.Venta;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.jdo.JDODataStoreException;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;




public class PersistenciaSuperAndes {
	
	
	private static Logger log = Logger.getLogger(PersistenciaSuperAndes.class.getName());
	
	/**
	 * Cadena para indicar el tipo de sentencias que se va a utilizar en una consulta
	 */
	public final static String SQL = "javax.jdo.query.SQL";
	
	/**
	 * Atributo privado que es el �nico objeto de la clase - Patr�n SINGLETON
	 */
	private static PersistenciaSuperAndes instance;
	
	/**
	 * F�brica de Manejadores de persistencia, para el manejo correcto de las transacciones
	 */
	private PersistenceManagerFactory pmf;
	
	/**
	 * Arreglo de cadenas con los nombres de las tablas de la base de datos, en su orden:
	 * Secuenciador, tipoBebida, bebida, bar, bebedor, gustan, sirven y visitan
	 */
	private List <String> tablas;
	
	/**
	 * Atributo para el acceso a las sentencias SQL propias a PersistenciaParranderos
	 */
	private SQLUtil sqlUtil;
	
	/**
	 * Atributo para el acceso a las sentencias SQL propias a PersistenciaParranderos
	 */
	private SQLSuperMercados sqlSuperMercado;
    private SQLConsumidor sqlConsumidor;
    private SQLProducto sqlProducto;
    private SQLSucursal sqlSucursal;
    private SQLVentas sqlVentas;
    private SQLPromocionDescuento sqlDescuento;
    private SQLPromocion sqlPromocion;
    private SQLPromocionPlus sqlPromocionPlus;
    private SQLLocal sqlLocal;
    private SQLEstante sqlEstante;
    private SQLPromocionPlusPeso sqlPromocionPlusPeso;
    private SQLPromocionPlusDescuento sqlPromocionPlusDescuento;
    private SQLPedidos sqlPedidos;
    
	/**
	 * Constructor privado con valores por defecto - Patr�n SINGLETON
	 */
	private PersistenciaSuperAndes ()
	{
		pmf = JDOHelper.getPersistenceManagerFactory("SuperAndes");		
		crearClasesSQL ();
		
		// Define los nombres por defecto de las tablas de la base de datos
		tablas = new LinkedList<String> ();
		//0
		tablas.add ("SuperAndes_sequence");
		//1
		tablas.add ("SuperMercados");
		//2
		tablas.add ("Consumidores");
		//3
		tablas.add ("Producto");
		//4
		tablas.add("Promocion");
		//5
		tablas.add("PromosionDescuento");
		//6
		tablas.add("PromocionPlus");
		//7
		tablas.add("PromcionPlusDescuento");
		//8
		tablas.add("PromocionPlusPeso");
		//9
		tablas.add("PromocionProducto");
		//10
		tablas.add ("Sucursal");
		//11
		tablas.add("Venta");
		//12
		tablas.add("Pedidos");
		//13
		tablas.add("Local");
		//14
		tablas.add("Estante");
		//15
		tablas.add("Proveedores");
		//16
		tablas.add("ProveedorSupermercado");
		//17
		tablas.add("Bodegas");
}
	/**
	 * Constructor privado, que recibe los nombres de las tablas en un objeto Json - Patr�n SINGLETON
	 * @param tableConfig - Objeto Json que contiene los nombres de las tablas y de la unidad de persistencia a manejar
	 */
	private PersistenciaSuperAndes (JsonObject tableConfig)
	{
		System.out.println("Entra a percistencia");
		crearClasesSQL ();
		System.out.println("Crea los sql");
		tablas = leerNombresTablas (tableConfig);
		
		
		String unidadPersistencia = tableConfig.get ("unidadPersistencia").getAsString ();
		log.trace ("Accediendo unidad de persistencia: " + unidadPersistencia);
		System.out.println("Unidad de persistencia");
		System.out.println("U:"+unidadPersistencia);
		pmf = JDOHelper.getPersistenceManagerFactory (unidadPersistencia);
		System.out.println("Tos que verga");
	}

	
	/**
	 * @return Retorna el �nico objeto PersistenciaParranderos existente - Patr�n SINGLETON
	 */
	public static PersistenciaSuperAndes getInstance ()
	{
		if (instance == null)
		{
			instance = new PersistenciaSuperAndes();
		}
		return instance;
	}
	/**
	 * @return La cadena de caracteres con el nombre del secuenciador de parranderos
	 */
	public String darSeqSuperAndes ()
	{
		return tablas.get (0);
	}
	
	public String darTablaPromocion()
	{
		return tablas.get(4);
	}
	
	public String darTablaPromocionDescuento()
	{
		return tablas.get(5);
	}
	
	public String darTablaPromocionPlus()
	{
		return tablas.get(6);
	}
	
	public String darTablaPromocionPlusDescuento()
	{
		return tablas.get(7);
	}
	
	
	public String darTablaPromocionPlusPeso()
	{
		return tablas.get(8);
	}
	
	
	public String darTablaPromocionProducto()
	{
		return tablas.get(9);
	}
	public String darTablaPedidos()
	{
		return tablas.get(12);
	}
	
	public String darTablaProveedores() {
		return tablas.get(15);
	}
	
	public String darTablaProveedorSupermercado() {
		return tablas.get(16);
	}
	
	public String darTablaBodegas() {
		return tablas.get(17);
	}
	/**
	 * Constructor que toma los nombres de las tablas de la base de datos del objeto tableConfig
	 * @param tableConfig - El objeto JSON con los nombres de las tablas
	 * @return Retorna el �nico objeto PersistenciaParranderos existente - Patr�n SINGLETON
	 */
	public static PersistenciaSuperAndes getInstance (JsonObject tableConfig)
	{
		System.out.println("Entra instance");
		if (instance == null)
		{
			System.out.println("EntraAl if de getIntance");
			instance = new PersistenciaSuperAndes (tableConfig);
		}
		return instance;
	}
	
	/**
	 * Cierra la conexi�n con la base de datos
	 */
	public void cerrarUnidadPersistencia ()
	{
		pmf.close ();
		instance = null;
	}
	/**
	 * Genera una lista con los nombres de las tablas de la base de datos
	 * @param tableConfig - El objeto Json con los nombres de las tablas
	 * @return La lista con los nombres del secuenciador y de las tablas
	 */
	private List <String> leerNombresTablas (JsonObject tableConfig)
	{
		JsonArray nombres = tableConfig.getAsJsonArray("tablas") ;

		List <String> resp = new LinkedList <String> ();
		for (JsonElement nom : nombres)
		{
			resp.add (nom.getAsString ());
		}
		
		return resp;
	}
	/**
	 * Crea los atributos de clases de apoyo SQL
	 */
	private void crearClasesSQL()
	{
		sqlSuperMercado = new SQLSuperMercados(this);
		sqlUtil = new SQLUtil(this);
		sqlConsumidor = new SQLConsumidor(this);
		sqlVentas = new SQLVentas(this);
		sqlDescuento = new SQLPromocionDescuento(this);
		sqlPromocionPlusPeso = new SQLPromocionPlusPeso(this);
		sqlPromocionPlusDescuento = new SQLPromocionPlusDescuento(this);
		sqlPedidos = new SQLPedidos(this);
		
	}
	
//	/**
//	 * Crea los atributos de clases de apoyo SQL
//	 */
//	private void crearClasesSQL ()
//	{
//		sqlTipoBebida = new SQLTipoBebida(this);
//		sqlBebida = new SQLBebida(this);
//		sqlBar = new SQLBar(this);
//		sqlBebedor = new SQLBebedor(this);
//		sqlGustan = new SQLGustan(this);
//		sqlSirven = new SQLSirven (this);
//		sqlVisitan = new SQLVisitan(this);		
//		sqlUtil = new SQLUtil(this);
//	}
	

	
	public String darTablaSuperMercados()
	{
		return tablas.get(1);
	}
	public String darTablaConsumidor()
	{
		return tablas.get(2);
	}
	public String darTablaProducto() {
		return tablas.get(3);
	}
	public String darTablaSucursal() {
		return tablas.get(10);
	}
	public String darTablaVentas(){
		return tablas.get(11);
	}
	public String darTablaLocal() {
		return tablas.get(13);
	}
	public String darTablaEstante() {
		return tablas.get(14);
	}
	
	/**
	 * Extrae el mensaje de la exception JDODataStoreException embebido en la Exception e, que da el detalle espec�fico del problema encontrado
	 * @param e - La excepci�n que ocurrio
	 * @return El mensaje de la excepci�n JDO
	 */
	private String darDetalleException(Exception e) 
	{
		String resp = "";
		if (e.getClass().getName().equals("javax.jdo.JDODataStoreException"))
		{
			JDODataStoreException je = (javax.jdo.JDODataStoreException) e;
			return je.getNestedExceptions() [0].getMessage();
		}
		return resp;
	}
	/**
	 * M�todo que inserta, de manera transaccional, una tupla en la tabla BAR
	 * Adiciona entradas al log de la aplicaci�n
	 * @param nombre - El nombre del bar
	 * @param ciudad - La ciudad del bar
	 * @param presupuesto - El presupuesto del bar (ALTO, MEDIO, BAJO)
	 * @param sedes - El n�mero de sedes del bar en la ciudad (Mayor que 0)
	 * @return El objeto Bar adicionado. null si ocurre alguna Excepci�n
	 */
	public SuperMercado adicionarSuperMercado(String nombre) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            System.out.println("idSuper");
            long idSuper = nextval ();
            System.out.println("LanzaraException");
            long tuplasInsertadas = sqlSuperMercado.adicionarSuperMercado(pm, idSuper, nombre);
            tx.commit();

            log.trace ("Inserci�n de Bar: " + nombre + ": " + tuplasInsertadas + " tuplas insertadas");

            return new SuperMercado (idSuper, nombre);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	System.out.println("LanzaException");
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	public Venta adicionarVentas( Date pFecha, String formaPago, Integer valotTotal, Integer consumidor) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            System.out.println("idSuper");
            long idSuper = nextval ();
            System.out.println("LanzaraException");
            long tuplasInsertadas = sqlVentas.adicionarVentas(pm, idSuper,   pFecha,  formaPago,  valotTotal,  consumidor);
            tx.commit();

            log.trace ("Inserci�n de Bar: " + consumidor + ": " + tuplasInsertadas + " tuplas insertadas");

            return new Venta (idSuper,  pFecha,  formaPago,  valotTotal,  consumidor);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	System.out.println("LanzaException");
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	public Pedido adicionarPedido( String nombreP, long idProveedor, Integer cat, boolean estado) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            System.out.println("idSuper");
            long idPed = nextval ();
            System.out.println("LanzaraException");
            long tuplasInsertadas = sqlPedidos.adicionarPedido(pm, idPed, nombreP, idProveedor, cat, estado);
            tx.commit();

            log.trace ("Inserci�n de Bar: " + nombreP + ": " + tuplasInsertadas + " tuplas insertadas");

            return new Pedido (idPed, nombreP, cat, estado);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	System.out.println("LanzaException");
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	public Consumidor adicionarConsumidor(int pDoc, String pNombre, String pEmail, String pDireccion)

	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            System.out.println("idSuper");
            long idConsum = nextval ();
            System.out.println("LanzaraException");
            long tuplasInsertadas = sqlConsumidor.adicionarConsumidor(pm,idConsum,pDoc,  pNombre, pEmail, pDireccion);
            tx.commit();

            log.trace ("Inserci�n de Bar: " + pNombre + ": " + tuplasInsertadas + " tuplas insertadas");

            return new Consumidor (idConsum,pDoc,  pNombre, pEmail, pDireccion);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	System.out.println("LanzaException");
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	public Promocion adicionarPromocion(String nombre, String descripcion, Integer tipo, Date fechaIni, Date fechaFinal, Integer estado,Integer decuent,Integer cvendidas, Integer cpagadas)

	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
        	if(tipo == 1)
        	{
        		 tx.begin();
                 System.out.println("idSuper");
                 long idProm = nextval ();
                 System.out.println("LanzaraException");
                 long tuplasInsertadas = sqlPromocionPlus.adicionarPromocionPlus(pm,  idProm,  decuent);
                 long tuplasInsertadas2 = sqlPromocion.adicionarPromocion(pm,  idProm,  nombre,  descripcion, tipo, fechaIni,  fechaFinal,  estado);
                 tx.commit();
                 return new PromocionPlus ( idProm,  nombre,  descripcion,  fechaIni,  fechaFinal);
        	}
        	if(tipo == 2)
        	{
        		 tx.begin();
                 System.out.println("idSuper");
                 long idProm = nextval ();
                 System.out.println("LanzaraException");
                 long tuplasInsertadas = sqlPromocionPlusPeso.adicionarPromocionPlusPeso(pm,  idProm,  cvendidas,cpagadas);
                 long tuplasInsertadas2 = sqlPromocion.adicionarPromocion(pm,  idProm,  nombre,  descripcion, tipo, fechaIni,  fechaFinal,  estado);
                 tx.commit();
                 return new PromocionPlusPeso ( idProm, nombre,  descripcion,  fechaIni,  fechaFinal);
        	}
        	if(tipo == 3)
        	{
       		 tx.begin();
             System.out.println("idSuper");
             long idProm = nextval ();
             System.out.println("LanzaraException");
             long tuplasInsertadas = sqlPromocionPlusDescuento.adicionarPromocionPlusDescuento(pm, idProm, decuent,cvendidas);
             long tuplasInsertadas2 = sqlPromocion.adicionarPromocion(pm,  idProm,  nombre,  descripcion, tipo, fechaIni,  fechaFinal,  estado);
             tx.commit();
             return new PromocionPlusDescuento ( idProm, nombre,  descripcion,  fechaIni,  fechaFinal, decuent);
        		
        	}
        	if(tipo == 4)
        	{
          		 tx.begin();
                 System.out.println("idSuper");
                 long idProm = nextval ();
                 System.out.println("LanzaraException");
                 long tuplasInsertadas = sqlDescuento.adicionarPromocionDescuento(pm, idProm, decuent);
                 long tuplasInsertadas2 = sqlPromocion.adicionarPromocion(pm,  idProm,  nombre,  descripcion, tipo, fechaIni,  fechaFinal,  estado);
                 tx.commit();
                 return new PromocionDescuento ( idProm, nombre,  descripcion,  fechaIni,  fechaFinal, decuent);
        	}
            tx.begin();
            System.out.println("idSuper");
            long idProm = nextval ();
            System.out.println("LanzaraException");
            long tuplasInsertadas = sqlPromocion.adicionarPromocion(pm,  idProm,  nombre,  descripcion, tipo, fechaIni,  fechaFinal,  estado);
            tx.commit();

            log.trace ("Inserci�n de Bar: " + nombre + ": " + tuplasInsertadas + " tuplas insertadas");

        return null;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	System.out.println("LanzaException");
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	public Perecedero adicionarProductoP(String nombre, String codigo, String marca, String presentacion, int cantidadPresentacion,
			int volumen, Timestamp fecha, int calificacion) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx =  pm.currentTransaction();
		try {
			tx.begin();
			long idProduc = nextval();
			long tuplasInsertadas = sqlProducto.adicionarProductoP(pm, idProduc, nombre, codigo, marca, presentacion, cantidadPresentacion, volumen, fecha, calificacion);
			tx.commit();
			
			return new Perecedero(idProduc, nombre);
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		finally {
			if(tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}
	
	public NoPerecedero adicionarProductoNoP(String nombre, String codigo, String marca, String presentacion, int cantidadPresentacion,
			int volumen, int calificacion) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx =  pm.currentTransaction();
		try {
			tx.begin();
			long idProduc = nextval();
			long tuplasInsertadas = sqlProducto.adicionarProductoNoP(pm, idProduc, nombre, codigo, marca, presentacion, cantidadPresentacion, volumen, calificacion);
			tx.commit();
			
			return new NoPerecedero(idProduc, nombre);
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		finally {
			if(tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}
	
	public Abarrote adicionarProductoA(String nombre, String codigo, String marca, String presentacion, int cantidadPresentacion,
			int volumen, int calificacion) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx =  pm.currentTransaction();
		try {
			tx.begin();
			long idProduc = nextval();
			long tuplasInsertadas = sqlProducto.adicionarProductoA(pm, idProduc, nombre, codigo, marca, presentacion, cantidadPresentacion, volumen, calificacion);
			tx.commit();
			
			return new Abarrote(idProduc, nombre);
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		finally {
			if(tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}
	
	public Sucursal adicionarSucursal(String nombre,  String ciudad, String direccion) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			long idSucursal = nextval();
			long tuplasInsertadas = sqlSucursal.adicionarSucursal(pm, idSucursal, nombre, ciudad, direccion);
			tx.commit();
			
			return new Sucursal();
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		finally {
			if(tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}
	
	public LocalVenta adicionarLocal(String direccion) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			long idLocal = nextval();
			long tuplasInsertadas = sqlLocal.adicionarLocal(pm, idLocal, direccion);
			tx.commit();
			
			return new LocalVenta(idLocal, direccion);
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		finally {
			if(tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}
	
	public LocalVenta darLocalPorDireccion(String pDireccion) {
		return sqlLocal.darLocalPorNombre(pmf.getPersistenceManager(), pDireccion);
	}
	
	public EstantePerecedero agregarEstanteP(String direccionLocal, int volumen, int maxPeso) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			long  idEstante = nextval();
			LocalVenta lv = darLocalPorDireccion(direccionLocal);
			long idLocal = lv.getID();
			long tuplasInsertadas = sqlEstante.adicionarEstante(pm, idEstante, idLocal, volumen, maxPeso);
			tx.commit();
			
			return new EstantePerecedero();
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		finally {
			if(tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}
	
	public EstanteNoPerecedero agregarEstanteNoP(String direccionLocal, int volumen, int maxPeso) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			long  idEstante = nextval();
			LocalVenta lv = darLocalPorDireccion(direccionLocal);
			long idLocal = lv.getID();
			long tuplasInsertadas = sqlEstante.adicionarEstante(pm, idEstante, idLocal, volumen, maxPeso);
			tx.commit();
			
			return new EstanteNoPerecedero();
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		finally {
			if(tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}
	
	/**
	 * Transacci�n para el generador de secuencia de Parranderos
	 * Adiciona entradas al log de la aplicaci�n
	 * @return El siguiente n�mero del secuenciador de Parranderos
	 */
	private long nextval ()
	{
		System.out.println("EntraNext");
        long resp = sqlUtil.nextval (pmf.getPersistenceManager());
        System.out.println("SFSFSFSFS");
        log.trace ("Generando secuencia: " + resp);
        return resp;
    }

	/**
	 * M�todo que consulta todas las tuplas en la tabla BAR
	 * @return La lista de objetos BAR, construidos con base en las tuplas de la tabla BAR
	 */
	public List<SuperMercado> darSupers ()
	{
		return sqlSuperMercado.darSupers (pmf.getPersistenceManager());
	}
	public List<Venta> darVentas()
	{
		return sqlVentas.darVentas (pmf.getPersistenceManager());
	}
	public Promocion adicionarPromocion ()
	{
		return null;
		
	}
	
 

}
