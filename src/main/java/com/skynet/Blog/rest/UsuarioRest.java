package com.skynet.Blog.rest;


import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skynet.Blog.repository.UsuarioRepository;
import com.skynet.Blog.model.Usuario;

@RestController
@RequestMapping("/usuario")
public class UsuarioRest {

	@Autowired
	private UsuarioRepository user;
	
	@GetMapping("/")
	public ResponseEntity<?> getAllUsers(){
		return new ResponseEntity<>(user.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getOneUser(@PathVariable("id") Long id) {
		return new ResponseEntity<>(user.findById(id), HttpStatus.OK);
	}
	
	
	@PostMapping("/")
	public ResponseEntity<?> createUser(@RequestBody Usuario newUser){
		newUser.setFechaAlta(LocalDate.now());
		return new ResponseEntity<>(user.save(newUser), HttpStatus.CREATED);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editUser(@PathVariable("id") Long id, @RequestBody Usuario newUser){
		Usuario userEdit = user.getOne(id);
		userEdit.setApellido(newUser.getApellido());
		userEdit.setNombre(newUser.getNombre());
		userEdit.setEmail(newUser.getEmail());
		userEdit.setPassword(newUser.getPassword());
		userEdit.setCiudad(newUser.getCiudad());
		userEdit.setProvincia(newUser.getProvincia());
		userEdit.setPais(newUser.getPais());
		return new ResponseEntity<>(user.save(userEdit), HttpStatus.OK);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable("id") Long id){
		user.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
