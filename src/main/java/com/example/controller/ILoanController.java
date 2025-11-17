package com.example.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.dto.DtoLoan;

@RequestMapping("/api/v1/loans")
public interface ILoanController {

	@PostMapping
	DtoLoan createLoan(@RequestBody DtoLoan dtoLoan);
	
	@GetMapping
	List<DtoLoan> getAllLoan();
	
	@GetMapping("/{id}")
	public DtoLoan getLoanById(@PathVariable Long id);
	
	@DeleteMapping("/{id}")
	public void deleteLoan(@PathVariable Long id);
	
	@PutMapping("/{id}")
	public DtoLoan updaLoan(@PathVariable Long id,@RequestBody DtoLoan updateLoan);
}
