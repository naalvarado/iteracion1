package Negocio;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.google.gson.JsonObject;

import Persistencia.PersistenciaSuperAndes;




public class SuperAndes {

	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Logger para escribir la traza de la ejecuci�n
	 */
	private static Logger log = Logger.getLogger(SuperAndes.class.getName());
	
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El manejador de persistencia
	 */
	private PersistenciaSuperAndes pp;
	
	/* ****************************************************************
	 * 			M�todos
	 *****************************************************************/
	/**
	 * El constructor por defecto
	 */
	public SuperAndes ()
	{
		pp = PersistenciaSuperAndes.getInstance ();
	}
	
	/**
	 * El constructor qye recibe los nombres de las tablas en tableConfig
	 * @param tableConfig - Objeto Json con los nombres de las tablas y de la unidad de persistencia
	 */
	public SuperAndes (JsonObject tableConfig)
	{
		System.out.println("LLega a a SuperAndesConstructor");
		pp = PersistenciaSuperAndes.getInstance (tableConfig);
	}
	
	/**
	 * Cierra la conexi�n con la base de datos (Unidad de persistencia)
	 */
	public void cerrarUnidadPersistencia ()
	{
		pp.cerrarUnidadPersistencia ();
	}
	
	// Metodos de adicionar
	
	public SuperMercado adicionarSuperMercado (String nombre)
	{
        log.info ("Adicionando bar: " + nombre);
       SuperMercado mercado = pp.adicionarSuperMercado (nombre);
        log.info ("Adicionando bar: " + mercado);
        return mercado;
	}
	
	public Consumidor adicionarConsumidorCedula (int pDoc, String pNombre, String pEmail, String pDireccion)
	{
        log.info ("Adicionando bar: " + pNombre);
       Consumidor cliente = pp.adicionarConsumidorCedula(pDoc, pNombre, pEmail, pDireccion);
        log.info ("Adicionando bar: " + cliente);
        return cliente;
	}
	
	public Consumidor adicionarConsumidorNIT (int pDoc, String pNombre, String pEmail, String pDireccion)
	{
        log.info ("Adicionando bar: " + pNombre);
       Consumidor cliente = pp.adicionarConsumidorNIT(pDoc, pNombre, pEmail, pDireccion);
        log.info ("Adicionando bar: " + cliente);
        return cliente;
	}
	
	public Producto adicionarProducto(String nombre, String codigo, String marca, String presentacion, int cantidadPresentacion, int volumen, 
			int calificacion, Timestamp fecha, double precioU, String tipo, String subTipo) {
		Producto pro = pp.adicionarProducto(nombre, codigo, marca, presentacion, cantidadPresentacion, volumen, calificacion, fecha, precioU, tipo, subTipo);
		return pro;
	}
	
	public Sucursal adicionarSucursal(String nombre,  String ciudad, String direccion) {
		Sucursal suc = pp.adicionarSucursal(nombre, ciudad, direccion);
		return suc;
	}
	public Promocion adicionarPromocion(String descripcion, String nombre, String tipo, Timestamp fechaIni, Timestamp fechaFinal, double decuent,double cvendidas, double cpagadas) {
		Promocion prom = pp.adicionarPromocion(descripcion, nombre, tipo, fechaIni, fechaFinal, cvendidas, cpagadas, decuent);
		return prom;
	}
	
	public LocalVenta adicionarLocal(String Direccion) {
		LocalVenta lv = pp.adicionarLocal(Direccion);
		return lv;
	}
	
	public Estante adicionarEstante(String direccionLocal, int volumen, int maxPeso) {
		Estante e = pp.agregarEstante(direccionLocal, volumen, maxPeso);
		return e;
	}
	
	/**
	 * Encuentra todos los bares en Parranderos
	 * Adiciona entradas al log de la aplicaci�n
	 * @return Una lista de objetos Bar con todos las bares que conoce la aplicaci�n, llenos con su informaci�n b�sica
	 */
	public List<SuperMercado> darSuperMercados ()
	{
        log.info ("Listando Bares");
        List<SuperMercado> bares = pp.darSupers ();	
        log.info ("Listando Bares: " + bares.size() + " bares existentes");
        return bares;
	}
	public Venta adicionarVenta(Date pFecha, long idProducto, long idLocal, long idConsumidor) {
		Venta venta = pp.adicionarVentas(pFecha, idProducto,  idLocal, idConsumidor);
		return venta;
	}
	public Pedido registrarPedidoProducto(long idProducto, int cat, double precioA, Timestamp fechaEn, char estado, long idSucursal, long idProveedor)
	{
		Pedido venta = pp.adicionarPedido(idProducto, cat, precioA, fechaEn, estado, idSucursal, idProveedor);
		return venta;
	}
}
