package com.nagarro.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Formatter;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nagarro.dao.BookRepository;
import com.nagarro.model.Book;

@Component
public class BookService {
	@Autowired
	BookRepository bookRepository;
	

	public List<Book> getAllBooks() {
        List<Book> list=(List<Book>)this.bookRepository.findAll();
        return list;
    }
	
	public void deleteBook(int id) {
		bookRepository.deleteById(id);
	}
    
	
	public void updateBook(Book book,int bookId) {
		book.setBookCode(bookId);
		bookRepository.save(book);
	}
	
	public Book addBook(Book b) {
		   Book result=bookRepository.save(b);
	       return result;
		}

	public List<Book> getBookById(int bookCode) {
		List<Book> list=(List<Book>) bookRepository.findByBookCode(bookCode);
		return list;
	}
}
