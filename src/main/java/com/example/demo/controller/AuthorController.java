package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repositories.AuthorRepository;

@Controller
public class AuthorController {

	private AuthorRepository authorRepository;
	
	public AuthorController(AuthorRepository authorRepository) {

		this.authorRepository = authorRepository;
	}
	
	@RequestMapping("/authors")
	public String getAllAuthors(Model model) {
		
		model.addAttribute("authors", authorRepository.findAll());
		
		return "authors";
	}
}
