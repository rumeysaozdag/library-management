package com.example.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoLoan {

	private Long id;
	private Date loanDate;
	private Date returnDate;
	private Date dueDate;
	
	
	private Long bookId;
	private Long memberId;
	
	
	private String bookTitle;
	private String memberName;
}
