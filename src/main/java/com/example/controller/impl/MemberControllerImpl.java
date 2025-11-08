package com.example.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.controller.IMemberController;
import com.example.dto.DtoMember;
import com.example.services.IMemberService;

@RestController
public class MemberControllerImpl implements IMemberController{

	@Autowired
	private IMemberService memberService;
	
	@Override
	public DtoMember createMember(DtoMember dtoMember) {
		
		return memberService.createDtoMember(dtoMember);
	}

	@Override
	public List<DtoMember> getAllMembers() {
		// TODO Auto-generated method stub
		return memberService.getAllMembers();
	}

	@Override
	public DtoMember getMemberById(Long id) {
		// TODO Auto-generated method stub
		return memberService.getMemberById(id);
	}

	@Override
	public DtoMember updateMember(Long id, DtoMember dtoMember) {
		// TODO Auto-generated method stub
		return memberService.updateMember(id, dtoMember);
	}

	@Override
	public void deleteMember(Long id) {
		// TODO Auto-generated method stub
		memberService.deleteMember(id);
	}

}
