package com.example.entities;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Table(name="loans")
@Data
public class Loan {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="book_id", nullable = false)
	private Book book;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@Column(name="member_id",nullable = false)
	private Member member;
	
	
	@Temporal(TemporalType.DATE)
	@Column(name="loan_date",nullable = false)
	private Date loanDte;
	
	
	@Temporal(TemporalType.DATE)
	@Column(name="due_date",nullable = false)
	private Date dueDate;
	
	
	@Temporal(TemporalType.DATE)
	@Column(name="return_date")
	private Date returnDate;
	
}
