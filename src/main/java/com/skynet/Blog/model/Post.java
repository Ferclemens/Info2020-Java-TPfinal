package com.skynet.Blog.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = false)
	@Size(min = 10, max = 60)
	@NotBlank
	private String titulo;
	
	@Column(nullable = false, unique = false)
	@Size(min = 50, max = 500)
	@NotBlank
	private String descripcion;
	
	@Column(nullable = false, unique = false)
	@Size(min = 300, max = 5000)
	@NotBlank
	private String contenido;
	
	@Column(name = "fechaCreacion")
	private LocalDate fechaCreacion;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_autor")
	private Usuario autor;
	
	@Column
	private boolean publicado;

}
