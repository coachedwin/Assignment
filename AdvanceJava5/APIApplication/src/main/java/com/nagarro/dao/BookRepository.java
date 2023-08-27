package com.nagarro.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.nagarro.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{
	public List<Book> findByBookCode(int bookCode);

}
