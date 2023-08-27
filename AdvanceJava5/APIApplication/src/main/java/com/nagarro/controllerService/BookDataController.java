package com.nagarro.controllerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.model.Book;
import com.nagarro.service.BookService;
import java.util.List;

@RestController
public class BookDataController {

	@Autowired
	BookService bookService;

	@GetMapping("/books")
	public List<Book> readBookData() {

		List<Book> list = bookService.getAllBooks();
		return list;
	}
	
	@GetMapping("/books/{bookCode}")
	public List<Book> getBookById(@PathVariable("bookCode") int bookCode) {

		List<Book> list = bookService.getBookById(bookCode);
		return list;
	}

	
	@PutMapping("/books/{bookId}")
	public Book updateBook(@RequestBody Book book,@PathVariable("bookId") int bookId) {
		this.bookService.updateBook(book, bookId);
		return book;
	}
	
	
	@PostMapping("/books")
	public Book addBook(@RequestBody Book book) {
		Book b=this.bookService.addBook(book);
		return b;
	}
	
	@DeleteMapping("/books/{bookCode}")
	public void deleteBook(@PathVariable("bookCode") int bookCode) {
		System.out.println(bookCode);
		bookService.deleteBook(bookCode);
	}
	
}
