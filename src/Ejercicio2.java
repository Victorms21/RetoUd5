package src;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileWriter;

public class Ejercicio2 {

	public static void main(String[] args) {
	/*Se trata de crear una clase llamada Ejercicio2.java y allí elaborar un programa que se
	encargará de crear un directorio y dentro dos ficheros, dentro de uno de los ficheros se
	almacenarán nombres de personas introducidos por teclado hasta que el usuario te
	indique lo contrario. Maneja las excepciones necesarias. Sigue las instrucciones.
	*/

	/* a) Muestra el directorio actual por consola y allí crea un nuevo directorio llamado
	“dirEjer2” y dentro dos ficheros, el fichero “uno.txt” y “dos.txt”. (Usa clase File y
	sus métodos como anteriormente y comprueba si existen o no antes de crearlos).
    */
		
		
		Ejercicio1 ej1 = new Ejercicio1();
		
		String directorioActual = System.getProperty("user.dir");
		
		System.out.println(directorioActual);
		
		String nuevoDirectorio = "dirEjer2" ;
		
		File carpeta = new File(nuevoDirectorio);
		
		carpeta.mkdir();
		
		String fichero1 = "uno.txt" , fichero2 = "dos.txt";
		
		File archivo1 = new File(carpeta + File.separator + fichero1);
		
		File archivo2 = new File(carpeta + File.separator + fichero2);
		
		if (!archivo1.exists()) {
			try {
					archivo1.createNewFile();
					System.out.println("El archivo: " + fichero1 + " se ha creado");
			} catch (IOException e) {
				    System.out.println("El archivo " + fichero1 + " no se ha podido crear");
				    e.getMessage();
			}
		} else {
			   System.out.println("El archivo: " + fichero2 + " no se ha creado porque ya existe");
		}
		if (!archivo2.exists()) {
			try {
				 archivo2.createNewFile();
				 System.out.println("El archivo: " + fichero2 + " se ha creado");
			
			} catch (IOException e) {
				System.out.println("El archivo: " + fichero2 + " NO se ha podido crear");
				e.getMessage();
			}

		} else {
			System.out.println("El archivo: " + fichero2 + " NO se ha creado porque ya existe");
		} 
				 
	 
	
		
		
	/* b) Abre el fichero “uno.txt” para escritura. Usa la clase BufferedWriter en
	  combinación con FileWriter.
	 */	 
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(archivo1, true)))
		
		{
		

			/* c) Pide al usuario que introduzca un nombre y pulse ‘Enter’ para continuar con
			  la introducción de nombres. El proceso finaliza cuando se pulse solo un guión
			  “- “, en ese momento se dejará de escribir en el fichero.
			 */
		
			Scanner sc = new Scanner(System.in);
			String nombres;
			System.out.println("\n------------------\n"
					
							+ "\nIntroduzca un nombre, pulse ENTER para continuar con la introducción de nombres"
							+"\nPara finalizar pulse '-' ");
			
			do {
				   nombres = sc.next();
				   if (!nombres.equalsIgnoreCase("-")) {
					   	bw.write(nombres);
					   	bw.newLine();
					   } else {
						       break;
					   }
			} while(!nombres.equalsIgnoreCase("-"));
			bw.close();
			sc.close();
			
		} catch (IOException e) {
			 System.out.println("No se ha podido escribir en el archivo");
			 
			 e.getMessage();
		
		}
		/* d) En este punto debes tener en el fichero “dos.txt” los nombres que se han
		  introducido por teclado.
		 */

			
			Ejercicio1.duplicarFicheros(archivo1, archivo2);
			
			// e) Abre el fichero “dos.txt” para lectura y muestra su contenido.
			
			try(BufferedReader bf = new BufferedReader(new FileReader(archivo2)))
			{ String linea;
			
			while ((linea = bf.readLine()) !=null)
			{
						System.out.println(linea);
			}
			
			
		}
			catch (IOException e)
			{
				System.out.println("No se ha podido leer el archivo");
				e.getMessage();
				
			
			
			}
			
		
		}
	
}

