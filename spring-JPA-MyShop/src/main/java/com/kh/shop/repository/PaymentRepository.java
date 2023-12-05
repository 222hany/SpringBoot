package com.kh.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kh.shop.vo.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}