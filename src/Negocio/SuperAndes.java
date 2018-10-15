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
	
	public Consumidor adicionarConsumidor (int pDoc, String pNombre, String pEmail, String pDireccion)
	{
        log.info ("Adicionando bar: " + pNombre);
       Consumidor cliente = pp.adicionarConsumidor(pDoc, pNombre, pEmail, pDireccion);
        log.info ("Adicionando bar: " + cliente);
        return cliente;
	}
	
	public Perecedero adicionarPerecedero(String nombre, String codigo, String marca, String presentacion, int cantidadPresentacion,
			int volumen, Timestamp fecha, int calificacion) {
		Perecedero per = pp.adicionarProductoP(nombre, codigo, marca, presentacion, cantidadPresentacion, volumen, fecha, calificacion);
		return per;
	}
	
	public NoPerecedero adicionarNoPerecedero(String nombre, String codigo, String marca, String presentacion, int cantidadPresentacion,
			int volumen, int calificacion) {
		NoPerecedero nper = pp.adicionarProductoNoP(nombre, codigo, marca, presentacion, cantidadPresentacion, volumen, calificacion);
		return nper;
	}
	
	public Abarrote adicionarAbarrote(String nombre, String codigo, String marca, String presentacion, int cantidadPresentacion,
			int volumen, int calificacion) {
		Abarrote abar = pp.adicionarProductoA(nombre, codigo, marca, presentacion, cantidadPresentacion, volumen, calificacion);
		return abar;
	}
	
	public Sucursal adicionarSucursal(String nombre,  String ciudad, String direccion) {
		Sucursal suc = pp.adicionarSucursal(nombre, ciudad, direccion);
		return suc;
	}
	public Promocion adicionarPromocion(String nombre, String descripcion, Integer tipo, Date fechaIni, Date fechaFinal, Integer estado,Integer decuent,Integer cvendidas, Integer cpagadas) {
		Promocion prom = pp.adicionarPromocion(nombre, descripcion, tipo, fechaIni, fechaFinal, estado, decuent, cvendidas, cpagadas);
		return prom;
	}
	
	public LocalVenta adicionarLocal(String Direccion) {
		LocalVenta lv = pp.adicionarLocal(Direccion);
		return lv;
	}
	
	public EstantePerecedero adicionarEstanteP(String direccionLocal, int volumen, int maxPeso) {
		EstantePerecedero ep = pp.agregarEstanteP(direccionLocal, volumen, maxPeso);
		return ep;
	}
	
	public EstanteNoPerecedero adicionarEstanteNoP(String direccionLocal, int volumen, int maxPeso) {
		EstanteNoPerecedero ep = pp.agregarEstanteNoP(direccionLocal, volumen, maxPeso);
		return ep;
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
	public Venta adicionarVenta(Date pFecha, String formaPago, Integer valotTotal, Integer consumidor) {
		Venta venta = pp.adicionarVentas(pFecha, formaPago,  valotTotal,  consumidor);
		return venta;
	}
	public Pedido registrarPedidoProducto(String nombreP,long idProveedor,Integer cat,boolean estado)
	{
		Pedido venta = pp.adicionarPedido(nombreP, idProveedor, cat, estado);
		return venta;
	}
}
