package com.kh.springdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kh.springdb.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Long>{
	
}
