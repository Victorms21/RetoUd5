package src;

public class Persona {
	
	
	String nombre, nacionalidad, idioma;
	int edad, anioNacimiento;
	
	
	public Persona(String nombre, String nacionalidad, String idioma, int edad, int anioNacimiento)
	{
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
		this.idioma = idioma;
		this.edad = edad;
		this.anioNacimiento = anioNacimiento;
		
	}
	
	public String getNombre() {
        return nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public String getIdioma() {
        return idioma;
    }

    public int getEdad() {
        return edad;
    }

    public int getAnioNacimiento() {
        return anioNacimiento;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setAnioNacimiento(int anioNacimiento) {
        this.anioNacimiento = anioNacimiento;
    }
	
}