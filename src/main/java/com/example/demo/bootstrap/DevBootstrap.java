package com.example.demo.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.model.Publisher;
import com.example.demo.repositories.AuthorRepository;
import com.example.demo.repositories.BookRepository;
import com.example.demo.repositories.PublisherRepositories;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	private AuthorRepository authorRepository;

	private BookRepository bookRepository;

	private PublisherRepositories publisherRepositories;
	
	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepositories publisherRepositories) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepositories = publisherRepositories;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		intiData();
	}

	private void intiData() {
		
		//create first book instances
		Author author = new Author("Author_1", "Last name 1");
		Publisher publisher = new Publisher("Publisher_1", "Publisher Address 1");
		Book book = new Book("Test Book Title 1", "Book Number_1", publisher);

		author.getBooks().add(book);
		book.getAuthors().add(author);
		
		//save first book details
		
		publisherRepositories.save(publisher);
		authorRepository.save(author);
		bookRepository.save(book);
		
		

		//create second book details
		author = new Author("Author_2", "Last name 2");
		publisher = new Publisher("Publisher_2", "Publisher Address 2");
		book = new Book("Test Book Title 2", "Book Number_2", publisher);

		author.getBooks().add(book);
		book.getAuthors().add(author);
		
		//save second book details
		publisherRepositories.save(publisher);
		authorRepository.save(author);
		bookRepository.save(book);
		
		
	}
}
