package com.skynet.Blog.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	@JsonIgnore
	@OneToMany(orphanRemoval = true, mappedBy = "autor", fetch = FetchType.LAZY)
	private List<Post> publicaciones;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public List<Post> getPublicaciones() {
		return publicaciones;
	}

	public void setPublicaciones(List<Post> publicaciones) {
		this.publicaciones = publicaciones;
	}
}
