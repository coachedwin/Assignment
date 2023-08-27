package com.nagarro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.dao.AuthorRepository;
import com.nagarro.model.Author;

@Service
public class AuthorService {
	@Autowired
	AuthorRepository authorRepository;
	
	public List<Author> getAuthors(){
		return authorRepository.findAll();
	}

	public void deleteAuthor(int authorId) {
		authorRepository.deleteById(authorId);
		
	}

	public void updateAuthor(Author author, int authorId) {
		author.setID(authorId);
		authorRepository.save(author);
		
	}

	public Author addAuthor(Author author) {
		Author value=authorRepository.save(author);
		return value;
	}

	public Author getAuthorByName(String authorName) {
		Author author=this.authorRepository.findByAuthorName(authorName);
		return author;
	}
	public void saveAuthor() {
		
	}
}