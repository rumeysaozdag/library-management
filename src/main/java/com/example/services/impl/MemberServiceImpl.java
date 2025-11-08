package com.example.services.impl;

import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.DtoMember;
import com.example.entities.Member;
import com.example.repository.MemberRepository;
import com.example.services.IMemberService;

@Service
public class MemberServiceImpl implements IMemberService{
	
	private static final Logger logger= LoggerFactory.getLogger(MemberServiceImpl.class);

	
	private final MemberRepository memberRepository;
	
	 public MemberServiceImpl(MemberRepository memberRepository) {
	        this.memberRepository = memberRepository;
	    }
	
	@Override
	public DtoMember createDtoMember(DtoMember dtoMember) {
		Member member = new Member();
		BeanUtils.copyProperties(dtoMember, member);
		
		Member savedMember= memberRepository.save(member);
		
		DtoMember responseDto = new DtoMember();
		BeanUtils.copyProperties(savedMember, responseDto);
		
		return responseDto;
	}

	@Override
	public DtoMember getMemberById(Long id) {
		Optional<Member> optionalMember= memberRepository.findById(id);
		if(optionalMember.isEmpty()) {
			return null;
			
		}
		
		Member dbMember = optionalMember.get();
		DtoMember dto = new DtoMember();
		BeanUtils.copyProperties(dbMember, dto);
		
		return dto;
	}

	@Override
	public List<DtoMember> getAllMembers() {
		List<DtoMember> dtoList =new ArrayList<>();
		List<Member> memberList= memberRepository.findAll();
		for(Member member: memberList) {
			DtoMember dto= new DtoMember();
			BeanUtils.copyProperties(member, dto);
			dtoList.add(dto);
		}
		return dtoList;
	}

	@Override
	public DtoMember updateMember(Long id, DtoMember dtoMember) {
		Optional<Member> optionalMember= memberRepository.findById(id);
		if(optionalMember.isEmpty()) {
			return null;
		}
		Member dbMember= optionalMember.get();
		
		dbMember.setName(dtoMember.getName());
		dbMember.setEmail(dtoMember.getEmail());
		dbMember.setPhone(dtoMember.getPhone());
		
		Member updateMember= memberRepository.save(dbMember);
		
		DtoMember responseDto= new DtoMember();
		BeanUtils.copyProperties(updateMember, responseDto);
		return responseDto;
	}

	@Override
	public void deleteMember(Long id) {
		Optional<Member> optionalMember= memberRepository.findById(id);
		if(optionalMember.isPresent()) {
			memberRepository.delete(optionalMember.get());
		}
		
	}

}
