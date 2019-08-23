package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.examplebeans.FakeDataSource;
import com.example.demo.repositories.AuthorRepository;

@Controller
public class AuthorController {

	private AuthorRepository authorRepository;
	
	@Autowired
	private FakeDataSource fakeDataSource;
	
	public AuthorController(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}
	
	@RequestMapping("/authors")
	public String getAllAuthors(Model model) {
		
		model.addAttribute("authors", authorRepository.findAll());
		
System.out.println(fakeDataSource);
		return "authors";
	}
}
