package com.kh.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.shop.repository.MemberRepository;
import com.kh.shop.vo.Member;

@Service
public class MemberService implements UserDetailsService {
	private final MemberRepository memberRepository;
	
	@Autowired
	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}
	
	//회원가입
	public Member saveMember(Member member) {
		return memberRepository.save(member);
	}
	
	//회원가입 시 중복회원 확인
	public void validateDuplicateMember(Member member) {
		Member findMember = memberRepository.findByEmail(member.getEmail());
		//만약 존재하는 회원이면 Exception을 활용해서 이미 존재하는 회원임을 나타낼 수 있도록 표시
		//DB 에서 이미 가입된 회원의 이메일이 존재한다면 예외를 발생시키는 if 문
		if(findMember != null) {
			throw new IllegalStateException("이미 가입된 회원입니다.");
		}
	}
}
/*
	UserDetailsService : 사용자 정보를 가져오거나 인증할 때 사용하는 서비스. 사용자의 아이디나 이메일을 받아와서 받아온 정보를 객체로 반환할 때 사용.
*/