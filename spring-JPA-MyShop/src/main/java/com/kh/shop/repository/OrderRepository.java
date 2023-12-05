package com.kh.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kh.shop.vo.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}