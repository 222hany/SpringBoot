package com.kh.springdb.model.vo.dao;

import com.kh.springdb.model.vo.MemberVO;

public interface MemberDAO {
	//전체 조회
	
	//DB 삽입
	void insertMember(MemberVO member);
	//수정
	
	//삭제
}

/*
DAO와 Repository
DAO(Data Access Object)
  데이터베이스와 상호작용하는 것을 캡슐화해서 데이터와 자바에서 실행하는 코드와 분리
  하기 위해 사용됨
  데이터베이스를 연결하거나, 쿼리를 실행하거나, 트랜잭션을 관리하는 것과 같은
  작업을 진행

Repository
  스프링에서 주로 사용
  데이터를 엑세스를 하기 위한 기능은 Bean을 통해 제공
  스프링에 제공하는 기능을 활용해서 데이터 엑세스를 편리하게 처리할 수 있음
  주로 인터페이스를 통해 사용되며, 사용자가 객체화가 아닌 추상화된 데이터베이스에 접근할 수 있음
   
Bean(빈)
 스프링 프레임워크에서 스프링에 의해 객체가 생성되고 관리되는 것을 말함
 






 * */