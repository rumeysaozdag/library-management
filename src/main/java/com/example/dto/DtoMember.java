package com.example.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoMember {

	private Long id;
	private String name;
	private String email;
	private String phone;
	private LocalDate joinDate;
	
}
