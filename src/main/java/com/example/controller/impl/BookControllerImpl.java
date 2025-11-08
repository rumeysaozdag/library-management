package com.example.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.controller.IBookController;
import com.example.dto.DtoBook;
import com.example.services.IBookService;
@RestController

public class BookControllerImpl implements IBookController{
	
	@Autowired
	private IBookService bookService;
	

	@Override
	public DtoBook createBook(DtoBook newBookRequest) {
		
		return bookService.createBook(newBookRequest);
	}

	@Override
	public List<DtoBook> getAllBooks() {
	
		return bookService.getAllListBooks();
	}

	@Override
	public DtoBook getBookById(Long id) {
		
		return bookService.getBookById(id);
	}

	@Override
	public void deleteBook(Long id) {
		bookService.deleteBook(id);
		
	}

	@Override
	public DtoBook updateBook(Long id, DtoBook updateBook) {
		// TODO Auto-generated method stub
		return bookService.updateBook(id, updateBook);
	}

}
