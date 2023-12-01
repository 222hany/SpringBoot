package com.kh.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kh.shop.vo.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{
	//회원가입, 로그인, 마이페이지 : 내장되어 있는 레포지토리 사용

	//이메일을 이용해 아이디 찾기
	Member findByEmail(String email);
}
