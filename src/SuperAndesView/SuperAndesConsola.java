package SuperAndesView;

import java.util.Scanner;

import Negocio.SuperAndes;

public class SuperAndesConsola {

	private SuperAndes superController;
	
	public static void main(String[] args) 
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
		System.out.println("---------ISIS 2304 - Sistemas Transaccionales----------");
		System.out.println("---------------------Iteracion 1----------------------");
		System.out.println("MENU:");
		System.out.println("1. Cargar toda la informacion dada una fuente de datos (small,medium, large).");
		System.out.println("2: Registrar un producto");
		System.out.println("4. Registrar una sucursal");
	}
	
}
