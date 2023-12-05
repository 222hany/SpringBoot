package com.kh.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kh.shop.vo.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
	//회원가입 로그인 마이페이지 아이디찾기
	
	//이메일을 이용해서 아이디를 찾을 것임
	Member findByEmail(String email);
}