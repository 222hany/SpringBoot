package com.kh.oracleDB.mallBoard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kh.oracleDB.mallBoard.vo.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer>{
	//사용자 아이디를 바탕으로 아이디 주인의 카트를 조회하기 위해 사용하는 매서드
	Cart findByUserId(int id);
	
	//주어진 카트아이디로 카트 내용 조회
	Cart findCartById(int id);
	
	//카트에서 카트를 중점으로 유저아이디를 검색해서 조회
	Cart findCartByUserId(int id);
}