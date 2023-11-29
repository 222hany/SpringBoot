package com.kh.springdb.vo;

//import org.springframework.data.annotation.Id; // Nosql
//import jakarta.persistence.Id; // 관계형 sql (현재 배우고 있는 부분은 관계형이므로 관계형을 import 해줘야 함)

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
// @Table(name="ProductItem")
public class Products {
	@Id
	//@Column(name = "product_id")
	private long product_id; //위 어노테이션을 사용하면 테이블을 새로 생성하는 거지만, 이미 있는 것을 확인하는 용이라 칼럼명도 일치해야하고, 칼럼 순서도 일치해야 함.
	//@Column(nullable = false, length = 50)
	private String product_name; // 굳이 안에 데이터 타입은 맞춰주지 않아도 됨.
	//@Column(nullable = false, length = 50)
	private String category;
	//@Column(name = "price")
	private Double price;
	private Integer stock_quantity;
}

/*
 @Table : 
 	테이블 이름을 지정해주는 어노테이션.
 
 @Id :
 	해당 필드가 엔터티의 primaryKey 임을 나타냄.
 	
 @Column : 해당 필드가 데이터베이스 테이블의 컬럼에 매핑되는 것을 확인할 수 있음.
 	+++ nullable : JPA에 들어있는 공식으로 해당 컬럼이 null값을 허용하는지 여부를 나타냄.
 	+++ length :  문자열 컬럼의 최대 길이를 지정.
	+++ String으로 시작되는 필드값의 경우 String으로 지정된 이름으로 명시되기 때문에 따로 name을 지정해주지 않아도 되지만,
	 	그 이외의 타입은 name을 설정해주어 Column명을 지정해주는 것이 원칙이다.
	 	
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_sequence") :
	JPA에서 엔터티의 기본키 값을 자동으로 생성하는 방법을 지정하는 데 사용하는 어노테이션.
	시퀀스(DB에서 중복되는 값이 아닌 각 레코드가 고유한 숫자번호를 가질 수 있도록 자동으로 값을 생성해줌.)를 사용하여 기본키 값을 생성할 수 있도록 지원함.

@SeqenceGenerator(name = "product_sequence", seqenceName = "PRODUCT_SEQ", allocationSize = 1) :
	@GeneratedValue와 연결할 이름을 설정해주고, 시퀀스의 이름과 크기를 지정할 수 있음.

@GeneratedValue(strategy = GenerationType.IDENTITY) :
	DB 자체에서 자동으로 값이 증가할 수 있도록 자동생성이 들어있는 경우 해당 어노테이션 방식을 사용.
	새로운 레코드가 삽입될 때 마다 DB가 자동으로 기본키의 값을 증가시킴.
 */