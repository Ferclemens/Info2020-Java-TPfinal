package com.skynet.Blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skynet.Blog.model.Comentario;

public interface ComentarioRepository extends JpaRepository<Comentario, Long>{
	List<Comentario> findAllCommentsByPublicacionIs(Long post);
}
