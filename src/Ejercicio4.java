package retoUd5;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {

		/* Por último, en la clase llamada Ejercicio4.java, que contendrá un método main
		  y los métodos que consideres necesarios, crearás un programa que se encargará
		  de escribir y leer en el fichero “persona.dat”, 3 objetos de la clase Persona
		  (esta clase la tendrás que haber definido antes, mínimo 4 atributos y un
		  constructor para inicializar el objeto). Utiliza las clases indicadas.
		 */	

		String nombreFichero ="Persona.dat";
		
		crearFichero (nombreFichero);
		escribirEnFichero(nombreFichero);
		
		
	}
	
	
	public static File crearFichero(String nombreFichero)
	{
		String direccionActual = "user.dir";
		
		String direccionFinal = System.getProperty(direccionActual) + File.separator + nombreFichero;
		
		File archivo = new File(direccionFinal);
		
		try
		{
				if(!archivo.exists())
				{
					archivo.createNewFile();
					System.out.println("El fichero se ha creado correctamente");
					
				} else {
					
					System.out.println("El fichero no se ha creado porque ya existe");
				}
		
				return archivo;
	     }
		catch (IOException e)
		{
			System.out.println("Error al crear el fichero");
			e.getMessage();
			return null;
			}
	}
	
	public static void escribirEnFichero(String nombreFichero)
	{
		File miFichero = new File(nombreFichero);
		Scanner sc = new Scanner(System.in);
		Persona p1 = new Persona("Ramon", "Brasil", "Brasileño", 28, 1996);
		Persona p2 = new Persona("Miguel", "España", "Español", 25, 1998);
		Persona p3 = new Persona("Chris", "Canadá", "Canadiense", 29, 1995);

	try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(miFichero)))
	
	{
		oos.writeBytes("------------------\n"
					+"\nNombre: " + p1.getNombre()
					+"\nNacionalidad: " + p1.getNacionalidad()
					+"\nIdioma: " + p1.getIdioma()
					+"\nEdad: " + p1.getEdad()
					+"\nAnio de nacimiento: " + p1.getAnioNacimiento()
					+"\n\n--------------------------\n"
					+"--------------------------\n"
					+"\nNombre: " + p2.getNombre()
					+"\nNacionalidad: " + p2.getNacionalidad()
					+"\nIdioma: " + p2.getIdioma()
					+"\nEdad: " + p2.getEdad()
					+"\nAnio de nacimiento: " + p2.getAnioNacimiento()
					+"\n\n--------------------------\n"
					+"--------------------------\n"
					+"\nNombre: " + p3.getNombre()
					+"\nNacionalidad: " + p3.getNacionalidad()
					+"\nIdioma: " + p3.getIdioma()
					+"\nEdad: " + p3.getEdad()
					+"\nAnio de nacimiento: " + p3.getAnioNacimiento()
					+"\n\n--------------------------\n\n");
	
	
		System.out.println("Contenido escrito en el fichero: " + miFichero.getName());
	
	
	}
	
			catch (IOException e)
	    {
				System.out.println("Error al escribir en el fichero" + miFichero.getName());
				e.printStackTrace();
	    }
	    
	}
	
	
	}
	
	
	
	
