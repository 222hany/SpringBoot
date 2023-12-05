package com.kh.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kh.shop.vo.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}