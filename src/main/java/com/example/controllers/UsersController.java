package com.example.controllers;

import java.util.List;
import java.util.Map;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ch.qos.logback.classic.Logger;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/users")
public class UsersController {
	
	 private static final Logger logger = (Logger) LoggerFactory.getLogger(UsersController.class);
	/* Injectamos el JdbcTemplate mediante a la anotación
	 * Autowired (mediante a la inyección de dependencias) */
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@GetMapping("/all")
	public ResponseEntity<List<Map<String, Object>>> getAllUsers() {
		try {
			// La query que ejecutaremos/lanzaremos jdbcTemplate
			final String QUERY1 = "SELECT * FROM USERS;";
	
			// Guardamos el resultado de la query
			List<Map<String, Object>> results = jdbcTemplate.queryForList (QUERY1);
			logger.info("GET /api/users/all called");
	        return ResponseEntity.ok(results); // Devuelve el código de estado 200
		
	     } catch (EmptyResultDataAccessException e) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(List.of(Map.of("message", "No existe un usuario con dicho ID"))); // Devuelve el código de estado 404
	     }

	}

	
	@GetMapping("/{id}")
	public ResponseEntity <Map<String, Object>> getUser(@PathVariable Integer id) {
		 try {
			 Map<String, Object> user = jdbcTemplate.queryForMap("SELECT * FROM users WHERE id = "+ id);
			 logger.info("GET /api/users/{} called", id);
	         return ResponseEntity.ok(user); // Devuelve el código de estado 200
	     } catch (EmptyResultDataAccessException e) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", "No existe un usuario con dicho ID")); // Devuelve el código de estado 404
	     }
     //   return jdbcTemplate.queryForMap("SELECT * FROM users WHERE id = "+ id);
	}
	

	
	@PostMapping("/add/{id}")
	public ResponseEntity<Map<String, String>> postPerson(@PathVariable Integer id, @RequestParam(required=true) String nombre,@RequestParam(required=true) String apellidos,@RequestParam(required=true) String fecha) {
		 if(getUser(id).equals(ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", "No existe un usuario con dicho ID")))) {
			 try {
			        jdbcTemplate.update("INSERT INTO users VALUES ("+id+",'"+nombre+"','"+apellidos+"','"+ fecha+"')");
					logger.info("POST /api/users/ called");
			        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("message","Usuario creado correctamente")); // Devuelve el código de estado 201
			 } catch (EmptyResultDataAccessException e) {
		            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", "Ya existe un usuario con dicho ID")); // Devuelve el código de estado 404
		     }
		}else {
			return ResponseEntity.ok(Map.of("message", "Ya existe un usuario con dicho ID")); // Devuelve el código de estado 200
		}
		
	}

	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Map<String, String>> deletePerson(@PathVariable Integer id) {
		try { 
			int rowsAffected =jdbcTemplate.update("DELETE FROM users WHERE id = "+ id);
			 if (rowsAffected == 0) {
			     return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", "No existe un usuario con dicho ID")); // Devuelve el código de estado 404
			 } else {
			     logger.info("DELETE /api/users/{} called", id);
			     return ResponseEntity.ok(Map.of("message", "La persona con id "+id+" se ha eliminado")); // Devuelve el código de estado 200
			 }
		}catch (EmptyResultDataAccessException e) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", "No se pudo eliminar el usuario")); // Devuelve el código de estado 404
	    }
	}


	@PutMapping("/update/{id}")
	public ResponseEntity<Map<String, String>> updateUser(@PathVariable Integer id, @RequestParam(required=true) String nombre) {
		if(!getUser(id).equals(ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", "No existe un usuario con dicho ID")))) {
			try {
				jdbcTemplate.update("UPDATE users SET nombre = '"+nombre+"' WHERE id = "+ id);
				logger.info("POST /api/users/ called");
				return ResponseEntity.ok(Map.of("message", "El nombre de la persona se ha cambiado correctamente")); // Devuelve el código de estado 200
			}catch (EmptyResultDataAccessException e) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", "No se pudo modificar el usuario")); // Devuelve el código de estado 404
		    }
		}else {
			return ResponseEntity.ok(Map.of("message", "No existe un usuario con dicho ID")); // Devuelve el código de estado 200
		}
	}
}
