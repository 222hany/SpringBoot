package com.kh.springdb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kh.springdb.vo.Products;

public interface ProductRepository extends JpaRepository<Products, Long> {
	
	
}
/*
 * 	// 메서드 이름으로 간단하게 쿼리를 정의하기
	Product findByProductName(String product_name);
	
	// 전체 제품 출력하는 메서드 추가
	List<Product> findByPriceDesc(Integer price);
	
	// 만약 repository에 쿼리를 추가하고 싶을 경우
	@Query("SELECT * FROM ProductItem WHERE price DESC")
	List<Product> findByDetail(@Param("category") String category);
	
	/*
	public void CreateProductList() {
		Product product = new Product();
		product.setProduct_name("테스터 제품");
		product.setPrice(1000);
		product.setCategory("가전");
	}
 * 
 Repository : 
 	Spring Data JPA에서 제공하는 인터페이스
 	DB에서 User 엔터티에 접근하는 데 사용.
 	기본적인 CRUD 작업을 수행할 수 있는 메서드를 제공.
 	mybatis에서는 ~Mapper가 수행했었고, ~Mapper.xml에서 id값을 넣어 사용했음.
 	
 	예를들어
 		조회 : 전체조회(findAll) 혹은 아이디 하나만 조회(findById)
 		저장 : save
 		삭제 : deleteById
 	
 	findOne : 조건에 해당하는 엔터티 중에서 첫 번째 엔터티만 반환.
 			  조건에 해당하는 엔터티가 없으면 null 을 반환.
 	findById : 일반적으로 프라이머리 키에 해당하는 엔터티를 찾아서 반환.
 			   Optional : Optional.empty() = 빈 값으로 반환 처리를 할 수 있음.
 			   JPA 2.0 이후로 출시된 findOne 보다는 최신버전.
 */