package com.kh.springdb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//bean : 스프링이 관리하는 자바 객체를 뜻함. 인스턴스화 된 객체. 스프링 컨테이너에 등록된 객체. 클래스의 등록된 정보, getter/setter 메서드를 가지고 있음.
//		 빈이 알아서 만들어지는 라이프 사이클
//repository : JPA 에서 주로 사용. Entity 에 의해 생성된 DB에 접근하는 메서드들을 사용하기 위한 인터페이스.
import org.springframework.stereotype.Service;

import com.kh.springdb.mapper.ProductMapper;
import com.kh.springdb.model.Product;

@Service
public class ProductService {
	//@Autowired : 의존관계를 주입할 때 사용하는 어노테이션. 의존관계에 해당하는 빈을 찾아 주입하는 역할.
			     //DI(Dependency Injection) : 의존성 주입. 프로그램에서 구성요소의 의존하는 관계가 소스코드 내부가 아니라 외부에서 설정한 파일을 통해 정의.
	/*
		JPA
		@Autowired
		private ProductRepository productRepository;
	*/
	
	@Autowired
	private ProductMapper productMapper;
	
	public List<Product> getAllProducts(){
		//return productRepository.findAll();
		return productMapper.getAllProducts();
	}
}