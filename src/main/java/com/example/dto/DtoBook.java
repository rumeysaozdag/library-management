package com.example.dto;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Min;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoBook {

	
	private Long id;
	
	@NotEmpty(message="Kitap başlığı(title) boş olomaz")
    @Size(min = 2, message = "Kitap başlığı en az 2 karakter olmalıdır.")
	private String title;
	
	@NotEmpty(message = "ISBN boş olamaz.")
	@Size(min = 10, max = 13, message = "ISBN 10 ile 13 karakter arasında olmalıdır.")
	private String isbn;
	
	
	@NotEmpty(message = "Yayınevi (publisher) boş olamaz.")
	private String publisher;
	
	
	@NotNull(message = "Basım yılı (publicationYear) boş olamaz.")
	@Min(value = 1500, message = "Basım yılı 1500'den büyük olmalıdır.")
	private int publicationYear;
}
