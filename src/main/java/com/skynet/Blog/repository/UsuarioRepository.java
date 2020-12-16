package com.skynet.Blog.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skynet.Blog.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	List<Usuario> findByCiudadLike(String ciudad);
	List<Usuario> findByFechaAltaAfter(LocalDate hoy);
	
}
