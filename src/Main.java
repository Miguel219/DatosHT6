import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args){

		//Se crea el scanner 
		Scanner s = new Scanner(System.in);
		//Variable con el numero de impementacion
		int implementacion = 0;
		//Variable que valida lo ingresado por el usuario
		Boolean validado = false;
		//Variable 	que almacena la opcion del menu seleccionada
		int menu = 0;
		//Se crea el factory de Map
		MapFactory<String,String> mapFactory = new MapFactory<String, String>();
		//Se crea dos objeto Map uno que posee todas las cartas y ootro que es la coleccion del usuario
		Map<String,String> cartas;
		Map<String,String> coleccion;
		
		
		//Se le pregunta al usuario la implementacion a usar
		System.out.println("Ingresa el número de la implementación  de MAP que usará el programa:\n1.HashMap\n2.TreeMap \n3.LinkedHashMap");
		do {
			String implementacionStr = s.nextLine();
			try {
				implementacion = Integer.parseInt(implementacionStr);
				if((implementacion==1)||(implementacion==2)||(implementacion==3)) {
					validado = true;
				}else {
					validado = false;
					System.out.println("Ingrese una opción correcta");
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Ingrese una opción correcta");
				validado = false;
			}
		}while(validado==false);

		cartas = mapFactory.getList(implementacion);
		coleccion = mapFactory.getList(implementacion);
		
		try {
			Stream<String> lines = Files.lines(Paths.get("cartas.txt"),StandardCharsets.UTF_8);
			lines.forEach(i->{
				String nombre = i.substring(0, i.indexOf("|"));
				String tipo = i.substring(i.indexOf("|")+1);
				cartas.put(nombre, tipo);
			});
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("nooo");
		}
			
		do {
			System.out.println("Ingresa el número de una opcion del menu:\n1.Agregar una carta a la colección\n2.Mostrar el tipo de una carta específica"
					+ "\n3.Mostrar el nombre, tipo y cantidad de cada carta en la colección\n4.Mostrar el nombre, tipo y cantidad de cada carta en la colección, ordenadas por tipo"
					+ "\n5.Mostrar el nombre y tipo de todas las cartas existentes\n6.Mostrar el nombre y tipo de todas las cartas existentes,ordenadas por tipo\n7.Salir");
			do{
				//Se setea validado falso
				validado = false;
				String menuStr = s.nextLine();
				try {
					menu = Integer.parseInt(menuStr);
					if((menu>=1)&&(menu<=7)) {
						validado = true;
					}else {
						System.out.println("Ingrese una opción correcta");
						validado = false;
					}
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Ingrese una opción correcta");
					validado = false;
				}
			}while(validado==false);
			
			//Funcion 1
			if(menu==1) {
				System.out.println("Ingrese el nombre de la carta para agregarla a la colección:");
				String nombre = s.nextLine();
				
				//Se busca entre las cartas el nombre ingresado
				String tipo = cartas.get(nombre);
				if(tipo!=null) {
					coleccion.put(nombre, tipo);
				}else {
					System.out.println("El nombre ingresado no es valido");
				}
				System.out.println("");
			}
			
			//Funcion 2
			if(menu==2) {
				System.out.println("Ingrese el nombre de la carta para ver su tipo:");
				String nombre = s.nextLine();
				
				//Se busca entre las cartas el nombre ingresado
				String tipo = cartas.get(nombre);
				if(tipo!=null) {
					System.out.println("El tipo de la carta es: "+tipo);
				}else {
					System.out.println("El nombre ingresado no es valido");
				}
				System.out.println("");
			}
			
			//Funcion 3
			if(menu==3) {
				//Se busca entre las cartas el nombre ingresado
				coleccion.forEach((nombre,tipo)->{
					System.out.println("Nombre: "+nombre+" Tipo: "+tipo);
				});
				System.out.println("");
			}
			
			//Funcion 4
			if(menu==4) {
				//Se busca entre las cartas el nombre ingresado
				coleccion.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getValue)).forEach(c->{
					System.out.println("Nombre: "+c.getKey()+" Tipo: "+c.getValue());
				});
				System.out.println("");
			}
			
			//Funcion 5
			if(menu==5) {
				//Se busca entre las cartas el nombre ingresado
				cartas.forEach((nombre,tipo)->{
					System.out.println("Nombre: "+nombre+" Tipo: "+tipo);
				});
				System.out.println("");
			}
			
			//Funcion 4
			if(menu==6) {
				//Se busca entre las cartas el nombre ingresado
				cartas.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getValue)).forEach(c->{
					System.out.println("Nombre: "+c.getKey()+" Tipo: "+c.getValue());
				});
				System.out.println("");
			}
			
		} while (menu!=7);
	}
}
