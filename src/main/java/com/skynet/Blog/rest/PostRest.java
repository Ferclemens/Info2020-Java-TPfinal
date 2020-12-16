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

import com.skynet.Blog.model.Post;
import com.skynet.Blog.model.Usuario;
import com.skynet.Blog.repository.ComentarioRepository;
import com.skynet.Blog.repository.PostRepository;
import com.skynet.Blog.repository.UsuarioRepository;

@RestController
@RequestMapping("/post")
public class PostRest {

	@Autowired
	private PostRepository post;
	
	@Autowired
	private UsuarioRepository user;
	
	@Autowired
	private ComentarioRepository comentarios;
	
	@GetMapping("/")
	public ResponseEntity<?> getAll(){
		return new ResponseEntity<>(post.findAll(), HttpStatus.OK);
	}
	
	
	@GetMapping("/{post}/comentarios")
	public ResponseEntity<?> getAllComments(@PathVariable("post") Long post){
		return new ResponseEntity<>(comentarios.findAllCommentsByPublicacionIs(post), HttpStatus.OK);
	}
	
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getOne(@PathVariable("id") Long id){
		return new ResponseEntity<>(post.findById(id), HttpStatus.OK);
	}
	
	
	@PostMapping("/{autor}/post")
	public ResponseEntity<?> createPost(@PathVariable("autor") Long autor, @Validated @RequestBody Post newPost){
		Usuario u = user.getOne(autor);
		newPost.setAutor(u);
		newPost.setFechaCreacion(LocalDate.now());
		return new ResponseEntity<>(post.save(newPost),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletePost(@PathVariable("id") Long id) {
		post.delete(post.getOne(id));
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updatePost(@RequestBody Post newPost, @PathVariable("id") Long id){
		Post editPost = post.getOne(id);
		editPost.setContenido(newPost.getContenido());
		editPost.setDescripcion(newPost.getDescripcion());
		editPost.setTitulo(newPost.getTitulo());
		editPost.setPublicado(newPost.isPublicado());
		return new ResponseEntity<>(post.save(editPost), HttpStatus.OK);
	}
	
}
