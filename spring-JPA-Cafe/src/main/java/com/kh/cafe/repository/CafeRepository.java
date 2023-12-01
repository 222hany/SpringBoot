package com.kh.cafe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kh.cafe.vo.Cafe;

public interface CafeRepository extends JpaRepository<Cafe, Long>{
	//카페가 존재하는지 존재여부(boolean)
	boolean existsByName(String name);
	
	//count 를 사용해 지역의 갯수가 몇 개인지 찾아보는 메서드
	int countByLocation(String location);
	
	//특정 문자열을 포함한 엔터티를 검색하는데 사용하는 메서드
	List<Cafe> findByNameContaining(String keyword);
	
	//@Query("SELECT c FROM Cafe c WHERE c.name LIKE %:keyword%")
	//List<Cafe> findCafe(@Param("keyword") String keyword);
	
	//1. 만약 보여줄 것이 많다 => List 로 담아서 한번에 보여주자!
	//2. 만약 보여줄 것이 하나 => Cafe 객체 하나만 호출
}
/*
	Query Creation : Spring Data JPA 에서 제공하는 기능. 메서드에 규칙이 존재하고 규칙에 따라서 메서드를 생성해주는 기능. 메서드 이름으로 DB 쿼리를 생성할 수 있음.
					*findBy  : List<클래스명> findBy + 찾고싶은변수명(String 찾고싶은변수명); => SELECT * FROM 클래스명/테이블 WHERE 찾고싶은변수명 = ?
							  *Containing : 해당하는 변수명이 특정 변수에 대한 검색을 LIKE %% 로 진행할 수 있게 도와줌
					*countBy : List<클래스명> countBy + 클래스에적어준변수명(String 클래스에적어준변수명); => SELECT COUNT(*) FROM 클래스명/테이블 WHERE 클래스에적어준변수명 = ?
					*existBy : List<클래스명> existBy + 클래스에적어준변수명(String 클래스에적어준변수명); => SELECT CASE WHEN COUNT(*) > 0 THEN true ELSE false
																							  END FROM 클래스명/테이블 WHERE 클래스에적어준변수명 = ?
					*deleteBy: List<클래스명> deleteBy + 지우고싶은변수명(String 지우고싶은변수명); => DELETE FROM 클래스명/테이블 WHERE 지우고싶은변수명 = ?
	
	Query -> AND OR IS EQUALS BETWEEN AFTER BEFORE LIKE ORDERBY IN FALSE TRUE IGNORECASE
			1. JPA 에서 SQL AND 구문을 써야할 때			: findBy변수명AND다른변수명
			2. JPA 에서 SQL OR 구문을 써야할 때			: findBy변수명OR다른변수명
			3. JPA 에서 SQL IS/EQUALS 구문을 써야할 때	: findBy변수명IS / findBy변수명Equals
			4. JPA 에서 SQL BETWEEN 구문을 써야할 때		: findBy변수명Between
			5. JPA 에서 SQL AFTER/BEFORE 구문을 써야할 때 : findBy변수명After/Before
			6. JPA 에서 SQL LIKE 구문을 써야할 때			: findBy변수명Like
			7. JPA 에서 SQL ORDERBY 구문을 써야할 때		: findBy변수명OrderBy정렬하고자하는기준변수명DESC/ASC
			8. JPA 에서 SQL IN 구문을 써야할 때			: findBy변수명IN(List<예약어> 변수명)
			9. JPA 에서 SQL FALSE/TRUE 구문을 써야할 때	: findBy변수명True() / findBy변수명False()
			10.JPA 에서 SQL IGNORECASE 구문을 써야할 때	: findBy변수명IgnoreCase
*/