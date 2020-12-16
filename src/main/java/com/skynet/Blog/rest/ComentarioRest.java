package com.skynet.Blog.rest;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skynet.Blog.model.Comentario;
import com.skynet.Blog.repository.ComentarioRepository;
import com.skynet.Blog.repository.PostRepository;
import com.skynet.Blog.repository.UsuarioRepository;

@RestController
@RequestMapping("/comentario")
public class ComentarioRest {

	@Autowired
	private ComentarioRepository cr;
	
	@Autowired
	private PostRepository pr;
	
	@Autowired
	private UsuarioRepository user;
	
	@GetMapping("/")
	public ResponseEntity<?> getAll(){
		return new ResponseEntity<>(cr.findAll(), HttpStatus.OK);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getOne(@PathVariable("id") Long id){
		return new ResponseEntity<>(cr.getOne(id), HttpStatus.OK);
	}
	
	
	@PostMapping("/{autor}/{post}/comments")
	public ResponseEntity<?> createComentario(@PathVariable("autor") Long autor,@PathVariable("post") Long post, @Validated @RequestBody Comentario newComentario){
		newComentario.setFechaCreacion(LocalDate.now());
		newComentario.setAutor(user.getOne(autor));
		newComentario.setPublicacion(pr.getOne(post));
		return new ResponseEntity<>(cr.save(newComentario), HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteComentario(@PathVariable("id") Long id) {
		cr.delete(cr.getOne(id));
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateComentario(@RequestBody Comentario newComentario, @PathVariable("id") Long id){
		Comentario editComentario = cr.getOne(id);
		editComentario.setComentario(newComentario.getComentario());
		return new ResponseEntity<>(cr.save(editComentario), HttpStatus.OK);
	}
}
