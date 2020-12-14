package com.skynet.Blog.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = false, nullable = false)
	@Size(min = 4, max = 30)
	@NotBlank
	private String nombre;
	
	@Column(unique = false, nullable = false)
	@Size(min = 5, max = 25)
	@NotBlank
	private String apellido;
	
	@Column(unique = true, nullable = false)
	@Size(min = 10, max = 60)
	@NotBlank
	private String email;
	
	@Column(unique = false, nullable = false, name = "pass")
	@Size(min = 10, max = 50)
	@NotBlank
	private String password;
	
	@Column(name ="fechaAlta")
	private LocalDate fechaAlta;
	
	@Column(unique = false, nullable = false)
	private String ciudad;
	
	@Column(unique = false, nullable = false)
	private String provincia;
	
	@Column(unique = false, nullable = false)
	private String pais;
}
