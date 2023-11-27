package com.example.pojo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/*
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
*/
@Data
@Slf4j
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	//Atributes
	private Integer id;
	private String nombre;
	private String apellidos;
	private String fechaNacimiento;
	
	public static void messageInfo(String message) {
		log.info(message);
	}
	
	
	/*
	//Constructors
	public User() {}
	
	public User(Long id, String name, String surname){
		this.id=id;
		this.name=name;
		this.surname=surname;
	}
	
	// Getters & Setters
	public Long getid() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getSurname() {
		return surname;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setId(Long id) {
		this.id=id;
	}
	public void setSurname(String surname) {
		this. surname = surname;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", surname=" + surname + "]";
	}
	*/
}