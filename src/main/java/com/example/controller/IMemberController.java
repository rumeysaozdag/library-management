package com.example.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.dto.DtoMember;

@RequestMapping("/api/v1/members")
public interface IMemberController {

	@PostMapping
	DtoMember createMember(@RequestBody DtoMember dtoMember);
	
	@GetMapping
	List<DtoMember> getAllMembers();
	
	@GetMapping("/{id}")
	DtoMember getMemberById(@PathVariable Long id);
	
	@PutMapping("/{id}")
	DtoMember updateMember(@PathVariable Long id, @RequestBody DtoMember dtoMember);
	
	@DeleteMapping("/{id}")
	void deleteMember(@PathVariable Long id);
	
}
