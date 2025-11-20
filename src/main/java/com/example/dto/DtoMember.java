package com.example.dto;



import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.time.LocalDate;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoMember {

	private Long id;
	
	@NotEmpty(message = "Üye adı (name) boş olamaz.")
	private String name;
	
	@NotEmpty(message = "E-posta (email) boş olamaz.")
    @Email(message = "Geçerli bir e-posta adresi giriniz.")
	private String email;
	private String phone;
	private LocalDate joinDate;
	
}
