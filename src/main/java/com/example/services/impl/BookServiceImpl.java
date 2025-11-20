package com.example.services.impl;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.DtoBook;
import com.example.entities.Book;
import com.example.exception.ResourceNotFoundException;
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
		Book dbBook = bookRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Kitap bulunamadı. ID: " + id));
		
		DtoBook dtoBook = new DtoBook();
		BeanUtils.copyProperties(dbBook, dtoBook);
		return dtoBook;
	}



	@Override
	public void deleteBook(Long id) {
		Book book = bookRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Silinecek kitap bulunamadı. ID: " + id));
		
		
		bookRepository.delete(book);
	}



	@Override
	public DtoBook updateBook(Long id, DtoBook dtoBook) {
		Book dbBook = bookRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Güncellenecek kitap bulunamadı. ID: " + id));

		
		dbBook.setTitle(dtoBook.getTitle());
		dbBook.setIsbn(dtoBook.getIsbn());
		dbBook.setPublisher(dtoBook.getPublisher());
		dbBook.setPublicationYear(dtoBook.getPublicationYear());
		
		
		Book updateBook = bookRepository.save(dbBook);
		
		
		DtoBook dto = new DtoBook();
		BeanUtils.copyProperties(updateBook, dto);
		return dto;
	}

}
