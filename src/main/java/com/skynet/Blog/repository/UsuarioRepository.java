package com.skynet.Blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skynet.Blog.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
