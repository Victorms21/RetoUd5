package src;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		/*
		 * Se pide al usuario que introduzca por teclado el nombre de dos ficheros. Estos deben de
		 *  tener una longitud igual o superior a 3, en caso contrario se le pregunta al usuario una 
		 *  y otra vez hasta que por fin introduzca un nombre válido tanto para el primer fichero como 
		 *  para el segundo. Cuando introduzca un nombre válido se le indica que… “el nombre del
		 * fichero XXX es válido”
		 */

		String fichero1, fichero2;

		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("Introduce el nombre del fichero 1\n");
			fichero1 = sc.next();

			if (fichero1.length() < 3) {
				System.out.println("El fichero introducido no es válido,\nDebe contener al menos 3 caracteres\n");
			} else {
				System.out.println("El nombre del fichero " + fichero1 + " es válido\n");
			}

		} while (fichero1.length() < 3);

		do {
			System.out.println("Introduce el nombre del fichero 2\n");
			fichero2 = sc.next();

			if (fichero2.length() < 3) {
				System.out.println("El fichero introducido no es válido,\nDebe contener al menos 3 caracteres\n");
			} else {
				System.out.println("El nombre del fichero " + fichero2 + " es válido\n");
			}

		} while (fichero2.length() < 3);

		/*
		 * Obtén la ruta de tu directorio actual con la instrucción
		 * System.getProperty("user.dir"); y muéstrala en consola.
		 */

		String directorioActual = System.getProperty("user.dir");

		System.out.println(directorioActual);
		
		/* Se construye la ruta relativa al primer fichero
		 * con la instrucción...String rutaCompletaFich = directorioActual 
		 * + File.separator + nombreArchivo1
		 */
		String rutaCompletaFich1 = directorioActual + File.separator + fichero1;
		
		System.out.println(rutaCompletaFich1);
		
		
		if (comprobarExiste(new File(rutaCompletaFich1))) {
				System.out.println("El fichero ya existe, no se puede crear");
		} else {
			try { 
				 File archivo1 = new File(rutaCompletaFich1);
				 
				 archivo1.createNewFile();
				 
				 System.out.println("Se ha creado el archivo");
			} catch (Exception e) {
				e.printStackTrace();			
				}
		}
		
		String rutaCompletaFich2 = directorioActual + File.separator + fichero2;

		System.out.print(rutaCompletaFich2);

		if (comprobarExiste(new File(fichero2))) {
			System.out.println("El fichero ya existe, por lo que no se puede crear\n");
		} else {
			try {
				File archivo2 = new File(rutaCompletaFich2);

				archivo2.createNewFile();

				System.out.println("Se ha creado tu archivo");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		/* Se deben haber creado los dos ficheros si los nombre proporcionados cumplían
		   con las reglas descritas ( ficheros no existentes )
		 */
		
		
		/*A continuación, vas a grabar datos en el primer fichero, para ello vuelve a,
	comprobar con el método comprobarExiste(nombreArchivo1) si el fichero existe y
	en caso de que exista llama al método escribirEnFichero (nombreArchivo1) que
	contiene el código necesario para grabar en dicho fichero los números del 0-10,
	cada uno en una línea diferente y utilizando un bucle for. Usa la clase FileWriter
		*/
		
		
		comprobarExiste(new File(rutaCompletaFich1));
		
		File archivo1 = new File(rutaCompletaFich1);
		
		if (archivo1.exists()) {
			escribirEnFichero(archivo1);
			}
		
		/*Comprueba con el método comprobarExiste(nombreArchivo1) si el fichero existe
		y llama al método leerDeFichero(nombreArchivo1) que contiene el código
		necesario para leer el contenido de dicho archivo. Usa la clase FileReader
		*/
		
		
		comprobarExiste(new File(rutaCompletaFich1));
		
		if (archivo1.exists()) {
			leerDeFichero(archivo1);
			
		}
		
		/* Comprueba con el método comprobarExiste(nombreArchivo1) si el fichero existe,
		en ese caso se mostrarán los siguientes datos del fichero en pantalla: Usa los
		métodos de la clase File
		
		• Nombre del archivo.
		• Ruta absoluta
		• Ruta del directorio padre
		• Tamaño del fichero
		• ¿Es un fichero o un directorio?
		• Permiso de lectura
		• Permiso de escritura
		• Permiso de ejecución
		• ¿Está oculto?
		
		 Si no existe muestra por consola mensaje de que no existe y por tanto no se puede
		realizar la acción de mostrar propiedades del fichero.
		*/
		
		comprobarExiste(new File(rutaCompletaFich1));
		
		if(archivo1.exists()) {
			
			System.out.println("\n---------------------------\n"
			
						+"\nNombre del archivo: "+archivo1.getName() + "\nRuta absoluta: " + archivo1.getAbsolutePath()		
						+ "\nRuta del directorio padre: " + archivo1.getParent() + "\nTamaño del archivo: "
						+ archivo1.length() + " bytes" + "\nEs un fichero o un directorio?: "
						+ (archivo1.isFile() ? "Fichero" : "Directorio") + "\nPermiso de lectura: "
						+ (archivo1.canRead() ? "Si" : "No") + "\nPermiso de escritura: "
						+ (archivo1.canWrite() ? "Si" : "No") + "\nPermiso de ejecución: "
						+ (archivo1.canExecute() ? "Si" : "No") + "\nEstá oculto?: " + (archivo1.isHidden() ? "Si" : "No"));
						
		
		} else { 
				System.out.println("El archivo no existe, por lo tanto no se puede realizar la acción de mostrar propiedades del fichero");
				
		}
		
		/*h) Copia el contenido del primer fichero al segundo, usa el método
		duplicarFicheros(nombreArchivo1, nombreArchivo2)
		*/
		
		File archivo2 = new File(rutaCompletaFich2);
		
		duplicarFicheros(archivo1, archivo2);
		
		/* i) Borra el primer fichero cuyo nombre te indicó el usuario, con una llamada al
		  método borrarFichero(nombreArchivo1).
		 */
		
		borrarFichero(archivo1);
		
		/* j)  En este punto el primer fichero ya no debería existir y el segundo fichero
		 * debe contener una copia del contenido del primero. Vuelve a leer el segundo
		 * archivo para comprobar que la copia se ha realizado y muestra contenido en
		 * pantalla.
		 */
		
		leerDeFichero(archivo2);
		
		/* k)  Crea un directorio llamado “dirEjer1”, pero antes comprueba su existencia con
		 * el método que tienes ya creado para este fin y en caso de que no exista
		 * puedes crearlo. Usa la misma fórmula utilizada anteriormente para la ruta y
		 * el método adecuado de la clase File.
		 */
		
		String nombreDirectorioNuevo = "dirEjer1";
		
		String rutaCompletaDirectorioNuevo = directorioActual + File.separator + nombreDirectorioNuevo;
		
		File directorio = new File(rutaCompletaDirectorioNuevo);
		
		if(comprobarExiste(directorio)) {
			System.out.println("El directorio"+nombreDirectorioNuevo+"ya existe.");
		}else {
			if (directorio.mkdir()) 
         {
        	 System.out.println("Se ha creado el directorio:" + nombreDirectorioNuevo);
         } else {
        	 System.out.println("No se pudo crear el directorio:" + nombreDirectorioNuevo);
                }
		}
	        }
		
         public static boolean leerDeFichero(File miFichero) {
        	 try (BufferedReader br = new BufferedReader(new FileReader(miFichero))) {
        		 String linea;
        		 System.out.println("Contenido del fichero" + miFichero.getName() + ":");
        		 while ((linea = br.readLine()) != null) {
        			 System.out.println(linea);
        		 }
        		 return true;
        	 } catch (IOException e) {
        		 System.out.println("Error al leer el fichero" + miFichero.getName());
        		 	return false;
        		  }
        	 }
         
         public static boolean escribirEnFichero(File miFichero) {
        	 
        	try (BufferedWriter bw = new BufferedWriter(new FileWriter(miFichero))) {
        		
        		for (int i = 0; i <= 10; i++) {
        			
        			bw.write(String.valueOf(i)+ "\n");
        			
        		}
         
        		System.out.println("Contenido escrito en el fichero:" +miFichero.getName());
        		
        		return true;
        	} catch (IOException e) {
        		System.out.println("Error al escribir en el fichero" + miFichero.getName());
        		
        		return false;
        		
        	}
        	
         }
         
         public static boolean borrarFichero(File miFichero) {
        	 
        	 if(miFichero.delete()) {
        		 System.out.println("El fichero se ha borrado con éxito");
        		 return true;
        	 } else {
        		 System.out.println("Error al borrar el fichero" + miFichero.getName());
        		 return false;
        	}
        	
         }
         
         public static boolean comprobarExiste(File fichero) { 
        	 
        	 if (fichero.exists()) {
        		 
        		 System.out.println("\nEl fichero:" + fichero.getName() + " existe\n");
        		 return true;
        	 } else {
        		   System.out.println("\nEl fichero:" + fichero.getName() + " no existe\n");
        		   return false;
        	 }
        	 
        }
         
         
         public static boolean duplicarFicheros(File origen, File destino) {
     		try (BufferedReader br = new BufferedReader(new FileReader(origen));
     				BufferedWriter bw = new BufferedWriter(new FileWriter(destino))) {
     			String linea;
     			while ((linea = br.readLine()) != null) {
     				bw.write(linea);
     				bw.newLine();
     			}
     			System.out.println("Fichero duplicado correctamente.");
     			return true;
     		} catch (IOException e) {
     			System.out.println("Error al duplicar el fichero.");
     			return false;
     		}
   }

     
				
		
		
		
		
		
		


	}


