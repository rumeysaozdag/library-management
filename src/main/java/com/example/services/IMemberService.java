package com.example.services;

import java.util.List;

import com.example.dto.DtoMember;

public interface IMemberService {

	
	DtoMember createDtoMember(DtoMember dtoMember);
	
	DtoMember getMemberById(Long id);
	
	List<DtoMember> getAllMembers();
	
	DtoMember updateMember(Long id, DtoMember dtoMember);
	
	void deleteMember(Long id);
}
