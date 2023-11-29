package com.kh.springdb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.springdb.repository.ProductRepository;
import com.kh.springdb.vo.Products;

@Service
public class ProductService {
	private final ProductRepository productRepository; // 인터페이스를 사용하여 DB와 상호작용하는 데 사용할 레포지토리를 나타내는 필드이며 final로 선언되어 변경 불가
	// SQL문을 가져오는 녀석이기 때문에 값이 변경되면 안되므로 final로 선언
	
	
	@Autowired // 생성자를 위한 어노테이션으로 스프링은 productRepository 타입의 빈을 찾아서 주입
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	public List<Products> getAllProducts(){ // 모든 상품을 조회하는 메서드
		return productRepository.findAll(); // Repository.findAll은 이미 만들어져 있는 지정된 메서드를 가지고와서 사용하는 것
	}
	
	public Optional<Products> getProductByID(Long id){ // 상품 1개만 조회하는 메서드 // Optional은 util로 import
		return productRepository.findById(id);		
	}
	
	public Products saveProduct(Products product) { // 저장하는 메서드 1.최초로 작성한 내용 저장 2.기존에 작성한 내용 수정해서 저장
		return productRepository.save(product);
	}
	
	public void deleteProducByID(Long id) { // 삭제하는 메서드
		productRepository.deleteById(id);
	}
	
	/*
	 * Controller와 Service의 역할차이
	 * Service : 앞서 진행했던 DB를 가져오는 구문을 상호작용(insert, select, update, delete)하도록 처리하는 역할
	 * 
	 * Controller : HTML 요청을 처리하고 사용자를 위한 DB를 서비스를 통해 전달하고, 서비스에서 전달받은 결과를 View에게 전달.
	 * 
	 * Optional :
	 * 		제품의 존재 여부를 체크할 수 있도록 해주는 객체
	 */
}