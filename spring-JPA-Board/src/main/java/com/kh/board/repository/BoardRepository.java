package com.kh.board.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kh.board.vo.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
	//기본 CRUD 쿼리는 JpaRepository 안에 내장되어있음
	
	//게시판에서 제목에 특정 키워드가 포함된 게시물을 검색
	@Query("SELECT b FROM Board b WHERE b.title LIKE %:keyword%") //%:keyword% : 파라미터로 받아온 키워드를 나타냄 / % : 어떤 문자라도 매칭될 수 있도록 도와줌
	List<Board> findTitle(@Param("keyword") String keyword); //List<Board> : 검색 결과를 리스트 형태로 반환할 수 있도록 해줌
}
/*
	@Query : JPA 에서 제공하는 CRUD 쿼리 이외에 추가적으로 필요한 쿼리가 있을 경우, 직접 생성해서 쿼리를 정의할 때 사용하는 어노테이션
			 인터페이스 메서드에 직접 쿼리를 작성할 수 있으며, 더 복잡한 검색이나 조인 등의 작업을 수행할 수 있음
	@Param : 키워드에 해당하는 값을 메서드의 파라미터로 받아오기 위해 사용하는 어노테이션 메서드에서 매개변수로 전달 된 키워드의 값을 쿼리 내의 키워드에 매핑시킴.
	
	@Query("SELECT * FROM Board WHERE title LIKE %:keyword%")
	@Query("SELECT b FROM Board b WHERE b.title LIKE %:keyword%")
		board b 에서 b 를 붙이는 것과 안 붙이는 것은 엔티티에서 별칭을 지정해서 사용하는 방식 차이가 있음
	
	JPQL(Java Persistence Query Language) : 자바 객체를 대상으로 하는 쿼리. JPA(Java Persistence API) 에서 사용. 엔티티 객체와 필드에 대한 쿼리를
											정의하는데 사용. 엔티티와 필드에 대한 쿼리를 작성할 때 SQL 과는 조금 다른 문법을 사용.
*/