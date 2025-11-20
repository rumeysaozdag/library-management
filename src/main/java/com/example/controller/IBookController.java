package com.example.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.dto.DtoBook;

import jakarta.validation.Valid;

@RequestMapping("/api/v1/books")
public interface IBookController {

	@PostMapping
	DtoBook createBook(@Valid @RequestBody DtoBook newBookRequest);
	
	@GetMapping
	public List<DtoBook> getAllBooks();
	
	@GetMapping("/{id}")
	public DtoBook getBookById(@PathVariable Long id);
	
	@DeleteMapping("/{id}")
	public void deleteBook(@PathVariable Long id);
	
	
	@PutMapping("/{id}")
	public  DtoBook updateBook(@PathVariable Long id,@Valid @RequestBody DtoBook updateBook);
}
