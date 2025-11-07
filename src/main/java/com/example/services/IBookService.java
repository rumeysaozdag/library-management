package com.example.services;

import java.util.List;

import com.example.dto.DtoBook;
import com.example.entities.Book;


public interface IBookService {

	DtoBook createBook(DtoBook dtoBook);
	
	public List<DtoBook> getAllListBooks();
	
	public DtoBook getBookById(Long id);
	
    public void deleteBook(Long id);
    
    DtoBook updateBook(Long id, DtoBook dtoBook);

	
	
}
