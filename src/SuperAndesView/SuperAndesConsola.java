package SuperAndesView;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import Negocio.SuperAndes;

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
			int option = sc.nextInt();

			switch(option)
			{
			//1C cargar informacion dada
			case 1:
				String nombre = sc.next();
				Controller.Controller.adiccionarSuperMercado(nombre);
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
					int option3 = sc.nextInt();
					switch(option3) {
					case 0:
						System.out.println("Ingrese la fecha: ");
						String fechaS = sc.next();
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
						Date parsedDate = dateFormat.parse(fechaS);
						Timestamp fecha = new java.sql.Timestamp(parsedDate.getTime());
						System.out.println("Ingrese el id del producto: ");
						long idP = sc.nextLong();
						System.out.println("Ingrese el id del Local: ");
						long idL = sc.nextLong();
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
			case 5:
				fin = true;
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
		System.out.println("5: Exit");
	}
	
	private static void printMenuI3() {
		System.out.println("------------Nicolas Alvarado----------------");
		System.out.println("----------------201630444-------------------");
		System.out.println("MENU: ");
		//System.out.println("0: Adicionar Venta");
		System.out.println("1: Dar Ventas de un producto en un lapso de tiempo");
		System.out.println("5: Exit");
		
	}
	
}
