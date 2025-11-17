package com.example.services;

import java.util.List;

import com.example.dto.DtoLoan;

public interface ILoanService {

	DtoLoan createLoan(DtoLoan dtoLoan);
	
	public List<DtoLoan> getAllListLoans();
	
	DtoLoan getLoanById(Long id);
	
	DtoLoan updateLoan(Long id, DtoLoan dtoLoan);
	
	void deleteLoan(Long id);
	
}
