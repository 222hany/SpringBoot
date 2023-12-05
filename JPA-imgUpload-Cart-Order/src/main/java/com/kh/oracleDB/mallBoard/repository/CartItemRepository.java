package com.kh.oracleDB.mallBoard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kh.oracleDB.mallBoard.vo.CartItem;

import java.util.*;

public interface CartItemRepository extends JpaRepository<CartItem, Integer>{
	//카트아이디와 아이템아이디로 카트아이템을 찾는 메서드
	CartItem findByCartIdAndItemId(int cartId, int itemId);
	
	//아이디 값에 해당하는 아이템을 찾는 메서드
	CartItem findCartItemById(int id);
	
	//모든 카트에 담긴 아이템을 반환하는 리스트
	List<CartItem> findCartItemByItemId(int id);
}
