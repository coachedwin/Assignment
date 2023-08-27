package com.nagarro.controllerService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.model.Author;
import com.nagarro.service.AuthorService;


@RestController
public class AuthorController {
	@Autowired
	private AuthorService authorService;
	
	@GetMapping("/authors")
	public List<Author> showAuthor(){
		return authorService.getAuthors();
	}
	
	@GetMapping("/authors/{authorName}")
		public Author getAuthor(@PathVariable("authorName")String authorName) {
			return this.authorService.getAuthorByName(authorName);
		}
	
	@PostMapping("/authors")
	public Author addAuthor(@RequestBody Author author) {
		Author add=this.authorService.addAuthor(author);
		return add;
	}
	
	@PutMapping("/authors/{authorId}")
	public Author updateAuthor(@RequestBody Author author,@PathVariable("authorId")int authorId) {
		this.authorService.updateAuthor(author,authorId);
		return author;
	}
	
	@DeleteMapping("authors/{authorId}")
	public void deleteAuthor(@PathVariable("authorId")int authorId) {
		this.authorService.deleteAuthor(authorId);
	}
	
	
	
}
