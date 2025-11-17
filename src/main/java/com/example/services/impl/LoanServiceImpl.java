package com.example.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.DtoBook;
import com.example.dto.DtoLoan;
import com.example.entities.Book;
import com.example.entities.Loan;
import com.example.entities.Member;
import com.example.repository.BookRepository;
import com.example.repository.LoanRepository;
import com.example.repository.MemberRepository;
import com.example.services.ILoanService;
@Service
public class LoanServiceImpl implements ILoanService{

	
	@Autowired
	private LoanRepository loanRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private MemberRepository memberRepository;
	
	
	@Override
	public DtoLoan createLoan(DtoLoan dtoLoan) {
		Optional<Book> optionalBook=bookRepository.findById(dtoLoan.getBookId());
		Optional<Member> optionalMember= memberRepository.findById(dtoLoan.getMemberId());
		
		if(optionalBook.isEmpty() || optionalMember.isEmpty()) {
			return null;
			
		}
		Loan loan = new Loan();
		BeanUtils.copyProperties(dtoLoan, loan,"id","bookId", "memberId", "bookTitle", "memberName");
		loan.setBook(optionalBook.get());
		loan.setMember(optionalMember.get());
		
		
		Loan savedLoan = loanRepository.save(loan);
		return mapToDto(savedLoan);
	}

	@Override
	public List<DtoLoan> getAllListLoans() {
		List<DtoLoan> dtoList= new ArrayList<>();
		List<Loan> loanList= loanRepository.findAll();
		
		for (Loan loan: loanList) {
			dtoList.add(mapToDto(loan));
		}
		return dtoList;
	}

	@Override
	public DtoLoan getLoanById(Long id) {
		Optional<Loan> optionalLoan= loanRepository.findById(id);
		if(optionalLoan.isEmpty()) {
			return null;
		}
		return mapToDto(optionalLoan.get());
	}

	@Override
	public DtoLoan updateLoan(Long id, DtoLoan dtoLoan) {
		Optional<Loan> optionalLoan= loanRepository.findById(id);
		if(optionalLoan.isEmpty()) {
			return null;
		}
		Loan dbLoan = optionalLoan.get();
		dbLoan.setReturnDate(dtoLoan.getReturnDate());
		Loan updatedLoan = loanRepository.save(dbLoan);
		return mapToDto(updatedLoan);
	}

	@Override
	public void deleteLoan(Long id) {
		Optional<Loan> optionalLoan=loanRepository.findById(id);
		if(optionalLoan.isPresent()) {
			loanRepository.delete(optionalLoan.get());
		}
		
	}
	
	private DtoLoan mapToDto(Loan loan) {
        DtoLoan dto = new DtoLoan();
        BeanUtils.copyProperties(loan, dto);
        dto.setBookId(loan.getBook().getId());
        dto.setBookTitle(loan.getBook().getTitle());
        dto.setMemberId(loan.getMember().getId());
        dto.setMemberName(loan.getMember().getName());
        return dto;
    }

}
