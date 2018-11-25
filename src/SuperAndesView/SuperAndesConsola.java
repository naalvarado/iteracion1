package SuperAndesView;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import Negocio.*;

public class SuperAndesConsola {

	private SuperAndes superController;
	
	public static void main(String[] args) throws Exception 
	{
		Scanner sc = new Scanner(System.in);
		boolean fin=false;
		while(!fin)
		{
			//imprime menu
			printMenu();

			//opcion req
			String opt = sc.next();
			int option = 0;
			if(opt.equals("Q")) {
				fin = true;
			}
			else {
				option = Integer.parseInt(opt);
			}

			switch(option)
			{
			//1C cargar informacion dada
			case 1:
				boolean fin1 = false;
				while(!fin1) {
					printMenuI1();
					String opt1 = sc.next();
					int option1 = 0;
					if(opt1.equals("Q")) {
						fin1 = true;
					}
					else {
						option1 = Integer.parseInt(opt1);
					}
					switch(option1) {
					case 1:
						System.out.println("Cedula(C) o NIT(N)");
						char c11 = sc.next().charAt(0);
						if(c11 == 'C') {
							System.out.println("Escriva el numero de documento: ");
							int cedula = sc.nextInt();
							System.out.println("Escriva el nombre: ");
							String nombre11 = sc.next();
							System.out.println("Escriva el email: ");
							String email = sc.next();
							System.out.println("Escriva la direccion: ");
							String direccion11 = sc.next();
							Controller.Controller.adicionarConsumidorCedula(cedula, nombre11, email, direccion11);
						}
						else if(c11 == 'N') {
							System.out.println("Escriva el NIT: ");
							int NIT = sc.nextInt();
							System.out.println("Escriva el nombre: ");
							String nombre11 = sc.next();
							System.out.println("Escriva el email: ");
							String email = sc.next();
							System.out.println("Escriva la direccion: ");
							String direccion11 = sc.next();
							Controller.Controller.adicionarConsumidorNIT(NIT, nombre11, email, direccion11);
						}
						else {
							System.out.println("Obcion incorrecta");
						}
						break;
					case 2:
						System.out.println("Escriva el nombre: ");
						String nombre12 = sc.next();
						System.out.println("Escriva el codigo: ");
						String codigo = sc.next();
						System.out.println("Escriva la marca: ");
						String marca = sc.next();
						System.out.println("Escriva la presentacion: ");
						String presentacion = sc.next();
						System.out.println("Escriva la cantidad de presentacion: ");
						int cantPre = sc.nextInt();
						System.out.println("Escriva el volumen: ");
						int volumen = sc.nextInt();
						int calificacion = 0;
						Timestamp fecha = new Timestamp(System.nanoTime());
						System.out.println("Escriva el precio Unitario: ");
						double precio = sc.nextDouble();
						System.out.println("Escriva el tipo: ");
						String tipo12 = sc.next();
						System.out.println("Escriva el subtipo: ");
						String subtipo = sc.next();
						Controller.Controller.adicionarProductoP(nombre12, codigo, marca, presentacion, cantPre, volumen, calificacion, fecha, precio, tipo12, subtipo);
						break;
					case 3:
						System.out.println("Escriva la direccion: ");
						String direcion = sc.next();
						Controller.Controller.adicionarLocal(direcion);
						break;
					}
				}
				break;
			case 2:
				System.out.println("Escriva el tipo de producto (Peresedero, NoPeresedero o Abarrote)");
				String tipo = sc.next();
				if(tipo == "Peresedero") {
					
				}
				else if(tipo == "NoPeresedero") {
					
				}
				else if(tipo == "Abarrote") {
					
				}
				else {
					System.out.println("El tipo de producto "+tipo+" no existe.");
				}
				break;
			case 3:
				boolean fin3 = false;
				while(!fin3) {
					printMenuI3();
					String opt3 = sc.next();
					int option3 = 0;
					if(opt3.equals("Q")) {
						fin3 = true;
					}
					else {
						option3 = Integer.parseInt(opt3);
					}
					switch(option3) {
					case 0:
						System.out.println("Ingrese la fecha: ");
						String fechaS = sc.next();
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
						Date parsedDate = dateFormat.parse(fechaS);
						Timestamp fecha = new java.sql.Timestamp(parsedDate.getTime());
						List<Producto> productos = Controller.Controller.darProductos();
						for(Producto p : productos) {
							System.out.println(p.getID());
						}
						System.out.println("Ingrese el id del producto: ");
						long idP = sc.nextLong();
						List<LocalVenta> locales = Controller.Controller.darLocales();
						for(LocalVenta lv : locales) {
							System.out.println(lv.getID());
						}
						System.out.println("Ingrese el id del Local: ");
						long idL = sc.nextLong();
						List<Consumidor> consumidores = Controller.Controller.darConsumidores();
						for(Consumidor c : consumidores) {
							System.out.println(c.getID());
						}
						System.out.println("Ingrese el id del Consumidor: ");
						long idC = sc.nextLong();
						Controller.Controller.adicionarVentas(fecha, idP, idL, idC);
						break;
					case 2:
						// TODO Agregar consumidor producto y local
						break;
					case 5:
						fin3 = true;
						break;
					}
				}
				break;
			case 4:
				System.out.println("Ingrese el nombre");
				String nombreSucursal = sc.next();
				break;
			}
     	}
	}
    /**
	 * Menu 
	 */
	private static void printMenu() //
	{
		System.out.println("------------Nicolas Alvarado----------------");
		System.out.println("----------------201630444-------------------");
		System.out.println("MENU: ");
		System.out.println("1: Iteracion 1");
		System.out.println("2: Iteracion 2");
		System.out.println("3: Iteracion 3");
		System.out.println("Q: Exit");
	}
	
	private static void printMenuI3() {
		System.out.println("------------Nicolas Alvarado----------------");
		System.out.println("----------------201630444-------------------");
		System.out.println("MENU: ");
		//System.out.println("0: Adicionar Venta");
		System.out.println("1: Dar Ventas de un producto en un lapso de tiempo");
		System.out.println("5: Exit");
		
	}
	
	private static void printMenuI1() {
		System.out.println("------------Nicolas Alvarado----------------");
		System.out.println("----------------201630444-------------------");
		System.out.println("MENU: ");
		System.out.println("1: Agregar Consumidor");
		System.out.println("2: Agregar Producto");
		System.out.println("3: Agregar Local");
		System.out.println("Q: Exit");
		
	}
	
}
