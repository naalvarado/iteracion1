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
	
	public static void adicionarConsumidor(int pDoc, String pNombre, String pEmail, String pDireccion)
	{
		manager.adicionarConsumidor( pDoc, pNombre, pEmail, pDireccion);
	}
	
	public static void adicionarProductoP(String nombre, String codigo, String marca, String presentacion, int cantidadPresentacion,
			int volumen, Timestamp fecha, int calificacion) {
		manager.adicionarPerecedero(nombre, codigo, marca, presentacion, cantidadPresentacion, volumen, fecha, calificacion);
	}
	
	public static void adicionarProductoNoP(String nombre, String codigo, String marca, String presentacion, int cantidadPresentacion,
			int volumen, int calificacion) {
		manager.adicionarNoPerecedero(nombre, codigo, marca, presentacion, cantidadPresentacion, volumen, calificacion);
	}
	
	public static void adicionarProductoA(String nombre, String codigo, String marca, String presentacion, int cantidadPresentacion,
			int volumen, int calificacion) {
		manager.adicionarAbarrote(nombre, codigo, marca, presentacion, cantidadPresentacion, volumen, calificacion);
	}
	
	public static void adicionarSucursal(String nombre,  String ciudad, String direccion) {
		manager.adicionarSucursal(nombre, ciudad, direccion);
	}
	public static void adicionarVentas(Date pFecha, String formaPago, Integer valotTotal, Integer consumidor)
	{
		manager.adicionarVenta(pFecha, formaPago, valotTotal, consumidor);
	}
	public static void adicionarPromocion(String nombre, String descripcion, Integer tipo, Date fechaIni, Date fechaFinal, Integer estado,Integer decuent,Integer cvendidas, Integer cpagadas)
	{
		manager.adicionarPromocion(nombre, descripcion, tipo, fechaIni, fechaFinal, estado, decuent, cvendidas, cpagadas);
	}
	public static void registrarPedido(String nombreP, long idProveedor, Integer cat, boolean estado)
	{
		manager.registrarPedidoProducto(nombreP, idProveedor, cat, estado);
	}
	
}
