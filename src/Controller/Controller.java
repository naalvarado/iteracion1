package Controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import Negocio.LocalVenta;
import Negocio.SuperAndes;

public class Controller {

	private static SuperAndes manager = new SuperAndes();
	
	public static void adiccionarSuperMercado(String nombre)
	{
		manager.adicionarSuperMercado(nombre);
		
	}
	
	public static void adicionarConsumidorCedula(int pDoc, String pNombre, String pEmail, String pDireccion)
	{
		manager.adicionarConsumidorCedula( pDoc, pNombre, pEmail, pDireccion);
	}
	
	public static void adicionarConsumidorNIT(int pDoc, String pNombre, String pEmail, String pDireccion)
	{
		manager.adicionarConsumidorNIT( pDoc, pNombre, pEmail, pDireccion);
	}
	
	public static void adicionarProductoP(String nombre, String codigo, String marca, String presentacion, int cantidadPresentacion,
			int volumen, int calificacion, Timestamp fecha, double precioU, String tipo, String subTipo) {
		manager.adicionarProducto(nombre, codigo, marca, presentacion, cantidadPresentacion, volumen, calificacion, fecha, precioU, tipo, subTipo);
	}
	
	public static void adicionarSucursal(String nombre,  String ciudad, String direccion) {
		manager.adicionarSucursal(nombre, ciudad, direccion);
	}
	public static void adicionarVentas(Timestamp pFecha, long idProducto, long idLocal, long idConsumidor)
	{
		manager.adicionarVenta(pFecha, idProducto,  idLocal, idConsumidor);
	}
	public static void adicionarPromocion(String descripcion, String nombre, String tipo, Timestamp fechaIni, Timestamp fechaFinal,double cvendidas, double cpagadas,double decuent)
	{
		manager.adicionarPromocion(nombre, descripcion, tipo, fechaIni, fechaFinal, decuent, cvendidas, cpagadas);
	}
	public static void registrarPedido(long idProducto, int cat, double precioA, Timestamp fechaEn, char estado, long idSucursal, long idProveedor)
	{
		manager.registrarPedidoProducto(idProducto, cat, precioA, fechaEn, estado, idSucursal, idProveedor);
	}
	
	public static void darVentasProductoFechas(long pProducto, Timestamp fechaIn, Timestamp fechaFin) {
		manager.darVentasProductoFechas(pProducto, fechaIn, fechaFin);
	}
	
	public static void adicionarLocal(String Direccion) {
		manager.adicionarLocal(Direccion);
	}
	
}
