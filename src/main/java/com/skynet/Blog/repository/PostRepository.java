package com.skynet.Blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skynet.Blog.model.Post;

public interface PostRepository extends JpaRepository<Post, Long>{

}
