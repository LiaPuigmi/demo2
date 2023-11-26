package com.example.controllers;

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
