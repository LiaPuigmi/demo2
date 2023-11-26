package com.example.controllers;

import java.util.Map;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import ch.qos.logback.classic.Logger;

@Controller
public class IndexController {

	 @GetMapping("/hola1") 
	  public ModelAndView test() { 
		  ModelAndView modelAndView = new ModelAndView(); 
		  modelAndView.setViewName("index.html");
		  modelAndView.setStatus(HttpStatus.I_AM_A_TEAPOT); 
		  return modelAndView; 
	  }
	 
	 @ResponseBody
	@RequestMapping(path="/hola2", produces="application/json")
		 public String test2() {
		  	return "{\"page\": \"index.html\"}";
		 }
	 
	 /*
	  * 5. ¿Cómo arrancarías una aplicación de Spring Boot desde la línea de comandos? Haz la
	  * prueba, arrancarlo desde la CMD (necesitaras tener Maven instalado)
	  * To run the application, run the following command in a terminal window (in the complete) directory:
		./gradlew bootRun
		If you use Maven, run the following command in a terminal window (in the complete) directory:
		./mvnw spring-boot:run
	  * 6. ¿Cómo podemos mirar las dependencias que tenemos añadidas en nuestro proyecto?
	  * ¿Qué maneras tenemos de sacar el árbol de jerarquía de dependencias?
	  * en el pom.xml y con la comanda mvn dependency-tree
	  */
	 @ResponseBody
	 @RequestMapping(value = {"/hello", "/hola","/salut"})
	 public String getPerson() {
	 return "Hola, hello, salut";
	 
	 }
	 
	 @GetMapping("/welcome")
	 @ResponseBody
	 public String welcomeWithParams(@RequestParam(required=false,defaultValue="desconocido") String name, @RequestParam(required=false,defaultValue="desconocidos") String surname) {
		return "Bienvenide "+ name+" "+surname;
		 
	 }	//  	

	 @GetMapping("/welcome2")
	 @ResponseBody
	 public String welcomeWithParams2(@RequestParam(required=false,defaultValue="desconocido") String name, @RequestParam(required=false,defaultValue="desconocidos") String surname) {
		 return "{\n\"name\": \""+name+"\",\n\"surname\": \""+surname+"\"\n}";
		 
	 }
	
	 private static final Logger LOGGER= (Logger) LoggerFactory.getLogger(IndexController.class);

	 @GetMapping("/test")
	 @ResponseBody
	 public String updateFoos(@RequestParam(required=false, defaultValue="La zona de parámetro está vacía ¡No has enviado nada!") Map<String,String> allParams) {
		 allParams.forEach((k,v) -> LOGGER.info("Key: " + k + ": Value: " + v));
		 return "Parameters are "+allParams.entrySet();
	 }
	 
	 @GetMapping("/discoteca")
	 @ResponseBody
	 public String giveMeEdad(@RequestParam(required=false) Integer edad) {
		if(edad==null) {
			return "¡No has enviado nada!";
	 	}else if(edad<18) {
			 return "No puedes pasar tronco";
		 }else {
			 return "Puedes pasar!";

		 }
	 }
	 
	 @GetMapping("/caraocruz")
	 @ResponseBody
	 public String giveMeChance(@RequestParam(required=false) String cara) {
		int num= (int) Math.round(Math.random());
		//0 es cruz y 1 cara
		if(cara.equals("cara")) {
			if(num==0) {
				return "Has perdido";
			}else {
				return "Has ganado!";
			}
	 	}else if(cara.equals("cruz")) {
	 		if(num==0) {
				return "Has ganado!";
			}else {
				return "Has perdido";
			}
		 }else {
			 return "¡No has elegido cara o cruz!";

		 }
	 }
	 
	 @GetMapping("{numero}/factura")
	 @ResponseBody
	 public String numFact(@PathVariable(name="numero") Optional<Integer> numero) {
		if(numero.isEmpty()) {
			return "¡No has enviado el numero!";
	 	}else if(numero.get()%2==0) {
			 return "Es par";
		 }else {
			 return "Es impar";

		 }
	 }
}
