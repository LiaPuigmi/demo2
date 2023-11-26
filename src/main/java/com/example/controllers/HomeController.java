package com.example.controllers;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.classic.Logger;

@RestController
@RequestMapping("/api")
public class HomeController {
	 private static final Logger LOGGER= (Logger) LoggerFactory.getLogger(HomeController.class);
	@RequestMapping(value="/persona", method=RequestMethod.GET)
	public String getPerson() {
		Persona persona1=new Persona(1,"Manu", "Martinez",23);
		LOGGER.info(getPerson());
		return persona1.toString();
	}
	
	@RequestMapping(value="/persona", method=RequestMethod.POST)
	public String postPerson(Persona persona) {
		LOGGER.info(postPerson(persona));
		return persona.toString();
	}
	
	@RequestMapping(value="/persona", method=RequestMethod.DELETE)
	public String deletePerson(Integer id) {
		LOGGER.info(deletePerson(id));
		return "La persona con id "+id+" se ha eliminado";
	}
	
	@RequestMapping(value="/persona", method=RequestMethod.PUT)
	public String putPerson(Persona persona) {
		LOGGER.info(putPerson(persona));
		return "Persona introducida correctamente";
	}
	
	/*
	 De la misma forma que hemos visto el @Request Mapping nos permite crear un end point
	 con todos que acepte todos los verbos HIP, definir grupos con algunos verbos HPo
	 inclusive trabajar de forma individual con un solo verbo HTTP.
	 Existe la opción de trabajar con otra opción más especifica si queremos trabajar
	 individualmente con un solo verbo HITP y este se encuentra dentro de las siguientes 5
	 anotaciones: @GetMapping @DeleteMapping  @PatchMapping @PostMapping @PutMapping
	 */
	 

}
