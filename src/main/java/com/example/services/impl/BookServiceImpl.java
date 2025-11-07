package com.example.services.impl;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.DtoBook;
import com.example.entities.Book;
import com.example.repository.BookRepository;
import com.example.services.IBookService;
@Service
public class BookServiceImpl implements IBookService{

	
	@Autowired
	private BookRepository bookRepository;
	
	
	@Override
	public DtoBook createBook(DtoBook dtoBook) {
		DtoBook response = new DtoBook();
		
		Book book= new Book();
		BeanUtils.copyProperties(dtoBook, book);
		Book dbBook=bookRepository.save(book);
		BeanUtils.copyProperties(dbBook, response);
		
		return response;
	}


	
	@Override
	public List<DtoBook> getAllListBooks() {
		List<DtoBook> dtoList = new ArrayList<>();
		List<Book> bookList= bookRepository.findAll();
		for(Book book : bookList) {
			DtoBook dto = new DtoBook();
			BeanUtils.copyProperties(book, dto);
			dtoList.add(dto);
		}
		return dtoList;
		
	}



	@Override
	public DtoBook getBookById(Long id) {
		DtoBook dtoBook = new DtoBook();
		Optional<Book> optional= bookRepository.findById(id);
		if(optional.isEmpty()) {
			return null;
			
		}
		Book dbBook= optional.get();
		BeanUtils.copyProperties(dbBook, dtoBook);
		
		return dtoBook;
	}



	@Override
	public void deleteBook(Long id) {
		Optional<Book> optional= bookRepository.findById(id);
		if(optional.isPresent()) {
			bookRepository.delete(optional.get());
		}
		
	}



	@Override
	public DtoBook updateBook(Long id, DtoBook dtoBook) {
		
		return null;
	}

}
