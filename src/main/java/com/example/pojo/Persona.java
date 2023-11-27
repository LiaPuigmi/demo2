package com.example.pojo;

public class Persona {
	private Integer id;
	private String nombre;
	private String apellidos;
	private String fechaNacimiento;
	
	public Persona() {}
	
	public Persona(Integer id, String nombre, String apellidos, String fechaNacimiento) {
		this.id=id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getId() {
		return nombre;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getfechaNacimiento() {
		return fechaNacimiento;
	}
	public void setfechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	@Override
	public String toString() {
		return "Persona [id="+id+",nombre=" + nombre + ", apellidos=" + apellidos + ", fecha Nacimiento=" + fechaNacimiento + "]";
	}
}

/*
 * Un **Java Bean** y un **POJO (Plain Old Java Object)** son conceptos utilizados en la programación Java, pero tienen algunas diferencias clave:

- **Java Bean**: Es una clase en Java que debe seguir ciertas convenciones:
    * Debe implementar la interfaz Serializable, lo que hace que un objeto Java Bean pueda ser guardado, transmitido y reconstruido.
    * Debe tener un constructor sin argumentos, lo que permite que se cree una instancia sin pasar información inicial.
    * Debe permitir el acceso a las propiedades utilizando métodos getter y setter. Estos métodos siguen una convención de nomenclatura basada en el nombre de la propiedad.

- **POJO (Plain Old Java Object)**: Este término se utiliza para enfatizar que un objeto no necesita ser parte de un marco especial o requerir cualquier clase base para proporcionar su funcionalidad. Un POJO no tiene ninguna restricción aparte de las impuestas por la especificación del lenguaje Java. No necesita implementar interfaces específicas, extender una clase base particular o tener anotaciones específicas.

Por lo tanto, un Java Bean es un tipo de POJO que sigue ciertas convenciones adicionales. Sin embargo, no todos los POJOs son Java Beans porque pueden no seguir estas convenciones. En resumen, todos los Java Beans son POJOs, pero no todos los POJOs son Java Beans. Espero que esto aclare tu duda. 😊
 */
