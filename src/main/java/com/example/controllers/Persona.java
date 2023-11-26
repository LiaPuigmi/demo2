package com.example.controllers;

public class Persona {
	private Integer id;
	private String nombre;
	private String apellidos;
	private Integer edad;
	
	public Persona() {}
	
	public Persona(Integer id, String nombre, String apellidos, Integer edad) {
		this.id=id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
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
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	
	@Override
	public String toString() {
		return "Persona [id="+id+",nombre=" + nombre + ", apellidos=" + apellidos + ", edad=" + edad + "]";
	}
}
