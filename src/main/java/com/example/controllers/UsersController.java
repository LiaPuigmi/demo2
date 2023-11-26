package com.example.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.classic.Logger;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api")
public class UsersController {
	
	 private static final Logger logger = (Logger) LoggerFactory.getLogger(UsersController.class);
	/* Injectamos el JdbcTemplate mediante a la anotación
	 * Autowired (mediante a la inyección de dependencias) */
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@RequestMapping(value = "/users", method=RequestMethod.GET)
	public List<String> getAllUsers() {
		// La query que ejecutaremos/lanzaremos jdbcTemplate
		final String QUERY1 = "SELECT * FROM USERS;";

		// Guardamos el resultado de la query
		List<Map<String, Object>> results = jdbcTemplate.queryForList (QUERY1);
		// Creamos el userList en el que guardaremos los usuarios
		List<String> userList = new ArrayList<String>();
		// Recorremos los resultados
		for (Map<String, Object> row : results) {
			// Mostramos la fila (row) en formato de String
			userList.add(row.toString());
		}
		
        logger.info("GET /api/users/ called");

		// Devolvemos el listado
		return userList;
	}
	
	@RequestMapping(value="/user/{id}", method=RequestMethod.GET)
	public Map<String, Object> getUser(@PathVariable String id) {
		logger.info("GET /api/users/{} called", id);
        return jdbcTemplate.queryForMap("SELECT * FROM users WHERE id = "+ id);
	}
	
	
	@RequestMapping(value="/user/insert", method=RequestMethod.POST)
	public String postPerson(@RequestParam(required=true) Integer id,@RequestParam(required=true) String nombre,@RequestParam(required=true) String apellidos,@RequestParam(required=true) String fecha) {
        logger.info("POST /api/users/ called");
		// La query que ejecutaremos/lanzaremos jdbcTemplate
        jdbcTemplate.update("INSERT INTO users VALUES ("+id+",'"+nombre+"','"+apellidos+"','"+ fecha+"')");
		return "Insertado correctamente";
	}

	
	@RequestMapping(value="/user/delete/{id}", method=RequestMethod.DELETE)
	public String deletePerson(@PathVariable Integer id) {
		logger.info("DELETE /api/users/{} called", id);
        jdbcTemplate.update("DELETE FROM users WHERE id = "+ id);
		return "La persona con id "+id+" se ha eliminado";
	}


	@RequestMapping(value="/user/update/{id}", method=RequestMethod.PUT)
	public String updateUser(@PathVariable Integer id, @RequestParam(required=true) String name) {
		logger.info("PUT /api/users/{} called", id);
        jdbcTemplate.update("UPDATE users SET nombre = '"+name+"' WHERE id = "+ id);
		return "El nombre de la persona se ha cambiado correctamente";
	}
}
