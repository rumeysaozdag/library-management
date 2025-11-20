package com.example.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.controller.ILoanController;
import com.example.dto.DtoLoan;
import com.example.services.ILoanService;

@RestController
public class LoanControllerImpl implements ILoanController{

	
	@Autowired
	private ILoanService loanService;
	
	
	@Override
	public DtoLoan createLoan(DtoLoan dtoLoan) {
		
		return loanService.createLoan(dtoLoan);
	}

	@Override
	public List<DtoLoan> getAllLoan() {
		
		return loanService.getAllListLoans();
	}

	@Override
	public DtoLoan getLoanById(Long id) {
		// TODO Auto-generated method stub
		return loanService.getLoanById(id);
	}

	@Override
	public void deleteLoan(Long id) {
		loanService.deleteLoan(id);
		
	}

	@Override
	public DtoLoan updaLoan(Long id, DtoLoan updateLoan) {
		// TODO Auto-generated method stub
		return loanService.updateLoan(id, updateLoan);
	}

}
