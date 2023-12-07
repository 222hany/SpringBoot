package com.kh.springdb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kh.springdb.model.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Integer>{
	List<CartItem> findCartItemByItemId(int id);
	CartItem findCartItemById(int id);
	
	List<CartItem> findByItemId(int itemId); //아이템아이디로 장바구니에서 상품 넣거나 찾을 수 있도록 아이템아이디로 조회하거나 집어넣을 수 있게 해주는 메서드.
	
	CartItem findByCartIdAndItemId(Long cartId, int itemId);
}
