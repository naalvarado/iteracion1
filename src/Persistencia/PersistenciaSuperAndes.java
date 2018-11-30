package Persistencia;



import org.apache.log4j.Logger;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import Negocio.*;

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
	
	public final static String SQL = "javax.jdo.query.SQL";
	private static PersistenciaSuperAndes instance;
	private PersistenceManagerFactory pmf;
	
	private List <String> tablas;
	private SQLUtil sqlUtil;
	
	private SQLSuperMercados sqlSuperMercado;
    private SQLConsumidor sqlConsumidor;
    private SQLProducto sqlProducto;
    private SQLSucursal sqlSucursal;
    private SQLVentas sqlVentas;
    private SQLPromocion sqlPromocion;
    private SQLLocal sqlLocal;
    private SQLEstante sqlEstante;
    private SQLPedidos sqlPedidos;
    private SQLCarrito sqlCarrito;
    private SQLProductosCarrito sqlProductosCarrito;
    
	private PersistenciaSuperAndes ()
	{
		pmf = JDOHelper.getPersistenceManagerFactory("SuperAndes");		
		crearClasesSQL ();
		
		// Define los nombres por defecto de las tablas de la base de datos
		tablas = new LinkedList<String> ();
		//0
		tablas.add ("SuperAndes_sequence");
		//1
		tablas.add ("SUPERMERCADOS");
		//2
		tablas.add ("Consumidores");
		//3
		tablas.add ("Productos");
		//4
		tablas.add("Promociones");
		//5
		tablas.add ("Sucursal");
		//6
		tablas.add("VENTAS");
		//7
		tablas.add("Pedidos");
		//8
		tablas.add("Local");
		//9
		tablas.add("Estante");
		//10
		tablas.add("Proveedores");
		//11
		tablas.add("ProveedorSupermercado");
		//12
		tablas.add("Bodegas");
		//13
		tablas.add("NivelesReordenBodegas");
		//14
		tablas.add("CarritosCompras");
		//15
		tablas.add("ProductosEnCarritos");
		//16
		tablas.add("NivelesReordenEstantes");
    }

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

	
	public static PersistenciaSuperAndes getInstance ()
	{
		if (instance == null)
		{
			instance = new PersistenciaSuperAndes();
		}
		return instance;
	}

	public String darSeqSuperAndes ()
	{
		return tablas.get (0);
	}
	
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
		return tablas.get(5);
	}
	public String darTablaVentas(){
		return tablas.get(6);
	}
	public String darTablaLocal() {
		return tablas.get(8);
	}
	public String darTablaEstante() {
		return tablas.get(9);
	}
	
	public String darTablaPromocion()
	{
		return tablas.get(4);
	}
	
	public String darTablaPedidos()
	{
		return tablas.get(7);
	}
	
	public String darTablaProveedores() {
		return tablas.get(10);
	}
	
	public String darTablaProveedorSupermercado() {
		return tablas.get(11);
	}
	
	public String darTablaBodegas() {
		return tablas.get(12);
	}
	
	public String darTablaReordenBodega() {
		return tablas.get(13);
	}
	
	public String darTablaCarrito() {
		return tablas.get(14);
	}
	
	public String darTablaProductosCarrito() {
		return tablas.get(15);
	}
	
	public String darTablaReordenEstante() {
		return tablas.get(16);
	}

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
	
	public void cerrarUnidadPersistencia ()
	{
		pmf.close ();
		instance = null;
	}

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

	private void crearClasesSQL()
	{
		sqlSuperMercado = new SQLSuperMercados(this);
		sqlUtil = new SQLUtil(this);
		sqlConsumidor = new SQLConsumidor(this);
		sqlVentas = new SQLVentas(this);
		sqlPedidos = new SQLPedidos(this);
		sqlCarrito = new SQLCarrito(this);
		sqlProductosCarrito = new SQLProductosCarrito(this);
		sqlProducto = new SQLProducto(this);
	}
	
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
	
	public Venta adicionarVentas( Timestamp pFecha, long idProducto, long idLocal, long idConsumidor) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            System.out.println("idSuper");
            long idSuper = nextval ();
            long tuplasInsertadas = sqlVentas.adicionarVentas(pm, idSuper,   pFecha,  idProducto,  idLocal, idConsumidor);
            tx.commit();
            System.out.println("Lo logra");
            log.trace ("Inserci�n de Bar: " + tuplasInsertadas + " tuplas insertadas");

            return new Venta (idSuper,  pFecha,  idProducto,  idLocal);
        }
        catch (Exception e)
        {
        	e.printStackTrace();
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
	
	public Pedido adicionarPedido( long idProducto, int cat, double precioA, Timestamp fechaEn, char estado, long idSucursal, long idProveedor) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            System.out.println("idSuper");
            long idPed = nextval ();
            System.out.println("LanzaraException");
            long tuplasInsertadas = sqlPedidos.adicionarPedido(pm, idPed, idProducto, cat, precioA, fechaEn, estado, idSucursal, idProveedor);
            tx.commit();

            //log.trace ("Inserci�n de Bar: " + nombreP + ": " + tuplasInsertadas + " tuplas insertadas");

            return new Pedido (idPed, idProducto, cat, estado);
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
	
	public Consumidor adicionarConsumidorCedula(int pDoc, String pNombre, String pEmail, String pDireccion)

	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long idConsum = nextval ();
            long tuplasInsertadas = sqlConsumidor.adicionarConsumidorCedula(pm,idConsum,pDoc,  pNombre, pEmail, pDireccion);
            System.out.println(tuplasInsertadas + " Antes del commit");
            tx.commit();
            System.out.println("Despues del commit");

            log.trace ("Inserci�n de Bar: " + pNombre + ": " + tuplasInsertadas + " tuplas insertadas");

            return new Consumidor (idConsum,pDoc,  pNombre, pEmail, pDireccion);
        }
        catch (Exception e)
        {
        	e.printStackTrace();
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
	
	public Consumidor adicionarConsumidorNIT(int pDoc, String pNombre, String pEmail, String pDireccion)

	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            System.out.println("idSuper");
            long idConsum = nextval ();
            System.out.println("LanzaraException");
            long tuplasInsertadas = sqlConsumidor.adicionarConsumidorNIT(pm,idConsum,pDoc,  pNombre, pEmail, pDireccion);
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
	
	public Promocion adicionarPromocion(String nombre, String descripcion, String tipo, Timestamp fechaIni, Timestamp fechaFinal, double decuent, double cvendidas, double cpagadas)

	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            System.out.println("idSuper");
            long idProm = nextval ();
            System.out.println("LanzaraException");
            long tuplasInsertadas = sqlPromocion.adicionarPromocion(pm,  idProm, descripcion, nombre, tipo, fechaIni,  fechaFinal,  cvendidas, cpagadas, decuent);
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
	
	public Producto adicionarProducto(String nombre, String codigo, String marca, String presentacion, int cantidadPresentacion,
			int volumen, int calificacion, Timestamp fecha, double precioU, String tipo, String subTipo) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx =  pm.currentTransaction();
		try {
			tx.begin();
			long idProduc = nextval();
			long tuplasInsertadas = sqlProducto.adicionarProducto(pm, idProduc, nombre, codigo, marca, presentacion, cantidadPresentacion, volumen, calificacion, fecha, precioU, tipo, subTipo);
			tx.commit();
			
			return new Producto(idProduc, nombre, codigo, marca, presentacion, cantidadPresentacion, volumen, calificacion, fecha, precioU, tipo, subTipo);
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
		return sqlLocal.darLocalPorDireccion(pmf.getPersistenceManager(), pDireccion);
	}
	
	public Estante agregarEstante(String direccionLocal, int volumen, int maxPeso) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			long  idEstante = nextval();
			LocalVenta lv = darLocalPorDireccion(direccionLocal);
			long idLocal = lv.getID();
			long tuplasInsertadas = sqlEstante.adicionarEstante(pm, idEstante, idLocal, volumen, maxPeso);
			tx.commit();
			
			return new Estante(idEstante,idLocal,volumen,maxPeso);
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
	
	public Consumidor darConsumidorPorID(long id) {
		return sqlConsumidor.darConsumidorPorId(pmf.getPersistenceManager(), id);
	}
	
	public Carrito agregarCarritoConConsumidor(long idConsumidor) {
		PersistenceManager  pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			long idCarrito = nextval();
			Consumidor con = darConsumidorPorID(idConsumidor);
			long idCon = con.getID();
			long tuplasInsertadas = sqlCarrito.adicionarCarrito(pm, idCarrito);
			long tuplaCons = sqlCarrito.adicionarConsumidor(pm, idCarrito, idCon);
			tx.commit();
			
			Carrito car = new Carrito(idCarrito);
			car.setConsumidor(con);
			return car;
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
	
	public Carrito darCarrito(long id) {
		return sqlCarrito.darCarritoId(pmf.getPersistenceManager(), id);
	}
	
	public Producto darProducto(long id) {
		return sqlProducto.darProductoId(pmf.getPersistenceManager(), id);
	}
	
	public ProductosCarrito agregarProductoACarrito(long idCarrito, long idProducto) {
		PersistenceManager pm =  pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			long  id = nextval();
			Carrito car = darCarrito(idCarrito);
			long idCar = car.getId();
			Producto pro = darProducto(idProducto);
			long idPro = pro.getID();
			long tuplasIn = sqlProductosCarrito.adicionarProductoCarrito(pm, id, idCar, idPro);
			tx.commit();
			
			return new ProductosCarrito(idCar,idPro);
		}
		catch(Exception e){
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
        long resp = sqlUtil.nextval (pmf.getPersistenceManager());
        System.out.println("SaleNextVal: " + resp);
        log.trace ("Generando secuencia: " + resp);
        return resp;
    }

	/**
	 * Metodos que retornan listas de objetos
	 * 
	 */
	
	public List<SuperMercado> darSupers ()
	{
		return sqlSuperMercado.darSupers (pmf.getPersistenceManager());
	}
	public List<Venta> darVentas()
	{
		return sqlVentas.darVentas (pmf.getPersistenceManager());
	}
	
	public List<Producto> darProductos(){
		return sqlProducto.darProductos(pmf.getPersistenceManager());
	}
	
	public List<LocalVenta> darLocales(){
		return sqlLocal.darLocales(pmf.getPersistenceManager());
	}
	
	public List<Consumidor> darConsumidores(){
		return sqlConsumidor.darConsumidores(pmf.getPersistenceManager());
	}
	
	//-----------------------------------------------------------
	//  ITERACION 3
	//-----------------------------------------------------------
	
	public List<Venta> darVentasProductoFechas(long pProducto, Timestamp fechaIn, Timestamp fechaFin){
		return sqlVentas.darVentasProductoFechas(pmf.getPersistenceManager(), pProducto, fechaIn, fechaFin);
	}
	
 

}
