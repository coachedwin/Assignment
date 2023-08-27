package com.nagarro.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nagarro.model.Author;

public interface AuthorRepository extends JpaRepository<Author ,Integer> {
	
	@Query("select a from Author a where a.name=:authorName")
	public Author findByAuthorName(@Param("authorName")String authorName);
	
	
}